package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MessagingRecommendationActionEventBuilder
  implements DataTemplateBuilder<MessagingRecommendationActionEvent>
{
  public static final MessagingRecommendationActionEventBuilder INSTANCE = new MessagingRecommendationActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("actionCategory");
    JSON_KEY_STORE.put("controlUrn");
    JSON_KEY_STORE.put("recommendationTrackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.MessagingRecommendationActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */