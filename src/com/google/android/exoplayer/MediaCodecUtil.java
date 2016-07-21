package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer.util.Util;
import java.util.HashMap;

@TargetApi(16)
public final class MediaCodecUtil
{
  private static final HashMap<CodecKey, Pair<String, MediaCodecInfo.CodecCapabilities>> codecs = new HashMap();
  
  public static DecoderInfo getDecoderInfo(String paramString, boolean paramBoolean)
    throws MediaCodecUtil.DecoderQueryException
  {
    Object localObject = getMediaCodecInfo(paramString, paramBoolean);
    if (localObject == null) {
      return null;
    }
    paramString = (String)first;
    localObject = (MediaCodecInfo.CodecCapabilities)second;
    if (Util.SDK_INT >= 19) {}
    for (paramBoolean = ((MediaCodecInfo.CodecCapabilities)localObject).isFeatureSupported("adaptive-playback");; paramBoolean = false) {
      return new DecoderInfo(paramString, paramBoolean);
    }
  }
  
  private static Pair<String, MediaCodecInfo.CodecCapabilities> getMediaCodecInfo(CodecKey paramCodecKey, MediaCodecListCompat paramMediaCodecListCompat)
    throws MediaCodecUtil.DecoderQueryException
  {
    for (;;)
    {
      String str1;
      int j;
      String str2;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      boolean bool2;
      HashMap localHashMap;
      try
      {
        str1 = mimeType;
        int k = paramMediaCodecListCompat.getCodecCount();
        boolean bool1 = paramMediaCodecListCompat.secureDecodersExplicit();
        j = 0;
        if (j >= k) {
          break label468;
        }
        MediaCodecInfo localMediaCodecInfo = paramMediaCodecListCompat.getCodecInfoAt(j);
        str2 = localMediaCodecInfo.getName();
        if ((localMediaCodecInfo.isEncoder()) || (!str2.startsWith("OMX."))) {
          break label470;
        }
        if ((!bool1) && (str2.endsWith(".secure")))
        {
          break label470;
          if (i == 0) {
            break label461;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          i = 0;
          if (i >= arrayOfString.length) {
            break label461;
          }
          localObject = arrayOfString[i];
          if (!((String)localObject).equalsIgnoreCase(str1)) {
            break label454;
          }
          localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType((String)localObject);
          bool2 = paramMediaCodecListCompat.isSecurePlaybackSupported(mimeType, localCodecCapabilities);
          if (bool1) {
            break label403;
          }
          localHashMap = codecs;
          if (!secure) {
            break label480;
          }
          localObject = new CodecKey(str1, false);
          localHashMap.put(localObject, Pair.create(str2, localCodecCapabilities));
          if (bool2)
          {
            localHashMap = codecs;
            if (secure)
            {
              localObject = paramCodecKey;
              localHashMap.put(localObject, Pair.create(str2 + ".secure", localCodecCapabilities));
            }
          }
          else
          {
            if (!codecs.containsKey(paramCodecKey)) {
              break label454;
            }
            return (Pair)codecs.get(paramCodecKey);
          }
        }
        else
        {
          if ((Util.SDK_INT == 16) && (("dlxu".equals(Util.DEVICE)) || ("protou".equals(Util.DEVICE)) || ("C6602".equals(Util.DEVICE)) || ("C6603".equals(Util.DEVICE))) && (str2.equals("OMX.qcom.audio.decoder.mp3")))
          {
            i = 0;
            continue;
          }
          if ((Util.SDK_INT > 19) || (Util.DEVICE == null) || (!Util.DEVICE.startsWith("serrano")) || (!"samsung".equals(Util.MANUFACTURER)) || (!str2.equals("OMX.SEC.vp8.dec"))) {
            break label475;
          }
          i = 0;
          continue;
        }
        localObject = new CodecKey(str1, true);
        continue;
        localHashMap = codecs;
      }
      catch (Exception paramCodecKey)
      {
        throw new DecoderQueryException(paramCodecKey, (byte)0);
      }
      label403:
      if (secure == bool2) {}
      for (Object localObject = paramCodecKey;; localObject = new CodecKey(str1, bool2))
      {
        localHashMap.put(localObject, Pair.create(str2, localCodecCapabilities));
        break;
      }
      label454:
      i += 1;
      continue;
      label461:
      j += 1;
      continue;
      label468:
      return null;
      label470:
      int i = 0;
      continue;
      label475:
      i = 1;
      continue;
      label480:
      localObject = paramCodecKey;
    }
  }
  
  private static Pair<String, MediaCodecInfo.CodecCapabilities> getMediaCodecInfo(String paramString, boolean paramBoolean)
    throws MediaCodecUtil.DecoderQueryException
  {
    for (;;)
    {
      try
      {
        CodecKey localCodecKey = new CodecKey(paramString, paramBoolean);
        if (codecs.containsKey(localCodecKey))
        {
          paramString = (Pair)codecs.get(localCodecKey);
          return paramString;
        }
        Object localObject;
        if (Util.SDK_INT >= 21)
        {
          localObject = new MediaCodecListCompatV21(paramBoolean);
          Pair localPair = getMediaCodecInfo(localCodecKey, (MediaCodecListCompat)localObject);
          localObject = localPair;
          if (paramBoolean)
          {
            localObject = localPair;
            if (localPair == null)
            {
              localObject = localPair;
              if (Util.SDK_INT >= 21)
              {
                localPair = getMediaCodecInfo(localCodecKey, new MediaCodecListCompatV16((byte)0));
                localObject = localPair;
                if (localPair != null)
                {
                  Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + paramString + ". Assuming: " + (String)first);
                  localObject = localPair;
                }
              }
            }
          }
        }
        else
        {
          localObject = new MediaCodecListCompatV16((byte)0);
          continue;
        }
        paramString = (String)localObject;
      }
      finally {}
    }
  }
  
  public static int maxH264DecodableFrameSize()
    throws MediaCodecUtil.DecoderQueryException
  {
    int i = 0;
    Object localObject = getMediaCodecInfo("video/avc", false);
    if (localObject == null) {}
    int j;
    int k;
    do
    {
      return i;
      j = 0;
      localObject = (MediaCodecInfo.CodecCapabilities)second;
      k = 0;
      i = j;
    } while (k >= profileLevels.length);
    switch (profileLevels[k].level)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      j = Math.max(i, j);
      k += 1;
      break;
      i = 25344;
      continue;
      i = 25344;
      continue;
      i = 101376;
      continue;
      i = 101376;
      continue;
      i = 101376;
      continue;
      i = 202752;
      continue;
      i = 414720;
      continue;
      i = 414720;
      continue;
      i = 921600;
      continue;
      i = 1310720;
      continue;
      i = 2097152;
      continue;
      i = 2097152;
      continue;
      i = 2228224;
      continue;
      i = 5652480;
      continue;
      i = 9437184;
    }
  }
  
  private static final class CodecKey
  {
    public final String mimeType;
    public final boolean secure;
    
    public CodecKey(String paramString, boolean paramBoolean)
    {
      mimeType = paramString;
      secure = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (paramObject.getClass() != CodecKey.class)) {
          return false;
        }
        paramObject = (CodecKey)paramObject;
      } while ((TextUtils.equals(mimeType, mimeType)) && (secure == secure));
      return false;
    }
    
    public final int hashCode()
    {
      int i;
      if (mimeType == null)
      {
        i = 0;
        if (!secure) {
          break label41;
        }
      }
      label41:
      for (int j = 1231;; j = 1237)
      {
        return j + (i + 31) * 31;
        i = mimeType.hashCode();
        break;
      }
    }
  }
  
  public static final class DecoderQueryException
    extends Exception
  {
    private DecoderQueryException(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  private static abstract interface MediaCodecListCompat
  {
    public abstract int getCodecCount();
    
    public abstract MediaCodecInfo getCodecInfoAt(int paramInt);
    
    public abstract boolean isSecurePlaybackSupported(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities);
    
    public abstract boolean secureDecodersExplicit();
  }
  
  private static final class MediaCodecListCompatV16
    implements MediaCodecUtil.MediaCodecListCompat
  {
    public final int getCodecCount()
    {
      return MediaCodecList.getCodecCount();
    }
    
    public final MediaCodecInfo getCodecInfoAt(int paramInt)
    {
      return MediaCodecList.getCodecInfoAt(paramInt);
    }
    
    public final boolean isSecurePlaybackSupported(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      return "video/avc".equals(paramString);
    }
    
    public final boolean secureDecodersExplicit()
    {
      return false;
    }
  }
  
  @TargetApi(21)
  private static final class MediaCodecListCompatV21
    implements MediaCodecUtil.MediaCodecListCompat
  {
    private final int codecKind;
    private MediaCodecInfo[] mediaCodecInfos;
    
    public MediaCodecListCompatV21(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        codecKind = i;
        return;
      }
    }
    
    private void ensureMediaCodecInfosInitialized()
    {
      if (mediaCodecInfos == null) {
        mediaCodecInfos = new MediaCodecList(codecKind).getCodecInfos();
      }
    }
    
    public final int getCodecCount()
    {
      ensureMediaCodecInfosInitialized();
      return mediaCodecInfos.length;
    }
    
    public final MediaCodecInfo getCodecInfoAt(int paramInt)
    {
      ensureMediaCodecInfosInitialized();
      return mediaCodecInfos[paramInt];
    }
    
    public final boolean isSecurePlaybackSupported(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
    {
      return paramCodecCapabilities.isFeatureSupported("secure-playback");
    }
    
    public final boolean secureDecodersExplicit()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */