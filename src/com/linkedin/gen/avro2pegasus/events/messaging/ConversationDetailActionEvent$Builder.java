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

public final class ConversationDetailActionEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.ConversationDetailActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */