package com.linkedin.android.growth.contactsync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;

final class ContactSyncAdapter$5
  implements Runnable
{
  ContactSyncAdapter$5(Context paramContext) {}
  
  public final void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Account[] arrayOfAccount = ContactSyncAdapter.getAllLinkedInAccounts(val$applicationContext);
        if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
        {
          Log.v(ContactSyncAdapter.access$100(), "No LinkedIn accounts found to remove");
          return;
        }
        int j = arrayOfAccount.length;
        i = 0;
        if (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          Log.v(ContactSyncAdapter.access$100(), "Removing linkedin account");
          Context localContext = val$applicationContext;
          if (Build.VERSION.SDK_INT >= 22) {
            AccountManager.get(localContext).removeAccount(localAccount, null, null, null);
          } else {
            AccountManager.get(localContext).removeAccount(localAccount, null, null);
          }
        }
      }
      catch (Exception localException)
      {
        Log.e(ContactSyncAdapter.access$100(), "Exception when removing accounts", localException);
        CrashReporter.reportNonFatal(new Throwable("Exception when removing accounts", localException));
      }
      return;
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */