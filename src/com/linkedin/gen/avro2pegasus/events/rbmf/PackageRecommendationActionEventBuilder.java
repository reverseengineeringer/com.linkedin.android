package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PackageRecommendationActionEventBuilder
  implements DataTemplateBuilder<PackageRecommendationActionEvent>
{
  public static final PackageRecommendationActionEventBuilder INSTANCE = new PackageRecommendationActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("packageId");
    JSON_KEY_STORE.put("packageFlowPosition");
    JSON_KEY_STORE.put("controlUrn");
    JSON_KEY_STORE.put("recommendedEntity");
    JSON_KEY_STORE.put("actionName");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */