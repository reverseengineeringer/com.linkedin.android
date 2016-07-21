package com.linkedin.gen.avro2pegasus.events.mobile;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class InboundExternalLinkFailureEvent
  implements RecordTemplate<InboundExternalLinkFailureEvent>
{
  public static final InboundExternalLinkFailureEventBuilder BUILDER = InboundExternalLinkFailureEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final LinkFailureType failureType;
  public final boolean hasFailureType;
  public final boolean hasHeader;
  public final boolean hasIntendedDestinationUrl;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final String intendedDestinationUrl;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  InboundExternalLinkFailureEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, LinkFailureType paramLinkFailureType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    intendedDestinationUrl = paramString;
    failureType = paramLinkFailureType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasIntendedDestinationUrl = paramBoolean4;
    hasFailureType = paramBoolean5;
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
      paramObject = (InboundExternalLinkFailureEvent)paramObject;
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
      if (intendedDestinationUrl != null)
      {
        if (intendedDestinationUrl.equals(intendedDestinationUrl)) {}
      }
      else {
        while (intendedDestinationUrl != null) {
          return false;
        }
      }
      if (failureType == null) {
        break;
      }
    } while (failureType.equals(failureType));
    for (;;)
    {
      return false;
      if (failureType == null) {
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
      if (intendedDestinationUrl == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = intendedDestinationUrl.hashCode();; m = 0)
    {
      if (failureType != null) {
        n = failureType.hashCode();
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */