package com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;

abstract interface MediaCodecUtil$MediaCodecListCompat
{
  public abstract int getCodecCount();
  
  public abstract MediaCodecInfo getCodecInfoAt(int paramInt);
  
  public abstract boolean isSecurePlaybackSupported(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities);
  
  public abstract boolean secureDecodersExplicit();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecUtil.MediaCodecListCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */