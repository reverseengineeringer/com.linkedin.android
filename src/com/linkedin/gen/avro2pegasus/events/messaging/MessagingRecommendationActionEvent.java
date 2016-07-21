package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class MessagingRecommendationActionEvent
  implements RecordTemplate<MessagingRecommendationActionEvent>
{
  public static final MessagingRecommendationActionEventBuilder BUILDER = MessagingRecommendationActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final MessagingRecommendationActionType actionCategory;
  public final String controlUrn;
  public final boolean hasActionCategory;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRecommendationTrackingId;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final String recommendationTrackingId;
  public final UserRequestHeader requestHeader;
  
  MessagingRecommendationActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, MessagingRecommendationActionType paramMessagingRecommendationActionType, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    actionCategory = paramMessagingRecommendationActionType;
    controlUrn = paramString1;
    recommendationTrackingId = paramString2;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasActionCategory = paramBoolean4;
    hasControlUrn = paramBoolean5;
    hasRecommendationTrackingId = paramBoolean6;
    _cachedId = null;
  }
  
  private MessagingRecommendationActionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label299;
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
          break label308;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label326;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label335;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label353;
        }
      }
    }
    label299:
    label308:
    label326:
    label335:
    label353:
    for (boolean bool3 = true;; bool3 = false)
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
      if (hasRecommendationTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("recommendationTrackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(recommendationTrackingId));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label477;
      }
      try
      {
        if (hasHeader) {
          break label359;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "header");
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
    }
    label359:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "requestHeader");
    }
    if (!hasActionCategory) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "actionCategory");
    }
    if (!hasControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "controlUrn");
    }
    if (!hasRecommendationTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "recommendationTrackingId");
    }
    return new MessagingRecommendationActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, actionCategory, controlUrn, recommendationTrackingId, bool1, bool2, bool3, hasActionCategory, hasControlUrn, hasRecommendationTrackingId);
    label477:
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
      paramObject = (MessagingRecommendationActionEvent)paramObject;
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
      if (recommendationTrackingId == null) {
        break;
      }
    } while (recommendationTrackingId.equals(recommendationTrackingId));
    for (;;)
    {
      return false;
      if (recommendationTrackingId == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label154;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label159;
      }
      k = mobileHeader.hashCode();
      if (actionCategory == null) {
        break label164;
      }
      m = actionCategory.hashCode();
      label76:
      if (controlUrn == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = controlUrn.hashCode();; n = 0)
    {
      if (recommendationTrackingId != null) {
        i1 = recommendationTrackingId.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
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
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<MessagingRecommendationActionEvent>
  {
    public MessagingRecommendationActionType actionCategory = null;
    public String controlUrn = null;
    public boolean hasActionCategory = false;
    public boolean hasControlUrn = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasRecommendationTrackingId = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public String recommendationTrackingId = null;
    private UserRequestHeader requestHeader = null;
    
    private MessagingRecommendationActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MessagingRecommendationActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new MessagingRecommendationActionEvent(header, requestHeader, mobileHeader, actionCategory, controlUrn, recommendationTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasActionCategory, hasControlUrn, hasRecommendationTrackingId);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "requestHeader");
        }
        if (!hasActionCategory) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "actionCategory");
        }
        if (!hasControlUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "controlUrn");
        }
      } while (hasRecommendationTrackingId);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent", "recommendationTrackingId");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */