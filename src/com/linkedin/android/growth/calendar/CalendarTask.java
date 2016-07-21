package com.linkedin.android.growth.calendar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSource;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTaskRequest;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTaskRequest.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.List;
import java.util.regex.Pattern;

public class CalendarTask
{
  static final Pattern LIX_PATTERN = Pattern.compile("^frequency_\\d{1,10}_period_\\d{1,10}_mintime_\\d{1,10}$");
  private static final String TAG = CalendarTask.class.getSimpleName();
  private final CalendarSyncManager calendarSyncManager;
  final FlagshipDataManager dataManager;
  final FlagshipSharedPreferences flagshipSharedPreferences;
  final LixManager lixManager;
  
  public CalendarTask(FlagshipDataManager paramFlagshipDataManager, CalendarSyncManager paramCalendarSyncManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, LixManager paramLixManager)
  {
    dataManager = paramFlagshipDataManager;
    calendarSyncManager = paramCalendarSyncManager;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    lixManager = paramLixManager;
  }
  
  final CalendarUploadTaskRequest getCalendarUploadRequest(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject1 = calendarSyncManager.getEventRequest(paramLong1, paramLong2);
    Object localObject2 = CalendarSyncManager.getHash((List)localObject1);
    if ((!((String)localObject2).equals(flagshipSharedPreferences.getPreferences().getString("calendarSyncHash", "hash"))) || (paramBoolean)) {
      for (;;)
      {
        Object localObject3;
        try
        {
          flagshipSharedPreferences.getPreferences().edit().putString("calendarSyncHash", (String)localObject2).apply();
          localObject2 = new CalendarUploadTask.Builder();
          localObject3 = Long.valueOf(paramLong1);
          if (localObject3 == null)
          {
            hasStartTime = false;
            startTime = 0L;
            localObject3 = Long.valueOf(paramLong2);
            if (localObject3 == null)
            {
              hasEndTime = false;
              endTime = 0L;
              localObject3 = CalendarSource.ANDROID_CALENDAR;
              if (localObject3 != null) {
                break label262;
              }
              hasSource = false;
              source = null;
              if (localObject1 != null) {
                break label278;
              }
              hasCalenderUploadEvents = false;
              calenderUploadEvents = null;
              localObject1 = ((CalendarUploadTask.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
              localObject2 = new CalendarUploadTaskRequest.Builder();
              hasCalendarUploadTask = true;
              calendarUploadTask = ((CalendarUploadTask)localObject1);
              return ((CalendarUploadTaskRequest.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
            }
          }
          else
          {
            hasStartTime = true;
            startTime = ((Long)localObject3).longValue();
            continue;
          }
          hasEndTime = true;
        }
        catch (BuilderException localBuilderException)
        {
          Log.e(TAG, localBuilderException.getMessage());
          return null;
        }
        endTime = ((Long)localObject3).longValue();
        continue;
        label262:
        hasSource = true;
        source = ((CalendarSource)localObject3);
        continue;
        label278:
        hasCalenderUploadEvents = true;
        calenderUploadEvents = localBuilderException;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */