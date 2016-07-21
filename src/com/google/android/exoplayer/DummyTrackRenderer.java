package com.google.android.exoplayer;

public final class DummyTrackRenderer
  extends TrackRenderer
{
  protected final int doPrepare(long paramLong)
  {
    return -1;
  }
  
  protected final void doSomeWork(long paramLong1, long paramLong2)
  {
    throw new IllegalStateException();
  }
  
  protected final long getBufferedPositionUs()
  {
    throw new IllegalStateException();
  }
  
  protected final long getDurationUs()
  {
    throw new IllegalStateException();
  }
  
  protected final boolean isEnded()
  {
    throw new IllegalStateException();
  }
  
  protected final boolean isReady()
  {
    throw new IllegalStateException();
  }
  
  protected final void maybeThrowError()
  {
    throw new IllegalStateException();
  }
  
  protected final void seekTo(long paramLong)
  {
    throw new IllegalStateException();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.DummyTrackRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */