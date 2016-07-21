package android.support.v4.os;

import android.os.Build.VERSION;

public final class CancellationSignal
{
  public boolean mCancelInProgress;
  public Object mCancellationSignalObj;
  public boolean mIsCanceled;
  
  public final Object getCancellationSignalObject()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    try
    {
      if (mCancellationSignalObj == null)
      {
        mCancellationSignalObj = new android.os.CancellationSignal();
        if (mIsCanceled) {
          ((android.os.CancellationSignal)mCancellationSignalObj).cancel();
        }
      }
      Object localObject1 = mCancellationSignalObj;
      return localObject1;
    }
    finally {}
  }
  
  public final boolean isCanceled()
  {
    try
    {
      boolean bool = mIsCanceled;
      return bool;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.os.CancellationSignal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */