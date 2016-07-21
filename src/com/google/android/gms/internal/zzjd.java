package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzhb
public class zzjd<T>
  implements zzjg<T>
{
  private boolean zzCy = false;
  private T zzNc = null;
  private boolean zzNd = false;
  final zzjh zzNe = new zzjh();
  private final Object zzpV = new Object();
  
  public boolean cancel(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    synchronized (zzpV)
    {
      if (zzNd) {
        return false;
      }
    }
    zzCy = true;
    zzNd = true;
    zzpV.notifyAll();
    zzNe.zzhK();
    return true;
  }
  
  public T get()
  {
    synchronized (zzpV)
    {
      boolean bool = zzNd;
      if (bool) {}
    }
    try
    {
      zzpV.wait();
      if (zzCy)
      {
        throw new CancellationException("CallbackFuture was cancelled.");
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      Object localObject3 = zzNc;
      return (T)localObject3;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException
  {
    synchronized (zzpV)
    {
      boolean bool = zzNd;
      if (!bool) {}
      try
      {
        paramLong = paramTimeUnit.toMillis(paramLong);
        if (paramLong != 0L) {
          zzpV.wait(paramLong);
        }
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;) {}
      }
      if (!zzNd) {
        throw new TimeoutException("CallbackFuture timed out.");
      }
    }
    if (zzCy) {
      throw new CancellationException("CallbackFuture was cancelled.");
    }
    paramTimeUnit = zzNc;
    return paramTimeUnit;
  }
  
  public boolean isCancelled()
  {
    synchronized (zzpV)
    {
      boolean bool = zzCy;
      return bool;
    }
  }
  
  public boolean isDone()
  {
    synchronized (zzpV)
    {
      boolean bool = zzNd;
      return bool;
    }
  }
  
  public final void zzg(T paramT)
  {
    synchronized (zzpV)
    {
      if (zzCy) {
        return;
      }
      if (zzNd) {
        throw new IllegalStateException("Provided CallbackFuture with multiple values.");
      }
    }
    zzNd = true;
    zzNc = paramT;
    zzpV.notifyAll();
    zzNe.zzhK();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */