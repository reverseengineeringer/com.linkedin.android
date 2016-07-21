package com.linkedin.gen.avro2pegasus.events.abook;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class AbookImportInvitationImpressionEventBuilder
  implements DataTemplateBuilder<AbookImportInvitationImpressionEvent>
{
  public static final AbookImportInvitationImpressionEventBuilder INSTANCE = new AbookImportInvitationImpressionEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("abookImportTransactionId");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("impressionType");
    JSON_KEY_STORE.put("count");
    JSON_KEY_STORE.put("numberOfExistingContacts");
    JSON_KEY_STORE.put("numberOfNewContacts");
    JSON_KEY_STORE.put("numberOfContactsPortedFromPhoneNumber");
    JSON_KEY_STORE.put("suggestedConnections");
    JSON_KEY_STORE.put("suggestedInvitations");
    JSON_KEY_STORE.put("invitationTrackingInfo");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("invitationCounts");
    JSON_KEY_STORE.put("abookFetchTransactionId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationImpressionEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */