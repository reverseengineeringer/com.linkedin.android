package com.linkedin.gen.avro2pegasus.events.badge;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class BadgeInteractionActionEventBuilder
  implements DataTemplateBuilder<BadgeInteractionActionEvent>
{
  public static final BadgeInteractionActionEventBuilder INSTANCE = new BadgeInteractionActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("badgeTabCleared");
    JSON_KEY_STORE.put("controlUrn");
    JSON_KEY_STORE.put("interactionType");
    JSON_KEY_STORE.put("tabBadgeDetails");
    JSON_KEY_STORE.put("appBadgeCount");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */