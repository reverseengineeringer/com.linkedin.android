package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class zzl$zza
{
  private final zzk zzait;
  
  protected zzl$zza(zzk paramzzk)
  {
    zzait = paramzzk;
  }
  
  public final void zzd(zzl paramzzl)
  {
    zzXG.lock();
    try
    {
      zzk localzzk1 = zzaip;
      zzk localzzk2 = zzait;
      if (localzzk1 != localzzk2) {
        return;
      }
      zzpt();
      return;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  protected abstract void zzpt();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */