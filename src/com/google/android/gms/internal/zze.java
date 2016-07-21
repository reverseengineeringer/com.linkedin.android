package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zze
  implements zzn
{
  private final Executor zzs;
  
  public zze(final Handler paramHandler)
  {
    zzs = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public final void zza(zzk<?> paramzzk, zzm<?> paramzzm)
  {
    zza(paramzzk, paramzzm, null);
  }
  
  public final void zza(zzk<?> paramzzk, zzm<?> paramzzm, Runnable paramRunnable)
  {
    zzM = true;
    paramzzk.zzc("post-response");
    zzs.execute(new zza(paramzzk, paramzzm, paramRunnable));
  }
  
  public final void zza(zzk<?> paramzzk, zzr paramzzr)
  {
    paramzzk.zzc("post-error");
    paramzzr = new zzm(paramzzr);
    zzs.execute(new zza(paramzzk, paramzzr, null));
  }
  
  private final class zza
    implements Runnable
  {
    private final zzk zzv;
    private final zzm zzw;
    private final Runnable zzx;
    
    public zza(zzk paramzzk, zzm paramzzm, Runnable paramRunnable)
    {
      zzv = paramzzk;
      zzw = paramzzm;
      zzx = paramRunnable;
    }
    
    public final void run()
    {
      if (zzv.zzL) {
        zzv.zzd("canceled-at-delivery");
      }
      label50:
      label91:
      label124:
      label134:
      for (;;)
      {
        return;
        int i;
        if (zzw.zzah == null)
        {
          i = 1;
          if (i == 0) {
            break label91;
          }
          zzv.zza(zzw.result);
          if (!zzw.zzai) {
            break label124;
          }
          zzv.zzc("intermediate-response");
        }
        for (;;)
        {
          if (zzx == null) {
            break label134;
          }
          zzx.run();
          return;
          i = 0;
          break;
          zzk localzzk = zzv;
          zzr localzzr = zzw.zzah;
          if (zzH == null) {
            break label50;
          }
          zzH.zze(localzzr);
          break label50;
          zzv.zzd("done");
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */