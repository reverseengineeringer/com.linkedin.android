package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zziq$5
  implements ThreadFactory
{
  private final AtomicInteger zzMa = new AtomicInteger(1);
  
  zziq$5(String paramString) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "AdWorker(" + zzMb + ") #" + zzMa.getAndIncrement());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziq.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */