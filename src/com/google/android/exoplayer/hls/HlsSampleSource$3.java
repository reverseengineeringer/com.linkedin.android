package com.google.android.exoplayer.hls;

final class HlsSampleSource$3
  implements Runnable
{
  HlsSampleSource$3(HlsSampleSource paramHlsSampleSource, long paramLong) {}
  
  public final void run()
  {
    this$0.eventListener.onLoadCanceled(this$0.eventSourceId, val$bytesLoaded);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsSampleSource.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */