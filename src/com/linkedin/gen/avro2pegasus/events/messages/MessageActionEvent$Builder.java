package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MessageType;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class MessageActionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MessageActionEvent>
{
  private actionType actionType = null;
  private String clickParameters = null;
  private boolean hasActionType = false;
  private boolean hasClickParameters = false;
  private boolean hasHeader = false;
  private boolean hasMessageId = false;
  private boolean hasMessageType = false;
  private boolean hasMobileHeader = false;
  private boolean hasPageTrackingCode = false;
  private boolean hasRequestHeader = false;
  private boolean hasSubchannels = false;
  private boolean hasTag = false;
  private EventHeader header = null;
  private MessageId messageId = null;
  private MessageType messageType = null;
  private MobileHeader mobileHeader = null;
  private String pageTrackingCode = null;
  private UserRequestHeader requestHeader = null;
  private Subchannels subchannels = null;
  private String tag = null;
  
  private MessageActionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MessageActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MessageActionEvent(header, requestHeader, actionType, messageId, mobileHeader, subchannels, tag, clickParameters, pageTrackingCode, messageType, hasHeader, hasRequestHeader, hasActionType, hasMessageId, hasMobileHeader, hasSubchannels, hasTag, hasClickParameters, hasPageTrackingCode, hasMessageType);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messages.MessageActionEvent", "header");
      }
      if (!hasActionType) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messages.MessageActionEvent", "actionType");
      }
    } while (hasMessageId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messages.MessageActionEvent", "messageId");
  }
  
  public final Builder setActionType(actionType paramactionType)
  {
    if (paramactionType == null)
    {
      hasActionType = false;
      actionType = null;
      return this;
    }
    hasActionType = true;
    actionType = paramactionType;
    return this;
  }
  
  public final Builder setMessageId(MessageId paramMessageId)
  {
    if (paramMessageId == null)
    {
      hasMessageId = false;
      messageId = null;
      return this;
    }
    hasMessageId = true;
    messageId = paramMessageId;
    return this;
  }
  
  public final Builder setMessageType(MessageType paramMessageType)
  {
    if (paramMessageType == null)
    {
      hasMessageType = false;
      messageType = null;
      return this;
    }
    hasMessageType = true;
    messageType = paramMessageType;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageActionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */