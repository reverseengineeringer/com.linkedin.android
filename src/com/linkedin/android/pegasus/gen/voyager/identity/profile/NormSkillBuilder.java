package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NormSkillBuilder
  implements FissileDataModelBuilder<NormSkill>, DataTemplateBuilder<NormSkill>
{
  public static final NormSkillBuilder INSTANCE = new NormSkillBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("standardizedSkillUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("entityUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormSkillBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */