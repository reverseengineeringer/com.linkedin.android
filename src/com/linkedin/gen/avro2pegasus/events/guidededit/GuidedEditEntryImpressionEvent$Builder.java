package com.linkedin.gen.avro2pegasus.events.guidededit;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditCategoryName;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditContextType;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;

public final class GuidedEditEntryImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<GuidedEditEntryImpressionEvent>
{
  private GuidedEditContextType contextType = null;
  private String flowTrackingId = null;
  private GridPosition gridPosition = null;
  private GuidedEditCategoryName guidedEditCategoryName = null;
  private boolean hasContextType = false;
  private boolean hasFlowTrackingId = false;
  private boolean hasGridPosition = false;
  private boolean hasGuidedEditCategoryName = false;
  private boolean hasHeader = false;
  public boolean hasListPosition = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public ListPosition listPosition = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private GuidedEditEntryImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GuidedEditEntryImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new GuidedEditEntryImpressionEvent(header, requestHeader, mobileHeader, contextType, guidedEditCategoryName, gridPosition, listPosition, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasContextType, hasGuidedEditCategoryName, hasGridPosition, hasListPosition, hasFlowTrackingId);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "requestHeader");
      }
      if (!hasContextType) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "contextType");
      }
      if (!hasGuidedEditCategoryName) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "guidedEditCategoryName");
      }
    } while (hasFlowTrackingId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent", "flowTrackingId");
  }
  
  public final Builder setContextType(GuidedEditContextType paramGuidedEditContextType)
  {
    if (paramGuidedEditContextType == null)
    {
      hasContextType = false;
      contextType = null;
      return this;
    }
    hasContextType = true;
    contextType = paramGuidedEditContextType;
    return this;
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
  
  public final Builder setGuidedEditCategoryName(GuidedEditCategoryName paramGuidedEditCategoryName)
  {
    if (paramGuidedEditCategoryName == null)
    {
      hasGuidedEditCategoryName = false;
      guidedEditCategoryName = null;
      return this;
    }
    hasGuidedEditCategoryName = true;
    guidedEditCategoryName = paramGuidedEditCategoryName;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */