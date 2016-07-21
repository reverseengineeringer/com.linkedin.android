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

public final class MobileApplicationSessionEvent
  implements RecordTemplate<MobileApplicationSessionEvent>
{
  public static final MobileApplicationSessionEventBuilder BUILDER = MobileApplicationSessionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ApplicationBuildType applicationBuildType;
  public final ApplicationStateChangeType applicationStateChangeType;
  public final String buildNumber;
  public final boolean hasApplicationBuildType;
  public final boolean hasApplicationStateChangeType;
  public final boolean hasBuildNumber;
  public final boolean hasHeader;
  public final boolean hasMobileApplicationName;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final String mobileApplicationName;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  MobileApplicationSessionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, ApplicationBuildType paramApplicationBuildType, String paramString1, String paramString2, ApplicationStateChangeType paramApplicationStateChangeType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    applicationBuildType = paramApplicationBuildType;
    mobileApplicationName = paramString1;
    buildNumber = paramString2;
    applicationStateChangeType = paramApplicationStateChangeType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasApplicationBuildType = paramBoolean4;
    hasMobileApplicationName = paramBoolean5;
    hasBuildNumber = paramBoolean6;
    hasApplicationStateChangeType = paramBoolean7;
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
      paramObject = (MobileApplicationSessionEvent)paramObject;
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
      if (applicationBuildType != null)
      {
        if (applicationBuildType.equals(applicationBuildType)) {}
      }
      else {
        while (applicationBuildType != null) {
          return false;
        }
      }
      if (mobileApplicationName != null)
      {
        if (mobileApplicationName.equals(mobileApplicationName)) {}
      }
      else {
        while (mobileApplicationName != null) {
          return false;
        }
      }
      if (buildNumber != null)
      {
        if (buildNumber.equals(buildNumber)) {}
      }
      else {
        while (buildNumber != null) {
          return false;
        }
      }
      if (applicationStateChangeType == null) {
        break;
      }
    } while (applicationStateChangeType.equals(applicationStateChangeType));
    for (;;)
    {
      return false;
      if (applicationStateChangeType == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label176;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label181;
      }
      k = mobileHeader.hashCode();
      if (applicationBuildType == null) {
        break label186;
      }
      m = applicationBuildType.hashCode();
      if (mobileApplicationName == null) {
        break label192;
      }
      n = mobileApplicationName.hashCode();
      label92:
      if (buildNumber == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = buildNumber.hashCode();; i1 = 0)
    {
      if (applicationStateChangeType != null) {
        i2 = applicationStateChangeType.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */