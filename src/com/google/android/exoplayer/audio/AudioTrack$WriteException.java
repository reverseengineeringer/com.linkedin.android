package com.google.android.exoplayer.audio;

public final class AudioTrack$WriteException
  extends Exception
{
  public final int errorCode;
  
  public AudioTrack$WriteException(int paramInt)
  {
    super("AudioTrack write failed: " + paramInt);
    errorCode = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.audio.AudioTrack.WriteException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */