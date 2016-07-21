package com.conviva.utils;

import com.conviva.api.system.ICallbackInterface;
import com.conviva.api.system.ICancelTimer;

public final class CallbackWithTimeout
{
  private Timer _timer;
  
  public CallbackWithTimeout(Timer paramTimer)
  {
    _timer = paramTimer;
  }
  
  public final ICallbackInterface getWrapperCallback(ICallbackInterface paramICallbackInterface, int paramInt, String paramString)
  {
    paramICallbackInterface = new ICallbackInterface()
    {
      private ICallbackInterface _callback;
      private boolean _calledBack;
      private String _timeoutMessage;
      private int _timeoutMs;
      
      public final void done(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        if (!_calledBack)
        {
          _calledBack = true;
          _callback.done(paramAnonymousBoolean, paramAnonymousString);
        }
      }
      
      public final void run()
      {
        if (!_calledBack)
        {
          _calledBack = true;
          _callback.done(false, _timeoutMessage + " (" + _timeoutMs + " ms)");
        }
      }
    };
    Object localObject = _timer;
    paramString = new Timer.2WrappedTimerAction((Timer)localObject, "CallbackWithTimeout.wrap", paramICallbackInterface);
    localObject = ((Timer)localObject).createTimer$23a07b1b(paramString, paramInt);
    _cancelTimer = ((ICancelTimer)localObject);
    if ((_timerActionHappened) && (localObject != null)) {
      ((ICancelTimer)localObject).cancel();
    }
    return paramICallbackInterface;
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.CallbackWithTimeout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */