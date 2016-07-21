package com.linkedin.android.l2m.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.performance.CrashReporter;

public class PackageReplacedReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"android.intent.action.MY_PACKAGE_REPLACED".equals(paramIntent.getAction())) {}
    do
    {
      return;
      CrashReporter.logComponentInfo("Starting broadcast receiver " + PackageReplacedReceiver.class.getSimpleName(), paramIntent);
      paramIntent = ((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent();
      paramIntent.notificationUtils();
    } while (!paramIntent.auth().isAuthenticated());
    NotificationUtils.registerNotification(paramContext);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.PackageReplacedReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */