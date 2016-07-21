package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
final class ActivityLifecycleCheckForUpdatesController
  extends AbstractCheckForUpdatesController
{
  private final ActivityLifecycleManager.Callbacks callbacks = new ActivityLifecycleManager.Callbacks()
  {
    public final void onActivityStarted(Activity paramAnonymousActivity)
    {
      paramAnonymousActivity = ActivityLifecycleCheckForUpdatesController.this;
      externallyReady.set(true);
      if (initialized.get()) {
        executorService.submit(new Runnable()
        {
          public final void run()
          {
            checkForUpdates();
          }
        });
      }
    }
  };
  final ExecutorService executorService;
  
  public ActivityLifecycleCheckForUpdatesController(ActivityLifecycleManager paramActivityLifecycleManager, ExecutorService paramExecutorService)
  {
    executorService = paramExecutorService;
    paramActivityLifecycleManager.registerCallbacks(callbacks);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */