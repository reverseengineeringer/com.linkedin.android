package com.linkedin.android.growth.calendar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.logger.Log;

final class CalendarTask$1
  implements RecordTemplateListener
{
  CalendarTask$1(CalendarTask paramCalendarTask, long paramLong) {}
  
  public final void onResponse(DataStoreResponse paramDataStoreResponse)
  {
    if (error != null)
    {
      Log.e(CalendarTask.access$000(), "Error while uploading calendar data");
      return;
    }
    paramDataStoreResponse = CalendarTask.access$100(this$0);
    long l = val$startTime;
    paramDataStoreResponse.getPreferences().edit().putLong("calendarLastSyncTime", l).apply();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */