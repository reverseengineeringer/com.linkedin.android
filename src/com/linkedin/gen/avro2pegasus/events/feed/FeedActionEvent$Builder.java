package com.linkedin.gen.avro2pegasus.events.feed;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

public class FeedActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FeedActionEvent>
{
  private ActionCategory actionCategory = null;
  private String actionType = null;
  public String controlUrn = null;
  private boolean hasActionCategory = false;
  private boolean hasActionType = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasModuleKey = false;
  private boolean hasRequestHeader = false;
  private boolean hasRequestId = false;
  private boolean hasSearchId = false;
  private boolean hasTrackingId = false;
  private boolean hasUpdateUrn = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private String moduleKey = null;
  private UserRequestHeader requestHeader = null;
  private String requestId = null;
  private String searchId = null;
  private String trackingId = null;
  private String updateUrn = null;
  
  private FeedActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FeedActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FeedActionEvent(header, requestHeader, mobileHeader, moduleKey, requestId, trackingId, updateUrn, actionCategory, controlUrn, actionType, searchId, hasHeader, hasRequestHeader, hasMobileHeader, hasModuleKey, hasRequestId, hasTrackingId, hasUpdateUrn, hasActionCategory, hasControlUrn, hasActionType, hasSearchId);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "requestHeader");
      }
      if (!hasModuleKey) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "moduleKey");
      }
      if (!hasRequestId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "requestId");
      }
      if (!hasTrackingId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "trackingId");
      }
      if (!hasUpdateUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "updateUrn");
      }
    } while (hasActionCategory);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent", "actionCategory");
  }
  
  public FeedActionEvent build()
    throws BuilderException
  {
    return build(RecordTemplate.Flavor.RECORD);
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
  
  public final Builder setRequestId(String paramString)
  {
    if (paramString == null)
    {
      hasRequestId = false;
      requestId = null;
      return this;
    }
    hasRequestId = true;
    requestId = paramString;
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
  
  public final Builder setUpdateUrn(String paramString)
  {
    if (paramString == null)
    {
      hasUpdateUrn = false;
      updateUrn = null;
      return this;
    }
    hasUpdateUrn = true;
    updateUrn = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */