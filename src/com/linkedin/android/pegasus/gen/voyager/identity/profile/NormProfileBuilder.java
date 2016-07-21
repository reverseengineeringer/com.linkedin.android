package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NormProfileBuilder
  implements FissileDataModelBuilder<NormProfile>, DataTemplateBuilder<NormProfile>
{
  public static final NormProfileBuilder INSTANCE = new NormProfileBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("firstName");
    JSON_KEY_STORE.put("lastName");
    JSON_KEY_STORE.put("maidenName");
    JSON_KEY_STORE.put("headline");
    JSON_KEY_STORE.put("industryName");
    JSON_KEY_STORE.put("industryUrn");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("backgroundImage");
    JSON_KEY_STORE.put("pictureInfo");
    JSON_KEY_STORE.put("phoneticFirstName");
    JSON_KEY_STORE.put("phoneticLastName");
    JSON_KEY_STORE.put("contactInstructions");
    JSON_KEY_STORE.put("interests");
    JSON_KEY_STORE.put("address");
    JSON_KEY_STORE.put("birthDate");
    JSON_KEY_STORE.put("summary");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfileBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */