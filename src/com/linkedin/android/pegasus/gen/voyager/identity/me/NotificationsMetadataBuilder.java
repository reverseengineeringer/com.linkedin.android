package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NotificationsMetadataBuilder
  implements FissileDataModelBuilder<NotificationsMetadata>, DataTemplateBuilder<NotificationsMetadata>
{
  public static final NotificationsMetadataBuilder INSTANCE = new NotificationsMetadataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numUnseen");
    JSON_KEY_STORE.put("latestPublishedAt");
    JSON_KEY_STORE.put("nextStart");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.NotificationsMetadataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */