package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class CalendarEventAttendee$Builder
  implements RecordTemplateBuilder<CalendarEventAttendee>
{
  public String email = null;
  public boolean hasEmail = false;
  public boolean hasName = false;
  public boolean hasStatus = false;
  public String name = null;
  public CalendarEventAttendeeStatus status = null;
  
  public final CalendarEventAttendee build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (CalendarEventAttendee.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new CalendarEventAttendee(name, email, status, hasName, hasEmail, hasStatus);
      if (!hasStatus) {
        status = CalendarEventAttendeeStatus.PENDING;
      }
    } while (hasEmail);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee", "email");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarEventAttendee.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */