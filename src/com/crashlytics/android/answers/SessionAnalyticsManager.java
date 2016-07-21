package com.crashlytics.android.answers;

import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.Collections;

public final class SessionAnalyticsManager
  implements BackgroundManager.Listener
{
  final BackgroundManager backgroundManager;
  public final AnswersEventsHandler eventsHandler;
  final long installedAt;
  final ActivityLifecycleManager lifecycleManager;
  final AnswersPreferenceManager preferenceManager;
  
  SessionAnalyticsManager(AnswersEventsHandler paramAnswersEventsHandler, ActivityLifecycleManager paramActivityLifecycleManager, BackgroundManager paramBackgroundManager, AnswersPreferenceManager paramAnswersPreferenceManager, long paramLong)
  {
    eventsHandler = paramAnswersEventsHandler;
    lifecycleManager = paramActivityLifecycleManager;
    backgroundManager = paramBackgroundManager;
    preferenceManager = paramAnswersPreferenceManager;
    installedAt = paramLong;
  }
  
  public final void onBackground()
  {
    Fabric.getLogger().d("Answers", "Flush events when app is backgrounded");
    AnswersEventsHandler localAnswersEventsHandler = eventsHandler;
    localAnswersEventsHandler.executeAsync(new AnswersEventsHandler.5(localAnswersEventsHandler));
  }
  
  public final void onLifecycle(Activity paramActivity, SessionEvent.Type paramType)
  {
    Fabric.getLogger().d("Answers", "Logged lifecycle event: " + paramType.name());
    AnswersEventsHandler localAnswersEventsHandler = eventsHandler;
    paramActivity = Collections.singletonMap("activity", paramActivity.getClass().getName());
    paramType = new SessionEvent.Builder(paramType);
    details = paramActivity;
    localAnswersEventsHandler.processEvent(paramType, false, false);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SessionAnalyticsManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */