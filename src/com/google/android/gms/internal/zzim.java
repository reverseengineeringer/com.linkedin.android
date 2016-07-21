package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzhb
public abstract class zzim
{
  volatile Thread zzLM;
  private boolean zzLN = false;
  private final Runnable zzx = new Runnable()
  {
    public final void run()
    {
      zzLM = Thread.currentThread();
      zzbr();
    }
  };
  
  public abstract void zzbr();
  
  public final Future zzhn()
  {
    if (zzLN) {
      return zziq.zza(1, zzx);
    }
    return zziq.zza(zzx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */