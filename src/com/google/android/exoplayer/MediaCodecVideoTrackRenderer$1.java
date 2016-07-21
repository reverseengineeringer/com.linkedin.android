package com.google.android.exoplayer;

final class MediaCodecVideoTrackRenderer$1
  implements Runnable
{
  MediaCodecVideoTrackRenderer$1(MediaCodecVideoTrackRenderer paramMediaCodecVideoTrackRenderer, int paramInt1, int paramInt2, float paramFloat) {}
  
  public final void run()
  {
    this$0.eventListener.onVideoSizeChanged(val$currentWidth, val$currentHeight, val$currentPixelWidthHeightRatio);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecVideoTrackRenderer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */