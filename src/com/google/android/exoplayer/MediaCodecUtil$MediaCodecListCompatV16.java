package com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

final class MediaCodecUtil$MediaCodecListCompatV16
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

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecUtil.MediaCodecListCompatV16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */