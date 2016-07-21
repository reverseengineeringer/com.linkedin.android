package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchMetadataBuilder
  implements FissileDataModelBuilder<SearchMetadata>, DataTemplateBuilder<SearchMetadata>
{
  public static final SearchMetadataBuilder INSTANCE = new SearchMetadataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("origin");
    JSON_KEY_STORE.put("warnings");
    JSON_KEY_STORE.put("keywords");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("guides");
    JSON_KEY_STORE.put("facets");
    JSON_KEY_STORE.put("spellCorrection");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchMetadataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */