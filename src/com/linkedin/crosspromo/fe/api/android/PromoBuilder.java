package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PromoBuilder
  implements FissileDataModelBuilder<Promo>, DataTemplateBuilder<Promo>
{
  public static final PromoBuilder INSTANCE = new PromoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("tType");
    JSON_KEY_STORE.put("widgetId");
    JSON_KEY_STORE.put("appId");
    JSON_KEY_STORE.put("appName");
    JSON_KEY_STORE.put("actionUrl");
    JSON_KEY_STORE.put("storeUrl");
    JSON_KEY_STORE.put("legoTrackingToken");
    JSON_KEY_STORE.put("needSyncRendering");
    JSON_KEY_STORE.put("noCache");
    JSON_KEY_STORE.put("images");
    JSON_KEY_STORE.put("texts");
    JSON_KEY_STORE.put("metricsObject");
    JSON_KEY_STORE.put("metricsMap");
    JSON_KEY_STORE.put("subPromos");
    JSON_KEY_STORE.put("boltons");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.PromoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */