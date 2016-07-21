package com.linkedin.gen.avro2pegasus.events.feed;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class FeedHighlightedUpdateEventBuilder
  implements DataTemplateBuilder<FeedHighlightedUpdateEvent>
{
  public static final FeedHighlightedUpdateEventBuilder INSTANCE = new FeedHighlightedUpdateEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("moduleKey");
    JSON_KEY_STORE.put("sourceTrackingId");
    JSON_KEY_STORE.put("highlightedUpdateSource");
    JSON_KEY_STORE.put("highlightedUpdates");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */