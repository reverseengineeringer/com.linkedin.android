package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PackageRecommendationImpressionEventBuilder
  implements DataTemplateBuilder<PackageRecommendationImpressionEvent>
{
  public static final PackageRecommendationImpressionEventBuilder INSTANCE = new PackageRecommendationImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("packages");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */