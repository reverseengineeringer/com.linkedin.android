package com.linkedin.gen.avro2pegasus.events.messaging;

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
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class StickerActionEvent
  implements RecordTemplate<StickerActionEvent>
{
  public static final StickerActionEventBuilder BUILDER = StickerActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final StickerAction actionCategory;
  public final TrackingObject conversation;
  public final boolean hasActionCategory;
  public final boolean hasConversation;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasSticker;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final StickerObject sticker;
  
  StickerActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject, StickerObject paramStickerObject, StickerAction paramStickerAction, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    conversation = paramTrackingObject;
    sticker = paramStickerObject;
    actionCategory = paramStickerAction;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasConversation = paramBoolean4;
    hasSticker = paramBoolean5;
    hasActionCategory = paramBoolean6;
    _cachedId = null;
  }
  
  private StickerActionEvent accept(DataProcessor paramDataProcessor)
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
          break label345;
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
          break label354;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label372;
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
          break label381;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label399;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasConversation)
      {
        paramDataProcessor.startRecordField$505cff1c("conversation");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label409;
        }
        localObject1 = conversation.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label427;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label210:
      localObject1 = null;
      bool5 = false;
      if (hasSticker)
      {
        paramDataProcessor.startRecordField$505cff1c("sticker");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label437;
        }
        localObject1 = sticker.accept(paramDataProcessor);
        label250:
        if (localObject1 == null) {
          break label455;
        }
      }
    }
    label345:
    label354:
    label372:
    label381:
    label399:
    label409:
    label427:
    label437:
    label455:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (hasActionCategory)
      {
        paramDataProcessor.startRecordField$505cff1c("actionCategory");
        paramDataProcessor.processEnum(actionCategory);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label571;
      }
      try
      {
        if (hasHeader) {
          break label461;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "header");
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
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(conversation);
      break label198;
      bool4 = false;
      localObject5 = localObject1;
      break label210;
      localObject1 = (StickerObject)paramDataProcessor.processDataTemplate(sticker);
      break label250;
    }
    label461:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "requestHeader");
    }
    if (!hasConversation) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "conversation");
    }
    if (!hasSticker) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "sticker");
    }
    if (!hasActionCategory) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "actionCategory");
    }
    return new StickerActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (TrackingObject)localObject5, (StickerObject)localObject1, actionCategory, bool1, bool2, bool3, bool4, bool5, hasActionCategory);
    label571:
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
      paramObject = (StickerActionEvent)paramObject;
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
      if (conversation != null)
      {
        if (conversation.equals(conversation)) {}
      }
      else {
        while (conversation != null) {
          return false;
        }
      }
      if (sticker != null)
      {
        if (sticker.equals(sticker)) {}
      }
      else {
        while (sticker != null) {
          return false;
        }
      }
      if (actionCategory == null) {
        break;
      }
    } while (actionCategory.equals(actionCategory));
    for (;;)
    {
      return false;
      if (actionCategory == null) {
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
      if (conversation == null) {
        break label164;
      }
      m = conversation.hashCode();
      label76:
      if (sticker == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = sticker.hashCode();; n = 0)
    {
      if (actionCategory != null) {
        i1 = actionCategory.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<StickerActionEvent>
  {
    public StickerAction actionCategory = null;
    public TrackingObject conversation = null;
    public boolean hasActionCategory = false;
    public boolean hasConversation = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasSticker = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public StickerObject sticker = null;
    
    private StickerActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (StickerActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new StickerActionEvent(header, requestHeader, mobileHeader, conversation, sticker, actionCategory, hasHeader, hasRequestHeader, hasMobileHeader, hasConversation, hasSticker, hasActionCategory);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "requestHeader");
        }
        if (!hasConversation) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "conversation");
        }
        if (!hasSticker) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "sticker");
        }
      } while (hasActionCategory);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent", "actionCategory");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */