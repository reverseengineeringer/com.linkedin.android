package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;

abstract class zzf
{
  private static volatile Handler zzRC;
  volatile long zzRD;
  private final zzw zzaTV;
  private boolean zzaVI;
  private final Runnable zzx;
  
  zzf(zzw paramzzw)
  {
    zzx.zzz(paramzzw);
    zzaTV = paramzzw;
    zzaVI = true;
    zzx = new Runnable()
    {
      public final void run()
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          zzf.zza(zzf.this).zzCn().zzg(this);
          return;
        }
        if (zzRD != 0L) {}
        for (int i = 1;; i = 0)
        {
          zzf.zza$5e5e5743(zzf.this);
          if ((i == 0) || (!zzf.zzb(zzf.this))) {
            break;
          }
          zzf.this.run();
          return;
        }
      }
    };
  }
  
  private Handler getHandler()
  {
    if (zzRC != null) {
      return zzRC;
    }
    try
    {
      if (zzRC == null) {
        zzRC = new Handler(zzaTV.mContext.getMainLooper());
      }
      Handler localHandler = zzRC;
      return localHandler;
    }
    finally {}
  }
  
  public final void cancel()
  {
    zzRD = 0L;
    getHandler().removeCallbacks(zzx);
  }
  
  public abstract void run();
  
  public final void zzt(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      zzRD = zzaTV.zzqW.currentTimeMillis();
      if (!getHandler().postDelayed(zzx, paramLong)) {
        zzaTV.zzAo().zzaWC.zzj("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */