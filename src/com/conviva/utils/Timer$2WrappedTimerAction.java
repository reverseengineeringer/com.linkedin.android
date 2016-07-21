package com.conviva.utils;

import com.conviva.api.system.ICancelTimer;
import java.util.concurrent.Callable;

final class Timer$2WrappedTimerAction
  implements Runnable
{
  private String _actionName;
  ICancelTimer _cancelTimer;
  private Runnable _timerAction;
  boolean _timerActionHappened;
  
  public Timer$2WrappedTimerAction(Timer paramTimer, String paramString, Runnable paramRunnable)
  {
    _actionName = paramString;
    _timerAction = paramRunnable;
    _cancelTimer = null;
    _timerActionHappened = false;
  }
  
  public final void run()
  {
    if (this$0._exceptionCatcher != null) {}
    try
    {
      this$0._exceptionCatcher.runProtected(new Callable() {}, _actionName);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Timer.2WrappedTimerAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */