package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class RecommendationBuilder
  implements FissileDataModelBuilder<Recommendation>, DataTemplateBuilder<Recommendation>
{
  public static final RecommendationBuilder INSTANCE = new RecommendationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("recommenderEntity");
    JSON_KEY_STORE.put("recommendeeEntity");
    JSON_KEY_STORE.put("relationship");
    JSON_KEY_STORE.put("recommendationText");
    JSON_KEY_STORE.put("status");
    JSON_KEY_STORE.put("created");
    JSON_KEY_STORE.put("lastModified");
    JSON_KEY_STORE.put("deleted");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("recommender");
    JSON_KEY_STORE.put("recommendee");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.RecommendationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */