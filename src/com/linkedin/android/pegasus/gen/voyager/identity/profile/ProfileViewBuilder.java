package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ProfileViewBuilder
  implements FissileDataModelBuilder<ProfileView>, DataTemplateBuilder<ProfileView>
{
  public static final ProfileViewBuilder INSTANCE = new ProfileViewBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("profile");
    JSON_KEY_STORE.put("primaryLocale");
    JSON_KEY_STORE.put("positionView");
    JSON_KEY_STORE.put("educationView");
    JSON_KEY_STORE.put("certificationView");
    JSON_KEY_STORE.put("courseView");
    JSON_KEY_STORE.put("honorView");
    JSON_KEY_STORE.put("languageView");
    JSON_KEY_STORE.put("organizationView");
    JSON_KEY_STORE.put("patentView");
    JSON_KEY_STORE.put("projectView");
    JSON_KEY_STORE.put("publicationView");
    JSON_KEY_STORE.put("skillView");
    JSON_KEY_STORE.put("testScoreView");
    JSON_KEY_STORE.put("volunteerExperienceView");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileViewBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */