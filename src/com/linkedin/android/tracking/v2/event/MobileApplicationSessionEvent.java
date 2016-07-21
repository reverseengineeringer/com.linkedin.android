package com.linkedin.android.tracking.v2.event;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.gen.avro2pegasus.events.mobile.ApplicationBuildType;
import com.linkedin.gen.avro2pegasus.events.mobile.ApplicationStateChangeType;

public class MobileApplicationSessionEvent
  extends AbstractTrackingEvent
{
  public final ApplicationBuildType applicationBuildType;
  public final ApplicationStateChangeType applicationStateChangeType;
  public final String buildNumber;
  public final String mobileApplicationName;
  
  public MobileApplicationSessionEvent(Tracker paramTracker, ApplicationBuildType paramApplicationBuildType, String paramString1, String paramString2, ApplicationStateChangeType paramApplicationStateChangeType)
  {
    super(paramTracker);
    applicationBuildType = paramApplicationBuildType;
    mobileApplicationName = paramString1;
    buildNumber = paramString2;
    applicationStateChangeType = paramApplicationStateChangeType;
  }
  
  public final String getTrackingDetailsForOverlay()
  {
    return MobileApplicationSessionEvent.class.getSimpleName() + " - " + applicationBuildType + ", " + mobileApplicationName + ", " + buildNumber + ", " + applicationStateChangeType;
  }
  
  public String toString()
  {
    return "applicationBuildType: " + applicationBuildType + ", mobileApplicationName: " + mobileApplicationName + ", buildNumber: " + buildNumber + ", applicationStateChangeType" + applicationStateChangeType;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.event.MobileApplicationSessionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */