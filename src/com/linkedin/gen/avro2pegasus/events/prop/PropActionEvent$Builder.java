package com.linkedin.gen.avro2pegasus.events.prop;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

public final class PropActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PropActionEvent>
{
  private ActionCategory actionCategory = null;
  private String actionType = null;
  private String controlUrn = null;
  private boolean hasActionCategory = false;
  private boolean hasActionType = false;
  private boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasModuleKey = false;
  private boolean hasPropUrn = false;
  private boolean hasRequestHeader = false;
  private boolean hasTrackingId = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private String moduleKey = null;
  private String propUrn = null;
  private UserRequestHeader requestHeader = null;
  private String trackingId = null;
  
  private PropActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PropActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PropActionEvent(header, requestHeader, mobileHeader, moduleKey, trackingId, propUrn, actionCategory, controlUrn, actionType, hasHeader, hasRequestHeader, hasMobileHeader, hasModuleKey, hasTrackingId, hasPropUrn, hasActionCategory, hasControlUrn, hasActionType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "requestHeader");
      }
      if (!hasModuleKey) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "moduleKey");
      }
      if (!hasTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "trackingId");
      }
      if (!hasPropUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "propUrn");
      }
    } while (hasActionCategory);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent", "actionCategory");
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
  
  public final Builder setActionType(String paramString)
  {
    if (paramString == null)
    {
      hasActionType = false;
      actionType = null;
      return this;
    }
    hasActionType = true;
    actionType = paramString;
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
  
  public final Builder setModuleKey(String paramString)
  {
    if (paramString == null)
    {
      hasModuleKey = false;
      moduleKey = null;
      return this;
    }
    hasModuleKey = true;
    moduleKey = paramString;
    return this;
  }
  
  public final Builder setPropUrn(String paramString)
  {
    if (paramString == null)
    {
      hasPropUrn = false;
      propUrn = null;
      return this;
    }
    hasPropUrn = true;
    propUrn = paramString;
    return this;
  }
  
  public final Builder setTrackingId(String paramString)
  {
    if (paramString == null)
    {
      hasTrackingId = false;
      trackingId = null;
      return this;
    }
    hasTrackingId = true;
    trackingId = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.prop.PropActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */