package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.Iterator;
import java.util.List;

public final class ConversationDetailImpressionEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */