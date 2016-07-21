package com.linkedin.android.growth.contactsync;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;
import java.util.concurrent.TimeUnit;

final class ContactSyncAdapter$3
  implements Runnable
{
  ContactSyncAdapter$3(Context paramContext1, Context paramContext2, LixManager paramLixManager, Auth paramAuth, FlagshipSharedPreferences paramFlagshipSharedPreferences) {}
  
  public final void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Account[] arrayOfAccount = ContactSyncAdapter.getAllLinkedInAccounts(val$applicationContext);
        if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
        {
          Log.v(ContactSyncAdapter.access$100(), "No LinkedIn accounts found. Perhaps adding accounts failed? Try adding again");
          ContactSyncAdapter.addLinkedInAccount(val$context, val$lixManager, val$auth);
          return;
        }
        Bundle localBundle = new Bundle();
        int j = arrayOfAccount.length;
        if (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", false);
          int k = ContactSyncAdapter.access$300(val$lixManager);
          if (k > 0)
          {
            Log.v(ContactSyncAdapter.access$100(), "Setup periodic sync once every " + k + " days");
            ContentResolver.addPeriodicSync(localAccount, "com.android.contacts", new Bundle(), TimeUnit.DAYS.toSeconds(k));
            long l = val$sharedPreferences.getPreferences().getLong("lastContactSyncTimestamp", 0L);
            if (System.currentTimeMillis() - l >= TimeUnit.DAYS.toMillis(k)) {
              ContactSyncAdapter.access$900(localAccount);
            }
          }
          else
          {
            Log.v(ContactSyncAdapter.access$100(), "Removed periodic contact sync");
            ContentResolver.removePeriodicSync(localAccount, "com.android.contacts", localBundle);
          }
        }
      }
      catch (Exception localException)
      {
        Log.e(ContactSyncAdapter.access$100(), "Exception when requesting account sync", localException);
        CrashReporter.reportNonFatal(new Throwable("Exception when requesting account sync", localException));
      }
      return;
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */