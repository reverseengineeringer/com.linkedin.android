package com.conviva.platforms.android;

import com.conviva.api.system.ICancelTimer;
import com.conviva.api.system.ITimerInterface;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class AndroidTimerInterface
  implements ITimerInterface
{
  private ScheduledThreadPoolExecutor _pool = null;
  
  public final ICancelTimer createTimer$23a07b1b(Runnable paramRunnable, int paramInt)
  {
    return new AndroidSystemTimer(_pool.scheduleAtFixedRate(paramRunnable, paramInt, paramInt, TimeUnit.MILLISECONDS));
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.AndroidTimerInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */