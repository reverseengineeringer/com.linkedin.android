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

public final class ThirdPartyMobileSdkLoginActionEvent
  implements RecordTemplate<ThirdPartyMobileSdkLoginActionEvent>
{
  public static final ThirdPartyMobileSdkLoginActionEventBuilder BUILDER = ThirdPartyMobileSdkLoginActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasLoggedInMemberUrn;
  public final boolean hasLoginResult;
  public final boolean hasLoginSessionId;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasThirdPartyApplicationIdentifier;
  public final EventHeader header;
  public final String loggedInMemberUrn;
  public final VoyagerLoginResult loginResult;
  public final String loginSessionId;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final String thirdPartyApplicationIdentifier;
  
  ThirdPartyMobileSdkLoginActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, VoyagerLoginResult paramVoyagerLoginResult, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    thirdPartyApplicationIdentifier = paramString1;
    loginResult = paramVoyagerLoginResult;
    loggedInMemberUrn = paramString2;
    loginSessionId = paramString3;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasThirdPartyApplicationIdentifier = paramBoolean4;
    hasLoginResult = paramBoolean5;
    hasLoggedInMemberUrn = paramBoolean6;
    hasLoginSessionId = paramBoolean7;
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
      paramObject = (ThirdPartyMobileSdkLoginActionEvent)paramObject;
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
      if (thirdPartyApplicationIdentifier != null)
      {
        if (thirdPartyApplicationIdentifier.equals(thirdPartyApplicationIdentifier)) {}
      }
      else {
        while (thirdPartyApplicationIdentifier != null) {
          return false;
        }
      }
      if (loginResult != null)
      {
        if (loginResult.equals(loginResult)) {}
      }
      else {
        while (loginResult != null) {
          return false;
        }
      }
      if (loggedInMemberUrn != null)
      {
        if (loggedInMemberUrn.equals(loggedInMemberUrn)) {}
      }
      else {
        while (loggedInMemberUrn != null) {
          return false;
        }
      }
      if (loginSessionId == null) {
        break;
      }
    } while (loginSessionId.equals(loginSessionId));
    for (;;)
    {
      return false;
      if (loginSessionId == null) {
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
      if (thirdPartyApplicationIdentifier == null) {
        break label186;
      }
      m = thirdPartyApplicationIdentifier.hashCode();
      if (loginResult == null) {
        break label192;
      }
      n = loginResult.hashCode();
      label92:
      if (loggedInMemberUrn == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = loggedInMemberUrn.hashCode();; i1 = 0)
    {
      if (loginSessionId != null) {
        i2 = loginSessionId.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<ThirdPartyMobileSdkLoginActionEvent>
  {
    private boolean hasHeader = false;
    public boolean hasLoggedInMemberUrn = false;
    public boolean hasLoginResult = false;
    public boolean hasLoginSessionId = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasThirdPartyApplicationIdentifier = false;
    private EventHeader header = null;
    public String loggedInMemberUrn = null;
    public VoyagerLoginResult loginResult = null;
    public String loginSessionId = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public String thirdPartyApplicationIdentifier = null;
    
    private ThirdPartyMobileSdkLoginActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ThirdPartyMobileSdkLoginActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ThirdPartyMobileSdkLoginActionEvent(header, requestHeader, mobileHeader, thirdPartyApplicationIdentifier, loginResult, loggedInMemberUrn, loginSessionId, hasHeader, hasRequestHeader, hasMobileHeader, hasThirdPartyApplicationIdentifier, hasLoginResult, hasLoggedInMemberUrn, hasLoginSessionId);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "requestHeader");
        }
        if (!hasMobileHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "mobileHeader");
        }
        if (!hasThirdPartyApplicationIdentifier) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "thirdPartyApplicationIdentifier");
        }
      } while (hasLoginResult);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent", "loginResult");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */