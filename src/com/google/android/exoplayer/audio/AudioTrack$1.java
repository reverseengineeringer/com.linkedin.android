package com.google.android.exoplayer.audio;

import android.os.ConditionVariable;

final class AudioTrack$1
  extends Thread
{
  AudioTrack$1(AudioTrack paramAudioTrack, android.media.AudioTrack paramAudioTrack1) {}
  
  public final void run()
  {
    try
    {
      val$toRelease.release();
      return;
    }
    finally
    {
      AudioTrack.access$100(this$0).open();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.audio.AudioTrack.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */