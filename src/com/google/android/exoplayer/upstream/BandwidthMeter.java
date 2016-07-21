package com.google.android.exoplayer.upstream;

public abstract interface BandwidthMeter
  extends TransferListener
{
  public abstract long getBitrateEstimate();
  
  public static abstract interface EventListener
  {
    public abstract void onBandwidthSample(int paramInt, long paramLong1, long paramLong2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.BandwidthMeter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */