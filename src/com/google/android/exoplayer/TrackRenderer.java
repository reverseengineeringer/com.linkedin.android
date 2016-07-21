package com.google.android.exoplayer;

import com.google.android.exoplayer.util.Assertions;

public abstract class TrackRenderer
  implements ExoPlayer.ExoPlayerComponent
{
  public int state;
  
  final void disable()
    throws ExoPlaybackException
  {
    if (state == 2) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      state = 1;
      onDisabled();
      return;
    }
  }
  
  public abstract int doPrepare(long paramLong)
    throws ExoPlaybackException;
  
  public abstract void doSomeWork(long paramLong1, long paramLong2)
    throws ExoPlaybackException;
  
  final void enable(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {
    boolean bool = true;
    if (state == 1) {}
    for (;;)
    {
      Assertions.checkState(bool);
      state = 2;
      onEnabled(paramLong, paramBoolean);
      return;
      bool = false;
    }
  }
  
  public abstract long getBufferedPositionUs();
  
  public abstract long getDurationUs();
  
  protected MediaClock getMediaClock()
  {
    return null;
  }
  
  public void handleMessage(int paramInt, Object paramObject)
    throws ExoPlaybackException
  {}
  
  public abstract boolean isEnded();
  
  public abstract boolean isReady();
  
  public abstract void maybeThrowError()
    throws ExoPlaybackException;
  
  public void onDisabled()
    throws ExoPlaybackException
  {}
  
  public void onEnabled(long paramLong, boolean paramBoolean)
    throws ExoPlaybackException
  {}
  
  public void onReleased()
    throws ExoPlaybackException
  {}
  
  protected void onStarted()
    throws ExoPlaybackException
  {}
  
  protected void onStopped()
    throws ExoPlaybackException
  {}
  
  public abstract void seekTo(long paramLong)
    throws ExoPlaybackException;
  
  final void start()
    throws ExoPlaybackException
  {
    if (state == 2) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      state = 3;
      onStarted();
      return;
    }
  }
  
  final void stop()
    throws ExoPlaybackException
  {
    if (state == 3) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      state = 2;
      onStopped();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.TrackRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */