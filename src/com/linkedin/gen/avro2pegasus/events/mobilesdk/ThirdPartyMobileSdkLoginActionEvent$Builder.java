package com.linkedin.gen.avro2pegasus.events.mobilesdk;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class ThirdPartyMobileSdkLoginActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<ThirdPartyMobileSdkLoginActionEvent>
{
  private boolean hasHeader = false;
  public boolean hasLoggedInMemberUrn = false;
  public boolean hasLoginResult = false;
  public boolean hasLoginSessionId = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasThirdPartyApplicationIdentifier = false;
  private EventHeader header = null;
  public String loggedInMemberUrn = null;
  public VoyagerLoginResult loginResult = null;
  public String loginSessionId = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public String thirdPartyApplicationIdentifier = null;
  
  private ThirdPartyMobileSdkLoginActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ThirdPartyMobileSdkLoginActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ThirdPartyMobileSdkLoginActionEvent(header, requestHeader, mobileHeader, thirdPartyApplicationIdentifier, loginResult, loggedInMemberUrn, loginSessionId, hasHeader, hasRequestHeader, hasMobileHeader, hasThirdPartyApplicationIdentifier, hasLoginResult, hasLoggedInMemberUrn, hasLoginSessionId);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "requestHeader");
      }
      if (!hasMobileHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "mobileHeader");
      }
      if (!hasThirdPartyApplicationIdentifier) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "thirdPartyApplicationIdentifier");
      }
    } while (hasLoginResult);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "loginResult");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */