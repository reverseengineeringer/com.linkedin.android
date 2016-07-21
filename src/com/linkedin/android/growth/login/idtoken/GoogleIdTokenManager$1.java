package com.linkedin.android.growth.login.idtoken;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public final class GoogleIdTokenManager$1
  implements GoogleApiClient.OnConnectionFailedListener
{
  public GoogleIdTokenManager$1(GoogleIdTokenManager paramGoogleIdTokenManager, GoogleIdTokenListener paramGoogleIdTokenListener) {}
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    Log.e(GoogleIdTokenManager.access$000(), "onConnectionFailed: " + zzafC);
    GoogleIdTokenManager.access$100(this$0);
    val$googleIdTokenListener.onFetchFailed();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */