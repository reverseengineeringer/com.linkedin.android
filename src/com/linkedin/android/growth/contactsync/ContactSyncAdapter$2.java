package com.linkedin.android.growth.contactsync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;
import java.util.concurrent.TimeUnit;

final class ContactSyncAdapter$2
  implements Runnable
{
  ContactSyncAdapter$2(Auth paramAuth, Context paramContext, LixManager paramLixManager) {}
  
  public final void run()
  {
    try
    {
      if (!val$auth.isAuthenticated())
      {
        Log.v(ContactSyncAdapter.access$100(), "Not adding account because app is not authenticated");
        return;
      }
      Account[] arrayOfAccount = ContactSyncAdapter.getAllLinkedInAccounts(val$applicationContext);
      if ((arrayOfAccount != null) && (arrayOfAccount.length > 0))
      {
        Log.v(ContactSyncAdapter.access$100(), "Not adding account because it already exists");
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(ContactSyncAdapter.access$100(), "Exception adding LinkedIn account", localException);
      CrashReporter.reportNonFatal(new Throwable("Exception adding LinkedIn account", localException));
      return;
    }
    Log.v(ContactSyncAdapter.access$100(), "Adding new LinkedIn account");
    Account localAccount = new Account(val$applicationContext.getResources().getString(2131233769), val$applicationContext.getPackageName());
    if (!AccountManager.get(val$applicationContext).addAccountExplicitly(localAccount, null, null))
    {
      Log.e(ContactSyncAdapter.access$100(), "Failed to add LinkedIn account. AccountManager returned false");
      return;
    }
    ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", false);
    ContentResolver.setIsSyncable(localAccount, "com.android.contacts", 1);
    int i = ContactSyncAdapter.access$300(val$lixManager);
    if (i > 0)
    {
      Log.v(ContactSyncAdapter.access$100(), "Setup periodic sync once every " + i + " days");
      ContentResolver.addPeriodicSync(localAccount, "com.android.contacts", new Bundle(), TimeUnit.DAYS.toSeconds(i));
    }
    ContactSyncAdapter.access$900(localAccount);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */