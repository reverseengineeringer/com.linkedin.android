package com.linkedin.gen.avro2pegasus.events.feed;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class FeedCommentActionEventBuilder
  implements DataTemplateBuilder<FeedCommentActionEvent>
{
  public static final FeedCommentActionEventBuilder INSTANCE = new FeedCommentActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("trackableUpdateObject");
    JSON_KEY_STORE.put("threadUrn");
    JSON_KEY_STORE.put("trackableCommentObject");
    JSON_KEY_STORE.put("actionCategory");
    JSON_KEY_STORE.put("controlUrn");
    JSON_KEY_STORE.put("actionType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedCommentActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */