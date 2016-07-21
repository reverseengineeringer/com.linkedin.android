package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.os.OperationCanceledException;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public abstract class AsyncTaskLoader<D>
  extends Loader<D>
{
  volatile AsyncTaskLoader<D>.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.LoadTask mCancellingTask;
  private final Executor mExecutor;
  Handler mHandler;
  long mLastLoadCompleteTime = -10000L;
  volatile AsyncTaskLoader<D>.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.LoadTask mTask;
  long mUpdateThrottle;
  
  public AsyncTaskLoader(Context paramContext)
  {
    this(paramContext, ModernAsyncTask.THREAD_POOL_EXECUTOR);
  }
  
  private AsyncTaskLoader(Context paramContext, Executor paramExecutor)
  {
    super(paramContext);
    mExecutor = paramExecutor;
  }
  
  public void cancelLoadInBackground() {}
  
  final void dispatchOnCancelled(AsyncTaskLoader<D>.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.android.support.v4.content.AsyncTaskLoader.LoadTask paramAsyncTaskLoader, D paramD)
  {
    onCanceled(paramD);
    if (mCancellingTask == paramAsyncTaskLoader)
    {
      if (mProcessingChange) {
        mContentChanged = true;
      }
      mLastLoadCompleteTime = SystemClock.uptimeMillis();
      mCancellingTask = null;
      if (mOnLoadCanceledListener != null) {
        mOnLoadCanceledListener.onLoadCanceled$5dda1f52();
      }
      executePendingTask();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (mTask != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(mTask);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(mTask.waiting);
    }
    if (mCancellingTask != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(mCancellingTask);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(mCancellingTask.waiting);
    }
    if (mUpdateThrottle != 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      TimeUtils.formatDuration(mUpdateThrottle, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      TimeUtils.formatDuration(mLastLoadCompleteTime, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    }
  }
  
  final void executePendingTask()
  {
    if ((mCancellingTask == null) && (mTask != null))
    {
      if (mTask.waiting)
      {
        mTask.waiting = false;
        mHandler.removeCallbacks(mTask);
      }
      if ((mUpdateThrottle > 0L) && (SystemClock.uptimeMillis() < mLastLoadCompleteTime + mUpdateThrottle))
      {
        mTask.waiting = true;
        mHandler.postAtTime(mTask, mLastLoadCompleteTime + mUpdateThrottle);
      }
    }
    else
    {
      return;
    }
    LoadTask localLoadTask = mTask;
    Executor localExecutor = mExecutor;
    if (mStatus != ModernAsyncTask.Status.PENDING) {}
    switch (ModernAsyncTask.4.$SwitchMap$android$support$v4$content$ModernAsyncTask$Status[mStatus.ordinal()])
    {
    default: 
      mStatus = ModernAsyncTask.Status.RUNNING;
      mWorker.mParams = null;
      localExecutor.execute(mFuture);
      return;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public abstract D loadInBackground();
  
  protected final boolean onCancelLoad()
  {
    if (mTask != null)
    {
      if (mCancellingTask != null)
      {
        if (mTask.waiting)
        {
          mTask.waiting = false;
          mHandler.removeCallbacks(mTask);
        }
        mTask = null;
      }
    }
    else {
      return false;
    }
    if (mTask.waiting)
    {
      mTask.waiting = false;
      mHandler.removeCallbacks(mTask);
      mTask = null;
      return false;
    }
    boolean bool = mTask.mFuture.cancel(false);
    if (bool)
    {
      mCancellingTask = mTask;
      cancelLoadInBackground();
    }
    mTask = null;
    return bool;
  }
  
  public void onCanceled(D paramD) {}
  
  protected final void onForceLoad()
  {
    super.onForceLoad();
    cancelLoad();
    mTask = new LoadTask();
    executePendingTask();
  }
  
  final class LoadTask
    extends ModernAsyncTask<Void, Void, D>
    implements Runnable
  {
    private final CountDownLatch mDone = new CountDownLatch(1);
    boolean waiting;
    
    LoadTask() {}
    
    private D doInBackground$532ebdd5()
    {
      try
      {
        Object localObject = loadInBackground();
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
        dispatchOnCancelled(this, paramD);
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
          localAsyncTaskLoader = AsyncTaskLoader.this;
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
      executePendingTask();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.AsyncTaskLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */