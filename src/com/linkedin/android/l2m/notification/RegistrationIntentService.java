package com.linkedin.android.l2m.notification;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzd;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;

public class RegistrationIntentService
  extends IntentService
{
  private static final String TAG = RegistrationIntentService.class.getSimpleName();
  private ApplicationComponent applicationComponent;
  private NotificationUtils notificationUtils;
  
  public RegistrationIntentService()
  {
    super(TAG);
  }
  
  public void onCreate()
  {
    CrashReporter.logComponentInfo("Starting service " + RegistrationIntentService.class.getSimpleName(), null);
    super.onCreate();
    applicationComponent = ((FlagshipApplication)getApplicationContext()).getAppComponent();
    notificationUtils = applicationComponent.notificationUtils();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    paramIntent = null;
    int k = 1;
    int j = 0;
    int i;
    try
    {
      Object localObject2;
      synchronized (TAG)
      {
        localObject2 = InstanceID.getInstance(this);
        if (Looper.getMainLooper() == Looper.myLooper()) {
          throw new IOException("MAIN_THREAD");
        }
      }
      Object localObject1;
      Object localObject3;
      String str2;
      String str3;
      long l;
      label522:
      label539:
      label542:
      while (i == 0) {}
    }
    catch (SecurityException paramIntent)
    {
      com.linkedin.android.logger.Log.e(TAG, "Failed to complete token Registration", paramIntent);
      return;
      localObject1 = InstanceID.zzaMQ.get("appVersion");
      if (localObject1 != null)
      {
        if (!((String)localObject1).equals(InstanceID.zzaMV))
        {
          break label542;
          localObject1 = paramIntent;
          if (paramIntent == null)
          {
            paramIntent = new Bundle();
            i = k;
            if (paramIntent.getString("ttl") != null) {
              i = 0;
            }
            if (!"jwt".equals(paramIntent.getString("type"))) {
              break label539;
            }
            i = j;
            paramIntent = ((InstanceID)localObject2).zzc("789113911969", "GCM", paramIntent);
            android.util.Log.w("InstanceID", "token: " + paramIntent);
            localObject1 = paramIntent;
            if (paramIntent != null)
            {
              localObject1 = paramIntent;
              if (i != 0)
              {
                InstanceID.zzaMQ.zza(zzaMT, "789113911969", "GCM", paramIntent, InstanceID.zzaMV);
                localObject1 = paramIntent;
              }
            }
          }
          com.linkedin.android.logger.Log.d(TAG, "Current GCM Registration Token: " + (String)localObject1);
          if (localObject1 != null)
          {
            paramIntent = notificationUtils;
            localObject3 = getApplicationContext();
            applicationComponent.lixManager();
            localObject2 = sharedPreferences.getNotificationToken();
            i = sharedPreferences.getPreferences().getInt("notificationTokenState", 0);
            str2 = Build.VERSION.RELEASE;
            localObject3 = getResourcesgetConfigurationlocale.toString();
            str3 = TimeZone.getDefault().getID();
            j = (str2 + "856" + (String)localObject3 + str3).hashCode();
            if ((((String)localObject1).equals(localObject2)) && (i == j)) {
              break label522;
            }
            if ((localObject2 != null) && (!((String)localObject1).equals(localObject2))) {
              paramIntent.sendTokenForDeregister((String)localObject2, null);
            }
            localObject2 = NotificationUtils.getPostBody((String)localObject1);
            if (localObject2 != null) {
              dataManager.submit(Request.post().url(registerRoute).customHeaders(Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance())).model((RecordTemplate)localObject2).listener(new NotificationUtils.1(paramIntent, (String)localObject1, j)).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
            }
          }
        }
        for (;;)
        {
          return;
          localObject1 = InstanceID.zzaMQ.get("lastToken");
          if (localObject1 == null)
          {
            i = 1;
            break label544;
          }
          l = Long.parseLong((String)localObject1);
          if (System.currentTimeMillis() / 1000L - Long.valueOf(l).longValue() <= 604800L) {
            break label551;
          }
          i = 1;
          break label544;
          paramIntent = InstanceID.zzaMQ.zzi(zzaMT, "789113911969", "GCM");
          break;
          com.linkedin.android.logger.Log.d(NotificationUtils.TAG, "GCM Token is already registered.");
        }
      }
    }
    catch (IOException paramIntent)
    {
      for (;;) {}
      i = 1;
    }
    for (;;)
    {
      label544:
      break;
      label551:
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.RegistrationIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */