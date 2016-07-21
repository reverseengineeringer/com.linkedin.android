package com.crashlytics.android.beta;

import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

final class ActivityLifecycleCheckForUpdatesController$1
  extends ActivityLifecycleManager.Callbacks
{
  ActivityLifecycleCheckForUpdatesController$1(ActivityLifecycleCheckForUpdatesController paramActivityLifecycleCheckForUpdatesController) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    paramActivity = this$0;
    externallyReady.set(true);
    if (initialized.get()) {
      this$0.executorService.submit(new Runnable()
      {
        public final void run()
        {
          this$0.checkForUpdates();
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */