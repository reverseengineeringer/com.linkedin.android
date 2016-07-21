package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ProfileContactInfoBuilder
  implements FissileDataModelBuilder<ProfileContactInfo>, DataTemplateBuilder<ProfileContactInfo>
{
  public static final ProfileContactInfoBuilder INSTANCE = new ProfileContactInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("weChatContactInfo");
    JSON_KEY_STORE.put("phoneNumbers");
    JSON_KEY_STORE.put("websites");
    JSON_KEY_STORE.put("twitterHandles");
    JSON_KEY_STORE.put("ims");
    JSON_KEY_STORE.put("emailAddress");
    JSON_KEY_STORE.put("address");
    JSON_KEY_STORE.put("birthDateOn");
    JSON_KEY_STORE.put("birthdayVisibilitySetting");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */