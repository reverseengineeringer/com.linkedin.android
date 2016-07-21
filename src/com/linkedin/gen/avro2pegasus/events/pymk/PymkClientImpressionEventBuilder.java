package com.linkedin.gen.avro2pegasus.events.pymk;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PymkClientImpressionEventBuilder
  implements DataTemplateBuilder<PymkClientImpressionEvent>
{
  public static final PymkClientImpressionEventBuilder INSTANCE = new PymkClientImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("usageContext");
    JSON_KEY_STORE.put("recommendations");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */