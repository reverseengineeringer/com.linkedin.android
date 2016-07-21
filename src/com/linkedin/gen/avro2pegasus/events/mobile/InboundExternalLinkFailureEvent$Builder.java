package com.linkedin.gen.avro2pegasus.events.mobile;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class InboundExternalLinkFailureEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<InboundExternalLinkFailureEvent>
{
  public LinkFailureType failureType = null;
  public boolean hasFailureType = false;
  private boolean hasHeader = false;
  public boolean hasIntendedDestinationUrl = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public String intendedDestinationUrl = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private InboundExternalLinkFailureEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (InboundExternalLinkFailureEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new InboundExternalLinkFailureEvent(header, requestHeader, mobileHeader, intendedDestinationUrl, failureType, hasHeader, hasRequestHeader, hasMobileHeader, hasIntendedDestinationUrl, hasFailureType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEvent", "requestHeader");
      }
      if (!hasMobileHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEvent", "mobileHeader");
      }
      if (!hasIntendedDestinationUrl) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEvent", "intendedDestinationUrl");
      }
    } while (hasFailureType);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEvent", "failureType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */