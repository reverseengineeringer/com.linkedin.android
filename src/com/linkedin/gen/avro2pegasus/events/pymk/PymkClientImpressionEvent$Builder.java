package com.linkedin.gen.avro2pegasus.events.pymk;

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

public final class PymkClientImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PymkClientImpressionEvent>
{
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRecommendations = false;
  private boolean hasRequestHeader = false;
  private boolean hasUsageContext = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private List<PymkRecommendation> recommendations = null;
  private UserRequestHeader requestHeader = null;
  private String usageContext = null;
  
  private PymkClientImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PymkClientImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (recommendations != null)
    {
      paramFlavor = recommendations.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((PymkRecommendation)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "recommendations");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "requestHeader");
            }
            if (!hasUsageContext) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "usageContext");
            }
            if (hasRecommendations) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "recommendations");
          }
        }
      }
    }
    return new PymkClientImpressionEvent(header, requestHeader, mobileHeader, usageContext, recommendations, hasHeader, hasRequestHeader, hasMobileHeader, hasUsageContext, hasRecommendations);
  }
  
  public final Builder setRecommendations(List<PymkRecommendation> paramList)
  {
    if (paramList == null)
    {
      hasRecommendations = false;
      recommendations = null;
      return this;
    }
    hasRecommendations = true;
    recommendations = paramList;
    return this;
  }
  
  public final Builder setUsageContext(String paramString)
  {
    if (paramString == null)
    {
      hasUsageContext = false;
      usageContext = null;
      return this;
    }
    hasUsageContext = true;
    usageContext = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */