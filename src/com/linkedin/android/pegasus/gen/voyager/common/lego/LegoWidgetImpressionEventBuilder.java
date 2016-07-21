package com.linkedin.android.pegasus.gen.voyager.common.lego;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class LegoWidgetImpressionEventBuilder
  implements FissileDataModelBuilder<LegoWidgetImpressionEvent>, DataTemplateBuilder<LegoWidgetImpressionEvent>
{
  public static final LegoWidgetImpressionEventBuilder INSTANCE = new LegoWidgetImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("trackingToken");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("visibility");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */