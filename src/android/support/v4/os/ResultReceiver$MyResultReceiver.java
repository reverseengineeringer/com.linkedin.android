package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;

final class ResultReceiver$MyResultReceiver
  extends IResultReceiver.Stub
{
  ResultReceiver$MyResultReceiver(ResultReceiver paramResultReceiver) {}
  
  public final void send(int paramInt, Bundle paramBundle)
  {
    if (this$0.mHandler != null)
    {
      this$0.mHandler.post(new ResultReceiver.MyRunnable(this$0, paramInt, paramBundle));
      return;
    }
    ResultReceiver.onReceiveResult$68e2e3e6();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.os.ResultReceiver.MyResultReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */