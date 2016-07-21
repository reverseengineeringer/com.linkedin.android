package com.linkedin.android.growth.login.idtoken;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

public final class GoogleIdTokenManager$2
  implements GoogleApiClient.ConnectionCallbacks
{
  public GoogleIdTokenManager$2(GoogleIdTokenManager paramGoogleIdTokenManager, GoogleIdTokenListener paramGoogleIdTokenListener) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    GoogleIdTokenManager.access$200(this$0, val$googleIdTokenListener);
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */