package com.linkedin.gen.avro2pegasus.events.premium;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PremiumChooserImpressionEventBuilder
  implements DataTemplateBuilder<PremiumChooserImpressionEvent>
{
  public static final PremiumChooserImpressionEventBuilder INSTANCE = new PremiumChooserImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("productUrn");
    JSON_KEY_STORE.put("priceUrns");
    JSON_KEY_STORE.put("channel");
    JSON_KEY_STORE.put("subsFamily");
    JSON_KEY_STORE.put("productPosition");
    JSON_KEY_STORE.put("productCount");
    JSON_KEY_STORE.put("chooserSessionStartPageInstance");
    JSON_KEY_STORE.put("upsellControlUrn");
    JSON_KEY_STORE.put("campaignUrn");
    JSON_KEY_STORE.put("contextUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumChooserImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */