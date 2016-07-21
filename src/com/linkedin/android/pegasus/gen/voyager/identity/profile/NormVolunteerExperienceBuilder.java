package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NormVolunteerExperienceBuilder
  implements FissileDataModelBuilder<NormVolunteerExperience>, DataTemplateBuilder<NormVolunteerExperience>
{
  public static final NormVolunteerExperienceBuilder INSTANCE = new NormVolunteerExperienceBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("companyName");
    JSON_KEY_STORE.put("companyUrn");
    JSON_KEY_STORE.put("role");
    JSON_KEY_STORE.put("cause");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("description");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperienceBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */