package com.crashlytics.android.answers;

import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

final class AnswersLifecycleCallbacks
  extends ActivityLifecycleManager.Callbacks
{
  private final SessionAnalyticsManager analyticsManager;
  private final BackgroundManager backgroundManager;
  
  public AnswersLifecycleCallbacks(SessionAnalyticsManager paramSessionAnalyticsManager, BackgroundManager paramBackgroundManager)
  {
    analyticsManager = paramSessionAnalyticsManager;
    backgroundManager = paramBackgroundManager;
  }
  
  public final void onActivityCreated$9bb446d(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    analyticsManager.onLifecycle(paramActivity, SessionEvent.Type.PAUSE);
    paramActivity = backgroundManager;
    if ((flushOnBackground) && (!inBackground)) {
      inBackground = true;
    }
    try
    {
      backgroundFutureRef.compareAndSet(null, executorService.schedule(new BackgroundManager.1(paramActivity), 5000L, TimeUnit.MILLISECONDS));
      return;
    }
    catch (RejectedExecutionException paramActivity)
    {
      Fabric.getLogger().d("Answers", "Failed to schedule background detector", paramActivity);
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    analyticsManager.onLifecycle(paramActivity, SessionEvent.Type.RESUME);
    paramActivity = backgroundManager;
    inBackground = false;
    paramActivity = (ScheduledFuture)backgroundFutureRef.getAndSet(null);
    if (paramActivity != null) {
      paramActivity.cancel(false);
    }
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    analyticsManager.onLifecycle(paramActivity, SessionEvent.Type.START);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    analyticsManager.onLifecycle(paramActivity, SessionEvent.Type.STOP);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersLifecycleCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */