package com.google.android.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.TraceUtil;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader
{
  LoadTask currentTask;
  private final ExecutorService downloadExecutorService;
  public boolean loading;
  
  public Loader(String paramString)
  {
    downloadExecutorService = Util.newSingleThreadExecutor(paramString);
  }
  
  public final void cancelLoading()
  {
    Assertions.checkState(loading);
    LoadTask localLoadTask = currentTask;
    loadable.cancelLoad();
    if (executorThread != null) {
      executorThread.interrupt();
    }
  }
  
  public final void release()
  {
    if (loading) {
      cancelLoading();
    }
    downloadExecutorService.shutdown();
  }
  
  public final void startLoading(Looper paramLooper, Loadable paramLoadable, Callback paramCallback)
  {
    if (!loading) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      loading = true;
      currentTask = new LoadTask(paramLooper, paramLoadable, paramCallback);
      downloadExecutorService.submit(currentTask);
      return;
    }
  }
  
  public final void startLoading(Loadable paramLoadable, Callback paramCallback)
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      startLoading(localLooper, paramLoadable, paramCallback);
      return;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onLoadCanceled$35e469eb();
    
    public abstract void onLoadCompleted(Loader.Loadable paramLoadable);
    
    public abstract void onLoadError(Loader.Loadable paramLoadable, IOException paramIOException);
  }
  
  @SuppressLint({"HandlerLeak"})
  private final class LoadTask
    extends Handler
    implements Runnable
  {
    private final Loader.Callback callback;
    volatile Thread executorThread;
    final Loader.Loadable loadable;
    
    public LoadTask(Looper paramLooper, Loader.Loadable paramLoadable, Loader.Callback paramCallback)
    {
      super();
      loadable = paramLoadable;
      callback = paramCallback;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (what == 2) {
        throw ((Error)obj);
      }
      loading = false;
      currentTask = null;
      if (loadable.isLoadCanceled())
      {
        callback.onLoadCanceled$35e469eb();
        return;
      }
      switch (what)
      {
      default: 
        return;
      case 0: 
        callback.onLoadCompleted(loadable);
        return;
      }
      callback.onLoadError(loadable, (IOException)obj);
    }
    
    public final void run()
    {
      try
      {
        executorThread = Thread.currentThread();
        if (!loadable.isLoadCanceled())
        {
          TraceUtil.beginSection(loadable.getClass().getSimpleName() + ".load()");
          loadable.load();
          TraceUtil.endSection();
        }
        sendEmptyMessage(0);
        return;
      }
      catch (IOException localIOException)
      {
        obtainMessage(1, localIOException).sendToTarget();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        Assertions.checkState(loadable.isLoadCanceled());
        sendEmptyMessage(0);
        return;
      }
      catch (Exception localException)
      {
        Log.e("LoadTask", "Unexpected exception loading stream", localException);
        obtainMessage(1, new Loader.UnexpectedLoaderException(localException)).sendToTarget();
        return;
      }
      catch (Error localError)
      {
        Log.e("LoadTask", "Unexpected error loading stream", localError);
        obtainMessage(2, localError).sendToTarget();
        throw localError;
      }
    }
  }
  
  public static abstract interface Loadable
  {
    public abstract void cancelLoad();
    
    public abstract boolean isLoadCanceled();
    
    public abstract void load()
      throws IOException, InterruptedException;
  }
  
  public static final class UnexpectedLoaderException
    extends IOException
  {
    public UnexpectedLoaderException(Exception paramException)
    {
      super(paramException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.Loader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */