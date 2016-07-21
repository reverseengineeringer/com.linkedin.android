package com.google.android.exoplayer;

final class MediaCodecTrackRenderer$3
  implements Runnable
{
  MediaCodecTrackRenderer$3(MediaCodecTrackRenderer paramMediaCodecTrackRenderer, String paramString, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    this$0.eventListener.onDecoderInitialized(val$decoderName, val$initializedTimestamp, val$initializationDuration);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecTrackRenderer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */