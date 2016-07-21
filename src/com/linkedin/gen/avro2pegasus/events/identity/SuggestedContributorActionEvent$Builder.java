package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SuggestedContributorActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedContributorActionEvent>
{
  public SuggestedEditActionType actionType = null;
  public Contributor contributor = null;
  public String flowTrackingId = null;
  public boolean hasActionType = false;
  public boolean hasContributor = false;
  public boolean hasFlowTrackingId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private SuggestedContributorActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SuggestedContributorActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SuggestedContributorActionEvent(header, requestHeader, mobileHeader, contributor, actionType, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasContributor, hasActionType, hasFlowTrackingId);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "requestHeader");
      }
      if (!hasContributor) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "contributor");
      }
      if (!hasActionType) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "actionType");
      }
    } while (hasFlowTrackingId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "flowTrackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */