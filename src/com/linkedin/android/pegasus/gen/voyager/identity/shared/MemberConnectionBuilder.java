package com.linkedin.android.pegasus.gen.voyager.identity.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MemberConnectionBuilder
  implements FissileDataModelBuilder<MemberConnection>, DataTemplateBuilder<MemberConnection>
{
  public static final MemberConnectionBuilder INSTANCE = new MemberConnectionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfile");
    JSON_KEY_STORE.put("distance");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.MemberConnectionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */