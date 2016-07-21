package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class WWUAdBuilder
  implements FissileDataModelBuilder<WWUAd>, DataTemplateBuilder<WWUAd>
{
  public static final WWUAdBuilder INSTANCE = new WWUAdBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("company");
    JSON_KEY_STORE.put("internalClickTrackingUrls");
    JSON_KEY_STORE.put("externalClickTrackingUrls");
    JSON_KEY_STORE.put("internalImpressionTrackingUrls");
    JSON_KEY_STORE.put("externalImpressionTrackingUrls");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.WWUAdBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */