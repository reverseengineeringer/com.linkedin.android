package com.linkedin.android.infra.shared;

import android.content.Context;
import com.linkedin.android.growth.calendar.CalendarUploadReceiver;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSource;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSourceRequest;
import com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSourceRequest.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalendarTaskUtil
{
  private static final Pattern LIX_PATTERN = Pattern.compile("^mins_\\d{1,3}$");
  private static final String TAG = CalendarTaskUtil.class.getSimpleName();
  public final Context context;
  public final FlagshipDataManager flagshipDataManager;
  
  public CalendarTaskUtil(Context paramContext, FlagshipDataManager paramFlagshipDataManager)
  {
    context = paramContext.getApplicationContext();
    flagshipDataManager = paramFlagshipDataManager;
  }
  
  public static CalendarSourceRequest getCalendarSourceRequest()
  {
    try
    {
      CalendarSourceRequest.Builder localBuilder = new CalendarSourceRequest.Builder();
      CalendarSource localCalendarSource = CalendarSource.ANDROID_CALENDAR;
      if (localCalendarSource == null) {
        hasCalendarSource = false;
      }
      for (calendarSource = null;; calendarSource = localCalendarSource)
      {
        return localBuilder.build(RecordTemplate.Flavor.RECORD);
        hasCalendarSource = true;
      }
      return null;
    }
    catch (BuilderException localBuilderException)
    {
      Log.e(TAG, localBuilderException.getMessage());
    }
  }
  
  public static long getWakeUpInterval(String paramString)
  {
    long l2 = 30L;
    long l1 = l2;
    if (LIX_PATTERN.matcher(paramString).matches()) {
      paramString = paramString.split("_")[1];
    }
    try
    {
      l1 = Long.parseLong(paramString);
      return TimeUnit.MINUTES.toMillis(l1);
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        Log.e(TAG, paramString.getMessage());
        l1 = l2;
      }
    }
  }
  
  public final void unregisterTask()
  {
    Util.setComponentEnabled(context, CalendarUploadReceiver.class, false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.CalendarTaskUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */