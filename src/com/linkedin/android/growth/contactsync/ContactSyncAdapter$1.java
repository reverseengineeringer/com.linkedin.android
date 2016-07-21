package com.linkedin.android.growth.contactsync;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.SyncResult;
import android.content.SyncStats;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.logger.Log;
import java.util.ArrayList;

final class ContactSyncAdapter$1
  implements Runnable
{
  ContactSyncAdapter$1(ContactSyncAdapter paramContactSyncAdapter, Account paramAccount, String paramString, SyncResult paramSyncResult, int paramInt) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        if (ContactSyncAdapter.access$000(this$0))
        {
          Log.v(ContactSyncAdapter.access$100(), "Sync cancelled manually by user. Aborting sync!");
          return;
        }
        if (ContentResolver.getIsSyncable(val$account, val$authority) > 0)
        {
          i = 1;
          if ((i != 0) && (ContactSyncAdapter.access$300(ContactSyncAdapter.access$200(this$0).lixManager()) > 0)) {
            break;
          }
          SyncStats localSyncStats = val$syncResult.stats;
          numSkippedEntries += 1L;
          Log.v(ContactSyncAdapter.access$100(), "Contact sync disabled. Doing nothing");
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e(ContactSyncAdapter.access$100(), "Exception when syncing contacts", localException);
        CrashReporter.reportNonFatal(new Throwable("Exception when syncing contacts", localException));
        return;
      }
      int i = 0;
    }
    String str = ContactSyncAdapter.access$200(this$0).memberUtil().getProfileId();
    if ((!ContactSyncAdapter.access$200(this$0).auth().isAuthenticated()) || (str == null) || (val$syncType == 2))
    {
      ContactSyncAdapter.access$400(this$0.getContext(), val$account);
      Log.v(ContactSyncAdapter.access$100(), "Contact sync finished. Sync type for this sync was: " + val$syncType);
      return;
    }
    long l = System.currentTimeMillis();
    ContactSyncAdapter.access$600(ContactSyncAdapter.access$500(this$0), val$account, val$syncType);
    ContactSyncAdapter.access$800$140481d3(this$0, val$account, new ArrayList(), String.valueOf(l), val$syncType, str, ContactSyncAdapter.access$700(ContactSyncAdapter.access$200(this$0).lixManager()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */