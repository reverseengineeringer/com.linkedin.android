package com.linkedin.android.authenticator;

import android.accounts.Account;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.linkedin.android.growth.contactsync.ContactSyncAdapter;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.LogoutUtils;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.liauthlib.LiAuth.LogoutReason;
import com.linkedin.android.logger.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public class AccountChangeReceiver
  extends BroadcastReceiver
{
  private static final String TAG = AccountChangeReceiver.class.getSimpleName();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ApplicationComponent localApplicationComponent = ((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent();
    if (!localApplicationComponent.auth().isAuthenticated()) {}
    do
    {
      do
      {
        Log.d(TAG, "Not authenticated. Do nothing.");
        do
        {
          return;
        } while (paramIntent.getExtras() == null);
        paramIntent = (Account)paramIntent.getExtras().getParcelable("account");
      } while ((paramIntent == null) || (!paramContext.getPackageName().equals(type)));
      paramIntent = ContactSyncAdapter.getAllLinkedInAccounts(paramContext);
    } while ((paramIntent == null) || (paramIntent.length != 0));
    CrashReporter.reportNonFatal(new Throwable("Logging user out due to system account removal"));
    if (FlagshipApplication.IS_BACKGROUND.get())
    {
      localApplicationComponent.auth().signOut(LogoutUtils.createSignOutListener(localApplicationComponent, false), LiAuth.LogoutReason.USER_INITIATED);
      return;
    }
    paramIntent = intentRegistrylogin.newIntent(paramContext.getApplicationContext(), new LoginIntentBundle().isLogout(LiAuth.LogoutReason.USER_INITIATED));
    paramContext.getApplicationContext().startActivity(paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.authenticator.AccountChangeReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */