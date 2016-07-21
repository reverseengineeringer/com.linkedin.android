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
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public class FeedCommentActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<FeedCommentActionEvent>
{
  private ActionCategory actionCategory = null;
  private String actionType = null;
  public String controlUrn = null;
  private boolean hasActionCategory = false;
  private boolean hasActionType = false;
  public boolean hasControlUrn = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private boolean hasThreadUrn = false;
  private boolean hasTrackableCommentObject = false;
  private boolean hasTrackableUpdateObject = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  private String threadUrn = null;
  private TrackingObject trackableCommentObject = null;
  private TrackingObject trackableUpdateObject = null;
  
  private FeedCommentActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FeedCommentActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FeedCommentActionEvent(header, requestHeader, mobileHeader, trackableUpdateObject, threadUrn, trackableCommentObject, actionCategory, controlUrn, actionType, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackableUpdateObject, hasThreadUrn, hasTrackableCommentObject, hasActionCategory, hasControlUrn, hasActionType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "header");
      }
      if (!hasRequestHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "requestHeader");
      }
      if (!hasTrackableUpdateObject) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "trackableUpdateObject");
      }
      if (!hasThreadUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "threadUrn");
      }
      if (!hasTrackableCommentObject) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "trackableCommentObject");
      }
      if (!hasActionCategory) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "actionCategory");
      }
      if (!hasControlUrn) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "controlUrn");
      }
    } while (hasActionType);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "actionType");
  }
  
  public FeedCommentActionEvent build()
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
  
  public final Builder setThreadUrn(String paramString)
  {
    if (paramString == null)
    {
      hasThreadUrn = false;
      threadUrn = null;
      return this;
    }
    hasThreadUrn = true;
    threadUrn = paramString;
    return this;
  }
  
  public final Builder setTrackableCommentObject(TrackingObject paramTrackingObject)
  {
    if (paramTrackingObject == null)
    {
      hasTrackableCommentObject = false;
      trackableCommentObject = null;
      return this;
    }
    hasTrackableCommentObject = true;
    trackableCommentObject = paramTrackingObject;
    return this;
  }
  
  public final Builder setTrackableUpdateObject(TrackingObject paramTrackingObject)
  {
    if (paramTrackingObject == null)
    {
      hasTrackableUpdateObject = false;
      trackableUpdateObject = null;
      return this;
    }
    hasTrackableUpdateObject = true;
    trackableUpdateObject = paramTrackingObject;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */