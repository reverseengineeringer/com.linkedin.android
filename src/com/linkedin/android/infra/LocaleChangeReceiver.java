package com.linkedin.android.infra;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;
import java.util.Locale;

public class LocaleChangeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"android.intent.action.LOCALE_CHANGED".equals(paramIntent.getAction())) {}
    do
    {
      return;
      CrashReporter.logComponentInfo("Starting broadcast receiver " + LocaleChangeReceiver.class.getSimpleName(), paramIntent);
    } while (paramContext.getResources() == null);
    paramIntent = getResourcesgetConfigurationlocale;
    Log.i(LocaleChangeReceiver.class.getSimpleName(), "System changed to locale " + paramIntent.toString());
    CrashReporter.setDeviceLocale(paramIntent);
    ((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent().flagshipCacheManager().clear();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.LocaleChangeReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */