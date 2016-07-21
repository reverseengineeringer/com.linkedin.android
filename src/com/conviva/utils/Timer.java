package com.conviva.utils;

import com.conviva.api.system.ICancelTimer;
import com.conviva.api.system.ITimerInterface;
import java.util.concurrent.Callable;

public final class Timer
{
  ExceptionCatcher _exceptionCatcher;
  private Logger _logger;
  private ITimerInterface _timerInterface;
  
  public Timer(Logger paramLogger, ITimerInterface paramITimerInterface, ExceptionCatcher paramExceptionCatcher)
  {
    _timerInterface = paramITimerInterface;
    _exceptionCatcher = paramExceptionCatcher;
    _logger = paramLogger;
  }
  
  public final ICancelTimer createTimer$23a07b1b(Runnable paramRunnable, int paramInt)
  {
    _logger.debug("createTimer(): calling TimerInterface.createTimer");
    return _timerInterface.createTimer$23a07b1b(paramRunnable, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Timer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */