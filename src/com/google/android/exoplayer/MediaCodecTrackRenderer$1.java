package com.google.android.exoplayer;

final class MediaCodecTrackRenderer$1
  implements Runnable
{
  MediaCodecTrackRenderer$1(MediaCodecTrackRenderer paramMediaCodecTrackRenderer, MediaCodecTrackRenderer.DecoderInitializationException paramDecoderInitializationException) {}
  
  public final void run()
  {
    this$0.eventListener.onDecoderInitializationError(val$e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecTrackRenderer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */