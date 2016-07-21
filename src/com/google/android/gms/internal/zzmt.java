package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzmt
  implements zzmq
{
  private static zzmt zzaoa;
  
  public static zzmq zzsc()
  {
    try
    {
      if (zzaoa == null) {
        zzaoa = new zzmt();
      }
      zzmt localzzmt = zzaoa;
      return localzzmt;
    }
    finally {}
  }
  
  public final long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public final long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */