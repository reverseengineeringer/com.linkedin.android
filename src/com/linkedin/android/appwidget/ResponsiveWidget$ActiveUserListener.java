package com.linkedin.android.appwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.performance.CrashReporter;

public class ResponsiveWidget$ActiveUserListener
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
      return;
    }
    CrashReporter.logComponentInfo("Starting broadcast receiver " + ActiveUserListener.class.getSimpleName(), paramIntent);
    ResponsiveWidget.updateAllAppWidgets(paramContext);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.appwidget.ResponsiveWidget.ActiveUserListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */