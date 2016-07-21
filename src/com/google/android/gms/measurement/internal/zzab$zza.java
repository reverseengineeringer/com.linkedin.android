package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmq;

@TargetApi(14)
final class zzab$zza
  implements Application.ActivityLifecycleCallbacks
{
  private zzab$zza(zzab paramzzab) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      zzaYH.zzAo().zzaWK.zzfg("onActivityCreated");
      paramActivity = paramActivity.getIntent();
      if (paramActivity == null) {
        return;
      }
      paramActivity = paramActivity.getData();
      if ((paramActivity == null) || (!paramActivity.isHierarchical())) {
        return;
      }
      paramActivity = paramActivity.getQueryParameter("referrer");
      if (TextUtils.isEmpty(paramActivity)) {
        return;
      }
      if (!paramActivity.contains("gclid"))
      {
        zzaYH.zzAo().zzaWJ.zzfg("Activity created with data 'referrer' param without gclid");
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      zzaYH.zzAo().zzaWC.zzj("Throwable caught in onActivityCreated", paramActivity);
      return;
    }
    zzaYH.zzAo().zzaWJ.zzj("Activity created with referrer", paramActivity);
    if (!TextUtils.isEmpty(paramActivity)) {
      zzaYH.zza("auto", "_ldl", paramActivity);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    paramActivity = zzaYH.zzCm();
    long l = paramActivity.zzjl().elapsedRealtime();
    paramActivity.zzCn().zzg(new zzad.5(paramActivity, l));
  }
  
  public final void onActivityResumed(Activity arg1)
  {
    synchronized (zzaYH.zzCm())
    {
      ???.zzDv();
      mHandler.removeCallbacks(zzaZb);
      long l = ???.zzjl().elapsedRealtime();
      ???.zzCn().zzg(new zzad.4(???, l));
      return;
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzab.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */