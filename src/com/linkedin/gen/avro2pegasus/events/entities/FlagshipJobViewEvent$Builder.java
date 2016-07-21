package com.linkedin.gen.avro2pegasus.events.entities;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class FlagshipJobViewEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipJobViewEvent>
{
  private boolean hasHeader = false;
  public boolean hasJob = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public TrackingObject job = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private FlagshipJobViewEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipJobViewEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FlagshipJobViewEvent(header, requestHeader, mobileHeader, job, hasHeader, hasRequestHeader, hasMobileHeader, hasJob);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobViewEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobViewEvent", "requestHeader");
      }
    } while (hasJob);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobViewEvent", "job");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobViewEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */