package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SubscriptionCartBuilder
  implements FissileDataModelBuilder<SubscriptionCart>, DataTemplateBuilder<SubscriptionCart>
{
  public static final SubscriptionCartBuilder INSTANCE = new SubscriptionCartBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("cartId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.SubscriptionCartBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */