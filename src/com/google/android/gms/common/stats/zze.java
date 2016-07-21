package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public final class zze
{
  private final long zzanN;
  private final int zzanO;
  private final SimpleArrayMap<String, Long> zzanP;
  
  public zze()
  {
    zzanN = 60000L;
    zzanO = 10;
    zzanP = new SimpleArrayMap(10);
  }
  
  public zze(long paramLong)
  {
    zzanN = paramLong;
    zzanO = 1024;
    zzanP = new SimpleArrayMap();
  }
  
  public final Long zzcS(String paramString)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = zzanN;
    for (;;)
    {
      int i;
      try
      {
        if (zzanP.size() >= zzanO)
        {
          i = zzanP.size() - 1;
          if (i >= 0)
          {
            if (l2 - ((Long)zzanP.valueAt(i)).longValue() > l1) {
              zzanP.removeAt(i);
            }
          }
          else
          {
            l1 /= 2L;
            Log.w("ConnectionTracker", "The max capacity " + zzanO + " is not enough. Current durationThreshold is: " + l1);
          }
        }
        else
        {
          paramString = (Long)zzanP.put(paramString, Long.valueOf(l2));
          return paramString;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  public final boolean zzcT(String paramString)
  {
    for (;;)
    {
      try
      {
        if (zzanP.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */