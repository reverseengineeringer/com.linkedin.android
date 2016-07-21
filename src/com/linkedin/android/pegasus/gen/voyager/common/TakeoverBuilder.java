package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class TakeoverBuilder
  implements FissileDataModelBuilder<Takeover>, DataTemplateBuilder<Takeover>
{
  public static final TakeoverBuilder INSTANCE = new TakeoverBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("takeoverType");
    JSON_KEY_STORE.put("legoTrackingToken");
    JSON_KEY_STORE.put("globalLegoTrackingToken");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.TakeoverBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */