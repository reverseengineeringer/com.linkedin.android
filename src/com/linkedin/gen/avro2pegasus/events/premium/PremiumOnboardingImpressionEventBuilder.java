package com.linkedin.gen.avro2pegasus.events.premium;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PremiumOnboardingImpressionEventBuilder
  implements DataTemplateBuilder<PremiumOnboardingImpressionEvent>
{
  public static final PremiumOnboardingImpressionEventBuilder INSTANCE = new PremiumOnboardingImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("chooserSessionStartPageInstance");
    JSON_KEY_STORE.put("subsFamily");
    JSON_KEY_STORE.put("orderUrn");
    JSON_KEY_STORE.put("receiptUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.premium.PremiumOnboardingImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */