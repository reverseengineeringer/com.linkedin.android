package com.linkedin.android.infra.events;

import com.linkedin.android.pegasus.gen.voyager.common.LaunchAlert;

public final class LaunchAlertEvent
{
  public LaunchAlert launchAlert;
  
  public LaunchAlertEvent(LaunchAlert paramLaunchAlert)
  {
    launchAlert = paramLaunchAlert;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.LaunchAlertEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */