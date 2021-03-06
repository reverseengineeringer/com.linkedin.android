package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ConfigurationBuilder
  implements FissileDataModelBuilder<Configuration>, DataTemplateBuilder<Configuration>
{
  public static final ConfigurationBuilder INSTANCE = new ConfigurationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("mediaConfig");
    JSON_KEY_STORE.put("launchAlert");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.ConfigurationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */