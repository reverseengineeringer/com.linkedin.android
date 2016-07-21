package com.linkedin.gen.avro2pegasus.events.badge;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class BadgeUpdateReceivedEventBuilder
  implements DataTemplateBuilder<BadgeUpdateReceivedEvent>
{
  public static final BadgeUpdateReceivedEventBuilder INSTANCE = new BadgeUpdateReceivedEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("isFirstUpdate");
    JSON_KEY_STORE.put("updateType");
    JSON_KEY_STORE.put("existingTabBadgeDetails");
    JSON_KEY_STORE.put("existingAppBadgeCount");
    JSON_KEY_STORE.put("newTabBadgeDetails");
    JSON_KEY_STORE.put("newAppBadgeCount");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */