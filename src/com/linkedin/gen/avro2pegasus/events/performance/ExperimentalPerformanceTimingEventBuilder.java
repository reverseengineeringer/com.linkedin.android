package com.linkedin.gen.avro2pegasus.events.performance;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ExperimentalPerformanceTimingEventBuilder
  implements DataTemplateBuilder<ExperimentalPerformanceTimingEvent>
{
  public static final ExperimentalPerformanceTimingEventBuilder INSTANCE = new ExperimentalPerformanceTimingEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("performanceTimingArray");
    JSON_KEY_STORE.put("userSessionId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.performance.ExperimentalPerformanceTimingEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */