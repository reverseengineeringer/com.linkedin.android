package com.linkedin.gen.avro2pegasus.events.media;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MediaBufferingEndEventBuilder
  implements DataTemplateBuilder<MediaBufferingEndEvent>
{
  public static final MediaBufferingEndEventBuilder INSTANCE = new MediaBufferingEndEventBuilder();
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
    JSON_KEY_STORE.put("duration");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.media.MediaBufferingEndEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */