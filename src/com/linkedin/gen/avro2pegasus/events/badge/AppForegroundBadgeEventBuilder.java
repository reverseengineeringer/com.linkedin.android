package com.linkedin.gen.avro2pegasus.events.badge;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class AppForegroundBadgeEventBuilder
  implements DataTemplateBuilder<AppForegroundBadgeEvent>
{
  public static final AppForegroundBadgeEventBuilder INSTANCE = new AppForegroundBadgeEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("appBadgeCount");
    JSON_KEY_STORE.put("actionSource");
    JSON_KEY_STORE.put("landingTab");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */