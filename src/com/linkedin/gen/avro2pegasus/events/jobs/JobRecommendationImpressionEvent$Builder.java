package com.linkedin.gen.avro2pegasus.events.jobs;

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

public final class JobRecommendationImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<JobRecommendationImpressionEvent>
{
  public List<JobRecommendationImpressionEntity> entities = null;
  public boolean hasEntities = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private JobRecommendationImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (JobRecommendationImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (entities != null)
    {
      paramFlavor = entities.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((JobRecommendationImpressionEntity)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEvent", "entities");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEvent", "requestHeader");
            }
            if (hasEntities) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEvent", "entities");
          }
        }
      }
    }
    return new JobRecommendationImpressionEvent(header, requestHeader, mobileHeader, entities, hasHeader, hasRequestHeader, hasMobileHeader, hasEntities);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */