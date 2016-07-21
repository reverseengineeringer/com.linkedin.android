package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NormEndorsementBuilder
  implements FissileDataModelBuilder<NormEndorsement>, DataTemplateBuilder<NormEndorsement>
{
  public static final NormEndorsementBuilder INSTANCE = new NormEndorsementBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("skill");
    JSON_KEY_STORE.put("endorserUrn");
    JSON_KEY_STORE.put("endorseeUrn");
    JSON_KEY_STORE.put("status");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsementBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */