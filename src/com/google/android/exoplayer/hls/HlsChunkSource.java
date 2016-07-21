package com.google.android.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.chunk.DataChunk;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.UriUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public final class HlsChunkSource
{
  final int adaptiveMode;
  final AudioCapabilities audioCapabilities;
  final BandwidthMeter bandwidthMeter;
  private final String baseUri;
  final DataSource dataSource;
  long durationUs;
  byte[] encryptionIv;
  String encryptionIvString;
  byte[] encryptionKey;
  Uri encryptionKeyUri;
  boolean live;
  final long maxBufferDurationToSwitchDownUs;
  final int maxHeight;
  final int maxWidth;
  final long minBufferDurationToSwitchUpUs;
  private final HlsPlaylistParser playlistParser;
  byte[] scratchSpace;
  int selectedVariantIndex;
  final long[] variantBlacklistTimes;
  final long[] variantLastPlaylistLoadTimesMs;
  final HlsMediaPlaylist[] variantPlaylists;
  final Variant[] variants;
  
  public HlsChunkSource(DataSource paramDataSource, String paramString, HlsPlaylist paramHlsPlaylist, BandwidthMeter paramBandwidthMeter, int[] paramArrayOfInt, AudioCapabilities paramAudioCapabilities)
  {
    this(paramDataSource, paramString, paramHlsPlaylist, paramBandwidthMeter, paramArrayOfInt, paramAudioCapabilities, (byte)0);
  }
  
  private HlsChunkSource(DataSource paramDataSource, String paramString, HlsPlaylist paramHlsPlaylist, BandwidthMeter paramBandwidthMeter, int[] paramArrayOfInt, AudioCapabilities paramAudioCapabilities, byte paramByte)
  {
    dataSource = paramDataSource;
    bandwidthMeter = paramBandwidthMeter;
    adaptiveMode = 0;
    audioCapabilities = paramAudioCapabilities;
    minBufferDurationToSwitchUpUs = 5000000L;
    maxBufferDurationToSwitchDownUs = 20000000L;
    baseUri = baseUri;
    playlistParser = new HlsPlaylistParser();
    if (type == 1)
    {
      variants = new Variant[] { new Variant(0, paramString, 0, null, -1, -1) };
      variantPlaylists = new HlsMediaPlaylist[1];
      variantLastPlaylistLoadTimesMs = new long[1];
      variantBlacklistTimes = new long[1];
      setMediaPlaylist(0, (HlsMediaPlaylist)paramHlsPlaylist);
    }
    for (;;)
    {
      maxWidth = -1;
      maxHeight = -1;
      return;
      paramDataSource = variants;
      variants = buildOrderedVariants(paramDataSource, paramArrayOfInt);
      variantPlaylists = new HlsMediaPlaylist[variants.length];
      variantLastPlaylistLoadTimesMs = new long[variants.length];
      variantBlacklistTimes = new long[variants.length];
      int j = -1;
      int i = -1;
      int k = Integer.MAX_VALUE;
      paramByte = 0;
      while (paramByte < variants.length)
      {
        int n = paramDataSource.indexOf(variants[paramByte]);
        int m = k;
        if (n < k)
        {
          m = n;
          selectedVariantIndex = paramByte;
        }
        paramString = variants[paramByte].format;
        j = Math.max(width, j);
        i = Math.max(height, i);
        paramByte += 1;
        k = m;
      }
    }
  }
  
  private static Variant[] buildOrderedVariants(List<Variant> paramList, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt != null)
    {
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        localArrayList.add(paramList.get(paramArrayOfInt[i]));
        i += 1;
      }
    }
    localArrayList.addAll(paramList);
    paramList = new ArrayList();
    paramArrayOfInt = new ArrayList();
    int i = 0;
    if (i < localArrayList.size())
    {
      Variant localVariant = (Variant)localArrayList.get(i);
      if ((format.height > 0) || (variantHasExplicitCodecWithPrefix(localVariant, "avc"))) {
        paramList.add(localVariant);
      }
      for (;;)
      {
        i += 1;
        break;
        if (variantHasExplicitCodecWithPrefix(localVariant, "mp4a")) {
          paramArrayOfInt.add(localVariant);
        }
      }
    }
    if (!paramList.isEmpty()) {}
    for (;;)
    {
      paramArrayOfInt = new Variant[paramList.size()];
      paramList.toArray(paramArrayOfInt);
      Arrays.sort(paramArrayOfInt, new Comparator()
      {
        private final Comparator<Format> formatComparator = new Format.DecreasingBandwidthComparator();
      });
      return paramArrayOfInt;
      paramList = localArrayList;
      if (paramArrayOfInt.size() < localArrayList.size())
      {
        localArrayList.removeAll(paramArrayOfInt);
        paramList = localArrayList;
      }
    }
  }
  
  private static boolean variantHasExplicitCodecWithPrefix(Variant paramVariant, String paramString)
  {
    paramVariant = format.codecs;
    if (TextUtils.isEmpty(paramVariant)) {}
    for (;;)
    {
      return false;
      paramVariant = paramVariant.split("(\\s*,\\s*)|(\\s*$)");
      int i = 0;
      while (i < paramVariant.length)
      {
        if (paramVariant[i].startsWith(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  final boolean allVariantsBlacklisted()
  {
    int i = 0;
    while (i < variantBlacklistTimes.length)
    {
      if (variantBlacklistTimes[i] == 0L) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  final int getLiveStartChunkMediaSequence(int paramInt)
  {
    HlsMediaPlaylist localHlsMediaPlaylist = variantPlaylists[paramInt];
    if (segments.size() > 3) {}
    for (paramInt = segments.size() - 3;; paramInt = 0) {
      return paramInt + mediaSequence;
    }
  }
  
  final int getVariantIndexForBandwidth(long paramLong)
  {
    long l = paramLong;
    if (paramLong == -1L) {
      l = 0L;
    }
    int k = (int)((float)l * 0.8F);
    int j = -1;
    int i = 0;
    while (i < variants.length)
    {
      if (variantBlacklistTimes[i] == 0L)
      {
        if (variants[i].format.bitrate <= k) {
          return i;
        }
        j = i;
      }
      i += 1;
    }
    if (j != -1) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      return j;
    }
  }
  
  final MediaPlaylistChunk newMediaPlaylistChunk(int paramInt)
  {
    Uri localUri = UriUtil.resolveToUri(baseUri, variants[paramInt].url);
    DataSpec localDataSpec = new DataSpec(localUri, 0L, -1L, null, 1);
    return new MediaPlaylistChunk(dataSource, localDataSpec, scratchSpace, playlistParser, paramInt, localUri.toString());
  }
  
  final void setEncryptionData(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject;
    byte[] arrayOfByte;
    if (paramString.toLowerCase(Locale.getDefault()).startsWith("0x"))
    {
      localObject = paramString.substring(2);
      localObject = new BigInteger((String)localObject, 16).toByteArray();
      arrayOfByte = new byte[16];
      if (localObject.length <= 16) {
        break label113;
      }
    }
    label113:
    for (int i = localObject.length - 16;; i = 0)
    {
      System.arraycopy(localObject, i, arrayOfByte, 16 - localObject.length + i, localObject.length - i);
      encryptionKeyUri = paramUri;
      encryptionKey = paramArrayOfByte;
      encryptionIvString = paramString;
      encryptionIv = arrayOfByte;
      return;
      localObject = paramString;
      break;
    }
  }
  
  final void setMediaPlaylist(int paramInt, HlsMediaPlaylist paramHlsMediaPlaylist)
  {
    variantLastPlaylistLoadTimesMs[paramInt] = SystemClock.elapsedRealtime();
    variantPlaylists[paramInt] = paramHlsMediaPlaylist;
    live |= live;
    durationUs = durationUs;
  }
  
  private static final class EncryptionKeyChunk
    extends DataChunk
  {
    public final String iv;
    byte[] result;
    public final int variantIndex;
    
    public EncryptionKeyChunk(DataSource paramDataSource, DataSpec paramDataSpec, byte[] paramArrayOfByte, String paramString, int paramInt)
    {
      super(paramDataSpec, 3, paramArrayOfByte);
      iv = paramString;
      variantIndex = paramInt;
    }
    
    protected final void consume(byte[] paramArrayOfByte, int paramInt)
      throws IOException
    {
      result = Arrays.copyOf(paramArrayOfByte, paramInt);
    }
  }
  
  private static final class MediaPlaylistChunk
    extends DataChunk
  {
    private final HlsPlaylistParser playlistParser;
    private final String playlistUrl;
    HlsMediaPlaylist result;
    public final int variantIndex;
    
    public MediaPlaylistChunk(DataSource paramDataSource, DataSpec paramDataSpec, byte[] paramArrayOfByte, HlsPlaylistParser paramHlsPlaylistParser, int paramInt, String paramString)
    {
      super(paramDataSpec, 4, paramArrayOfByte);
      variantIndex = paramInt;
      playlistParser = paramHlsPlaylistParser;
      playlistUrl = paramString;
    }
    
    protected final void consume(byte[] paramArrayOfByte, int paramInt)
      throws IOException
    {
      result = ((HlsMediaPlaylist)HlsPlaylistParser.parse(playlistUrl, new ByteArrayInputStream(paramArrayOfByte, 0, paramInt)));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsChunkSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */