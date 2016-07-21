package com.linkedin.android.growth.contactsync;

import android.accounts.Account;
import android.content.Context;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;

final class ContactSyncAdapter$4
  implements Runnable
{
  ContactSyncAdapter$4(Context paramContext) {}
  
  public final void run()
  {
    try
    {
      Account[] arrayOfAccount = ContactSyncAdapter.getAllLinkedInAccounts(val$applicationContext);
      if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
      {
        Log.v(ContactSyncAdapter.access$100(), "No LinkedIn accounts found to sync");
        return;
      }
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        ContactSyncAdapter.access$900(arrayOfAccount[i]);
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e(ContactSyncAdapter.access$100(), "Exception when requesting account sync", localException);
      CrashReporter.reportNonFatal(new Throwable("Exception when requesting account sync", localException));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */