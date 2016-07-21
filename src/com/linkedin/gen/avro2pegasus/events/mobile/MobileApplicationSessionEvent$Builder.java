package com.linkedin.gen.avro2pegasus.events.mobile;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class MobileApplicationSessionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MobileApplicationSessionEvent>
{
  public ApplicationBuildType applicationBuildType = null;
  public ApplicationStateChangeType applicationStateChangeType = null;
  public String buildNumber = null;
  public boolean hasApplicationBuildType = false;
  public boolean hasApplicationStateChangeType = false;
  public boolean hasBuildNumber = false;
  private boolean hasHeader = false;
  public boolean hasMobileApplicationName = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public String mobileApplicationName = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  public final MobileApplicationSessionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MobileApplicationSessionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MobileApplicationSessionEvent(header, requestHeader, mobileHeader, applicationBuildType, mobileApplicationName, buildNumber, applicationStateChangeType, hasHeader, hasRequestHeader, hasMobileHeader, hasApplicationBuildType, hasMobileApplicationName, hasBuildNumber, hasApplicationStateChangeType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEvent", "requestHeader");
      }
      if (!hasMobileHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEvent", "mobileHeader");
      }
      if (!hasMobileApplicationName) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEvent", "mobileApplicationName");
      }
      if (!hasBuildNumber) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEvent", "buildNumber");
      }
    } while (hasApplicationStateChangeType);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEvent", "applicationStateChangeType");
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
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */