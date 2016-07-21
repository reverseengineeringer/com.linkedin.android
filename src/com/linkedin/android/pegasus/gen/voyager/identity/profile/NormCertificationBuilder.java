package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NormCertificationBuilder
  implements FissileDataModelBuilder<NormCertification>, DataTemplateBuilder<NormCertification>
{
  public static final NormCertificationBuilder INSTANCE = new NormCertificationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("licenseNumber");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("displaySource");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("authority");
    JSON_KEY_STORE.put("companyUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCertificationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */