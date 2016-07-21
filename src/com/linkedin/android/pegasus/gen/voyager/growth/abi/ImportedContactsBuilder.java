package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ImportedContactsBuilder
  implements FissileDataModelBuilder<ImportedContacts>, DataTemplateBuilder<ImportedContacts>
{
  public static final ImportedContactsBuilder INSTANCE = new ImportedContactsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("memberContacts");
    JSON_KEY_STORE.put("guestContacts");
    JSON_KEY_STORE.put("trackingId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContactsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */