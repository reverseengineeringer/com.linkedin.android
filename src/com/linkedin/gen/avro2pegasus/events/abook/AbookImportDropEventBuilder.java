package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class AbookImportDropEventBuilder
  implements DataTemplateBuilder<AbookImportDropEvent>
{
  public static final AbookImportDropEventBuilder INSTANCE = new AbookImportDropEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("abookImportTransactionId");
    JSON_KEY_STORE.put("abookImportDropReason");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportDropEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */