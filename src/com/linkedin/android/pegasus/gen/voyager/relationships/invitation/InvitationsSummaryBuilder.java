package com.linkedin.android.pegasus.gen.voyager.relationships.invitation;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class InvitationsSummaryBuilder
  implements FissileDataModelBuilder<InvitationsSummary>, DataTemplateBuilder<InvitationsSummary>
{
  public static final InvitationsSummaryBuilder INSTANCE = new InvitationsSummaryBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("numNewInvitations");
    JSON_KEY_STORE.put("numPendingInvitations");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationsSummaryBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */