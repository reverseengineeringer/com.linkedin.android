package com.linkedin.gen.avro2pegasus.events.mobilesdk;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class ThirdPartyMobileSdkProfileViewEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<ThirdPartyMobileSdkProfileViewEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasThirdPartyApplicationIdentifier = false;
  public boolean hasViewee = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public String thirdPartyApplicationIdentifier = null;
  public TrackingObject viewee = null;
  
  private ThirdPartyMobileSdkProfileViewEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ThirdPartyMobileSdkProfileViewEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ThirdPartyMobileSdkProfileViewEvent(header, requestHeader, mobileHeader, thirdPartyApplicationIdentifier, viewee, hasHeader, hasRequestHeader, hasMobileHeader, hasThirdPartyApplicationIdentifier, hasViewee);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "requestHeader");
      }
      if (!hasMobileHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "mobileHeader");
      }
      if (!hasThirdPartyApplicationIdentifier) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "thirdPartyApplicationIdentifier");
      }
    } while (hasViewee);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent", "viewee");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */