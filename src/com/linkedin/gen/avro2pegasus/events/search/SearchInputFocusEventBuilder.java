package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SearchInputFocusEventBuilder
  implements DataTemplateBuilder<SearchInputFocusEvent>
{
  public static final SearchInputFocusEventBuilder INSTANCE = new SearchInputFocusEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("controlUrn");
    JSON_KEY_STORE.put("tagValue");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchInputFocusEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */