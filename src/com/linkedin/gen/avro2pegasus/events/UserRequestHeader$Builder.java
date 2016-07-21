package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class UserRequestHeader$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.UserRequestHeader.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */