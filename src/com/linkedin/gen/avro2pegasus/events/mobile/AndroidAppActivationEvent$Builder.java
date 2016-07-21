package com.linkedin.gen.avro2pegasus.events.mobile;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class AndroidAppActivationEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<AndroidAppActivationEvent>
{
  private ActivationStateType activationState = null;
  private boolean hasActivationState = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRawReferrer = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private String rawReferrer = null;
  private UserRequestHeader requestHeader = null;
  
  private AndroidAppActivationEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AndroidAppActivationEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new AndroidAppActivationEvent(header, requestHeader, mobileHeader, rawReferrer, activationState, hasHeader, hasRequestHeader, hasMobileHeader, hasRawReferrer, hasActivationState);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.AndroidAppActivationEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.AndroidAppActivationEvent", "requestHeader");
      }
      if (!hasMobileHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.AndroidAppActivationEvent", "mobileHeader");
      }
      if (!hasRawReferrer) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.AndroidAppActivationEvent", "rawReferrer");
      }
    } while (hasActivationState);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobile.AndroidAppActivationEvent", "activationState");
  }
  
  public final Builder setActivationState(ActivationStateType paramActivationStateType)
  {
    if (paramActivationStateType == null)
    {
      hasActivationState = false;
      activationState = null;
      return this;
    }
    hasActivationState = true;
    activationState = paramActivationStateType;
    return this;
  }
  
  public final Builder setRawReferrer(String paramString)
  {
    if (paramString == null)
    {
      hasRawReferrer = false;
      rawReferrer = null;
      return this;
    }
    hasRawReferrer = true;
    rawReferrer = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.AndroidAppActivationEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */