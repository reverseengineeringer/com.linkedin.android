package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class AbookImportImpressionEventBuilder
  implements DataTemplateBuilder<AbookImportImpressionEvent>
{
  public static final AbookImportImpressionEventBuilder INSTANCE = new AbookImportImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("abookImportTransactionId");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("source");
    JSON_KEY_STORE.put("autoFilledEmail");
    JSON_KEY_STORE.put("autoSelectedEmailProvider");
    JSON_KEY_STORE.put("orderOfEmailProviderss");
    JSON_KEY_STORE.put("socialProofType");
    JSON_KEY_STORE.put("socialProofCount");
    JSON_KEY_STORE.put("mobileHeader");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */