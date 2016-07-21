package com.linkedin.gen.avro2pegasus.events.feed;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class FeedCommentActionEvent
  implements RecordTemplate<FeedCommentActionEvent>
{
  public static final FeedCommentActionEventBuilder BUILDER = FeedCommentActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ActionCategory actionCategory;
  public final String actionType;
  public final String controlUrn;
  public final boolean hasActionCategory;
  public final boolean hasActionType;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasThreadUrn;
  public final boolean hasTrackableCommentObject;
  public final boolean hasTrackableUpdateObject;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final String threadUrn;
  public final TrackingObject trackableCommentObject;
  public final TrackingObject trackableUpdateObject;
  
  FeedCommentActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject1, String paramString1, TrackingObject paramTrackingObject2, ActionCategory paramActionCategory, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    trackableUpdateObject = paramTrackingObject1;
    threadUrn = paramString1;
    trackableCommentObject = paramTrackingObject2;
    actionCategory = paramActionCategory;
    controlUrn = paramString2;
    actionType = paramString3;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasTrackableUpdateObject = paramBoolean4;
    hasThreadUrn = paramBoolean5;
    hasTrackableCommentObject = paramBoolean6;
    hasActionCategory = paramBoolean7;
    hasControlUrn = paramBoolean8;
    hasActionType = paramBoolean9;
    _cachedId = null;
  }
  
  private FeedCommentActionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    label146:
    label158:
    Object localObject5;
    boolean bool4;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label420;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label429;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label447;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label456;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label474;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasTrackableUpdateObject)
      {
        paramDataProcessor.startRecordField$505cff1c("trackableUpdateObject");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label484;
        }
        localObject1 = trackableUpdateObject.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label502;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label210:
      if (hasThreadUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("threadUrn");
        paramDataProcessor.processString(threadUrn);
      }
      localObject1 = null;
      bool5 = false;
      if (hasTrackableCommentObject)
      {
        paramDataProcessor.startRecordField$505cff1c("trackableCommentObject");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label512;
        }
        localObject1 = trackableCommentObject.accept(paramDataProcessor);
        label275:
        if (localObject1 == null) {
          break label530;
        }
      }
    }
    label420:
    label429:
    label447:
    label456:
    label474:
    label484:
    label502:
    label512:
    label530:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (hasActionCategory)
      {
        paramDataProcessor.startRecordField$505cff1c("actionCategory");
        paramDataProcessor.processEnum(actionCategory);
      }
      if (hasControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("controlUrn");
        paramDataProcessor.processString(controlUrn);
      }
      if (hasActionType)
      {
        paramDataProcessor.startRecordField$505cff1c("actionType");
        paramDataProcessor.processString(actionType);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label727;
      }
      try
      {
        if (hasHeader) {
          break label536;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(trackableUpdateObject);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(trackableCommentObject);
      break label275;
    }
    label536:
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
    if (!hasActionType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent", "actionType");
    }
    return new FeedCommentActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (TrackingObject)localObject5, threadUrn, (TrackingObject)localObject1, actionCategory, controlUrn, actionType, bool1, bool2, bool3, bool4, hasThreadUrn, bool5, hasActionCategory, hasControlUrn, hasActionType);
    label727:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FeedCommentActionEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (trackableUpdateObject != null)
      {
        if (trackableUpdateObject.equals(trackableUpdateObject)) {}
      }
      else {
        while (trackableUpdateObject != null) {
          return false;
        }
      }
      if (threadUrn != null)
      {
        if (threadUrn.equals(threadUrn)) {}
      }
      else {
        while (threadUrn != null) {
          return false;
        }
      }
      if (trackableCommentObject != null)
      {
        if (trackableCommentObject.equals(trackableCommentObject)) {}
      }
      else {
        while (trackableCommentObject != null) {
          return false;
        }
      }
      if (actionCategory != null)
      {
        if (actionCategory.equals(actionCategory)) {}
      }
      else {
        while (actionCategory != null) {
          return false;
        }
      }
      if (controlUrn != null)
      {
        if (controlUrn.equals(controlUrn)) {}
      }
      else {
        while (controlUrn != null) {
          return false;
        }
      }
      if (actionType == null) {
        break;
      }
    } while (actionType.equals(actionType));
    for (;;)
    {
      return false;
      if (actionType == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label92:
    int i1;
    label108:
    int i2;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label220;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label225;
      }
      k = mobileHeader.hashCode();
      if (trackableUpdateObject == null) {
        break label230;
      }
      m = trackableUpdateObject.hashCode();
      if (threadUrn == null) {
        break label236;
      }
      n = threadUrn.hashCode();
      if (trackableCommentObject == null) {
        break label242;
      }
      i1 = trackableCommentObject.hashCode();
      if (actionCategory == null) {
        break label248;
      }
      i2 = actionCategory.hashCode();
      label124:
      if (controlUrn == null) {
        break label254;
      }
    }
    label220:
    label225:
    label230:
    label236:
    label242:
    label248:
    label254:
    for (int i3 = controlUrn.hashCode();; i3 = 0)
    {
      if (actionType != null) {
        i4 = actionType.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */