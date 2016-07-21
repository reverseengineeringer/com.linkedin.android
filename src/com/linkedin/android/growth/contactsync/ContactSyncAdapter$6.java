package com.linkedin.android.growth.contactsync;

import android.accounts.Account;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.ContactSyncConnection;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

final class ContactSyncAdapter$6
  implements RecordTemplateListener<CollectionTemplate<ContactSyncConnection, CollectionMetadata>>
{
  ContactSyncAdapter$6(ContactSyncAdapter paramContactSyncAdapter, int paramInt1, int paramInt2, Account paramAccount, ArrayList paramArrayList, String paramString1, String paramString2, int paramInt3) {}
  
  public final void onResponse(final DataStoreResponse<CollectionTemplate<ContactSyncConnection, CollectionMetadata>> paramDataStoreResponse)
  {
    if (error != null)
    {
      Log.e(ContactSyncAdapter.access$100(), "Error fetching response", error);
      return;
    }
    int i = ContactSyncAdapter.access$200(this$0).flagshipSharedPreferences().getContactAddressBookSyncType();
    if (i != val$syncType)
    {
      Log.v(ContactSyncAdapter.access$100(), "Sync type changed from " + val$syncType + " to " + i + ". Aborting sync!");
      return;
    }
    ContactSyncAdapter.access$1100().submit(new Runnable()
    {
      public final void run()
      {
        ContactSyncAdapter.access$1000(this$0, val$startIndex, (CollectionTemplate)paramDataStoreResponsemodel, val$account, val$operationList, val$snapshotValue, val$syncType, val$meProfileId, val$batchSize);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */