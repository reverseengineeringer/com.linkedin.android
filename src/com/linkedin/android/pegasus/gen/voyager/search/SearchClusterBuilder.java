package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchClusterBuilder
  implements FissileDataModelBuilder<SearchCluster>, DataTemplateBuilder<SearchCluster>
{
  public static final SearchClusterBuilder INSTANCE = new SearchClusterBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("total");
    JSON_KEY_STORE.put("elements");
    JSON_KEY_STORE.put("guides");
    JSON_KEY_STORE.put("keywords");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("hitType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchClusterBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */