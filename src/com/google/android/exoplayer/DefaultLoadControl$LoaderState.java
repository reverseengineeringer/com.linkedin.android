package com.google.android.exoplayer;

final class DefaultLoadControl$LoaderState
{
  public final int bufferSizeContribution;
  public int bufferState;
  public boolean loading;
  public long nextLoadPositionUs;
  
  public DefaultLoadControl$LoaderState(int paramInt)
  {
    bufferSizeContribution = paramInt;
    bufferState = 0;
    loading = false;
    nextLoadPositionUs = -1L;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.DefaultLoadControl.LoaderState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */