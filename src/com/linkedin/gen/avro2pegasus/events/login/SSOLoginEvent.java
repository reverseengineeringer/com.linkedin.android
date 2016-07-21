package com.linkedin.gen.avro2pegasus.events.login;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SSOLoginEvent
  implements RecordTemplate<SSOLoginEvent>
{
  public static final SSOLoginEventBuilder BUILDER = SSOLoginEventBuilder.INSTANCE;
  public final SSOLoginResult SSOLoginResult;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String appName;
  public final boolean hasAppName;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasSSOLoginResult;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  SSOLoginEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, SSOLoginResult paramSSOLoginResult, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    appName = paramString;
    SSOLoginResult = paramSSOLoginResult;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasAppName = paramBoolean4;
    hasSSOLoginResult = paramBoolean5;
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
      paramObject = (SSOLoginEvent)paramObject;
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
      if (appName != null)
      {
        if (appName.equals(appName)) {}
      }
      else {
        while (appName != null) {
          return false;
        }
      }
      if (SSOLoginResult == null) {
        break;
      }
    } while (SSOLoginResult.equals(SSOLoginResult));
    for (;;)
    {
      return false;
      if (SSOLoginResult == null) {
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
      if (appName == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = appName.hashCode();; m = 0)
    {
      if (SSOLoginResult != null) {
        n = SSOLoginResult.hashCode();
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.login.SSOLoginEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */