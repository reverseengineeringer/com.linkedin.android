package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class HeaderBuilder
  implements FissileDataModelBuilder<Header>, DataTemplateBuilder<Header>
{
  public static final HeaderBuilder INSTANCE = new HeaderBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("createdOn");
    JSON_KEY_STORE.put("totalSocialActivityCounts");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("socialUpdateType");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("objectUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.HeaderBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */