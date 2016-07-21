package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class CalendarUploadTask$Builder
  implements RecordTemplateBuilder<CalendarUploadTask>
{
  public List<CalendarUploadEvent> calenderUploadEvents = null;
  public long endTime = 0L;
  public boolean hasCalenderUploadEvents = false;
  public boolean hasEndTime = false;
  public boolean hasSource = false;
  public boolean hasStartTime = false;
  public CalendarSource source = null;
  public long startTime = 0L;
  
  public final CalendarUploadTask build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (CalendarUploadTask.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (calenderUploadEvents != null)
    {
      paramFlavor = calenderUploadEvents.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((CalendarUploadEvent)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "calenderUploadEvents");
            if (!hasCalenderUploadEvents) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "calenderUploadEvents");
            }
            if (!hasStartTime) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "startTime");
            }
            if (hasEndTime) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "endTime");
          }
        }
      }
    }
    return new CalendarUploadTask(calenderUploadEvents, source, startTime, endTime, hasCalenderUploadEvents, hasSource, hasStartTime, hasEndTime);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */