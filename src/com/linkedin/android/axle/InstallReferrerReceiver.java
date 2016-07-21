package com.linkedin.android.axle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.gen.avro2pegasus.events.mobile.ActivationStateType;
import com.linkedin.gen.avro2pegasus.events.mobile.AndroidAppActivationEvent.Builder;

public class InstallReferrerReceiver
  extends BroadcastReceiver
{
  private static boolean appWasLaunched;
  
  private static ApplicationComponent getAppComponent(Context paramContext)
  {
    return ((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent();
  }
  
  private static Uri toInstallationState(String paramString, ActivationStateType paramActivationStateType)
  {
    return new Uri.Builder().scheme("AXLE").authority("referred").appendQueryParameter("referrer", paramString).appendQueryParameter("state", String.valueOf(paramActivationStateType)).build();
  }
  
  public static void trackAppLaunched(Context paramContext)
  {
    appWasLaunched = true;
    trackUsage(paramContext);
  }
  
  private static void trackNextEvent(ApplicationComponent paramApplicationComponent, Uri paramUri)
  {
    Object localObject1 = null;
    String str2 = null;
    String str1 = str2;
    try
    {
      Object localObject2 = ActivationStateType.of(paramUri.getQueryParameter("state"));
      localObject1 = localObject2;
      str1 = str2;
      str2 = paramUri.getQueryParameter("referrer");
      localObject1 = localObject2;
      str1 = str2;
      Tracker localTracker = paramApplicationComponent.tracker();
      paramUri = (Uri)localObject2;
      localObject1 = localObject2;
      str1 = str2;
      if (localObject2 == ActivationStateType.DOWNLOAD)
      {
        localObject1 = localObject2;
        str1 = str2;
        localTracker.send(new AndroidAppActivationEvent.Builder().setRawReferrer(str2).setActivationState((ActivationStateType)localObject2));
        localObject1 = localObject2;
        str1 = str2;
        paramUri = ActivationStateType.PRE_ACTIVATION_APP_LAUNCH;
      }
      localObject2 = paramUri;
      localObject1 = paramUri;
      str1 = str2;
      AndroidAppActivationEvent.Builder localBuilder;
      if (appWasLaunched)
      {
        localObject1 = paramUri;
        str1 = str2;
        localBuilder = new AndroidAppActivationEvent.Builder().setRawReferrer(str2);
        localObject1 = paramUri;
        str1 = str2;
        if (!paramApplicationComponent.auth().isAuthenticated()) {
          break label188;
        }
        localObject1 = null;
        localObject2 = null;
        str1 = str2;
        localTracker.send(localBuilder.setActivationState(ActivationStateType.FIRST_TIME_ACTIVATION));
      }
      for (;;)
      {
        paramApplicationComponent = paramApplicationComponent.flagshipSharedPreferences();
        if (localObject2 != null) {
          break;
        }
        paramApplicationComponent.removeInstallationState();
        return;
        label188:
        localObject2 = paramUri;
        localObject1 = paramUri;
        str1 = str2;
        if (paramUri == ActivationStateType.PRE_ACTIVATION_APP_LAUNCH)
        {
          localObject1 = paramUri;
          str1 = str2;
          localTracker.send(localBuilder.setActivationState(ActivationStateType.PRE_ACTIVATION_APP_LAUNCH));
          localObject1 = paramUri;
          str1 = str2;
          localObject2 = ActivationStateType.FIRST_TIME_ACTIVATION;
        }
      }
      paramApplicationComponent.setInstallationState(toInstallationState(str2, (ActivationStateType)localObject2));
      return;
    }
    finally
    {
      paramApplicationComponent = paramApplicationComponent.flagshipSharedPreferences();
      if (localObject1 != null) {
        break label264;
      }
    }
    paramApplicationComponent.removeInstallationState();
    for (;;)
    {
      throw paramUri;
      label264:
      paramApplicationComponent.setInstallationState(toInstallationState(str1, (ActivationStateType)localObject1));
    }
  }
  
  public static void trackSignedIn(Context paramContext)
  {
    trackUsage(paramContext);
  }
  
  private static void trackUsage(Context paramContext)
  {
    Object localObject = null;
    ApplicationComponent localApplicationComponent = getAppComponent(paramContext);
    paramContext = localApplicationComponent.flagshipSharedPreferences().getPreferences().getString("installationState", null);
    if (paramContext == null) {}
    for (paramContext = (Context)localObject;; paramContext = Uri.parse(paramContext))
    {
      if ((paramContext != null) && ("AXLE".equals(paramContext.getScheme()))) {
        trackNextEvent(localApplicationComponent, paramContext);
      }
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    CrashReporter.logComponentInfo("Starting broadcast receiver " + InstallReferrerReceiver.class.getSimpleName(), paramIntent);
    if ((paramIntent != null) && ("com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())))
    {
      paramIntent = paramIntent.getStringExtra("referrer");
      if (!TextUtils.isEmpty(paramIntent))
      {
        paramContext = getAppComponent(paramContext);
        trackNextEvent(paramContext, toInstallationState(paramIntent, ActivationStateType.DOWNLOAD));
        paramContext.tracker().flushQueue();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.InstallReferrerReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */