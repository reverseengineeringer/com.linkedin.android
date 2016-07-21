package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullMapValueException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class PageViewEvent
  implements RecordTemplate<PageViewEvent>
{
  public static final PageViewEventBuilder BUILDER = PageViewEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String errorMessageKey;
  public final boolean hasErrorMessageKey;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasPageType;
  public final boolean hasRequestHeader;
  public final boolean hasTotalTime;
  public final boolean hasTrackingCode;
  public final boolean hasTrackingInfo;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final PageType pageType;
  public final UserRequestHeader requestHeader;
  public final int totalTime;
  public final String trackingCode;
  public final Map<String, String> trackingInfo;
  
  PageViewEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, PageType paramPageType, String paramString1, String paramString2, Map<String, String> paramMap, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    pageType = paramPageType;
    errorMessageKey = paramString1;
    trackingCode = paramString2;
    if (paramMap == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableMap(paramMap))
    {
      trackingInfo = paramEventHeader;
      totalTime = paramInt;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasPageType = paramBoolean4;
      hasErrorMessageKey = paramBoolean5;
      hasTrackingCode = paramBoolean6;
      hasTrackingInfo = paramBoolean7;
      hasTotalTime = paramBoolean8;
      _cachedId = null;
      return;
    }
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
      paramObject = (PageViewEvent)paramObject;
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
      if (pageType != null)
      {
        if (pageType.equals(pageType)) {}
      }
      else {
        while (pageType != null) {
          return false;
        }
      }
      if (errorMessageKey != null)
      {
        if (errorMessageKey.equals(errorMessageKey)) {}
      }
      else {
        while (errorMessageKey != null) {
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
      if (trackingInfo != null)
      {
        if (trackingInfo.equals(trackingInfo)) {}
      }
      else {
        while (trackingInfo != null) {
          return false;
        }
      }
    } while (totalTime == totalTime);
    return false;
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
        break label186;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label191;
      }
      k = mobileHeader.hashCode();
      if (pageType == null) {
        break label196;
      }
      m = pageType.hashCode();
      if (errorMessageKey == null) {
        break label202;
      }
      n = errorMessageKey.hashCode();
      label92:
      if (trackingCode == null) {
        break label208;
      }
    }
    label186:
    label191:
    label196:
    label202:
    label208:
    for (int i1 = trackingCode.hashCode();; i1 = 0)
    {
      if (trackingInfo != null) {
        i2 = trackingInfo.hashCode();
      }
      i = ((i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2) * 31 + totalTime;
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
    implements TrackingEventBuilder, RecordTemplateBuilder<PageViewEvent>
  {
    private String errorMessageKey = null;
    private boolean hasErrorMessageKey = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasPageType = false;
    private boolean hasRequestHeader = false;
    public boolean hasTotalTime = false;
    public boolean hasTrackingCode = false;
    public boolean hasTrackingInfo = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public PageType pageType = null;
    private UserRequestHeader requestHeader = null;
    public int totalTime = 0;
    public String trackingCode = null;
    public Map<String, String> trackingInfo = null;
    
    public final PageViewEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PageViewEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (trackingInfo != null)
      {
        paramFlavor = trackingInfo.values().iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullMapValueException("com.linkedin.gen.avro2pegasus.events.PageViewEvent", "trackingInfo");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.PageViewEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.PageViewEvent", "requestHeader");
              }
              if (!hasPageType) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.PageViewEvent", "pageType");
              }
              if (!hasTrackingInfo) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.PageViewEvent", "trackingInfo");
              }
              if (hasTotalTime) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.PageViewEvent", "totalTime");
            }
          }
        }
      }
      return new PageViewEvent(header, requestHeader, mobileHeader, pageType, errorMessageKey, trackingCode, trackingInfo, totalTime, hasHeader, hasRequestHeader, hasMobileHeader, hasPageType, hasErrorMessageKey, hasTrackingCode, hasTrackingInfo, hasTotalTime);
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
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.PageViewEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */