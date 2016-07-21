package com.linkedin.gen.avro2pegasus.events.player;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PlayerVolumeChangedEventBuilder
  implements DataTemplateBuilder<PlayerVolumeChangedEvent>
{
  public static final PlayerVolumeChangedEventBuilder INSTANCE = new PlayerVolumeChangedEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("state");
    JSON_KEY_STORE.put("previousVolume");
    JSON_KEY_STORE.put("mediaTrackingObject");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.player.PlayerVolumeChangedEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */