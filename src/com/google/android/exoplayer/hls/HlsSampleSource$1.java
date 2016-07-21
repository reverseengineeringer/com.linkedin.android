package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;

final class HlsSampleSource$1
  implements Runnable
{
  HlsSampleSource$1(HlsSampleSource paramHlsSampleSource, long paramLong1, int paramInt1, int paramInt2, Format paramFormat, long paramLong2, long paramLong3) {}
  
  public final void run()
  {
    this$0.eventListener.onLoadStarted(this$0.eventSourceId, val$length, val$type, val$trigger, val$format, (int)(val$mediaStartTimeUs / 1000L), (int)(val$mediaEndTimeUs / 1000L));
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsSampleSource.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */