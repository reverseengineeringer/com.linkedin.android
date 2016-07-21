package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class VersionTagBuilder
  implements FissileDataModelBuilder<VersionTag>, DataTemplateBuilder<VersionTag>
{
  public static final VersionTagBuilder INSTANCE = new VersionTagBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("versionTag");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.VersionTagBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */