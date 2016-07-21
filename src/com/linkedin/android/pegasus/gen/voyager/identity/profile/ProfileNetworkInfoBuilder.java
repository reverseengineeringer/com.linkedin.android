package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ProfileNetworkInfoBuilder
  implements FissileDataModelBuilder<ProfileNetworkInfo>, DataTemplateBuilder<ProfileNetworkInfo>
{
  public static final ProfileNetworkInfoBuilder INSTANCE = new ProfileNetworkInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("distance");
    JSON_KEY_STORE.put("connectionsCount");
    JSON_KEY_STORE.put("followingInfo");
    JSON_KEY_STORE.put("followersCount");
    JSON_KEY_STORE.put("following");
    JSON_KEY_STORE.put("followable");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */