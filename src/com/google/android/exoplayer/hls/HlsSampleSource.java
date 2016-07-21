package com.google.android.exoplayer.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer.LoadControl;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener;
import com.google.android.exoplayer.chunk.Chunk;
import com.google.android.exoplayer.chunk.DataChunk;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.extractor.DefaultTrackOutput;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.RollingSampleBuffer;
import com.google.android.exoplayer.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer.extractor.ts.TsExtractor;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.UriUtil;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class HlsSampleSource
  implements SampleSource, SampleSource.SampleSourceReader, Loader.Callback
{
  private final int bufferSizeContribution;
  private final HlsChunkSource chunkSource;
  private long currentLoadStartTimeMs;
  private Chunk currentLoadable;
  private IOException currentLoadableException;
  private int currentLoadableExceptionCount;
  private long currentLoadableExceptionTimestamp;
  private TsChunk currentTsLoadable;
  private Format downstreamFormat;
  private MediaFormat[] downstreamMediaFormats;
  private long downstreamPositionUs;
  private int enabledTrackCount;
  private final Handler eventHandler;
  final EventListener eventListener;
  final int eventSourceId;
  private final LinkedList<HlsExtractorWrapper> extractors;
  private long lastSeekPositionUs;
  private final LoadControl loadControl;
  private boolean loadControlRegistered;
  private Loader loader;
  private boolean loadingFinished;
  private final int minLoadableRetryCount;
  private boolean[] pendingDiscontinuities;
  private long pendingResetPositionUs;
  private boolean prepared;
  private TsChunk previousTsLoadable;
  private int remainingReleaseCount;
  private int trackCount;
  private boolean[] trackEnabledStates;
  private TrackInfo[] trackInfos;
  
  public HlsSampleSource(HlsChunkSource paramHlsChunkSource, LoadControl paramLoadControl, Handler paramHandler, EventListener paramEventListener)
  {
    this(paramHlsChunkSource, paramLoadControl, paramHandler, paramEventListener, (byte)0);
  }
  
  private HlsSampleSource(HlsChunkSource paramHlsChunkSource, LoadControl paramLoadControl, Handler paramHandler, EventListener paramEventListener, byte paramByte)
  {
    chunkSource = paramHlsChunkSource;
    loadControl = paramLoadControl;
    bufferSizeContribution = 16777216;
    minLoadableRetryCount = 3;
    eventHandler = paramHandler;
    eventListener = paramEventListener;
    eventSourceId = 0;
    pendingResetPositionUs = -1L;
    extractors = new LinkedList();
  }
  
  private void clearCurrentLoadable()
  {
    currentTsLoadable = null;
    currentLoadable = null;
    currentLoadableException = null;
    currentLoadableExceptionCount = 0;
  }
  
  private void clearState()
  {
    int i = 0;
    while (i < extractors.size())
    {
      ((HlsExtractorWrapper)extractors.get(i)).clear();
      i += 1;
    }
    extractors.clear();
    clearCurrentLoadable();
    previousTsLoadable = null;
  }
  
  private HlsExtractorWrapper getCurrentExtractor()
  {
    HlsExtractorWrapper localHlsExtractorWrapper = (HlsExtractorWrapper)extractors.getFirst();
    if (extractors.size() > 1)
    {
      if (localHlsExtractorWrapper.isPrepared())
      {
        i = 0;
        label31:
        if (i < trackEnabledStates.length) {
          if ((trackEnabledStates[i] == 0) || (!localHlsExtractorWrapper.hasSamples(i))) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          return localHlsExtractorWrapper;
        }
        ((HlsExtractorWrapper)extractors.removeFirst()).clear();
        localHlsExtractorWrapper = (HlsExtractorWrapper)extractors.getFirst();
        break;
        i += 1;
        break label31;
      }
    }
    return localHlsExtractorWrapper;
  }
  
  private boolean isPendingReset()
  {
    return pendingResetPositionUs != -1L;
  }
  
  private void maybeStartLoading()
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1;
    int i;
    label27:
    boolean bool1;
    if (isPendingReset())
    {
      l1 = pendingResetPositionUs;
      if (currentLoadableException == null) {
        break label181;
      }
      i = 1;
      if ((!loader.loading) && (i == 0)) {
        break label186;
      }
      bool1 = true;
      label44:
      bool1 = loadControl.update(this, downstreamPositionUs, l1, bool1);
      if (i == 0) {
        break label192;
      }
      if (l2 - currentLoadableExceptionTimestamp >= Math.min((currentLoadableExceptionCount - 1L) * 1000L, 5000L))
      {
        currentLoadableException = null;
        loader.startLoading(currentLoadable, this);
      }
    }
    label181:
    label186:
    label192:
    while ((loader.loading) || (!bool1))
    {
      return;
      if (currentTsLoadable != null)
      {
        if (currentTsLoadable.isLastChunk)
        {
          l1 = -1L;
          break;
        }
        l1 = currentTsLoadable.endTimeUs;
        break;
      }
      if (previousTsLoadable.isLastChunk)
      {
        l1 = -1L;
        break;
      }
      l1 = previousTsLoadable.endTimeUs;
      break;
      i = 0;
      break label27;
      bool1 = false;
      break label44;
    }
    Object localObject2 = chunkSource;
    Object localObject1 = previousTsLoadable;
    long l3 = pendingResetPositionUs;
    long l4 = downstreamPositionUs;
    int j;
    int k;
    label250:
    Object localObject4;
    if (adaptiveMode == 0)
    {
      j = selectedVariantIndex;
      bool1 = false;
      k = j;
      localObject4 = variantPlaylists[k];
      if (localObject4 == null)
      {
        localObject1 = ((HlsChunkSource)localObject2).newMediaPlaylistChunk(k);
        label272:
        if (localObject1 == null) {
          break label1312;
        }
        currentLoadStartTimeMs = l2;
        currentLoadable = ((Chunk)localObject1);
        if (!(currentLoadable instanceof TsChunk)) {
          break label1411;
        }
        localObject1 = (TsChunk)currentLoadable;
        if (isPendingReset()) {
          pendingResetPositionUs = -1L;
        }
        localObject2 = extractorWrapper;
        if ((extractors.isEmpty()) || (extractors.getLast() != localObject2))
        {
          allocator = loadControl.getAllocator();
          extractor.init((ExtractorOutput)localObject2);
          extractors.addLast(localObject2);
        }
        notifyLoadStarted(dataSpec.length, type, trigger, format, startTimeUs, endTimeUs);
        currentTsLoadable = ((TsChunk)localObject1);
        label429:
        loader.startLoading(currentLoadable, this);
      }
    }
    else
    {
      l1 = SystemClock.elapsedRealtime();
      i = 0;
      while (i < variantBlacklistTimes.length)
      {
        if ((variantBlacklistTimes[i] != 0L) && (l1 - variantBlacklistTimes[i] > 60000L)) {
          variantBlacklistTimes[i] = 0L;
        }
        i += 1;
      }
      l1 = bandwidthMeter.getBitrateEstimate();
      if (variantBlacklistTimes[selectedVariantIndex] != 0L) {
        i = ((HlsChunkSource)localObject2).getVariantIndexForBandwidth(l1);
      }
      for (;;)
      {
        j = i;
        if (localObject1 == null) {
          break;
        }
        j = i;
        if (variants[i].format.equals(format)) {
          break;
        }
        j = i;
        if (adaptiveMode != 1) {
          break;
        }
        bool1 = true;
        k = i;
        break label250;
        if ((localObject1 != null) && (l1 != -1L))
        {
          i = ((HlsChunkSource)localObject2).getVariantIndexForBandwidth(l1);
          if (i != selectedVariantIndex)
          {
            if (adaptiveMode == 1) {}
            for (l1 = startTimeUs;; l1 = endTimeUs)
            {
              l1 -= l4;
              if ((variantBlacklistTimes[selectedVariantIndex] == 0L) && ((i <= selectedVariantIndex) || (l1 >= maxBufferDurationToSwitchDownUs)) && ((i >= selectedVariantIndex) || (l1 <= minBufferDurationToSwitchUpUs))) {
                break label711;
              }
              break;
            }
          }
        }
        label711:
        i = selectedVariantIndex;
      }
    }
    selectedVariantIndex = k;
    label746:
    int m;
    if (live) {
      if (localObject1 == null)
      {
        i = ((HlsChunkSource)localObject2).getLiveStartChunkMediaSequence(k);
        m = 0;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      m = j - mediaSequence;
      if (m >= segments.size())
      {
        if (live)
        {
          localObject1 = variantPlaylists[k];
          if (SystemClock.elapsedRealtime() - variantLastPlaylistLoadTimesMs[k] >= targetDurationSecs * 1000 / 2) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label940;
            }
            localObject1 = ((HlsChunkSource)localObject2).newMediaPlaylistChunk(k);
            break;
            if (bool1) {}
            for (i = chunkIndex;; i = chunkIndex + 1)
            {
              if (i >= mediaSequence) {
                break label1455;
              }
              j = ((HlsChunkSource)localObject2).getLiveStartChunkMediaSequence(k);
              i = 1;
              break;
            }
            if (localObject1 == null)
            {
              i = Util.binarySearchFloor$8efcd4b(segments, Long.valueOf(l3)) + mediaSequence;
              break label746;
            }
            if (bool1)
            {
              i = chunkIndex;
              break label746;
            }
            i = chunkIndex + 1;
            break label746;
          }
        }
        label940:
        localObject1 = null;
        break label272;
      }
      HlsMediaPlaylist.Segment localSegment = (HlsMediaPlaylist.Segment)segments.get(m);
      Uri localUri = UriUtil.resolveToUri(baseUri, url);
      Object localObject3;
      label1104:
      label1143:
      boolean bool2;
      if (isEncrypted)
      {
        localObject3 = UriUtil.resolveToUri(baseUri, encryptionKeyUri);
        if (!((Uri)localObject3).equals(encryptionKeyUri))
        {
          localObject1 = encryptionIV;
          i = selectedVariantIndex;
          localObject3 = new DataSpec((Uri)localObject3, 0L, -1L, null, 1);
          localObject1 = new HlsChunkSource.EncryptionKeyChunk(dataSource, (DataSpec)localObject3, scratchSpace, (String)localObject1, i);
          break label272;
        }
        if (!Util.areEqual(encryptionIV, encryptionIvString)) {
          ((HlsChunkSource)localObject2).setEncryptionData((Uri)localObject3, encryptionIV, encryptionKey);
        }
        localObject3 = new DataSpec(localUri, byterangeOffset, byterangeLength);
        if (!live) {
          break label1366;
        }
        if (localObject1 != null) {
          break label1341;
        }
        l1 = 0L;
        l3 = (durationSecs * 1000000.0D);
        if ((live) || (m != segments.size() - 1)) {
          break label1376;
        }
        bool2 = true;
        label1183:
        localObject4 = variants[selectedVariantIndex].format;
        if ((localObject1 != null) && (!discontinuity) && (((Format)localObject4).equals(format)) && (i == 0)) {
          break label1401;
        }
        if (!localUri.getLastPathSegment().endsWith(".aac")) {
          break label1382;
        }
        localObject1 = new AdtsExtractor(l1);
      }
      label1254:
      label1312:
      label1341:
      label1366:
      label1376:
      label1382:
      label1401:
      for (localObject1 = new HlsExtractorWrapper((Format)localObject4, l1, (Extractor)localObject1, bool1);; localObject1 = extractorWrapper)
      {
        localObject1 = new TsChunk(dataSource, (DataSpec)localObject3, (Format)localObject4, l1, l1 + l3, j, bool2, (HlsExtractorWrapper)localObject1, encryptionKey, encryptionIv);
        break label272;
        break;
        encryptionKeyUri = null;
        encryptionKey = null;
        encryptionIvString = null;
        encryptionIv = null;
        break label1104;
        if (bool1)
        {
          l1 = startTimeUs;
          break label1143;
        }
        l1 = endTimeUs;
        break label1143;
        l1 = startTimeUs;
        break label1143;
        bool2 = false;
        break label1183;
        localObject1 = new TsExtractor(l1, audioCapabilities);
        break label1254;
      }
      label1411:
      notifyLoadStarted(currentLoadable.dataSpec.length, currentLoadable.type, currentLoadable.trigger, currentLoadable.format, -1L, -1L);
      break label429;
      label1455:
      j = i;
      i = 0;
    }
  }
  
  private void notifyLoadCompleted(final long paramLong1, int paramInt1, final int paramInt2, final Format paramFormat, final long paramLong2, final long paramLong3, long paramLong4, final long paramLong5)
  {
    if ((eventHandler != null) && (eventListener != null)) {
      eventHandler.post(new Runnable()
      {
        public final void run()
        {
          eventListener.onLoadCompleted(eventSourceId, paramLong1, paramInt2, paramFormat, paramLong2, (int)(paramLong3 / 1000L), (int)(paramLong5 / 1000L), val$elapsedRealtimeMs, val$loadDurationMs);
        }
      });
    }
  }
  
  private void notifyLoadStarted(final long paramLong1, int paramInt1, final int paramInt2, final Format paramFormat, final long paramLong2, final long paramLong3)
  {
    if ((eventHandler != null) && (eventListener != null)) {
      eventHandler.post(new Runnable()
      {
        public final void run()
        {
          eventListener.onLoadStarted(eventSourceId, paramLong1, paramInt2, paramFormat, paramLong2, (int)(paramLong3 / 1000L), (int)(val$mediaEndTimeUs / 1000L));
        }
      });
    }
  }
  
  private void restartFrom(long paramLong)
  {
    pendingResetPositionUs = paramLong;
    loadingFinished = false;
    if (loader.loading)
    {
      loader.cancelLoading();
      return;
    }
    clearState();
    maybeStartLoading();
  }
  
  public final boolean continueBuffering(int paramInt, long paramLong)
  {
    boolean bool2 = false;
    Assertions.checkState(prepared);
    Assertions.checkState(trackEnabledStates[paramInt]);
    downstreamPositionUs = paramLong;
    HlsExtractorWrapper localHlsExtractorWrapper;
    if (!extractors.isEmpty())
    {
      localHlsExtractorWrapper = getCurrentExtractor();
      paramLong = downstreamPositionUs;
      if (localHlsExtractorWrapper.isPrepared())
      {
        i = 0;
        while (i < trackEnabledStates.length)
        {
          if (trackEnabledStates[i] == 0)
          {
            Assertions.checkState(localHlsExtractorWrapper.isPrepared());
            ((DefaultTrackOutput)sampleQueues.valueAt(i)).discardUntil(paramLong);
          }
          i += 1;
        }
      }
    }
    boolean bool1;
    if (loadingFinished) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        maybeStartLoading();
        bool1 = bool2;
      } while (isPendingReset());
      bool1 = bool2;
    } while (extractors.isEmpty());
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= extractors.size()) {
        break;
      }
      localHlsExtractorWrapper = (HlsExtractorWrapper)extractors.get(i);
      bool1 = bool2;
      if (!localHlsExtractorWrapper.isPrepared()) {
        break;
      }
      if (localHlsExtractorWrapper.hasSamples(paramInt)) {
        return true;
      }
      i += 1;
    }
  }
  
  public final void disable(int paramInt)
  {
    Assertions.checkState(prepared);
    Assertions.checkState(trackEnabledStates[paramInt]);
    enabledTrackCount -= 1;
    trackEnabledStates[paramInt] = false;
    if (enabledTrackCount == 0)
    {
      downstreamPositionUs = Long.MIN_VALUE;
      if (loadControlRegistered)
      {
        loadControl.unregister(this);
        loadControlRegistered = false;
      }
      if (loader.loading) {
        loader.cancelLoading();
      }
    }
    else
    {
      return;
    }
    clearState();
    loadControl.trimAllocator();
  }
  
  public final void enable(int paramInt, long paramLong)
  {
    Assertions.checkState(prepared);
    if (trackEnabledStates[paramInt] == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      enabledTrackCount += 1;
      trackEnabledStates[paramInt] = true;
      downstreamMediaFormats[paramInt] = null;
      downstreamFormat = null;
      if (!loadControlRegistered)
      {
        loadControl.register(this, bufferSizeContribution);
        loadControlRegistered = true;
      }
      if (enabledTrackCount == 1) {
        seekToUs(paramLong);
      }
      pendingDiscontinuities[paramInt] = false;
      return;
    }
  }
  
  public final long getBufferedPositionUs()
  {
    Assertions.checkState(prepared);
    boolean bool;
    long l2;
    if (enabledTrackCount > 0)
    {
      bool = true;
      Assertions.checkState(bool);
      if (!isPendingReset()) {
        break label41;
      }
      l2 = pendingResetPositionUs;
    }
    label41:
    long l1;
    do
    {
      return l2;
      bool = false;
      break;
      if (loadingFinished) {
        return -3L;
      }
      HlsExtractorWrapper localHlsExtractorWrapper = (HlsExtractorWrapper)extractors.getLast();
      int i = 0;
      l1 = Long.MIN_VALUE;
      while (i < sampleQueues.size())
      {
        l1 = Math.max(l1, sampleQueues.valueAt(i)).largestParsedTimestampUs);
        i += 1;
      }
      l2 = l1;
    } while (l1 != Long.MIN_VALUE);
    return downstreamPositionUs;
  }
  
  public final int getTrackCount()
  {
    Assertions.checkState(prepared);
    return trackCount;
  }
  
  public final TrackInfo getTrackInfo(int paramInt)
  {
    Assertions.checkState(prepared);
    return trackInfos[paramInt];
  }
  
  public final void maybeThrowError()
    throws IOException
  {
    if ((currentLoadableException != null) && (currentLoadableExceptionCount > minLoadableRetryCount)) {
      throw currentLoadableException;
    }
  }
  
  public final void onLoadCanceled$35e469eb()
  {
    final long l = currentLoadable.bytesLoaded();
    if ((eventHandler != null) && (eventListener != null)) {
      eventHandler.post(new Runnable()
      {
        public final void run()
        {
          eventListener.onLoadCanceled(eventSourceId, l);
        }
      });
    }
    if (enabledTrackCount > 0)
    {
      restartFrom(pendingResetPositionUs);
      return;
    }
    clearState();
    loadControl.trimAllocator();
  }
  
  public final void onLoadCompleted(Loader.Loadable paramLoadable)
  {
    boolean bool2 = true;
    boolean bool1;
    long l1;
    long l2;
    Object localObject;
    if (paramLoadable == currentLoadable)
    {
      bool1 = true;
      Assertions.checkState(bool1);
      l1 = SystemClock.elapsedRealtime();
      l2 = l1 - currentLoadStartTimeMs;
      paramLoadable = chunkSource;
      localObject = currentLoadable;
      if (!(localObject instanceof HlsChunkSource.MediaPlaylistChunk)) {
        break label203;
      }
      localObject = (HlsChunkSource.MediaPlaylistChunk)localObject;
      scratchSpace = data;
      paramLoadable.setMediaPlaylist(variantIndex, result);
      label79:
      if (!(currentLoadable instanceof TsChunk)) {
        break label257;
      }
      if (currentLoadable != currentTsLoadable) {
        break label252;
      }
      bool1 = bool2;
      label102:
      Assertions.checkState(bool1);
      loadingFinished = currentTsLoadable.isLastChunk;
      previousTsLoadable = currentTsLoadable;
      notifyLoadCompleted(currentLoadable.bytesLoaded(), currentTsLoadable.type, currentTsLoadable.trigger, currentTsLoadable.format, currentTsLoadable.startTimeUs, currentTsLoadable.endTimeUs, l1, l2);
    }
    for (;;)
    {
      clearCurrentLoadable();
      if ((enabledTrackCount > 0) || (!prepared)) {
        maybeStartLoading();
      }
      return;
      bool1 = false;
      break;
      label203:
      if (!(localObject instanceof HlsChunkSource.EncryptionKeyChunk)) {
        break label79;
      }
      localObject = (HlsChunkSource.EncryptionKeyChunk)localObject;
      scratchSpace = data;
      paramLoadable.setEncryptionData(dataSpec.uri, iv, result);
      break label79;
      label252:
      bool1 = false;
      break label102;
      label257:
      notifyLoadCompleted(currentLoadable.bytesLoaded(), currentLoadable.type, currentLoadable.trigger, currentLoadable.format, -1L, -1L, l1, l2);
    }
  }
  
  public final void onLoadError(Loader.Loadable paramLoadable, final IOException paramIOException)
  {
    int k = 1;
    paramLoadable = chunkSource;
    Chunk localChunk = currentLoadable;
    int m;
    Format localFormat;
    label126:
    int j;
    if ((localChunk.bytesLoaded() == 0L) && (((localChunk instanceof TsChunk)) || ((localChunk instanceof HlsChunkSource.MediaPlaylistChunk)) || ((localChunk instanceof HlsChunkSource.EncryptionKeyChunk))) && ((paramIOException instanceof HttpDataSource.InvalidResponseCodeException)))
    {
      m = responseCode;
      if ((m == 404) || (m == 410))
      {
        if (!(localChunk instanceof TsChunk)) {
          break label297;
        }
        localFormat = format;
        i = 0;
        if (i >= variants.length) {
          break label271;
        }
        if (!variants[i].format.equals(localFormat)) {
          break label264;
        }
        if (variantBlacklistTimes[i] == 0L) {
          break label329;
        }
        j = 1;
        label140:
        variantBlacklistTimes[i] = SystemClock.elapsedRealtime();
        if (j == 0) {
          break label335;
        }
        Log.w("HlsChunkSource", "Already blacklisted variant (" + m + "): " + dataSpec.uri);
      }
    }
    label196:
    int i = 0;
    label198:
    if (i != 0)
    {
      if ((previousTsLoadable == null) && (!isPendingReset())) {
        pendingResetPositionUs = lastSeekPositionUs;
      }
      clearCurrentLoadable();
    }
    for (;;)
    {
      if ((eventHandler != null) && (eventListener != null)) {
        eventHandler.post(new Runnable()
        {
          public final void run()
          {
            eventListener.onLoadError(eventSourceId, paramIOException);
          }
        });
      }
      maybeStartLoading();
      return;
      label264:
      i += 1;
      break;
      label271:
      throw new IllegalStateException("Invalid format: " + localFormat);
      label297:
      if ((localChunk instanceof HlsChunkSource.MediaPlaylistChunk))
      {
        i = variantIndex;
        break label126;
      }
      i = variantIndex;
      break label126;
      label329:
      j = 0;
      break label140;
      label335:
      if (!paramLoadable.allVariantsBlacklisted())
      {
        Log.w("HlsChunkSource", "Blacklisted variant (" + m + "): " + dataSpec.uri);
        i = k;
        break label198;
      }
      Log.w("HlsChunkSource", "Final variant not blacklisted (" + m + "): " + dataSpec.uri);
      variantBlacklistTimes[i] = 0L;
      break label196;
      currentLoadableException = paramIOException;
      currentLoadableExceptionCount += 1;
      currentLoadableExceptionTimestamp = SystemClock.elapsedRealtime();
    }
  }
  
  public final boolean prepare(long paramLong)
  {
    if (prepared) {
      return true;
    }
    if (!extractors.isEmpty())
    {
      HlsExtractorWrapper localHlsExtractorWrapper = getCurrentExtractor();
      if (localHlsExtractorWrapper.isPrepared())
      {
        trackCount = localHlsExtractorWrapper.getTrackCount();
        trackEnabledStates = new boolean[trackCount];
        pendingDiscontinuities = new boolean[trackCount];
        downstreamMediaFormats = new MediaFormat[trackCount];
        trackInfos = new TrackInfo[trackCount];
        int i = 0;
        if (i < trackCount)
        {
          Object localObject = localHlsExtractorWrapper.getMediaFormat(i);
          TrackInfo[] arrayOfTrackInfo = trackInfos;
          localObject = mimeType;
          HlsChunkSource localHlsChunkSource = chunkSource;
          if (live) {}
          for (paramLong = -1L;; paramLong = durationUs)
          {
            arrayOfTrackInfo[i] = new TrackInfo((String)localObject, paramLong);
            i += 1;
            break;
          }
        }
        prepared = true;
        return true;
      }
    }
    if (loader == null) {
      loader = new Loader("Loader:HLS");
    }
    if (!loadControlRegistered)
    {
      loadControl.register(this, bufferSizeContribution);
      loadControlRegistered = true;
    }
    if (!loader.loading)
    {
      pendingResetPositionUs = paramLong;
      downstreamPositionUs = paramLong;
    }
    maybeStartLoading();
    return false;
  }
  
  public final int readData(int paramInt, final long paramLong, MediaFormatHolder paramMediaFormatHolder, SampleHolder paramSampleHolder, boolean paramBoolean)
  {
    Assertions.checkState(prepared);
    downstreamPositionUs = paramLong;
    if (pendingDiscontinuities[paramInt] != 0)
    {
      pendingDiscontinuities[paramInt] = false;
      return -5;
    }
    if (paramBoolean) {
      return -2;
    }
    if (isPendingReset()) {
      return -2;
    }
    Object localObject1 = getCurrentExtractor();
    if (!((HlsExtractorWrapper)localObject1).isPrepared()) {
      return -2;
    }
    final boolean bool;
    if ((downstreamFormat == null) || (!downstreamFormat.equals(format)))
    {
      localObject2 = format;
      bool = trigger;
      paramLong = startTimeUs;
      if ((eventHandler != null) && (eventListener != null)) {
        eventHandler.post(new Runnable()
        {
          public final void run()
          {
            eventListener.onDownstreamFormatChanged(eventSourceId, localObject2, bool, (int)(paramLong / 1000L));
          }
        });
      }
      downstreamFormat = format;
    }
    if (extractors.size() > 1)
    {
      localObject2 = (HlsExtractorWrapper)extractors.get(1);
      Assertions.checkState(((HlsExtractorWrapper)localObject1).isPrepared());
      if ((!spliceConfigured) && (shouldSpliceIn) && (((HlsExtractorWrapper)localObject2).isPrepared())) {
        break label273;
      }
    }
    label273:
    int j;
    Object localObject3;
    for (;;)
    {
      bool = false;
      do
      {
        if ((extractors.size() <= bool + true) || (((HlsExtractorWrapper)localObject1).hasSamples(paramInt))) {
          break;
        }
        localObject1 = extractors;
        bool += true;
        localObject2 = (HlsExtractorWrapper)((LinkedList)localObject1).get(bool);
        localObject1 = localObject2;
      } while (((HlsExtractorWrapper)localObject2).isPrepared());
      return -2;
      int k = ((HlsExtractorWrapper)localObject1).getTrackCount();
      j = 0;
      paramBoolean = true;
      if (j < k)
      {
        localObject3 = (DefaultTrackOutput)sampleQueues.valueAt(j);
        Object localObject4 = (DefaultTrackOutput)sampleQueues.valueAt(j);
        if (spliceOutTimeUs != Long.MIN_VALUE) {
          bool = true;
        }
        for (;;)
        {
          j += 1;
          paramBoolean &= bool;
          break;
          if (rollingBuffer.peekSample(sampleInfoHolder)) {}
          for (paramLong = sampleInfoHolder.timeUs;; paramLong = lastReadTimeUs + 1L)
          {
            localObject4 = rollingBuffer;
            while ((((RollingSampleBuffer)localObject4).peekSample(sampleInfoHolder)) && ((sampleInfoHolder.timeUs < paramLong) || (!sampleInfoHolder.isSyncFrame()))) {
              ((RollingSampleBuffer)localObject4).skipSample();
            }
          }
          if (((RollingSampleBuffer)localObject4).peekSample(sampleInfoHolder))
          {
            spliceOutTimeUs = sampleInfoHolder.timeUs;
            bool = true;
          }
          else
          {
            bool = false;
          }
        }
      }
      spliceConfigured = paramBoolean;
    }
    final Object localObject2 = ((HlsExtractorWrapper)localObject1).getMediaFormat(paramInt);
    label592:
    int i;
    if (localObject2 != null)
    {
      localObject3 = downstreamMediaFormats[paramInt];
      if (localObject2 == localObject3)
      {
        paramBoolean = true;
        if (paramBoolean) {
          break label641;
        }
        paramSampleHolder = chunkSource;
        if ((maxWidth != -1) && (maxHeight != -1)) {
          break label592;
        }
      }
      for (;;)
      {
        format = ((MediaFormat)localObject2);
        downstreamMediaFormats[paramInt] = localObject2;
        return -4;
        if (localObject3 == null)
        {
          paramBoolean = false;
          break;
        }
        paramBoolean = ((MediaFormat)localObject2).equalsInternal((MediaFormat)localObject3, true);
        break;
        i = maxWidth;
        j = maxHeight;
        maxWidth = i;
        maxHeight = j;
        if (frameworkMediaFormat != null) {
          ((MediaFormat)localObject2).maybeSetMaxDimensionsV16(frameworkMediaFormat);
        }
      }
    }
    label641:
    Assertions.checkState(((HlsExtractorWrapper)localObject1).isPrepared());
    if (((DefaultTrackOutput)sampleQueues.valueAt(paramInt)).getSample(paramSampleHolder))
    {
      if (timeUs < lastSeekPositionUs)
      {
        paramInt = 1;
        i = flags;
        if (paramInt == 0) {
          break label716;
        }
      }
      label716:
      for (paramInt = 134217728;; paramInt = 0)
      {
        flags = (paramInt | i);
        return -3;
        paramInt = 0;
        break;
      }
    }
    if (loadingFinished) {
      return -1;
    }
    return -2;
  }
  
  public final SampleSource.SampleSourceReader register()
  {
    remainingReleaseCount += 1;
    return this;
  }
  
  public final void release()
  {
    if (remainingReleaseCount > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      int i = remainingReleaseCount - 1;
      remainingReleaseCount = i;
      if ((i == 0) && (loader != null))
      {
        loader.release();
        loader = null;
      }
      return;
    }
  }
  
  public final void seekToUs(long paramLong)
  {
    Assertions.checkState(prepared);
    boolean bool;
    if (enabledTrackCount > 0)
    {
      bool = true;
      Assertions.checkState(bool);
      if (!isPendingReset()) {
        break label59;
      }
    }
    label59:
    for (long l = pendingResetPositionUs;; l = downstreamPositionUs)
    {
      downstreamPositionUs = paramLong;
      lastSeekPositionUs = paramLong;
      if (l != paramLong) {
        break label68;
      }
      return;
      bool = false;
      break;
    }
    label68:
    downstreamPositionUs = paramLong;
    int i = 0;
    while (i < pendingDiscontinuities.length)
    {
      pendingDiscontinuities[i] = true;
      i += 1;
    }
    restartFrom(paramLong);
  }
  
  public static abstract interface EventListener
    extends BaseChunkSampleSourceEventListener
  {}
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsSampleSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */