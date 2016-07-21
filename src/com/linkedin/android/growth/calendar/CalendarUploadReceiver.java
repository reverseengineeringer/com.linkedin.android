package com.linkedin.android.growth.calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.CalendarTaskUtil;

public class CalendarUploadReceiver
  extends WakefulBroadcastReceiver
{
  private static void startDaemon(Context paramContext)
  {
    Object localObject = new Intent("com.linkedin.android.Flagship.tasks.WAKE_UP", null, paramContext, CalendarUploadReceiver.class);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    localObject = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 268435456);
    long l = CalendarTaskUtil.getWakeUpInterval(((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent().lixManager().getTreatment(Lix.MYNETWORK_CALENDAR_WAKEUP));
    localAlarmManager.setRepeating(3, SystemClock.elapsedRealtime(), l, (PendingIntent)localObject);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    CrashReporter.logComponentInfo("Starting broadcast receiver " + CalendarUploadReceiver.class.getSimpleName(), paramIntent);
    paramIntent = paramIntent.getAction();
    FlagshipApplication localFlagshipApplication = (FlagshipApplication)paramContext.getApplicationContext();
    if ("android.intent.action.BOOT_COMPLETED".equals(paramIntent)) {
      if (localFlagshipApplication.getAppComponent().flagshipSharedPreferences().getCalendarSyncEnabled()) {
        startDaemon(paramContext);
      }
    }
    do
    {
      do
      {
        return;
        if (!"com.linkedin.android.Flagship.tasks.START".equals(paramIntent)) {
          break;
        }
      } while (!localFlagshipApplication.getAppComponent().flagshipSharedPreferences().getCalendarSyncEnabled());
      startDaemon(paramContext);
      return;
      if ("com.linkedin.android.Flagship.tasks.WAKE_UP".equals(paramIntent))
      {
        startWakefulService(paramContext, new Intent(paramContext, CalendarUploadService.class));
        return;
      }
    } while (!"com.linkedin.android.Flagship.tasks.CANCEL".equals(paramIntent));
    paramIntent = new Intent("com.linkedin.android.Flagship.tasks.WAKE_UP", null, paramContext, CalendarUploadReceiver.class);
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(paramContext, 0, paramIntent, 268435456));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarUploadReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */