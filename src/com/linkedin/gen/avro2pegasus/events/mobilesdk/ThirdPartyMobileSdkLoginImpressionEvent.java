package com.linkedin.gen.avro2pegasus.events.mobilesdk;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class ThirdPartyMobileSdkLoginImpressionEvent
  implements RecordTemplate<ThirdPartyMobileSdkLoginImpressionEvent>
{
  public static final ThirdPartyMobileSdkLoginImpressionEventBuilder BUILDER = ThirdPartyMobileSdkLoginImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasThirdPartyApplicationIdentifier;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final String thirdPartyApplicationIdentifier;
  
  ThirdPartyMobileSdkLoginImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    thirdPartyApplicationIdentifier = paramString;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasThirdPartyApplicationIdentifier = paramBoolean4;
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
      paramObject = (ThirdPartyMobileSdkLoginImpressionEvent)paramObject;
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
      if (thirdPartyApplicationIdentifier == null) {
        break;
      }
    } while (thirdPartyApplicationIdentifier.equals(thirdPartyApplicationIdentifier));
    for (;;)
    {
      return false;
      if (thirdPartyApplicationIdentifier == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label110;
      }
      j = requestHeader.hashCode();
      label45:
      if (mobileHeader == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = mobileHeader.hashCode();; k = 0)
    {
      if (thirdPartyApplicationIdentifier != null) {
        m = thirdPartyApplicationIdentifier.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<ThirdPartyMobileSdkLoginImpressionEvent>
  {
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasThirdPartyApplicationIdentifier = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public String thirdPartyApplicationIdentifier = null;
    
    private ThirdPartyMobileSdkLoginImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ThirdPartyMobileSdkLoginImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ThirdPartyMobileSdkLoginImpressionEvent(header, requestHeader, mobileHeader, thirdPartyApplicationIdentifier, hasHeader, hasRequestHeader, hasMobileHeader, hasThirdPartyApplicationIdentifier);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginImpressionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginImpressionEvent", "requestHeader");
        }
        if (!hasMobileHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginImpressionEvent", "mobileHeader");
        }
      } while (hasThirdPartyApplicationIdentifier);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginImpressionEvent", "thirdPartyApplicationIdentifier");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */