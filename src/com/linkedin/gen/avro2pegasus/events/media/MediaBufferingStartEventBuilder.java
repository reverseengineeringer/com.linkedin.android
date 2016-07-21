package com.linkedin.gen.avro2pegasus.events.media;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MediaBufferingStartEventBuilder
  implements DataTemplateBuilder<MediaBufferingStartEvent>
{
  public static final MediaBufferingStartEventBuilder INSTANCE = new MediaBufferingStartEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("mediaTrackingObject");
    JSON_KEY_STORE.put("bufferingType");
    JSON_KEY_STORE.put("initializationStartTime");
    JSON_KEY_STORE.put("bufferingStartTime");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.media.MediaBufferingStartEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */