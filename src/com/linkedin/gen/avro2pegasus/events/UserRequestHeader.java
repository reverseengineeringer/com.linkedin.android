package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class UserRequestHeader
  implements RecordTemplate<UserRequestHeader>
{
  public static final UserRequestHeaderBuilder BUILDER = UserRequestHeaderBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String browserId;
  public final boolean hasBrowserId;
  public final boolean hasInterfaceLocale;
  public final boolean hasIp;
  public final boolean hasIpAsBytes;
  public final boolean hasLocale;
  public final boolean hasPageKey;
  public final boolean hasPath;
  public final boolean hasReferer;
  public final boolean hasSessionId;
  public final boolean hasTrackingCode;
  public final boolean hasUserAgent;
  public final String interfaceLocale;
  public final String ip;
  public final String ipAsBytes;
  public final String locale;
  public final String pageKey;
  public final String path;
  public final String referer;
  public final String sessionId;
  public final String trackingCode;
  public final String userAgent;
  
  UserRequestHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    browserId = paramString1;
    sessionId = paramString2;
    ip = paramString3;
    pageKey = paramString4;
    path = paramString5;
    locale = paramString6;
    interfaceLocale = paramString7;
    trackingCode = paramString8;
    referer = paramString9;
    userAgent = paramString10;
    ipAsBytes = paramString11;
    hasBrowserId = paramBoolean1;
    hasSessionId = paramBoolean2;
    hasIp = paramBoolean3;
    hasPageKey = paramBoolean4;
    hasPath = paramBoolean5;
    hasLocale = paramBoolean6;
    hasInterfaceLocale = paramBoolean7;
    hasTrackingCode = paramBoolean8;
    hasReferer = paramBoolean9;
    hasUserAgent = paramBoolean10;
    hasIpAsBytes = paramBoolean11;
    _cachedId = null;
  }
  
  public final UserRequestHeader accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasBrowserId)
    {
      paramDataProcessor.startRecordField$505cff1c("browserId");
      paramDataProcessor.processString(browserId);
    }
    if (hasSessionId)
    {
      paramDataProcessor.startRecordField$505cff1c("sessionId");
      paramDataProcessor.processString(sessionId);
    }
    if (hasIp)
    {
      paramDataProcessor.startRecordField$505cff1c("ip");
      paramDataProcessor.processString(ip);
    }
    if (hasPageKey)
    {
      paramDataProcessor.startRecordField$505cff1c("pageKey");
      paramDataProcessor.processString(pageKey);
    }
    if (hasPath)
    {
      paramDataProcessor.startRecordField$505cff1c("path");
      paramDataProcessor.processString(path);
    }
    if (hasLocale)
    {
      paramDataProcessor.startRecordField$505cff1c("locale");
      paramDataProcessor.processString(locale);
    }
    if (hasInterfaceLocale)
    {
      paramDataProcessor.startRecordField$505cff1c("interfaceLocale");
      paramDataProcessor.processString(interfaceLocale);
    }
    if (hasTrackingCode)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingCode");
      paramDataProcessor.processString(trackingCode);
    }
    if (hasReferer)
    {
      paramDataProcessor.startRecordField$505cff1c("referer");
      paramDataProcessor.processString(referer);
    }
    if (hasUserAgent)
    {
      paramDataProcessor.startRecordField$505cff1c("userAgent");
      paramDataProcessor.processString(userAgent);
    }
    if (hasIpAsBytes)
    {
      paramDataProcessor.startRecordField$505cff1c("ipAsBytes");
      BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(ipAsBytes));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new UserRequestHeader(browserId, sessionId, ip, pageKey, path, locale, interfaceLocale, trackingCode, referer, userAgent, ipAsBytes, hasBrowserId, hasSessionId, hasIp, hasPageKey, hasPath, hasLocale, hasInterfaceLocale, hasTrackingCode, hasReferer, hasUserAgent, hasIpAsBytes);
    }
    return null;
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
      paramObject = (UserRequestHeader)paramObject;
      if (browserId != null)
      {
        if (browserId.equals(browserId)) {}
      }
      else {
        while (browserId != null) {
          return false;
        }
      }
      if (sessionId != null)
      {
        if (sessionId.equals(sessionId)) {}
      }
      else {
        while (sessionId != null) {
          return false;
        }
      }
      if (ip != null)
      {
        if (ip.equals(ip)) {}
      }
      else {
        while (ip != null) {
          return false;
        }
      }
      if (pageKey != null)
      {
        if (pageKey.equals(pageKey)) {}
      }
      else {
        while (pageKey != null) {
          return false;
        }
      }
      if (path != null)
      {
        if (path.equals(path)) {}
      }
      else {
        while (path != null) {
          return false;
        }
      }
      if (locale != null)
      {
        if (locale.equals(locale)) {}
      }
      else {
        while (locale != null) {
          return false;
        }
      }
      if (interfaceLocale != null)
      {
        if (interfaceLocale.equals(interfaceLocale)) {}
      }
      else {
        while (interfaceLocale != null) {
          return false;
        }
      }
      if (trackingCode != null)
      {
        if (trackingCode.equals(trackingCode)) {}
      }
      else {
        while (trackingCode != null) {
          return false;
        }
      }
      if (referer != null)
      {
        if (referer.equals(referer)) {}
      }
      else {
        while (referer != null) {
          return false;
        }
      }
      if (userAgent != null)
      {
        if (userAgent.equals(userAgent)) {}
      }
      else {
        while (userAgent != null) {
          return false;
        }
      }
      if (ipAsBytes == null) {
        break;
      }
    } while (ipAsBytes.equals(ipAsBytes));
    for (;;)
    {
      return false;
      if (ipAsBytes == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i6 = 0;
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
    label92:
    int i1;
    label108:
    int i2;
    label124:
    int i3;
    label140:
    int i4;
    if (browserId != null)
    {
      i = browserId.hashCode();
      if (sessionId == null) {
        break label264;
      }
      j = sessionId.hashCode();
      if (ip == null) {
        break label269;
      }
      k = ip.hashCode();
      if (pageKey == null) {
        break label274;
      }
      m = pageKey.hashCode();
      if (path == null) {
        break label280;
      }
      n = path.hashCode();
      if (locale == null) {
        break label286;
      }
      i1 = locale.hashCode();
      if (interfaceLocale == null) {
        break label292;
      }
      i2 = interfaceLocale.hashCode();
      if (trackingCode == null) {
        break label298;
      }
      i3 = trackingCode.hashCode();
      if (referer == null) {
        break label304;
      }
      i4 = referer.hashCode();
      label156:
      if (userAgent == null) {
        break label310;
      }
    }
    label264:
    label269:
    label274:
    label280:
    label286:
    label292:
    label298:
    label304:
    label310:
    for (int i5 = userAgent.hashCode();; i5 = 0)
    {
      if (ipAsBytes != null) {
        i6 = ipAsBytes.hashCode();
      }
      i = (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6;
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
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
      i3 = 0;
      break label140;
      i4 = 0;
      break label156;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<UserRequestHeader>
  {
    private String browserId = null;
    private boolean hasBrowserId = false;
    private boolean hasInterfaceLocale = false;
    private boolean hasIp = false;
    private boolean hasIpAsBytes = false;
    private boolean hasLocale = false;
    private boolean hasPageKey = false;
    private boolean hasPath = false;
    private boolean hasReferer = false;
    private boolean hasSessionId = false;
    private boolean hasTrackingCode = false;
    private boolean hasUserAgent = false;
    private String interfaceLocale = null;
    private String ip = null;
    private String ipAsBytes = null;
    private String locale = null;
    private String pageKey = null;
    private String path = null;
    private String referer = null;
    private String sessionId = null;
    private String trackingCode = null;
    private String userAgent = null;
    
    public final UserRequestHeader build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = UserRequestHeader.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new UserRequestHeader(browserId, sessionId, ip, pageKey, path, locale, interfaceLocale, trackingCode, referer, userAgent, ipAsBytes, hasBrowserId, hasSessionId, hasIp, hasPageKey, hasPath, hasLocale, hasInterfaceLocale, hasTrackingCode, hasReferer, hasUserAgent, hasIpAsBytes);
    }
    
    public final Builder setInterfaceLocale(String paramString)
    {
      if (paramString == null)
      {
        hasInterfaceLocale = false;
        interfaceLocale = null;
        return this;
      }
      hasInterfaceLocale = true;
      interfaceLocale = paramString;
      return this;
    }
    
    public final Builder setPageKey(String paramString)
    {
      if (paramString == null)
      {
        hasPageKey = false;
        pageKey = null;
        return this;
      }
      hasPageKey = true;
      pageKey = paramString;
      return this;
    }
    
    public final Builder setPath(String paramString)
    {
      if (paramString == null)
      {
        hasPath = false;
        path = null;
        return this;
      }
      hasPath = true;
      path = paramString;
      return this;
    }
    
    public final Builder setReferer(String paramString)
    {
      if (paramString == null)
      {
        hasReferer = false;
        referer = null;
        return this;
      }
      hasReferer = true;
      referer = paramString;
      return this;
    }
    
    public final Builder setTrackingCode(String paramString)
    {
      if (paramString == null)
      {
        hasTrackingCode = false;
        trackingCode = null;
        return this;
      }
      hasTrackingCode = true;
      trackingCode = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.UserRequestHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */