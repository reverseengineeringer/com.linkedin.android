package com.conviva.utils;

import com.conviva.api.system.ICallbackInterface;

final class CallbackWithTimeout$1WrapperCallback
  implements ICallbackInterface, Runnable
{
  private ICallbackInterface _callback;
  private boolean _calledBack;
  private String _timeoutMessage;
  private int _timeoutMs;
  
  public CallbackWithTimeout$1WrapperCallback(CallbackWithTimeout paramCallbackWithTimeout, ICallbackInterface paramICallbackInterface, int paramInt, String paramString)
  {
    _callback = paramICallbackInterface;
    _timeoutMs = paramInt;
    _timeoutMessage = paramString;
    _calledBack = false;
  }
  
  public final void done(boolean paramBoolean, String paramString)
  {
    if (!_calledBack)
    {
      _calledBack = true;
      _callback.done(paramBoolean, paramString);
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
}

/* Location:
 * Qualified Name:     com.conviva.utils.CallbackWithTimeout.1WrapperCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */