package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class BasicLocationBuilder
  implements FissileDataModelBuilder<BasicLocation>, DataTemplateBuilder<BasicLocation>
{
  public static final BasicLocationBuilder INSTANCE = new BasicLocationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("countryCode");
    JSON_KEY_STORE.put("postalCode");
    JSON_KEY_STORE.put("countryName");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.BasicLocationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */