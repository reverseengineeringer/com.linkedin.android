package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NormPublicationBuilder
  implements FissileDataModelBuilder<NormPublication>, DataTemplateBuilder<NormPublication>
{
  public static final NormPublicationBuilder INSTANCE = new NormPublicationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("publisher");
    JSON_KEY_STORE.put("date");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("authors");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublicationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */