package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class EndorsedSkillBuilder
  implements FissileDataModelBuilder<EndorsedSkill>, DataTemplateBuilder<EndorsedSkill>
{
  public static final EndorsedSkillBuilder INSTANCE = new EndorsedSkillBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("skill");
    JSON_KEY_STORE.put("endorsementCount");
    JSON_KEY_STORE.put("endorsedByViewer");
    JSON_KEY_STORE.put("endorsements");
    JSON_KEY_STORE.put("highlights");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkillBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */