package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class RecommendedPackageBuilder
  implements FissileDataModelBuilder<RecommendedPackage>, DataTemplateBuilder<RecommendedPackage>
{
  public static final RecommendedPackageBuilder INSTANCE = new RecommendedPackageBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("packageId");
    JSON_KEY_STORE.put("recommendationType");
    JSON_KEY_STORE.put("reason");
    JSON_KEY_STORE.put("secondaryReason");
    JSON_KEY_STORE.put("recommendedEntities");
    JSON_KEY_STORE.put("entityUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackageBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */