package com.linkedin.android.pegasus.gen.voyager.growth.seo;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SameNameProfileResultBuilder
  implements FissileDataModelBuilder<SameNameProfileResult>, DataTemplateBuilder<SameNameProfileResult>
{
  public static final SameNameProfileResultBuilder INSTANCE = new SameNameProfileResultBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("education");
    JSON_KEY_STORE.put("industry");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("miniProfile");
    JSON_KEY_STORE.put("currentPositions");
    JSON_KEY_STORE.put("pastPositions");
    JSON_KEY_STORE.put("summary");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.seo.SameNameProfileResultBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */