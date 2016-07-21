package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class SuggestedRecipientListBuilder
  implements FissileDataModelBuilder<SuggestedRecipientList>, DataTemplateBuilder<SuggestedRecipientList>
{
  public static final SuggestedRecipientListBuilder INSTANCE = new SuggestedRecipientListBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("suggestedRecipients");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientListBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */