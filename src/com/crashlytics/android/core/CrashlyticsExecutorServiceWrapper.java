package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class CrashlyticsExecutorServiceWrapper
{
  private final ExecutorService executorService;
  
  public CrashlyticsExecutorServiceWrapper(ExecutorService paramExecutorService)
  {
    executorService = paramExecutorService;
  }
  
  public final Future<?> executeAsync(final Runnable paramRunnable)
  {
    try
    {
      paramRunnable = executorService.submit(new Runnable()
      {
        public final void run()
        {
          try
          {
            paramRunnable.run();
            return;
          }
          catch (Exception localException)
          {
            Fabric.getLogger().e("CrashlyticsCore", "Failed to execute task.", localException);
          }
        }
      });
      return paramRunnable;
    }
    catch (RejectedExecutionException paramRunnable)
    {
      Fabric.getLogger().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
    }
    return null;
  }
  
  public final <T> Future<T> executeAsync(final Callable<T> paramCallable)
  {
    try
    {
      paramCallable = executorService.submit(new Callable()
      {
        public final T call()
          throws Exception
        {
          try
          {
            Object localObject = paramCallable.call();
            return (T)localObject;
          }
          catch (Exception localException)
          {
            Fabric.getLogger().e("CrashlyticsCore", "Failed to execute task.", localException);
          }
          return null;
        }
      });
      return paramCallable;
    }
    catch (RejectedExecutionException paramCallable)
    {
      Fabric.getLogger().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
    }
    return null;
  }
  
  final <T> T executeSyncLoggingException(Callable<T> paramCallable)
  {
    try
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        return (T)executorService.submit(paramCallable).get(4L, TimeUnit.SECONDS);
      }
      paramCallable = executorService.submit(paramCallable).get();
      return paramCallable;
    }
    catch (RejectedExecutionException paramCallable)
    {
      Fabric.getLogger().d("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
      return null;
    }
    catch (Exception paramCallable)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Failed to execute task.", paramCallable);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsExecutorServiceWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */