package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@zzhb
@TargetApi(14)
public final class zzbe
  implements Application.ActivityLifecycleCallbacks
{
  Activity mActivity;
  Context mContext;
  private final Object zzpV;
  
  private void setActivity(Activity paramActivity)
  {
    synchronized (zzpV)
    {
      if (!paramActivity.getClass().getName().startsWith("com.google.android.gms.ads")) {
        mActivity = paramActivity;
      }
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    synchronized (zzpV)
    {
      if (mActivity == null) {
        return;
      }
      if (mActivity.equals(paramActivity)) {
        mActivity = null;
      }
      return;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public final void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */