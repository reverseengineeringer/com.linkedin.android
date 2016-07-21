package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MemberBadgesBuilder
  implements FissileDataModelBuilder<MemberBadges>, DataTemplateBuilder<MemberBadges>
{
  public static final MemberBadgesBuilder INSTANCE = new MemberBadgesBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("influencer");
    JSON_KEY_STORE.put("jobSeeker");
    JSON_KEY_STORE.put("premium");
    JSON_KEY_STORE.put("openLink");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadgesBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */