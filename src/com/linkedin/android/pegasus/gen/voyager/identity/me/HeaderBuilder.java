package com.linkedin.android.pegasus.gen.voyager.identity.me;

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
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("miniProfile");
    JSON_KEY_STORE.put("backgroundImage");
    JSON_KEY_STORE.put("numProfileViews");
    JSON_KEY_STORE.put("numLastUpdateViews");
    JSON_KEY_STORE.put("lastUpdateType");
    JSON_KEY_STORE.put("numFollowers");
    JSON_KEY_STORE.put("numActivities");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.HeaderBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */