package com.google.android.exoplayer;

import java.io.IOException;

public abstract interface SampleSource$SampleSourceReader
{
  public abstract boolean continueBuffering(int paramInt, long paramLong);
  
  public abstract void disable(int paramInt);
  
  public abstract void enable(int paramInt, long paramLong);
  
  public abstract long getBufferedPositionUs();
  
  public abstract int getTrackCount();
  
  public abstract TrackInfo getTrackInfo(int paramInt);
  
  public abstract void maybeThrowError()
    throws IOException;
  
  public abstract boolean prepare(long paramLong);
  
  public abstract int readData(int paramInt, long paramLong, MediaFormatHolder paramMediaFormatHolder, SampleHolder paramSampleHolder, boolean paramBoolean);
  
  public abstract void release();
  
  public abstract void seekToUs(long paramLong);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.SampleSource.SampleSourceReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */