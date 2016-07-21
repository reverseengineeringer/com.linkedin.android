package com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PropBuilder
  implements FissileDataModelBuilder<Prop>, DataTemplateBuilder<Prop>
{
  public static final PropBuilder INSTANCE = new PropBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("displayMessages");
    JSON_KEY_STORE.put("propType");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("miniProfile");
    JSON_KEY_STORE.put("seen");
    JSON_KEY_STORE.put("details");
    JSON_KEY_STORE.put("socialActivityInfo");
    JSON_KEY_STORE.put("profileSummary");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */