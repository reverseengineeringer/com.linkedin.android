package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchImpressionEventBuilder
  implements DataTemplateBuilder<SearchImpressionEvent>
{
  public static final SearchImpressionEventBuilder INSTANCE = new SearchImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("searchHeader");
    JSON_KEY_STORE.put("pageNum");
    JSON_KEY_STORE.put("results");
    JSON_KEY_STORE.put("suggestedSecondaryVerticals");
    JSON_KEY_STORE.put("components");
    JSON_KEY_STORE.put("verticalGuides");
    JSON_KEY_STORE.put("filterGuides");
    JSON_KEY_STORE.put("facetGuides");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */