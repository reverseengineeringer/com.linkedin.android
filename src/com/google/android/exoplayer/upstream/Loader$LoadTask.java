package com.google.android.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.TraceUtil;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class Loader$LoadTask
  extends Handler
  implements Runnable
{
  private final Loader.Callback callback;
  volatile Thread executorThread;
  final Loader.Loadable loadable;
  
  public Loader$LoadTask(Loader paramLoader, Looper paramLooper, Loader.Loadable paramLoadable, Loader.Callback paramCallback)
  {
    super(paramLooper);
    loadable = paramLoadable;
    callback = paramCallback;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (what == 2) {
      throw ((Error)obj);
    }
    this$0.loading = false;
    this$0.currentTask = null;
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

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.Loader.LoadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */