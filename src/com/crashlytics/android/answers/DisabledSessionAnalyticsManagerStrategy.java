package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;

final class DisabledSessionAnalyticsManagerStrategy
  implements SessionAnalyticsManagerStrategy
{
  public final void cancelTimeBasedFileRollOver() {}
  
  public final void deleteAllEvents() {}
  
  public final void processEvent(SessionEvent.Builder paramBuilder) {}
  
  public final boolean rollFileOver()
    throws IOException
  {
    return false;
  }
  
  public final void sendEvents() {}
  
  public final void setAnalyticsSettingsData(AnalyticsSettingsData paramAnalyticsSettingsData, String paramString) {}
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.DisabledSessionAnalyticsManagerStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */