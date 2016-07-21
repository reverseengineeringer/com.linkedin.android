package com.linkedin.gen.avro2pegasus.events.guidededit;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class GuidedEditFlowSaveActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<GuidedEditFlowSaveActionEvent>
{
  public GuidedEditEducationsField educations = null;
  private String flowTrackingId = null;
  public boolean hasEducations = false;
  private boolean hasFlowTrackingId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  public boolean hasPositions = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  public GuidedEditPositionsField positions = null;
  private UserRequestHeader requestHeader = null;
  
  private GuidedEditFlowSaveActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GuidedEditFlowSaveActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new GuidedEditFlowSaveActionEvent(header, requestHeader, mobileHeader, positions, educations, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasPositions, hasEducations, hasFlowTrackingId);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowSaveActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowSaveActionEvent", "requestHeader");
      }
    } while (hasFlowTrackingId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowSaveActionEvent", "flowTrackingId");
  }
  
  public final Builder setFlowTrackingId(String paramString)
  {
    if (paramString == null)
    {
      hasFlowTrackingId = false;
      flowTrackingId = null;
      return this;
    }
    hasFlowTrackingId = true;
    flowTrackingId = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowSaveActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */