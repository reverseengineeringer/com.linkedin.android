package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
final class MediaCodecUtil$MediaCodecListCompatV21
  implements MediaCodecUtil.MediaCodecListCompat
{
  private final int codecKind;
  private MediaCodecInfo[] mediaCodecInfos;
  
  public MediaCodecUtil$MediaCodecListCompatV21(boolean paramBoolean)
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

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecUtil.MediaCodecListCompatV21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */