package com.linkedin.android.pegasus.gen.voyager.premium.boost;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class BoostEligibilityBuilder
  implements FissileDataModelBuilder<BoostEligibility>, DataTemplateBuilder<BoostEligibility>
{
  public static final BoostEligibilityBuilder INSTANCE = new BoostEligibilityBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("userEligible");
    JSON_KEY_STORE.put("promotionData");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostEligibilityBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */