package com.linkedin.gen.avro2pegasus.events.relevance;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SuggestedRouteRequestEventBuilder
  implements DataTemplateBuilder<SuggestedRouteRequestEvent>
{
  public static final SuggestedRouteRequestEventBuilder INSTANCE = new SuggestedRouteRequestEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("origin");
    JSON_KEY_STORE.put("userActionType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */