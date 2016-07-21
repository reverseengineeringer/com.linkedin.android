package com.linkedin.android.growth.calendar;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.actionresponse.StringActionResponse;
import com.linkedin.data.lite.RecordTemplate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalendarUploadService
  extends IntentService
{
  private static final String TAG = CalendarUploadService.class.getSimpleName();
  
  public CalendarUploadService()
  {
    super(TAG);
  }
  
  public void onCreate()
  {
    super.onCreate();
    CrashReporter.logComponentInfo("Starting service " + CalendarUploadService.class.getSimpleName(), null);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    boolean bool1 = true;
    if (paramIntent == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = ((FlagshipApplication)getApplicationContext()).getAppComponent();
        if (((ApplicationComponent)localObject1).flagshipSharedPreferences().getCalendarSyncEnabled())
        {
          localObject1 = new CalendarTask(((ApplicationComponent)localObject1).dataManager(), ((ApplicationComponent)localObject1).calendarSyncManager(), ((ApplicationComponent)localObject1).flagshipSharedPreferences(), ((ApplicationComponent)localObject1).lixManager());
          localObject3 = lixManager.getTreatment(Lix.MYNETWORK_CALENDAR_CONFIG);
          if (!"control".equals(localObject3))
          {
            boolean bool2 = CalendarTask.LIX_PATTERN.matcher((CharSequence)localObject3).matches();
            if (bool2) {
              continue;
            }
          }
        }
        return;
        Object localObject3 = ((String)localObject3).split("_");
        long l4 = Long.parseLong(localObject3[1]);
        long l3 = Long.parseLong(localObject3[3]);
        long l1 = flagshipSharedPreferences.getPreferences().getLong("calendarLastSyncTime", 0L);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 >= l4)
        {
          l1 = l2;
          localObject3 = ((CalendarTask)localObject1).getCalendarUploadRequest(l1, l1 + l3, bool1);
          if (localObject3 != null)
          {
            localObject3 = Request.post().url(Routes.SYNC_CALENDAR.buildUponRoot().buildUpon().appendQueryParameter("action", "uploadCalendarV2").build().toString()).model((RecordTemplate)localObject3).builder(StringActionResponse.BUILDER).listener(new CalendarTask.1((CalendarTask)localObject1, l1)).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
            dataManager.submit((Request.Builder)localObject3);
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally
      {
        CalendarUploadReceiver.completeWakefulIntent(paramIntent);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarUploadService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */