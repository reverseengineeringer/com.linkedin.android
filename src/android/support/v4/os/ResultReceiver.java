package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator() {};
  public final Handler mHandler = null;
  public final boolean mLocal = false;
  public IResultReceiver mReceiver;
  
  ResultReceiver(Parcel paramParcel)
  {
    mReceiver = IResultReceiver.Stub.asInterface(paramParcel.readStrongBinder());
  }
  
  protected static void onReceiveResult$68e2e3e6() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (mReceiver == null) {
        mReceiver = new MyResultReceiver();
      }
      paramParcel.writeStrongBinder(mReceiver.asBinder());
      return;
    }
    finally {}
  }
  
  final class MyResultReceiver
    extends IResultReceiver.Stub
  {
    MyResultReceiver() {}
    
    public final void send(int paramInt, Bundle paramBundle)
    {
      if (mHandler != null)
      {
        mHandler.post(new ResultReceiver.MyRunnable(ResultReceiver.this, paramInt, paramBundle));
        return;
      }
      ResultReceiver.onReceiveResult$68e2e3e6();
    }
  }
  
  public final class MyRunnable
    implements Runnable
  {
    final int mResultCode;
    final Bundle mResultData;
    
    public MyRunnable(int paramInt, Bundle paramBundle)
    {
      mResultCode = paramInt;
      mResultData = paramBundle;
    }
    
    public final void run() {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */