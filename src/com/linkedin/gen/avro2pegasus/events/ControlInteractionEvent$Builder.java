package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.ControlInteractionType;

public final class ControlInteractionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<ControlInteractionEvent>
{
  public String controlUrn = null;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  public boolean hasInteractionType = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public ControlInteractionType interactionType = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  public final ControlInteractionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ControlInteractionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ControlInteractionEvent(header, requestHeader, mobileHeader, controlUrn, interactionType, hasHeader, hasRequestHeader, hasMobileHeader, hasControlUrn, hasInteractionType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ControlInteractionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ControlInteractionEvent", "requestHeader");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ControlInteractionEvent", "controlUrn");
      }
    } while (hasInteractionType);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.ControlInteractionEvent", "interactionType");
  }
  
  public final Builder setHeader(EventHeader paramEventHeader)
  {
    if (paramEventHeader == null)
    {
      hasHeader = false;
      header = null;
      return this;
    }
    hasHeader = true;
    header = paramEventHeader;
    return this;
  }
  
  public final Builder setMobileHeader(MobileHeader paramMobileHeader)
  {
    if (paramMobileHeader == null)
    {
      hasMobileHeader = false;
      mobileHeader = null;
      return this;
    }
    hasMobileHeader = true;
    mobileHeader = paramMobileHeader;
    return this;
  }
  
  public final Builder setRequestHeader(UserRequestHeader paramUserRequestHeader)
  {
    if (paramUserRequestHeader == null)
    {
      hasRequestHeader = false;
      requestHeader = null;
      return this;
    }
    hasRequestHeader = true;
    requestHeader = paramUserRequestHeader;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.ControlInteractionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */