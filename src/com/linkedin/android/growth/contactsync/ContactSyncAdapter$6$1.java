package com.linkedin.android.growth.contactsync;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;

final class ContactSyncAdapter$6$1
  implements Runnable
{
  ContactSyncAdapter$6$1(ContactSyncAdapter.6 param6, DataStoreResponse paramDataStoreResponse) {}
  
  public final void run()
  {
    ContactSyncAdapter.access$1000(this$1.this$0, this$1.val$startIndex, (CollectionTemplate)val$response.model, this$1.val$account, this$1.val$operationList, this$1.val$snapshotValue, this$1.val$syncType, this$1.val$meProfileId, this$1.val$batchSize);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter.6.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */