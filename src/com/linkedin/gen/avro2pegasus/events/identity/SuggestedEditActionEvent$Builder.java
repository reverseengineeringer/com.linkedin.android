package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SuggestedEditActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedEditActionEvent>
{
  public SuggestedEditActionType actionType = null;
  public String flowTrackingId = null;
  public boolean hasActionType = false;
  public boolean hasFlowTrackingId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasRawProfileElementUrn = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public String rawProfileElementUrn = null;
  private UserRequestHeader requestHeader = null;
  
  private SuggestedEditActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SuggestedEditActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SuggestedEditActionEvent(header, requestHeader, mobileHeader, rawProfileElementUrn, flowTrackingId, actionType, hasHeader, hasRequestHeader, hasMobileHeader, hasRawProfileElementUrn, hasFlowTrackingId, hasActionType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "requestHeader");
      }
      if (!hasRawProfileElementUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "rawProfileElementUrn");
      }
      if (!hasFlowTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "flowTrackingId");
      }
    } while (hasActionType);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "actionType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */