package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ProfileActionsBuilder
  implements FissileDataModelBuilder<ProfileActions>, DataTemplateBuilder<ProfileActions>
{
  public static final ProfileActionsBuilder INSTANCE = new ProfileActionsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("primaryAction");
    JSON_KEY_STORE.put("secondaryAction");
    JSON_KEY_STORE.put("overflowActions");
    JSON_KEY_STORE.put("actions");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActionsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */