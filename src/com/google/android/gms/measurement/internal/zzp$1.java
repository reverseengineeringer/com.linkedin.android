package com.google.android.gms.measurement.internal;

final class zzp$1
  implements Runnable
{
  zzp$1(zzp paramzzp, String paramString) {}
  
  public final void run()
  {
    zzt localzzt = zzaWM.zzaTV.zzCo();
    if ((!localzzt.isInitialized()) || (zzaYC))
    {
      zzaWM.zzl(6, "Persisted config not initialized . Not logging error/warn.");
      return;
    }
    zzaXi.zzf(zzaWL, 1L);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzp.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */