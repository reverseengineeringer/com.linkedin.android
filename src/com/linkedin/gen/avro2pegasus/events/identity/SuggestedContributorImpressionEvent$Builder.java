package com.linkedin.gen.avro2pegasus.events.identity;

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

public final class SuggestedContributorImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedContributorImpressionEvent>
{
  public List<Contributor> contributors = null;
  public String flowTrackingId = null;
  public boolean hasContributors = false;
  public boolean hasFlowTrackingId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private SuggestedContributorImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SuggestedContributorImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (contributors != null)
    {
      paramFlavor = contributors.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Contributor)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorImpressionEvent", "contributors");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorImpressionEvent", "requestHeader");
            }
            if (!hasContributors) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorImpressionEvent", "contributors");
            }
            if (hasFlowTrackingId) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorImpressionEvent", "flowTrackingId");
          }
        }
      }
    }
    return new SuggestedContributorImpressionEvent(header, requestHeader, mobileHeader, contributors, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasContributors, hasFlowTrackingId);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */