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

public final class AndroidAppActivationEvent
  implements RecordTemplate<AndroidAppActivationEvent>
{
  public static final AndroidAppActivationEventBuilder BUILDER = AndroidAppActivationEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ActivationStateType activationState;
  public final boolean hasActivationState;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRawReferrer;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final String rawReferrer;
  public final UserRequestHeader requestHeader;
  
  AndroidAppActivationEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, ActivationStateType paramActivationStateType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    rawReferrer = paramString;
    activationState = paramActivationStateType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasRawReferrer = paramBoolean4;
    hasActivationState = paramBoolean5;
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
      paramObject = (AndroidAppActivationEvent)paramObject;
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
      if (rawReferrer != null)
      {
        if (rawReferrer.equals(rawReferrer)) {}
      }
      else {
        while (rawReferrer != null) {
          return false;
        }
      }
      if (activationState == null) {
        break;
      }
    } while (activationState.equals(activationState));
    for (;;)
    {
      return false;
      if (activationState == null) {
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
      if (rawReferrer == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = rawReferrer.hashCode();; m = 0)
    {
      if (activationState != null) {
        n = activationState.hashCode();
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.AndroidAppActivationEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */