package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CalendarUploadEvent$Builder
  implements RecordTemplateBuilder<CalendarUploadEvent>
{
  public List<CalendarEventAttendee> attendees = null;
  public long endTime = 0L;
  public String externalId = null;
  public boolean fullDayEvent = false;
  public boolean hasAttendees = false;
  public boolean hasEndTime = false;
  public boolean hasExternalId = false;
  public boolean hasFullDayEvent = false;
  public boolean hasLocation = false;
  public boolean hasRecurring = false;
  public boolean hasSource = false;
  public boolean hasStartTime = false;
  public boolean hasStatus = false;
  public boolean hasTitle = false;
  public String location = null;
  public boolean recurring = false;
  public CalendarSource source = null;
  public long startTime = 0L;
  public CalendarEventAvailability status = null;
  public String title = null;
  
  public final CalendarUploadEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (CalendarUploadEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (attendees != null)
    {
      paramFlavor = attendees.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((CalendarEventAttendee)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "attendees");
            if (!hasFullDayEvent) {
              fullDayEvent = false;
            }
            if (!hasRecurring) {
              recurring = false;
            }
            if (!hasAttendees) {
              attendees = Collections.emptyList();
            }
            if (!hasStatus) {
              status = CalendarEventAvailability.NOT_SUPPORTED;
            }
            if (!hasExternalId) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "externalId");
            }
            if (!hasSource) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "source");
            }
            if (!hasStartTime) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "startTime");
            }
            if (hasEndTime) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "endTime");
          }
        }
      }
    }
    return new CalendarUploadEvent(externalId, source, startTime, endTime, title, location, fullDayEvent, recurring, attendees, status, hasExternalId, hasSource, hasStartTime, hasEndTime, hasTitle, hasLocation, hasFullDayEvent, hasRecurring, hasAttendees, hasStatus);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */