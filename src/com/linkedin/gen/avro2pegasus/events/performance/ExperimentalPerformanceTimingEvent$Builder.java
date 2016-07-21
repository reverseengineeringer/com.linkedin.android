package com.linkedin.gen.avro2pegasus.events.performance;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.PerformanceTimingItems;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class ExperimentalPerformanceTimingEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.performance.ExperimentalPerformanceTimingEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */