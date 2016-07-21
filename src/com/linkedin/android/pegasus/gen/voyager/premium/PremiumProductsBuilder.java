package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PremiumProductsBuilder
  implements FissileDataModelBuilder<PremiumProducts>, DataTemplateBuilder<PremiumProducts>
{
  public static final PremiumProductsBuilder INSTANCE = new PremiumProductsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("footer");
    JSON_KEY_STORE.put("products");
    JSON_KEY_STORE.put("warningText");
    JSON_KEY_STORE.put("recommendedProductIndex");
    JSON_KEY_STORE.put("promotionOffered");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */