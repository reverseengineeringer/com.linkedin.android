package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.PageInstance;

public final class NavigationEvent
  implements RecordTemplate<NavigationEvent>
{
  public static final NavigationEventBuilder BUILDER = NavigationEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasPreviousPageInstance;
  public final boolean hasRequestHeader;
  public final boolean hasTriggerControlUrn;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final PageInstance previousPageInstance;
  public final UserRequestHeader requestHeader;
  public final String triggerControlUrn;
  
  NavigationEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, PageInstance paramPageInstance, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    previousPageInstance = paramPageInstance;
    triggerControlUrn = paramString;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasPreviousPageInstance = paramBoolean4;
    hasTriggerControlUrn = paramBoolean5;
    _cachedId = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (NavigationEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (previousPageInstance != null)
      {
        if (previousPageInstance.equals(previousPageInstance)) {}
      }
      else {
        while (previousPageInstance != null) {
          return false;
        }
      }
      if (triggerControlUrn == null) {
        break;
      }
    } while (triggerControlUrn.equals(triggerControlUrn));
    for (;;)
    {
      return false;
      if (triggerControlUrn == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label132;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label137;
      }
      k = mobileHeader.hashCode();
      label60:
      if (previousPageInstance == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = previousPageInstance.hashCode();; m = 0)
    {
      if (triggerControlUrn != null) {
        n = triggerControlUrn.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.NavigationEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */