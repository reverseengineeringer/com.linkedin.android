package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NormPatentBuilder
  implements FissileDataModelBuilder<NormPatent>, DataTemplateBuilder<NormPatent>
{
  public static final NormPatentBuilder INSTANCE = new NormPatentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("number");
    JSON_KEY_STORE.put("applicationNumber");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("issuer");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("pending");
    JSON_KEY_STORE.put("filingDate");
    JSON_KEY_STORE.put("issueDate");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("localizedIssuerCountryName");
    JSON_KEY_STORE.put("inventors");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */