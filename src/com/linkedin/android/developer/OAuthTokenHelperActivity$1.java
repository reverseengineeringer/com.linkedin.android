package com.linkedin.android.developer;

import android.os.Bundle;

final class OAuthTokenHelperActivity$1
  implements OAuthNetworkHelper.OAuthResponseListener
{
  OAuthTokenHelperActivity$1(OAuthTokenHelperActivity paramOAuthTokenHelperActivity) {}
  
  public final void onFailure()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("error_msg", "Could not get user token");
    OAuthTokenHelperActivity.access$000(this$0, localBundle);
    this$0.finish();
  }
  
  public final void onSuccess(Bundle paramBundle)
  {
    OAuthTokenHelperActivity.access$000(this$0, paramBundle);
    this$0.finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.developer.OAuthTokenHelperActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */