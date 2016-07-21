package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzr;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzhb
public final class zziq
{
  private static final ExecutorService zzLU = Executors.newFixedThreadPool(10, zzaB("Default"));
  private static final ExecutorService zzLV = Executors.newFixedThreadPool(5, zzaB("Loader"));
  
  public static zzjg<Void> zza(int paramInt, Runnable paramRunnable)
  {
    if (paramInt == 1) {
      zza(zzLV, new Callable() {});
    }
    zza(zzLU, new Callable() {});
  }
  
  public static zzjg<Void> zza(Runnable paramRunnable)
  {
    return zza(0, paramRunnable);
  }
  
  private static <T> zzjg<T> zza(ExecutorService arg0, final Callable<T> paramCallable)
  {
    localzzjd = new zzjd();
    try
    {
      paramCallable = new Runnable()
      {
        public final void run()
        {
          try
          {
            Process.setThreadPriority(10);
            zzLX.zzg(paramCallable.call());
            return;
          }
          catch (Exception localException)
          {
            zzr.zzbF().zzb(localException, true);
            zzLX.cancel(true);
          }
        }
      }
      {
        public final void run()
        {
          if (zzLX.isCancelled()) {
            zzLZ.cancel(true);
          }
        }
      };
      zzjh localzzjh = zzNe;
      synchronized (zzNm)
      {
        if (zzNp)
        {
          zzjh.zze(paramCallable);
          return localzzjd;
        }
        zzNo.add(paramCallable);
      }
      return localzzjd;
    }
    catch (RejectedExecutionException ???)
    {
      zzin.zzd("Thread execution is rejected.", ???);
      localzzjd.cancel(true);
    }
  }
  
  private static ThreadFactory zzaB(String paramString)
  {
    new ThreadFactory()
    {
      private final AtomicInteger zzMa = new AtomicInteger(1);
      
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, "AdWorker(" + zzMb + ") #" + zzMa.getAndIncrement());
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */