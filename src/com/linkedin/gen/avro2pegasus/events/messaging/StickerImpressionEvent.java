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

public final class StickerImpressionEvent
  implements RecordTemplate<StickerImpressionEvent>
{
  public static final StickerImpressionEventBuilder BUILDER = StickerImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final TrackingObject conversation;
  public final boolean hasConversation;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasSticker;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final StickerObject sticker;
  
  StickerImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject, StickerObject paramStickerObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    conversation = paramTrackingObject;
    sticker = paramStickerObject;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasConversation = paramBoolean4;
    hasSticker = paramBoolean5;
    _cachedId = null;
  }
  
  private StickerImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label320;
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
          break label329;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label347;
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
          break label356;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label374;
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
          break label384;
        }
        localObject1 = conversation.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label402;
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
          break label412;
        }
        localObject1 = sticker.accept(paramDataProcessor);
        label250:
        if (localObject1 == null) {
          break label430;
        }
      }
    }
    label320:
    label329:
    label347:
    label356:
    label374:
    label384:
    label402:
    label412:
    label430:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label519;
      }
      try
      {
        if (hasHeader) {
          break label436;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "header");
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
    label436:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "requestHeader");
    }
    if (!hasConversation) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "conversation");
    }
    if (!hasSticker) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "sticker");
    }
    return new StickerImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (TrackingObject)localObject5, (StickerObject)localObject1, bool1, bool2, bool3, bool4, bool5);
    label519:
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
      paramObject = (StickerImpressionEvent)paramObject;
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
      if (sticker == null) {
        break;
      }
    } while (sticker.equals(sticker));
    for (;;)
    {
      return false;
      if (sticker == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label132;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label137;
      }
      k = mobileHeader.hashCode();
      label60:
      if (conversation == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = conversation.hashCode();; m = 0)
    {
      if (sticker != null) {
        n = sticker.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<StickerImpressionEvent>
  {
    public TrackingObject conversation = null;
    public boolean hasConversation = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasSticker = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public StickerObject sticker = null;
    
    private StickerImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (StickerImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new StickerImpressionEvent(header, requestHeader, mobileHeader, conversation, sticker, hasHeader, hasRequestHeader, hasMobileHeader, hasConversation, hasSticker);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "requestHeader");
        }
        if (!hasConversation) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "conversation");
        }
      } while (hasSticker);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent", "sticker");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.StickerImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */