package com.linkedin.gen.avro2pegasus.events.invitations;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class InvitationClickEventBuilder
  implements DataTemplateBuilder<InvitationClickEvent>
{
  public static final InvitationClickEventBuilder INSTANCE = new InvitationClickEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("invitationType");
    JSON_KEY_STORE.put("inviteeUrns");
    JSON_KEY_STORE.put("inviteeEmails");
    JSON_KEY_STORE.put("product");
    JSON_KEY_STORE.put("subproduct");
    JSON_KEY_STORE.put("invitationTrackingInfo");
    JSON_KEY_STORE.put("transactionId");
    JSON_KEY_STORE.put("flow");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */