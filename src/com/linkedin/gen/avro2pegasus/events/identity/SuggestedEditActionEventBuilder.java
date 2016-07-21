package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SuggestedEditActionEventBuilder
  implements DataTemplateBuilder<SuggestedEditActionEvent>
{
  public static final SuggestedEditActionEventBuilder INSTANCE = new SuggestedEditActionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("rawProfileElementUrn");
    JSON_KEY_STORE.put("flowTrackingId");
    JSON_KEY_STORE.put("actionType");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */