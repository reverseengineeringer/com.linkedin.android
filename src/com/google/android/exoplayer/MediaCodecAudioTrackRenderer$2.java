package com.google.android.exoplayer;

import com.google.android.exoplayer.audio.AudioTrack.WriteException;

final class MediaCodecAudioTrackRenderer$2
  implements Runnable
{
  MediaCodecAudioTrackRenderer$2(MediaCodecAudioTrackRenderer paramMediaCodecAudioTrackRenderer, AudioTrack.WriteException paramWriteException) {}
  
  public final void run()
  {
    this$0.eventListener.onAudioTrackWriteError(val$e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecAudioTrackRenderer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */