package com.linkedin.android.developer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

final class OAuthService$1$2
  implements OAuthNetworkHelper.OAuthResponseListener
{
  OAuthService$1$2(OAuthService.1 param1, LocalBroadcastManager paramLocalBroadcastManager) {}
  
  public final void onFailure()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("error_msg", "Could not get user token");
    Intent localIntent = new Intent("com.linkedin.android.OAUTH_RESULT_ACTION");
    localIntent.putExtra("ouath_result_bundle", localBundle);
    val$localBroadcastManager.sendBroadcast(localIntent);
  }
  
  public final void onSuccess(Bundle paramBundle)
  {
    Intent localIntent = new Intent("com.linkedin.android.OAUTH_RESULT_ACTION");
    localIntent.putExtra("ouath_result_bundle", paramBundle);
    val$localBroadcastManager.sendBroadcast(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.OAuthService.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */