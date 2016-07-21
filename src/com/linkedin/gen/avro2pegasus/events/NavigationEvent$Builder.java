package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;

public final class NavigationEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<NavigationEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasPreviousPageInstance = false;
  private boolean hasRequestHeader = false;
  private boolean hasTriggerControlUrn = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private PageInstance previousPageInstance = null;
  private UserRequestHeader requestHeader = null;
  private String triggerControlUrn = null;
  
  public final NavigationEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NavigationEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NavigationEvent(header, requestHeader, mobileHeader, previousPageInstance, triggerControlUrn, hasHeader, hasRequestHeader, hasMobileHeader, hasPreviousPageInstance, hasTriggerControlUrn);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.NavigationEvent", "header");
      }
    } while (hasRequestHeader);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.NavigationEvent", "requestHeader");
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
  
  public final Builder setPreviousPageInstance(PageInstance paramPageInstance)
  {
    if (paramPageInstance == null)
    {
      hasPreviousPageInstance = false;
      previousPageInstance = null;
      return this;
    }
    hasPreviousPageInstance = true;
    previousPageInstance = paramPageInstance;
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
  
  public final Builder setTriggerControlUrn(String paramString)
  {
    if (paramString == null)
    {
      hasTriggerControlUrn = false;
      triggerControlUrn = null;
      return this;
    }
    hasTriggerControlUrn = true;
    triggerControlUrn = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.NavigationEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */