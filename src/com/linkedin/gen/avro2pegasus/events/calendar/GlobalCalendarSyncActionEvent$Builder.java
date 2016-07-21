package com.linkedin.gen.avro2pegasus.events.calendar;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class GlobalCalendarSyncActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<GlobalCalendarSyncActionEvent>
{
  private boolean hasHeader = false;
  public boolean hasIsSyncEnabled = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public boolean isSyncEnabled = false;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private GlobalCalendarSyncActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GlobalCalendarSyncActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new GlobalCalendarSyncActionEvent(header, mobileHeader, requestHeader, isSyncEnabled, hasHeader, hasMobileHeader, hasRequestHeader, hasIsSyncEnabled);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "requestHeader");
      }
    } while (hasIsSyncEnabled);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "isSyncEnabled");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */