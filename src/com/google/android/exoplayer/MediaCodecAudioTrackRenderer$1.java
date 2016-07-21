package com.google.android.exoplayer;

import com.google.android.exoplayer.audio.AudioTrack.InitializationException;

final class MediaCodecAudioTrackRenderer$1
  implements Runnable
{
  MediaCodecAudioTrackRenderer$1(MediaCodecAudioTrackRenderer paramMediaCodecAudioTrackRenderer, AudioTrack.InitializationException paramInitializationException) {}
  
  public final void run()
  {
    this$0.eventListener.onAudioTrackInitializationError(val$e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecAudioTrackRenderer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */