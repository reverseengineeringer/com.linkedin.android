package com.linkedin.gen.avro2pegasus.events.mobilesdk;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ThirdPartyMobileSdkProfileViewEventBuilder
  implements DataTemplateBuilder<ThirdPartyMobileSdkProfileViewEvent>
{
  public static final ThirdPartyMobileSdkProfileViewEventBuilder INSTANCE = new ThirdPartyMobileSdkProfileViewEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("thirdPartyApplicationIdentifier");
    JSON_KEY_STORE.put("viewee");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkProfileViewEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */