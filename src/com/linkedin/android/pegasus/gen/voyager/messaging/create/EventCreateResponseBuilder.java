package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class EventCreateResponseBuilder
  implements FissileDataModelBuilder<EventCreateResponse>, DataTemplateBuilder<EventCreateResponse>
{
  public static final EventCreateResponseBuilder INSTANCE = new EventCreateResponseBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("createdAt");
    JSON_KEY_STORE.put("conversationUrn");
    JSON_KEY_STORE.put("eventUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponseBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */