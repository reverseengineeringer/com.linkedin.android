package com.linkedin.gen.avro2pegasus.events.me.wvmp;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class WvmpOverviewInsightImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<WvmpOverviewInsightImpressionEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasWvmpOverviewInsights = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public List<WvmpOverviewInsightImpression> wvmpOverviewInsights = null;
  
  private WvmpOverviewInsightImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (WvmpOverviewInsightImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (wvmpOverviewInsights != null)
    {
      paramFlavor = wvmpOverviewInsights.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((WvmpOverviewInsightImpression)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "wvmpOverviewInsights");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "requestHeader");
            }
            if (hasWvmpOverviewInsights) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "wvmpOverviewInsights");
          }
        }
      }
    }
    return new WvmpOverviewInsightImpressionEvent(header, requestHeader, mobileHeader, wvmpOverviewInsights, hasHeader, hasRequestHeader, hasMobileHeader, hasWvmpOverviewInsights);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */