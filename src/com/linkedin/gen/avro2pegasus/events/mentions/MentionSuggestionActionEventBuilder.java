package com.linkedin.gen.avro2pegasus.events.mentions;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MentionSuggestionActionEventBuilder
  implements DataTemplateBuilder<MentionSuggestionActionEvent>
{
  public static final MentionSuggestionActionEventBuilder INSTANCE = new MentionSuggestionActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("searchHeader");
    JSON_KEY_STORE.put("mentionWorkflowId");
    JSON_KEY_STORE.put("actionType");
    JSON_KEY_STORE.put("result");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.mentions.MentionSuggestionActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */