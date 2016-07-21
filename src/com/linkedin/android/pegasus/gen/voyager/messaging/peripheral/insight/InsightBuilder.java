package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class InsightBuilder
  implements FissileDataModelBuilder<Insight>, DataTemplateBuilder<Insight>
{
  public static final InsightBuilder INSTANCE = new InsightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("body");
    JSON_KEY_STORE.put("preFilledText");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("trackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.insight.InsightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */