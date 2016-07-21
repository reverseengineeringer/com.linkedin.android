package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

final class zzv$zzb
  implements Thread.UncaughtExceptionHandler
{
  private final String zzaXR;
  
  public zzv$zzb(zzv paramzzv, String paramString)
  {
    zzx.zzz(paramString);
    zzaXR = paramString;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      zzaXS.zzAo().zzaWC.zzj(zzaXR, paramThrowable);
      return;
    }
    finally
    {
      paramThread = finally;
      throw paramThread;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzv.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */