package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;

final class HlsSampleSource$2
  implements Runnable
{
  HlsSampleSource$2(HlsSampleSource paramHlsSampleSource, long paramLong1, int paramInt1, int paramInt2, Format paramFormat, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public final void run()
  {
    this$0.eventListener.onLoadCompleted(this$0.eventSourceId, val$bytesLoaded, val$type, val$trigger, val$format, (int)(val$mediaStartTimeUs / 1000L), (int)(val$mediaEndTimeUs / 1000L), val$elapsedRealtimeMs, val$loadDurationMs);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsSampleSource.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */