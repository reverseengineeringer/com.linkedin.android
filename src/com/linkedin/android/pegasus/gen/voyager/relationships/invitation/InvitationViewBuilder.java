package com.linkedin.android.pegasus.gen.voyager.relationships.invitation;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class InvitationViewBuilder
  implements FissileDataModelBuilder<InvitationView>, DataTemplateBuilder<InvitationView>
{
  public static final InvitationViewBuilder INSTANCE = new InvitationViewBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("invitation");
    JSON_KEY_STORE.put("insights");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationViewBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */