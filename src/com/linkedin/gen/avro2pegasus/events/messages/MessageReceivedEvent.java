package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class MessageReceivedEvent
  implements RecordTemplate<MessageReceivedEvent>
{
  public static final MessageReceivedEventBuilder BUILDER = MessageReceivedEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMessageId;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MessageId messageId;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  MessageReceivedEvent(EventHeader paramEventHeader, MessageId paramMessageId, MobileHeader paramMobileHeader, UserRequestHeader paramUserRequestHeader, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    header = paramEventHeader;
    messageId = paramMessageId;
    mobileHeader = paramMobileHeader;
    requestHeader = paramUserRequestHeader;
    hasHeader = paramBoolean1;
    hasMessageId = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasRequestHeader = paramBoolean4;
    _cachedId = null;
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
      paramObject = (MessageReceivedEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (messageId != null)
      {
        if (messageId.equals(messageId)) {}
      }
      else {
        while (messageId != null) {
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
      if (requestHeader == null) {
        break;
      }
    } while (requestHeader.equals(requestHeader));
    for (;;)
    {
      return false;
      if (requestHeader == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (header != null)
    {
      i = header.hashCode();
      if (messageId == null) {
        break label110;
      }
      j = messageId.hashCode();
      label45:
      if (mobileHeader == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = mobileHeader.hashCode();; k = 0)
    {
      if (requestHeader != null) {
        m = requestHeader.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageReceivedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */