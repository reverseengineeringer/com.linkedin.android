package com.linkedin.gen.avro2pegasus.events.guidededit;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditFlowNavAction;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class GuidedEditFlowNavActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<GuidedEditFlowNavActionEvent>
{
  public String flowTrackingId = null;
  public boolean hasFlowTrackingId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasUserAction = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public GuidedEditFlowNavAction userAction = null;
  
  private GuidedEditFlowNavActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GuidedEditFlowNavActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new GuidedEditFlowNavActionEvent(header, requestHeader, mobileHeader, userAction, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasUserAction, hasFlowTrackingId);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowNavActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowNavActionEvent", "requestHeader");
      }
      if (!hasUserAction) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowNavActionEvent", "userAction");
      }
    } while (hasFlowTrackingId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowNavActionEvent", "flowTrackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowNavActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */