package com.linkedin.android.developer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.Auth;

public class OAuthTokenHelperActivity
  extends BaseActivity
{
  private void sendBroadcast(Bundle paramBundle)
  {
    Intent localIntent = new Intent("com.linkedin.android.OAUTH_RESULT_ACTION");
    localIntent.putExtra("ouath_result_bundle", paramBundle);
    LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (applicationComponent.auth().isAuthenticated())
    {
      if (!applicationComponent.flagshipSharedPreferences().getDevTokenUserSelection())
      {
        paramBundle = new Bundle();
        paramBundle.putString("error_msg", "User did not give consent");
        sendBroadcast(paramBundle);
        finish();
        return;
      }
      applicationComponent.oAuthNetworkHelper().getToken(paramBundle.getStringExtra("apiKey"), paramBundle.getStringExtra("scope"), paramBundle.getStringExtra("secret"), new OAuthNetworkHelper.OAuthResponseListener()
      {
        public final void onFailure()
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("error_msg", "Could not get user token");
          OAuthTokenHelperActivity.this.sendBroadcast(localBundle);
          finish();
        }
        
        public final void onSuccess(Bundle paramAnonymousBundle)
        {
          OAuthTokenHelperActivity.this.sendBroadcast(paramAnonymousBundle);
          finish();
        }
      });
      return;
    }
    paramBundle = new Bundle();
    paramBundle.putString("error_msg", "User is not authenticated in helper activity");
    sendBroadcast(paramBundle);
    finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.OAuthTokenHelperActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */