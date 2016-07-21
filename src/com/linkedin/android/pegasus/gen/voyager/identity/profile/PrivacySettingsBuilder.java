package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PrivacySettingsBuilder
  implements FissileDataModelBuilder<PrivacySettings>, DataTemplateBuilder<PrivacySettings>
{
  public static final PrivacySettingsBuilder INSTANCE = new PrivacySettingsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("showPremiumSubscriberBadge");
    JSON_KEY_STORE.put("allowOpenProfile");
    JSON_KEY_STORE.put("profilePictureVisibilitySetting");
    JSON_KEY_STORE.put("allowProfileEditBroadcasts");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettingsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */