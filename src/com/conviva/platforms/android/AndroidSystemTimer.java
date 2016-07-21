package com.conviva.platforms.android;

import com.conviva.api.system.ICancelTimer;
import java.util.concurrent.ScheduledFuture;

public final class AndroidSystemTimer
  implements ICancelTimer
{
  private ScheduledFuture<?> _scheduledTask = null;
  
  public AndroidSystemTimer(ScheduledFuture<?> paramScheduledFuture)
  {
    _scheduledTask = paramScheduledFuture;
  }
  
  public final boolean cancel()
  {
    _scheduledTask.cancel(true);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.AndroidSystemTimer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */