package com.google.android.exoplayer.audio;

public final class AudioTrack$InitializationException
  extends Exception
{
  public final int audioTrackState;
  
  public AudioTrack$InitializationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super("AudioTrack init failed: " + paramInt1 + ", Config(" + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ")");
    audioTrackState = paramInt1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.audio.AudioTrack.InitializationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */