package com.linkedin.gen.avro2pegasus.events.login;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SSOLoginEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SSOLoginEvent>
{
  public SSOLoginResult SSOLoginResult = null;
  public String appName = null;
  public boolean hasAppName = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasSSOLoginResult = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private SSOLoginEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SSOLoginEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SSOLoginEvent(header, requestHeader, mobileHeader, appName, SSOLoginResult, hasHeader, hasRequestHeader, hasMobileHeader, hasAppName, hasSSOLoginResult);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.login.SSOLoginEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.login.SSOLoginEvent", "requestHeader");
      }
      if (!hasMobileHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.login.SSOLoginEvent", "mobileHeader");
      }
      if (!hasAppName) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.login.SSOLoginEvent", "appName");
      }
    } while (hasSSOLoginResult);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.login.SSOLoginEvent", "SSOLoginResult");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.login.SSOLoginEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */