package com.google.android.gms.measurement.internal;

import android.os.Looper;

final class zzf$1
  implements Runnable
{
  zzf$1(zzf paramzzf) {}
  
  public final void run()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      zzf.zza(zzaVJ).zzCn().zzg(this);
      return;
    }
    if (zzaVJ.zzRD != 0L) {}
    for (int i = 1;; i = 0)
    {
      zzf.zza$5e5e5743(zzaVJ);
      if ((i == 0) || (!zzf.zzb(zzaVJ))) {
        break;
      }
      zzaVJ.run();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzf.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */