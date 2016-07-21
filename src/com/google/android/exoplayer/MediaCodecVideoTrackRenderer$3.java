package com.google.android.exoplayer;

final class MediaCodecVideoTrackRenderer$3
  implements Runnable
{
  MediaCodecVideoTrackRenderer$3(MediaCodecVideoTrackRenderer paramMediaCodecVideoTrackRenderer, int paramInt, long paramLong) {}
  
  public final void run()
  {
    this$0.eventListener.onDroppedFrames(val$countToNotify, val$elapsedToNotify);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecVideoTrackRenderer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */