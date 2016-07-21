package com.linkedin.gen.avro2pegasus.events.guidededit;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class GuidedEditFlowImpressionEventBuilder
  implements DataTemplateBuilder<GuidedEditFlowImpressionEvent>
{
  public static final GuidedEditFlowImpressionEventBuilder INSTANCE = new GuidedEditFlowImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("contextType");
    JSON_KEY_STORE.put("fieldNames");
    JSON_KEY_STORE.put("flowTrackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */