package com.linkedin.android.pegasus.gen.actionresponse;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class BooleanActionResponseBuilder
  implements FissileDataModelBuilder<BooleanActionResponse>, DataTemplateBuilder<BooleanActionResponse>
{
  public static final BooleanActionResponseBuilder INSTANCE = new BooleanActionResponseBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("value");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.actionresponse.BooleanActionResponseBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */