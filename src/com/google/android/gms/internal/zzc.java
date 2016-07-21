package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzc
  extends Thread
{
  private static final boolean DEBUG = zzs.DEBUG;
  private final BlockingQueue<zzk<?>> zzh;
  private final BlockingQueue<zzk<?>> zzi;
  private final zzb zzj;
  private final zzn zzk;
  volatile boolean zzl = false;
  
  public zzc(BlockingQueue<zzk<?>> paramBlockingQueue1, BlockingQueue<zzk<?>> paramBlockingQueue2, zzb paramzzb, zzn paramzzn)
  {
    zzh = paramBlockingQueue1;
    zzi = paramBlockingQueue2;
    zzj = paramzzb;
    zzk = paramzzn;
  }
  
  public final void run()
  {
    if (DEBUG) {
      zzs.zza("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    zzj.zza();
    label73:
    zzb.zza localzza;
    for (;;)
    {
      try
      {
        zzk localzzk = (zzk)zzh.take();
        localzzk.zzc("cache-queue-take");
        if (!zzL) {
          break label73;
        }
        localzzk.zzd("cache-discard-canceled");
        continue;
        if (!zzl) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      localzza = zzj.zza(zzF);
      if (localzza == null)
      {
        localInterruptedException.zzc("cache-miss");
        zzi.put(localInterruptedException);
      }
      else
      {
        if (zze >= System.currentTimeMillis()) {
          break label257;
        }
        i = 1;
        label123:
        if (i == 0) {
          break;
        }
        localInterruptedException.zzc("cache-hit-expired");
        zzP = localzza;
        zzi.put(localInterruptedException);
      }
    }
    localInterruptedException.zzc("cache-hit");
    zzm localzzm = localInterruptedException.zza(new zzi(data, zzg));
    localInterruptedException.zzc("cache-hit-parsed");
    if (zzf < System.currentTimeMillis()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        zzk.zza(localInterruptedException, localzzm);
        break;
      }
      localInterruptedException.zzc("cache-hit-refresh-needed");
      zzP = localzza;
      zzai = true;
      zzk.zza(localInterruptedException, localzzm, new Runnable()
      {
        public final void run()
        {
          try
          {
            zzc.zza(zzc.this).put(localInterruptedException);
            return;
          }
          catch (InterruptedException localInterruptedException) {}
        }
      });
      break;
      label257:
      i = 0;
      break label123;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */