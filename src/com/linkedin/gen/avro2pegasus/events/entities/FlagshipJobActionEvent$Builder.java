package com.linkedin.gen.avro2pegasus.events.entities;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class FlagshipJobActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipJobActionEvent>
{
  private ActionCategory actionCategory = null;
  private String controlUrn = null;
  private boolean hasActionCategory = false;
  private boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasJob = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private boolean hasSubItemUrn = false;
  private EventHeader header = null;
  private TrackingObject job = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  private String subItemUrn = null;
  
  private FlagshipJobActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FlagshipJobActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FlagshipJobActionEvent(header, requestHeader, mobileHeader, controlUrn, actionCategory, subItemUrn, job, hasHeader, hasRequestHeader, hasMobileHeader, hasControlUrn, hasActionCategory, hasSubItemUrn, hasJob);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobActionEvent", "requestHeader");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobActionEvent", "controlUrn");
      }
      if (!hasActionCategory) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobActionEvent", "actionCategory");
      }
    } while (hasJob);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobActionEvent", "job");
  }
  
  public final Builder setActionCategory(ActionCategory paramActionCategory)
  {
    if (paramActionCategory == null)
    {
      hasActionCategory = false;
      actionCategory = null;
      return this;
    }
    hasActionCategory = true;
    actionCategory = paramActionCategory;
    return this;
  }
  
  public final Builder setControlUrn(String paramString)
  {
    if (paramString == null)
    {
      hasControlUrn = false;
      controlUrn = null;
      return this;
    }
    hasControlUrn = true;
    controlUrn = paramString;
    return this;
  }
  
  public final Builder setJob(TrackingObject paramTrackingObject)
  {
    if (paramTrackingObject == null)
    {
      hasJob = false;
      job = null;
      return this;
    }
    hasJob = true;
    job = paramTrackingObject;
    return this;
  }
  
  public final Builder setSubItemUrn(String paramString)
  {
    if (paramString == null)
    {
      hasSubItemUrn = false;
      subItemUrn = null;
      return this;
    }
    hasSubItemUrn = true;
    subItemUrn = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */