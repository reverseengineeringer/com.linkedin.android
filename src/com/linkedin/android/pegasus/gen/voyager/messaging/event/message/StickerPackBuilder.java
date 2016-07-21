package com.linkedin.android.pegasus.gen.voyager.messaging.event.message;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class StickerPackBuilder
  implements FissileDataModelBuilder<StickerPack>, DataTemplateBuilder<StickerPack>
{
  public static final StickerPackBuilder INSTANCE = new StickerPackBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("author");
    JSON_KEY_STORE.put("hidden");
    JSON_KEY_STORE.put("previewSticker");
    JSON_KEY_STORE.put("modifiedAt");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.StickerPackBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */