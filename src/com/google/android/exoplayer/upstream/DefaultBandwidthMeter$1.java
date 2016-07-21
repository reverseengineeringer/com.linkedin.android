package com.google.android.exoplayer.upstream;

final class DefaultBandwidthMeter$1
  implements Runnable
{
  DefaultBandwidthMeter$1(DefaultBandwidthMeter paramDefaultBandwidthMeter, int paramInt, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    this$0.eventListener.onBandwidthSample(val$elapsedMs, val$bytes, val$bitrate);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.DefaultBandwidthMeter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */