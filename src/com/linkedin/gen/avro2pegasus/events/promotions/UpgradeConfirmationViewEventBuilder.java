package com.linkedin.gen.avro2pegasus.events.promotions;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class UpgradeConfirmationViewEventBuilder
  implements DataTemplateBuilder<UpgradeConfirmationViewEvent>
{
  public static final UpgradeConfirmationViewEventBuilder INSTANCE = new UpgradeConfirmationViewEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("phoneNumberInfo");
    JSON_KEY_STORE.put("productUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.promotions.UpgradeConfirmationViewEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */