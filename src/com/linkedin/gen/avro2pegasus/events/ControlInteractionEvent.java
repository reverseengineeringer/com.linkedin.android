package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.ControlInteractionType;

public final class ControlInteractionEvent
  implements RecordTemplate<ControlInteractionEvent>
{
  public static final ControlInteractionEventBuilder BUILDER = ControlInteractionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String controlUrn;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasInteractionType;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final ControlInteractionType interactionType;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  ControlInteractionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, ControlInteractionType paramControlInteractionType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    controlUrn = paramString;
    interactionType = paramControlInteractionType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasControlUrn = paramBoolean4;
    hasInteractionType = paramBoolean5;
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
      paramObject = (ControlInteractionEvent)paramObject;
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
      if (controlUrn != null)
      {
        if (controlUrn.equals(controlUrn)) {}
      }
      else {
        while (controlUrn != null) {
          return false;
        }
      }
      if (interactionType == null) {
        break;
      }
    } while (interactionType.equals(interactionType));
    for (;;)
    {
      return false;
      if (interactionType == null) {
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
      if (controlUrn == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = controlUrn.hashCode();; m = 0)
    {
      if (interactionType != null) {
        n = interactionType.hashCode();
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.ControlInteractionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */