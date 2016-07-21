package com.linkedin.gen.avro2pegasus.events.performance;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.PerformanceTimingItems;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ExperimentalPerformanceTimingEvent
  implements RecordTemplate<ExperimentalPerformanceTimingEvent>
{
  public static final ExperimentalPerformanceTimingEventBuilder BUILDER = ExperimentalPerformanceTimingEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasPerformanceTimingArray;
  public final boolean hasRequestHeader;
  public final boolean hasUserSessionId;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final List<PerformanceTimingItems> performanceTimingArray;
  public final UserRequestHeader requestHeader;
  public final String userSessionId;
  
  ExperimentalPerformanceTimingEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, List<PerformanceTimingItems> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      performanceTimingArray = paramEventHeader;
      userSessionId = paramString;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasPerformanceTimingArray = paramBoolean4;
      hasUserSessionId = paramBoolean5;
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
      paramObject = (ExperimentalPerformanceTimingEvent)paramObject;
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
      if (performanceTimingArray != null)
      {
        if (performanceTimingArray.equals(performanceTimingArray)) {}
      }
      else {
        while (performanceTimingArray != null) {
          return false;
        }
      }
      if (userSessionId == null) {
        break;
      }
    } while (userSessionId.equals(userSessionId));
    for (;;)
    {
      return false;
      if (userSessionId == null) {
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
        break label134;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label139;
      }
      k = mobileHeader.hashCode();
      label60:
      if (performanceTimingArray == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = performanceTimingArray.hashCode();; m = 0)
    {
      if (userSessionId != null) {
        n = userSessionId.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<ExperimentalPerformanceTimingEvent>
  {
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasPerformanceTimingArray = false;
    private boolean hasRequestHeader = false;
    public boolean hasUserSessionId = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public List<PerformanceTimingItems> performanceTimingArray = null;
    private UserRequestHeader requestHeader = null;
    public String userSessionId = null;
    
    private ExperimentalPerformanceTimingEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ExperimentalPerformanceTimingEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (performanceTimingArray != null)
      {
        paramFlavor = performanceTimingArray.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((PerformanceTimingItems)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.performance.ExperimentalPerformanceTimingEvent", "performanceTimingArray");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.performance.ExperimentalPerformanceTimingEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.performance.ExperimentalPerformanceTimingEvent", "requestHeader");
              }
              if (!hasMobileHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.performance.ExperimentalPerformanceTimingEvent", "mobileHeader");
              }
              if (hasPerformanceTimingArray) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.performance.ExperimentalPerformanceTimingEvent", "performanceTimingArray");
            }
          }
        }
      }
      return new ExperimentalPerformanceTimingEvent(header, requestHeader, mobileHeader, performanceTimingArray, userSessionId, hasHeader, hasRequestHeader, hasMobileHeader, hasPerformanceTimingArray, hasUserSessionId);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.performance.ExperimentalPerformanceTimingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */