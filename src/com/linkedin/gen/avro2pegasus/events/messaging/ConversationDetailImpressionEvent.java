package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
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

public final class ConversationDetailImpressionEvent
  implements RecordTemplate<ConversationDetailImpressionEvent>
{
  public static final ConversationDetailImpressionEventBuilder BUILDER = ConversationDetailImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final TrackingObject conversation;
  public final boolean hasConversation;
  public final boolean hasHeader;
  public final boolean hasMessages;
  public final boolean hasMobileHeader;
  public final boolean hasParticipantUrns;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final List<TrackingObject> messages;
  public final MobileHeader mobileHeader;
  public final List<String> participantUrns;
  public final UserRequestHeader requestHeader;
  
  ConversationDetailImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject, List<String> paramList, List<TrackingObject> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    conversation = paramTrackingObject;
    if (paramList == null)
    {
      paramEventHeader = null;
      participantUrns = paramEventHeader;
      if (paramList1 != null) {
        break label105;
      }
    }
    label105:
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList1))
    {
      messages = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasConversation = paramBoolean4;
      hasParticipantUrns = paramBoolean5;
      hasMessages = paramBoolean6;
      _cachedId = null;
      return;
      paramEventHeader = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  private ConversationDetailImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label360;
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
          break label369;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label387;
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
          break label397;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label415;
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
          break label425;
        }
        localObject1 = conversation.accept(paramDataProcessor);
        label200:
        if (localObject1 == null) {
          break label443;
        }
        bool4 = true;
      }
    }
    Object localObject6;
    boolean bool5;
    int i;
    for (Object localObject5 = localObject1;; localObject5 = localObject1)
    {
      localObject6 = null;
      localObject1 = null;
      bool5 = false;
      if (!hasParticipantUrns) {
        break label471;
      }
      paramDataProcessor.startRecordField$505cff1c("participantUrns");
      participantUrns.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject6 = participantUrns.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (String)((Iterator)localObject6).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject7);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject7);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label360:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label369:
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      label387:
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      label397:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      label415:
      bool3 = false;
      localObject4 = localObject1;
      break label160;
      label425:
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(conversation);
      break label200;
      label443:
      bool4 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool5 = true;
      localObject6 = localObject1;
      label471:
      localObject1 = null;
      localObject7 = null;
      bool6 = false;
      if (!hasMessages) {
        break label659;
      }
      paramDataProcessor.startRecordField$505cff1c("messages");
      messages.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject7;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = messages.iterator();
      label546:
      if (!localIterator.hasNext()) {
        break label645;
      }
      localObject7 = (TrackingObject)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label629;
      }
    }
    label629:
    for (Object localObject7 = ((TrackingObject)localObject7).accept(paramDataProcessor);; localObject7 = (TrackingObject)paramDataProcessor.processDataTemplate((DataTemplate)localObject7))
    {
      if ((localObject1 != null) && (localObject7 != null)) {
        ((List)localObject1).add(localObject7);
      }
      i += 1;
      break label546;
      bool5 = false;
      localObject6 = localObject1;
      break;
    }
    label645:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool6 = true;; bool6 = false)
    {
      label659:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label878;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "requestHeader");
    }
    if (!hasConversation) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "conversation");
    }
    if (participantUrns != null)
    {
      paramDataProcessor = participantUrns.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "participantUrns");
        }
      }
    }
    if (messages != null)
    {
      paramDataProcessor = messages.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((TrackingObject)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "messages");
        }
      }
    }
    return new ConversationDetailImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (TrackingObject)localObject5, (List)localObject6, (List)localObject1, bool1, bool2, bool3, bool4, bool5, bool6);
    label878:
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
      paramObject = (ConversationDetailImpressionEvent)paramObject;
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
      if (messages == null) {
        break;
      }
    } while (messages.equals(messages));
    for (;;)
    {
      return false;
      if (messages == null) {
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
        break label158;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label163;
      }
      k = mobileHeader.hashCode();
      if (conversation == null) {
        break label168;
      }
      m = conversation.hashCode();
      label76:
      if (participantUrns == null) {
        break label174;
      }
    }
    label158:
    label163:
    label168:
    label174:
    for (int n = participantUrns.hashCode();; n = 0)
    {
      if (messages != null) {
        i1 = messages.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<ConversationDetailImpressionEvent>
  {
    public TrackingObject conversation = null;
    public boolean hasConversation = false;
    private boolean hasHeader = false;
    public boolean hasMessages = false;
    private boolean hasMobileHeader = false;
    public boolean hasParticipantUrns = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    public List<TrackingObject> messages = null;
    private MobileHeader mobileHeader = null;
    public List<String> participantUrns = null;
    private UserRequestHeader requestHeader = null;
    
    private ConversationDetailImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ConversationDetailImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
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
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "participantUrns");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "requestHeader");
              }
              if (hasConversation) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "conversation");
            }
          }
        }
      }
      if (messages != null)
      {
        paramFlavor = messages.iterator();
        while (paramFlavor.hasNext()) {
          if ((TrackingObject)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent", "messages");
          }
        }
      }
      return new ConversationDetailImpressionEvent(header, requestHeader, mobileHeader, conversation, participantUrns, messages, hasHeader, hasRequestHeader, hasMobileHeader, hasConversation, hasParticipantUrns, hasMessages);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */