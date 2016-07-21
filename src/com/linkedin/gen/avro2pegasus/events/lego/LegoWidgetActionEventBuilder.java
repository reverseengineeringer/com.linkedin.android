package com.linkedin.gen.avro2pegasus.events.lego;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class LegoWidgetActionEventBuilder
  implements DataTemplateBuilder<LegoWidgetActionEvent>
{
  public static final LegoWidgetActionEventBuilder INSTANCE = new LegoWidgetActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("trackingToken");
    JSON_KEY_STORE.put("widgetTrackingId");
    JSON_KEY_STORE.put("actionCategory");
    JSON_KEY_STORE.put("actionName");
    JSON_KEY_STORE.put("actionCount");
    JSON_KEY_STORE.put("isSyncTrack");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */