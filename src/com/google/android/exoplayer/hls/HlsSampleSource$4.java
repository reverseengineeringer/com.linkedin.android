package com.google.android.exoplayer.hls;

import java.io.IOException;

final class HlsSampleSource$4
  implements Runnable
{
  HlsSampleSource$4(HlsSampleSource paramHlsSampleSource, IOException paramIOException) {}
  
  public final void run()
  {
    this$0.eventListener.onLoadError(this$0.eventSourceId, val$e);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsSampleSource.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */