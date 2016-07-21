package com.google.android.exoplayer.util;

public final class SystemClock
  implements Clock
{
  public final long elapsedRealtime()
  {
    return android.os.SystemClock.elapsedRealtime();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.SystemClock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */