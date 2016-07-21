package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class JymbiiBuilder
  implements FissileDataModelBuilder<Jymbii>, DataTemplateBuilder<Jymbii>
{
  public static final JymbiiBuilder INSTANCE = new JymbiiBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("sponsored");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("objectUrn");
    JSON_KEY_STORE.put("jymbiiUpdate");
    JSON_KEY_STORE.put("linkedInApplication");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JymbiiBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */