package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class CalendarSourceRequest$Builder
  implements RecordTemplateBuilder<CalendarSourceRequest>
{
  public CalendarSource calendarSource = null;
  public boolean hasCalendarSource = false;
  
  public final CalendarSourceRequest build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (CalendarSourceRequest.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new CalendarSourceRequest(calendarSource, hasCalendarSource);
    } while (hasCalendarSource);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSourceRequest", "calendarSource");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarSourceRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */