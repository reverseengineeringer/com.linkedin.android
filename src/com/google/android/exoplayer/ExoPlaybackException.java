package com.google.android.exoplayer;

public final class ExoPlaybackException
  extends Exception
{
  public final boolean caughtAtTopLevel;
  
  public ExoPlaybackException(String paramString)
  {
    super(paramString);
    caughtAtTopLevel = false;
  }
  
  public ExoPlaybackException(Throwable paramThrowable)
  {
    super(paramThrowable);
    caughtAtTopLevel = false;
  }
  
  ExoPlaybackException(Throwable paramThrowable, byte paramByte)
  {
    super(paramThrowable);
    caughtAtTopLevel = true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.ExoPlaybackException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */