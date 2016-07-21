package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class StickerActionEventBuilder
  implements DataTemplateBuilder<StickerActionEvent>
{
  public static final StickerActionEventBuilder INSTANCE = new StickerActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("conversation");
    JSON_KEY_STORE.put("sticker");
    JSON_KEY_STORE.put("actionCategory");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.StickerActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */