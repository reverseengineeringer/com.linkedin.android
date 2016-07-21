package com.linkedin.gen.avro2pegasus.events.prop;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PropActionEventBuilder
  implements DataTemplateBuilder<PropActionEvent>
{
  public static final PropActionEventBuilder INSTANCE = new PropActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("moduleKey");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("propUrn");
    JSON_KEY_STORE.put("actionCategory");
    JSON_KEY_STORE.put("controlUrn");
    JSON_KEY_STORE.put("actionType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.prop.PropActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */