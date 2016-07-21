package com.linkedin.gen.avro2pegasus.events.player;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PlayerPositionChangedEventBuilder
  implements DataTemplateBuilder<PlayerPositionChangedEvent>
{
  public static final PlayerPositionChangedEventBuilder INSTANCE = new PlayerPositionChangedEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("state");
    JSON_KEY_STORE.put("mediaTrackingObject");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerPositionChangedEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */