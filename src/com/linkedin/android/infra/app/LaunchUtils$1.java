package com.linkedin.android.infra.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;

final class LaunchUtils$1
  extends BroadcastReceiver
{
  LaunchUtils$1(LaunchUtils paramLaunchUtils) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("CALLING_PACKAGE_NAME");
    int i = paramIntent.getIntExtra("CALLING_PACKAGE_VERSION", -1);
    paramContext = "Got a log out from " + paramContext + " (" + i + ")";
    Log.d(LaunchUtils.access$000(), paramContext);
    CrashReporter.reportNonFatal(new Throwable(paramContext));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.LaunchUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */