package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class ContactsUploadContactsRequestBuilder
  implements FissileDataModelBuilder<ContactsUploadContactsRequest>, DataTemplateBuilder<ContactsUploadContactsRequest>
{
  public static final ContactsUploadContactsRequestBuilder INSTANCE = new ContactsUploadContactsRequestBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("rawContacts");
    JSON_KEY_STORE.put("uploadTransactionId");
    JSON_KEY_STORE.put("deviceCountryCode");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.ContactsUploadContactsRequestBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */