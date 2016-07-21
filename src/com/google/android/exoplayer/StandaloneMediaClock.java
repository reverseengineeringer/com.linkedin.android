package com.google.android.exoplayer;

import android.os.SystemClock;

final class StandaloneMediaClock
  implements MediaClock
{
  long deltaUs;
  long positionUs;
  boolean started;
  
  static long elapsedRealtimeMinus(long paramLong)
  {
    return SystemClock.elapsedRealtime() * 1000L - paramLong;
  }
  
  public final long getPositionUs()
  {
    if (started) {
      return elapsedRealtimeMinus(deltaUs);
    }
    return positionUs;
  }
  
  public final void setPositionUs(long paramLong)
  {
    positionUs = paramLong;
    deltaUs = elapsedRealtimeMinus(paramLong);
  }
  
  public final void stop()
  {
    if (started)
    {
      positionUs = elapsedRealtimeMinus(deltaUs);
      started = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.StandaloneMediaClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */