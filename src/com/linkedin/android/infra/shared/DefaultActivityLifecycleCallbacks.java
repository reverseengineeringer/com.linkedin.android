package com.linkedin.android.infra.shared;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

public class DefaultActivityLifecycleCallbacks
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.DefaultActivityLifecycleCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */