package com.linkedin.android.growth.contactsync;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.Util;

public final class Authenticator
  extends AbstractAccountAuthenticator
{
  private final ApplicationComponent appComponent;
  private final Context context;
  
  public Authenticator(Context paramContext)
  {
    super(paramContext);
    context = paramContext;
    appComponent = Util.getAppComponent(paramContext);
  }
  
  public final Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
    throws NetworkErrorException
  {
    if (appComponent.auth().isAuthenticated()) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          Toast.makeText(context, 2131233615, 0).show();
        }
      });
    }
    for (;;)
    {
      throw new UnsupportedOperationException();
      paramAccountAuthenticatorResponse = appComponent.intentRegistry().login.newIntent(context, null);
      context.startActivity(paramAccountAuthenticatorResponse);
    }
  }
  
  public final Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
    throws NetworkErrorException
  {
    return null;
  }
  
  public final Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    throws NetworkErrorException
  {
    throw new UnsupportedOperationException();
  }
  
  public final String getAuthTokenLabel(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
    throws NetworkErrorException
  {
    throw new UnsupportedOperationException();
  }
  
  public final Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    throws NetworkErrorException
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.Authenticator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */