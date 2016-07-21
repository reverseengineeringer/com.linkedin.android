package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ConversationDetailActionEvent
  implements RecordTemplate<ConversationDetailActionEvent>
{
  public static final ConversationDetailActionEventBuilder BUILDER = ConversationDetailActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ConversationActionType actionType;
  public final String controlUrn;
  public final TrackingObject conversation;
  public final boolean hasActionType;
  public final boolean hasControlUrn;
  public final boolean hasConversation;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasParticipantUrns;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final List<String> participantUrns;
  public final UserRequestHeader requestHeader;
  
  ConversationDetailActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject, List<String> paramList, ConversationActionType paramConversationActionType, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    conversation = paramTrackingObject;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      participantUrns = paramEventHeader;
      actionType = paramConversationActionType;
      controlUrn = paramString;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasConversation = paramBoolean4;
      hasParticipantUrns = paramBoolean5;
      hasActionType = paramBoolean6;
      hasControlUrn = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  private ConversationDetailActionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    Object localObject4;
    boolean bool3;
    label148:
    label160:
    boolean bool4;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label364;
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
          break label373;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label391;
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
          break label401;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label419;
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
          break label429;
        }
        localObject1 = conversation.accept(paramDataProcessor);
        label200:
        if (localObject1 == null) {
          break label447;
        }
        bool4 = true;
      }
    }
    for (Object localObject5 = localObject1;; localObject5 = localObject1)
    {
      localObject1 = null;
      Iterator localIterator = null;
      bool5 = false;
      if (!hasParticipantUrns) {
        break label471;
      }
      paramDataProcessor.startRecordField$505cff1c("participantUrns");
      participantUrns.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localIterator = participantUrns.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label364:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label373:
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      label391:
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      label401:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      label419:
      bool3 = false;
      localObject4 = localObject1;
      break label160;
      label429:
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(conversation);
      break label200;
      label447:
      bool4 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label471:
      if (hasActionType)
      {
        paramDataProcessor.startRecordField$505cff1c("actionType");
        paramDataProcessor.processEnum(actionType);
      }
      if (hasControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("controlUrn");
        paramDataProcessor.processString(controlUrn);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label740;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "requestHeader");
    }
    if (!hasConversation) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "conversation");
    }
    if (!hasActionType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "actionType");
    }
    if (!hasControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "controlUrn");
    }
    if (participantUrns != null)
    {
      paramDataProcessor = participantUrns.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "participantUrns");
        }
      }
    }
    return new ConversationDetailActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (TrackingObject)localObject5, (List)localObject1, actionType, controlUrn, bool1, bool2, bool3, bool4, bool5, hasActionType, hasControlUrn);
    label740:
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
      paramObject = (ConversationDetailActionEvent)paramObject;
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
      if (participantUrns != null)
      {
        if (participantUrns.equals(participantUrns)) {}
      }
      else {
        while (participantUrns != null) {
          return false;
        }
      }
      if (actionType != null)
      {
        if (actionType.equals(actionType)) {}
      }
      else {
        while (actionType != null) {
          return false;
        }
      }
      if (controlUrn == null) {
        break;
      }
    } while (controlUrn.equals(controlUrn));
    for (;;)
    {
      return false;
      if (controlUrn == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
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
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label178;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label183;
      }
      k = mobileHeader.hashCode();
      if (conversation == null) {
        break label188;
      }
      m = conversation.hashCode();
      if (participantUrns == null) {
        break label194;
      }
      n = participantUrns.hashCode();
      label94:
      if (actionType == null) {
        break label200;
      }
    }
    label178:
    label183:
    label188:
    label194:
    label200:
    for (int i1 = actionType.hashCode();; i1 = 0)
    {
      if (controlUrn != null) {
        i2 = controlUrn.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
      break label94;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<ConversationDetailActionEvent>
  {
    public ConversationActionType actionType = null;
    public String controlUrn = null;
    public TrackingObject conversation = null;
    public boolean hasActionType = false;
    public boolean hasControlUrn = false;
    public boolean hasConversation = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasParticipantUrns = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public List<String> participantUrns = null;
    private UserRequestHeader requestHeader = null;
    
    private ConversationDetailActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ConversationDetailActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (participantUrns != null)
      {
        paramFlavor = participantUrns.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "participantUrns");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "requestHeader");
              }
              if (!hasConversation) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "conversation");
              }
              if (!hasActionType) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "actionType");
              }
              if (hasControlUrn) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent", "controlUrn");
            }
          }
        }
      }
      return new ConversationDetailActionEvent(header, requestHeader, mobileHeader, conversation, participantUrns, actionType, controlUrn, hasHeader, hasRequestHeader, hasMobileHeader, hasConversation, hasParticipantUrns, hasActionType, hasControlUrn);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */