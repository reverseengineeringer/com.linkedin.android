package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class AbookImportSubmitEventBuilder
  implements DataTemplateBuilder<AbookImportSubmitEvent>
{
  public static final AbookImportSubmitEventBuilder INSTANCE = new AbookImportSubmitEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("abookImportTransactionId");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("providerName");
    JSON_KEY_STORE.put("requestHeader");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportSubmitEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */