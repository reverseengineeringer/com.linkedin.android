package com.linkedin.gen.avro2pegasus.events.guidededit;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditContextType;
import com.linkedin.gen.avro2pegasus.common.guidededit.IsbFieldName;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class GuidedEditFlowImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<GuidedEditFlowImpressionEvent>
{
  public GuidedEditContextType contextType = null;
  public List<IsbFieldName> fieldNames = null;
  public String flowTrackingId = null;
  public boolean hasContextType = false;
  public boolean hasFieldNames = false;
  public boolean hasFlowTrackingId = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private GuidedEditFlowImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GuidedEditFlowImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (fieldNames != null)
    {
      paramFlavor = fieldNames.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((IsbFieldName)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "fieldNames");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "requestHeader");
            }
            if (!hasContextType) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "contextType");
            }
            if (hasFlowTrackingId) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "flowTrackingId");
          }
        }
      }
    }
    return new GuidedEditFlowImpressionEvent(header, requestHeader, mobileHeader, contextType, fieldNames, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasContextType, hasFieldNames, hasFlowTrackingId);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */