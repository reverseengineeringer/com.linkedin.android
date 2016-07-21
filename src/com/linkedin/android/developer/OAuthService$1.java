package com.linkedin.android.developer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.samsung.SamsungSyncConsentIntent;
import com.linkedin.android.growth.samsung.SamsungSyncConsentIntentBundle;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.Auth;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class OAuthService$1
  extends IOAuthService.Stub
{
  OAuthService$1(OAuthService paramOAuthService) {}
  
  public final void getToken$628af682(String paramString1, String paramString2, String paramString3, final IOAuthServiceResultCallback paramIOAuthServiceResultCallback)
    throws RemoteException
  {
    FlagshipApplication localFlagshipApplication = (FlagshipApplication)this$0.getApplication();
    ApplicationComponent localApplicationComponent = localFlagshipApplication.getAppComponent();
    int i = getCallingUid();
    String str = OAuthService.access$000$51afb15f(localFlagshipApplication, i);
    final LocalBroadcastManager localLocalBroadcastManager = LocalBroadcastManager.getInstance(this$0.getApplicationContext());
    BroadcastReceiver local1;
    if ((str != null) && (OAuthService.access$100$4b0eacd0(localFlagshipApplication, str)))
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      local1 = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          OAuthService.access$200(paramIOAuthServiceResultCallback, paramAnonymousIntent.getBundleExtra("ouath_result_bundle"));
          localCountDownLatch.countDown();
        }
      };
      localLocalBroadcastManager.registerReceiver(local1, new IntentFilter("com.linkedin.android.OAUTH_RESULT_ACTION"));
      OAuthNetworkHelper localOAuthNetworkHelper = localApplicationComponent.oAuthNetworkHelper();
      if (!localApplicationComponent.auth().isAuthenticated())
      {
        paramString1 = OAuthService.access$300$354d2d2d(localFlagshipApplication, paramString1, paramString2, paramString3);
        paramString2 = new LoginIntentBundle();
        paramString2.setThirdPartyApplicationPackageName(str);
        paramString2.setRedirectIntent(paramString1);
        paramString1 = intentRegistrylogin.newIntent(localFlagshipApplication, paramString2);
        paramString1.addFlags(335544320);
        localFlagshipApplication.startActivity(paramString1);
      }
      for (;;)
      {
        try
        {
          if (!localCountDownLatch.await(5L, TimeUnit.SECONDS)) {
            paramIOAuthServiceResultCallback.onError("Service timed out: " + i + "(" + str + ")");
          }
          return;
        }
        catch (InterruptedException paramString1)
        {
          paramIOAuthServiceResultCallback.onError("Service interrupted: " + i + "(" + str + ")");
          return;
        }
        finally
        {
          localLocalBroadcastManager.unregisterReceiver(local1);
        }
        if (localApplicationComponent.flagshipSharedPreferences().getDevTokenUserSelection())
        {
          localOAuthNetworkHelper.getToken(paramString1, paramString3, paramString2, new OAuthNetworkHelper.OAuthResponseListener()
          {
            public final void onFailure()
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("error_msg", "Could not get user token");
              Intent localIntent = new Intent("com.linkedin.android.OAUTH_RESULT_ACTION");
              localIntent.putExtra("ouath_result_bundle", localBundle);
              localLocalBroadcastManager.sendBroadcast(localIntent);
            }
            
            public final void onSuccess(Bundle paramAnonymousBundle)
            {
              Intent localIntent = new Intent("com.linkedin.android.OAUTH_RESULT_ACTION");
              localIntent.putExtra("ouath_result_bundle", paramAnonymousBundle);
              localLocalBroadcastManager.sendBroadcast(localIntent);
            }
          });
        }
        else if (localFlagshipApplication.getAppComponent().flagshipSharedPreferences().getPreferences().getBoolean("homeActivityResumedAtLeastOnce", false))
        {
          paramString1 = OAuthService.access$300$354d2d2d(localFlagshipApplication, paramString1, paramString2, paramString3);
          paramString2 = new SamsungSyncConsentIntentBundle();
          bundle.putParcelable("redirect", paramString1);
          paramString1 = intentRegistrysamsungSyncConsentIntent.newIntent(localFlagshipApplication, paramString2);
          paramString1.addFlags(268435456);
          localFlagshipApplication.startActivity(paramString1);
        }
        else
        {
          paramIOAuthServiceResultCallback.onError("App not ready yet: " + i + "(" + str + ")");
          return;
        }
      }
    }
    paramIOAuthServiceResultCallback.onError("Unauthorized caller: " + i + "(" + str + ")");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.OAuthService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */