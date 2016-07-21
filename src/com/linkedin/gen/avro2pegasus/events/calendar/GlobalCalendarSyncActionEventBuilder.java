package com.linkedin.gen.avro2pegasus.events.calendar;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class GlobalCalendarSyncActionEventBuilder
  implements DataTemplateBuilder<GlobalCalendarSyncActionEvent>
{
  public static final GlobalCalendarSyncActionEventBuilder INSTANCE = new GlobalCalendarSyncActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("isSyncEnabled");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */