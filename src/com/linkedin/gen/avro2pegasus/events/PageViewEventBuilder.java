package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PageViewEventBuilder
  implements DataTemplateBuilder<PageViewEvent>
{
  public static final PageViewEventBuilder INSTANCE = new PageViewEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("pageType");
    JSON_KEY_STORE.put("errorMessageKey");
    JSON_KEY_STORE.put("trackingCode");
    JSON_KEY_STORE.put("trackingInfo");
    JSON_KEY_STORE.put("totalTime");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.PageViewEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */