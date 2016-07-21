package com.google.android.exoplayer.chunk;

import java.io.IOException;

public abstract interface BaseChunkSampleSourceEventListener
{
  public abstract void onDownstreamFormatChanged(int paramInt1, Format paramFormat, int paramInt2, int paramInt3);
  
  public abstract void onLoadCanceled(int paramInt, long paramLong);
  
  public abstract void onLoadCompleted(int paramInt1, long paramLong1, int paramInt2, int paramInt3, Format paramFormat, int paramInt4, int paramInt5, long paramLong2, long paramLong3);
  
  public abstract void onLoadError(int paramInt, IOException paramIOException);
  
  public abstract void onLoadStarted(int paramInt1, long paramLong, int paramInt2, int paramInt3, Format paramFormat, int paramInt4, int paramInt5);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */