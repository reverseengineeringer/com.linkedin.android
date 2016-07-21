package com.linkedin.gen.avro2pegasus.events.mobilesdk;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class ThirdPartyMobileSdkRegistrationActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<ThirdPartyMobileSdkRegistrationActionEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasThirdPartyApplicationIdentifier = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public String thirdPartyApplicationIdentifier = null;
  
  private ThirdPartyMobileSdkRegistrationActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ThirdPartyMobileSdkRegistrationActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ThirdPartyMobileSdkRegistrationActionEvent(header, requestHeader, mobileHeader, thirdPartyApplicationIdentifier, hasHeader, hasRequestHeader, hasMobileHeader, hasThirdPartyApplicationIdentifier);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkRegistrationActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkRegistrationActionEvent", "requestHeader");
      }
      if (!hasMobileHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkRegistrationActionEvent", "mobileHeader");
      }
    } while (hasThirdPartyApplicationIdentifier);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkRegistrationActionEvent", "thirdPartyApplicationIdentifier");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkRegistrationActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */