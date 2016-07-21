package com.linkedin.android.pegasus.gen.voyager.messaging.realtime;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class RealtimeTypingIndicatorBuilder
  implements FissileDataModelBuilder<RealtimeTypingIndicator>, DataTemplateBuilder<RealtimeTypingIndicator>
{
  public static final RealtimeTypingIndicatorBuilder INSTANCE = new RealtimeTypingIndicatorBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("conversation");
    JSON_KEY_STORE.put("fromParticipant");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeTypingIndicatorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */