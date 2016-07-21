package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class CityBuilder
  implements FissileDataModelBuilder<City>, DataTemplateBuilder<City>
{
  public static final CityBuilder INSTANCE = new CityBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("cityName");
    JSON_KEY_STORE.put("cityCode");
    JSON_KEY_STORE.put("centralizedPostalCode");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.CityBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */