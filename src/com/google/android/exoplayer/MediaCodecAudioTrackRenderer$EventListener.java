package com.google.android.exoplayer;

import com.google.android.exoplayer.audio.AudioTrack.InitializationException;
import com.google.android.exoplayer.audio.AudioTrack.WriteException;

public abstract interface MediaCodecAudioTrackRenderer$EventListener
  extends MediaCodecTrackRenderer.EventListener
{
  public abstract void onAudioTrackInitializationError(AudioTrack.InitializationException paramInitializationException);
  
  public abstract void onAudioTrackWriteError(AudioTrack.WriteException paramWriteException);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecAudioTrackRenderer.EventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */