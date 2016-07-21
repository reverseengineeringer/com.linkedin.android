package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ConversationCreateBuilder
  implements FissileDataModelBuilder<ConversationCreate>, DataTemplateBuilder<ConversationCreate>
{
  public static final ConversationCreateBuilder INSTANCE = new ConversationCreateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("recipients");
    JSON_KEY_STORE.put("subject");
    JSON_KEY_STORE.put("eventCreate");
    JSON_KEY_STORE.put("subtype");
    JSON_KEY_STORE.put("name");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.ConversationCreateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */