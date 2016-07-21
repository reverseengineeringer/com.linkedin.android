package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MessageActionEventBuilder
  implements DataTemplateBuilder<MessageActionEvent>
{
  public static final MessageActionEventBuilder INSTANCE = new MessageActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("actionType");
    JSON_KEY_STORE.put("messageId");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("subchannels");
    JSON_KEY_STORE.put("tag");
    JSON_KEY_STORE.put("clickParameters");
    JSON_KEY_STORE.put("pageTrackingCode");
    JSON_KEY_STORE.put("messageType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */