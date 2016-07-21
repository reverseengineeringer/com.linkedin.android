package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class CalendarUploadTaskRequest$Builder
  implements RecordTemplateBuilder<CalendarUploadTaskRequest>
{
  public CalendarUploadTask calendarUploadTask = null;
  public boolean hasCalendarUploadTask = false;
  
  public final CalendarUploadTaskRequest build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (CalendarUploadTaskRequest.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new CalendarUploadTaskRequest(calendarUploadTask, hasCalendarUploadTask);
    } while (hasCalendarUploadTask);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTaskRequest", "calendarUploadTask");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTaskRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */