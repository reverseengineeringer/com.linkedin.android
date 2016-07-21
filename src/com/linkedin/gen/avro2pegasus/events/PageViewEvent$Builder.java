package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullMapValueException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class PageViewEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.PageViewEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */