package com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ContactSyncConnectionBuilder
  implements FissileDataModelBuilder<ContactSyncConnection>, DataTemplateBuilder<ContactSyncConnection>
{
  public static final ContactSyncConnectionBuilder INSTANCE = new ContactSyncConnectionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("miniProfile");
    JSON_KEY_STORE.put("phoneNumbers");
    JSON_KEY_STORE.put("emailAddress");
    JSON_KEY_STORE.put("twitterHandles");
    JSON_KEY_STORE.put("weChatContactInfo");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.ContactSyncConnectionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */