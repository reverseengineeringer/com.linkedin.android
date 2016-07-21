package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class TreasuryMediaItemsBuilder
  implements FissileDataModelBuilder<TreasuryMediaItems>, DataTemplateBuilder<TreasuryMediaItems>
{
  public static final TreasuryMediaItemsBuilder INSTANCE = new TreasuryMediaItemsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("sectionUrn");
    JSON_KEY_STORE.put("sectionType");
    JSON_KEY_STORE.put("mediaList");
    JSON_KEY_STORE.put("pagingInfo");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaItemsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */