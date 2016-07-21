package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class LixTreatmentBuilder
  implements FissileDataModelBuilder<LixTreatment>, DataTemplateBuilder<LixTreatment>
{
  public static final LixTreatmentBuilder INSTANCE = new LixTreatmentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("testKey");
    JSON_KEY_STORE.put("treatment");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.LixTreatmentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */