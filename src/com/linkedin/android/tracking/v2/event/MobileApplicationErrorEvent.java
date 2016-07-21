package com.linkedin.android.tracking.v2.event;

import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.gen.avro2pegasus.events.ApplicationBuildType;
import com.linkedin.gen.avro2pegasus.events.ErrorType;

public final class MobileApplicationErrorEvent
  extends AbstractTrackingEvent
{
  public final ApplicationBuildType applicationBuildType;
  public final String buildNumber;
  public final String errorSummary;
  public final ErrorType errorType;
  public final String mobileApplicationName;
  public final PageInstance pageInstance;
  public final String rawCrashData;
  
  public MobileApplicationErrorEvent(Tracker paramTracker, ApplicationBuildType paramApplicationBuildType, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramTracker, paramApplicationBuildType, paramString1, paramString2, paramString3, paramString4, ErrorType.CRASH, null);
  }
  
  public MobileApplicationErrorEvent(Tracker paramTracker, ApplicationBuildType paramApplicationBuildType, String paramString1, String paramString2, String paramString3, String paramString4, ErrorType paramErrorType, PageInstance paramPageInstance)
  {
    super(paramTracker);
    applicationBuildType = paramApplicationBuildType;
    mobileApplicationName = paramString1;
    buildNumber = paramString2;
    errorSummary = paramString3;
    rawCrashData = paramString4;
    errorType = paramErrorType;
    paramApplicationBuildType = paramPageInstance;
    if (paramPageInstance == null) {
      paramApplicationBuildType = paramTracker.getCurrentPageInstance();
    }
    pageInstance = paramApplicationBuildType;
  }
  
  public final String getTrackingDetailsForOverlay()
  {
    return MobileApplicationSessionEvent.class.getSimpleName() + " - " + applicationBuildType + ", " + mobileApplicationName + ", " + buildNumber + ", " + errorSummary;
  }
  
  public final String toString()
  {
    return "applicationBuildType: " + applicationBuildType + ", mobileApplicationName: " + mobileApplicationName + ", buildNumber: " + buildNumber + ", " + errorSummary;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.event.MobileApplicationErrorEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */