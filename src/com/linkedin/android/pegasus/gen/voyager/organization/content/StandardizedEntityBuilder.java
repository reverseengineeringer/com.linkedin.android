package com.linkedin.android.pegasus.gen.voyager.organization.content;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class StandardizedEntityBuilder
  implements FissileDataModelBuilder<StandardizedEntity>, DataTemplateBuilder<StandardizedEntity>
{
  public static final StandardizedEntityBuilder INSTANCE = new StandardizedEntityBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("urn");
    JSON_KEY_STORE.put("localizedName");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.organization.content.StandardizedEntityBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */