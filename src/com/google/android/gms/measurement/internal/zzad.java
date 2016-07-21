package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public final class zzad
  extends zzz
{
  Handler mHandler;
  private long zzaZa;
  final Runnable zzaZb = new Runnable()
  {
    public final void run()
    {
      zzCn().zzg(new Runnable()
      {
        public final void run()
        {
          zzDx();
        }
      });
    }
  };
  private final zzf zzaZc = new zzf(zzaTV)
  {
    public final void run()
    {
      zzad.zza(zzad.this);
    }
  };
  private final zzf zzaZd = new zzf(zzaTV)
  {
    public final void run()
    {
      zzad.zzb(zzad.this);
    }
  };
  
  zzad(zzw paramzzw)
  {
    super(paramzzw);
  }
  
  final void zzDv()
  {
    try
    {
      if (mHandler == null) {
        mHandler = new Handler(Looper.getMainLooper());
      }
      return;
    }
    finally {}
  }
  
  public final void zzDx()
  {
    super.zzjk();
    zzAozzaWJ.zzfg("Application backgrounded. Logging engagement");
    long l = zzCozzaXw.get();
    if (l > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("_et", l);
      super.zzCf().zze("auto", "_e", localBundle);
      zzCozzaXw.set(0L);
      return;
    }
    zzAozzaWF.zzj("Not logging non-positive engagement time", Long.valueOf(l));
  }
  
  protected final void zziJ() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */