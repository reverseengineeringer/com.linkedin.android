package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class MessageReceivedEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MessageReceivedEvent>
{
  private boolean hasHeader = false;
  public boolean hasMessageId = false;
  private boolean hasMobileHeader = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  public MessageId messageId = null;
  private MobileHeader mobileHeader = null;
  private UserRequestHeader requestHeader = null;
  
  private MessageReceivedEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MessageReceivedEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MessageReceivedEvent(header, messageId, mobileHeader, requestHeader, hasHeader, hasMessageId, hasMobileHeader, hasRequestHeader);
      if (!hasHeader) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messages.MessageReceivedEvent", "header");
      }
    } while (hasMessageId);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messages.MessageReceivedEvent", "messageId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageReceivedEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */