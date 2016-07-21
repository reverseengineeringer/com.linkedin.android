package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;

final class HlsSampleSource$5
  implements Runnable
{
  HlsSampleSource$5(HlsSampleSource paramHlsSampleSource, Format paramFormat, int paramInt, long paramLong) {}
  
  public final void run()
  {
    this$0.eventListener.onDownstreamFormatChanged(this$0.eventSourceId, val$format, val$trigger, (int)(val$positionUs / 1000L));
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsSampleSource.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */