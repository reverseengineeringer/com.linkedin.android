package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ModernAsyncTask$InternalHandler
  extends Handler
{
  public ModernAsyncTask$InternalHandler()
  {
    super(Looper.getMainLooper());
  }
  
  public final void handleMessage(Message paramMessage)
  {
    ModernAsyncTask.AsyncTaskResult localAsyncTaskResult = (ModernAsyncTask.AsyncTaskResult)obj;
    switch (what)
    {
    default: 
      return;
    case 1: 
      ModernAsyncTask.access$400(mTask, mData[0]);
      return;
    }
    ModernAsyncTask.onProgressUpdate$1b4f7664();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.InternalHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */