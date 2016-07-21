package com.google.android.gms.internal;

import java.util.concurrent.Future;

final class zziq$4
  implements Runnable
{
  zziq$4(zzjd paramzzjd, Future paramFuture) {}
  
  public final void run()
  {
    if (zzLX.isCancelled()) {
      zzLZ.cancel(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziq.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */