package com.conviva.utils;

import java.util.concurrent.Callable;

public final class Timer$1WrappedTimerAction
  implements Runnable
{
  private String _actionName;
  private Runnable _timerAction;
  
  public Timer$1WrappedTimerAction(Timer paramTimer, String paramString, Runnable paramRunnable)
  {
    _actionName = paramString;
    _timerAction = paramRunnable;
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
 * Qualified Name:     com.conviva.utils.Timer.1WrappedTimerAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */