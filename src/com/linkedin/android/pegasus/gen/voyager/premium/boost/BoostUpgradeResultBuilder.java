package com.linkedin.android.pegasus.gen.voyager.premium.boost;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class BoostUpgradeResultBuilder
  implements FissileDataModelBuilder<BoostUpgradeResult>, DataTemplateBuilder<BoostUpgradeResult>
{
  public static final BoostUpgradeResultBuilder INSTANCE = new BoostUpgradeResultBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("upgradeFulfilled");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostUpgradeResultBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */