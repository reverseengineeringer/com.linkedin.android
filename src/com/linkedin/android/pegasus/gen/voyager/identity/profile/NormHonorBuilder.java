package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NormHonorBuilder
  implements FissileDataModelBuilder<NormHonor>, DataTemplateBuilder<NormHonor>
{
  public static final NormHonorBuilder INSTANCE = new NormHonorBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("issueDate");
    JSON_KEY_STORE.put("issuer");
    JSON_KEY_STORE.put("occupation");
    JSON_KEY_STORE.put("description");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormHonorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */