package com.linkedin.android.feed.shared;

import com.linkedin.android.infra.RepeatingRunnable;
import com.linkedin.android.infra.events.ApplicationLifecycleEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import org.greenrobot.eventbus.Subscribe;

public abstract class RepeatInForegroundRunnable
  extends RepeatingRunnable
{
  public final Bus bus;
  public boolean stopped;
  private final String tag;
  
  public RepeatInForegroundRunnable(String paramString, DelayedExecution paramDelayedExecution, Bus paramBus, long paramLong)
  {
    super(paramDelayedExecution, paramLong);
    tag = paramString;
    bus = paramBus;
    Bus.subscribe(this);
  }
  
  @Subscribe
  public void onEvent(StopEvent paramStopEvent)
  {
    if (tag.equals(tag)) {
      stop(false);
    }
  }
  
  @Subscribe
  public void onEvent(ApplicationLifecycleEvent paramApplicationLifecycleEvent)
  {
    switch (newState)
    {
    default: 
      return;
    case 0: 
      restart(true);
      return;
    }
    stop(true);
  }
  
  public void restart(boolean paramBoolean)
  {
    if (!stopped) {
      stop();
    }
    stopped = false;
    if (paramBoolean)
    {
      run();
      return;
    }
    start();
  }
  
  public void stop(boolean paramBoolean)
  {
    stop();
    stopped = true;
  }
  
  public static final class StopEvent
  {
    public final String tag;
    
    public StopEvent(String paramString)
    {
      tag = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.RepeatInForegroundRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */