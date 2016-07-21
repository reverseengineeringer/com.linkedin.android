package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Callable;

final class zziq$3
  implements Runnable
{
  zziq$3(zzjd paramzzjd, Callable paramCallable) {}
  
  public final void run()
  {
    try
    {
      Process.setThreadPriority(10);
      zzLX.zzg(zzLY.call());
      return;
    }
    catch (Exception localException)
    {
      zzr.zzbF().zzb(localException, true);
      zzLX.cancel(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziq.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */