package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MessageReceivedEventBuilder
  implements DataTemplateBuilder<MessageReceivedEvent>
{
  public static final MessageReceivedEventBuilder INSTANCE = new MessageReceivedEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("messageId");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("requestHeader");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageReceivedEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */