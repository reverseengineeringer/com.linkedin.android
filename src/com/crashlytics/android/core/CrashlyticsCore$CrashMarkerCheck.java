package com.crashlytics.android.core;

import java.util.concurrent.Callable;

final class CrashlyticsCore$CrashMarkerCheck
  implements Callable<Boolean>
{
  private final CrashlyticsFileMarker crashMarker;
  
  public CrashlyticsCore$CrashMarkerCheck(CrashlyticsFileMarker paramCrashlyticsFileMarker)
  {
    crashMarker = paramCrashlyticsFileMarker;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.CrashMarkerCheck
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */