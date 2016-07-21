package android.support.v4.content;

import android.os.SystemClock;
import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

final class AsyncTaskLoader$LoadTask
  extends ModernAsyncTask<Void, Void, D>
  implements Runnable
{
  private final CountDownLatch mDone = new CountDownLatch(1);
  boolean waiting;
  
  AsyncTaskLoader$LoadTask(AsyncTaskLoader paramAsyncTaskLoader) {}
  
  private D doInBackground$532ebdd5()
  {
    try
    {
      Object localObject = this$0.loadInBackground();
      return (D)localObject;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      if (!mFuture.isCancelled()) {
        throw localOperationCanceledException;
      }
    }
    return null;
  }
  
  protected final void onCancelled(D paramD)
  {
    try
    {
      this$0.dispatchOnCancelled(this, paramD);
      return;
    }
    finally
    {
      mDone.countDown();
    }
  }
  
  protected final void onPostExecute(D paramD)
  {
    for (;;)
    {
      AsyncTaskLoader localAsyncTaskLoader;
      try
      {
        localAsyncTaskLoader = this$0;
        if (mTask != this)
        {
          localAsyncTaskLoader.dispatchOnCancelled(this, paramD);
          return;
        }
        if (mAbandoned)
        {
          localAsyncTaskLoader.onCanceled(paramD);
          continue;
        }
        mProcessingChange = false;
      }
      finally
      {
        mDone.countDown();
      }
      mLastLoadCompleteTime = SystemClock.uptimeMillis();
      mTask = null;
      localAsyncTaskLoader.deliverResult(paramD);
    }
  }
  
  public final void run()
  {
    waiting = false;
    this$0.executePendingTask();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.AsyncTaskLoader.LoadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */