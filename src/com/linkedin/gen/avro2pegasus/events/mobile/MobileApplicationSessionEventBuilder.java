package com.linkedin.gen.avro2pegasus.events.mobile;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MobileApplicationSessionEventBuilder
  implements DataTemplateBuilder<MobileApplicationSessionEvent>
{
  public static final MobileApplicationSessionEventBuilder INSTANCE = new MobileApplicationSessionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("applicationBuildType");
    JSON_KEY_STORE.put("mobileApplicationName");
    JSON_KEY_STORE.put("buildNumber");
    JSON_KEY_STORE.put("applicationStateChangeType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationSessionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */