package com.linkedin.gen.avro2pegasus.events.me.wvmp;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class WvmpOverviewInsightImpressionEventBuilder
  implements DataTemplateBuilder<WvmpOverviewInsightImpressionEvent>
{
  public static final WvmpOverviewInsightImpressionEventBuilder INSTANCE = new WvmpOverviewInsightImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("wvmpOverviewInsights");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */