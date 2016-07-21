package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class LegoTrackingEventBuilder
  implements FissileDataModelBuilder<LegoTrackingEvent>, DataTemplateBuilder<LegoTrackingEvent>
{
  public static final LegoTrackingEventBuilder INSTANCE = new LegoTrackingEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("legoTrackingToken");
    JSON_KEY_STORE.put("metricsObject");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.LegoTrackingEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */