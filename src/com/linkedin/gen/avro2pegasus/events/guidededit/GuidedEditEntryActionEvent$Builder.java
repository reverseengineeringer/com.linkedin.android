package com.linkedin.gen.avro2pegasus.events.guidededit;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditContextType;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEntryAction;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class GuidedEditEntryActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<GuidedEditEntryActionEvent>
{
  public GuidedEditContextType contextType = null;
  public String flowTrackingId = null;
  public boolean hasContextType = false;
  public boolean hasFlowTrackingId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  public boolean hasUserAction = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  public GuidedEditEntryAction userAction = null;
  
  private GuidedEditEntryActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GuidedEditEntryActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new GuidedEditEntryActionEvent(header, requestHeader, mobileHeader, userAction, flowTrackingId, contextType, hasHeader, hasRequestHeader, hasMobileHeader, hasUserAction, hasFlowTrackingId, hasContextType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryActionEvent", "requestHeader");
      }
      if (!hasUserAction) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryActionEvent", "userAction");
      }
    } while (hasFlowTrackingId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryActionEvent", "flowTrackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */