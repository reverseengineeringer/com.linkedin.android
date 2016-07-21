package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchActionEventBuilder
  implements DataTemplateBuilder<SearchActionEvent>
{
  public static final SearchActionEventBuilder INSTANCE = new SearchActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("searchHeader");
    JSON_KEY_STORE.put("entityActionType");
    JSON_KEY_STORE.put("searchResult");
    JSON_KEY_STORE.put("searchResultComponent");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */