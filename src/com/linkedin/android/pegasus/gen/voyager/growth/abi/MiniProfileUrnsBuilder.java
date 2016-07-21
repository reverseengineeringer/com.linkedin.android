package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MiniProfileUrnsBuilder
  implements FissileDataModelBuilder<MiniProfileUrns>, DataTemplateBuilder<MiniProfileUrns>
{
  public static final MiniProfileUrnsBuilder INSTANCE = new MiniProfileUrnsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfileUrns");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrnsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */