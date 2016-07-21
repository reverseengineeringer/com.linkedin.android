package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MessageType;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class MessageActionEvent
  implements RecordTemplate<MessageActionEvent>
{
  public static final MessageActionEventBuilder BUILDER = MessageActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final actionType actionType;
  public final String clickParameters;
  public final boolean hasActionType;
  public final boolean hasClickParameters;
  public final boolean hasHeader;
  public final boolean hasMessageId;
  public final boolean hasMessageType;
  public final boolean hasMobileHeader;
  public final boolean hasPageTrackingCode;
  public final boolean hasRequestHeader;
  public final boolean hasSubchannels;
  public final boolean hasTag;
  public final EventHeader header;
  public final MessageId messageId;
  public final MessageType messageType;
  public final MobileHeader mobileHeader;
  public final String pageTrackingCode;
  public final UserRequestHeader requestHeader;
  public final Subchannels subchannels;
  public final String tag;
  
  MessageActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, actionType paramactionType, MessageId paramMessageId, MobileHeader paramMobileHeader, Subchannels paramSubchannels, String paramString1, String paramString2, String paramString3, MessageType paramMessageType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    actionType = paramactionType;
    messageId = paramMessageId;
    mobileHeader = paramMobileHeader;
    subchannels = paramSubchannels;
    tag = paramString1;
    clickParameters = paramString2;
    pageTrackingCode = paramString3;
    messageType = paramMessageType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasActionType = paramBoolean3;
    hasMessageId = paramBoolean4;
    hasMobileHeader = paramBoolean5;
    hasSubchannels = paramBoolean6;
    hasTag = paramBoolean7;
    hasClickParameters = paramBoolean8;
    hasPageTrackingCode = paramBoolean9;
    hasMessageType = paramBoolean10;
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
      paramObject = (MessageActionEvent)paramObject;
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
      if (actionType != null)
      {
        if (actionType.equals(actionType)) {}
      }
      else {
        while (actionType != null) {
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
      if (subchannels != null)
      {
        if (subchannels.equals(subchannels)) {}
      }
      else {
        while (subchannels != null) {
          return false;
        }
      }
      if (tag != null)
      {
        if (tag.equals(tag)) {}
      }
      else {
        while (tag != null) {
          return false;
        }
      }
      if (clickParameters != null)
      {
        if (clickParameters.equals(clickParameters)) {}
      }
      else {
        while (clickParameters != null) {
          return false;
        }
      }
      if (pageTrackingCode != null)
      {
        if (pageTrackingCode.equals(pageTrackingCode)) {}
      }
      else {
        while (pageTrackingCode != null) {
          return false;
        }
      }
      if (messageType == null) {
        break;
      }
    } while (messageType.equals(messageType));
    for (;;)
    {
      return false;
      if (messageType == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i5 = 0;
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
    label92:
    int i1;
    label108:
    int i2;
    label124:
    int i3;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label242;
      }
      j = requestHeader.hashCode();
      if (actionType == null) {
        break label247;
      }
      k = actionType.hashCode();
      if (messageId == null) {
        break label252;
      }
      m = messageId.hashCode();
      if (mobileHeader == null) {
        break label258;
      }
      n = mobileHeader.hashCode();
      if (subchannels == null) {
        break label264;
      }
      i1 = subchannels.hashCode();
      if (tag == null) {
        break label270;
      }
      i2 = tag.hashCode();
      if (clickParameters == null) {
        break label276;
      }
      i3 = clickParameters.hashCode();
      label140:
      if (pageTrackingCode == null) {
        break label282;
      }
    }
    label242:
    label247:
    label252:
    label258:
    label264:
    label270:
    label276:
    label282:
    for (int i4 = pageTrackingCode.hashCode();; i4 = 0)
    {
      if (messageType != null) {
        i5 = messageType.hashCode();
      }
      i = (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i5;
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
      break label92;
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
      i3 = 0;
      break label140;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */