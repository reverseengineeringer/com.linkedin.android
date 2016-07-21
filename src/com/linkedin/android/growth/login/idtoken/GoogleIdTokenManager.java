package com.linkedin.android.growth.login.idtoken;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import javax.inject.Inject;

public class GoogleIdTokenManager
{
  private static final String TAG = GoogleIdTokenManager.class.getSimpleName();
  public final BaseActivity activity;
  public GoogleApiClient googleApiClient;
  private Tracker tracker;
  
  @Inject
  public GoogleIdTokenManager(BaseActivity paramBaseActivity, Tracker paramTracker)
  {
    activity = paramBaseActivity;
    tracker = paramTracker;
  }
  
  private void disconnect()
  {
    if (googleApiClient != null) {
      googleApiClient.disconnect();
    }
  }
  
  private static String getIdToken(GoogleSignInResult paramGoogleSignInResult)
  {
    if (zzUX.isSuccess())
    {
      paramGoogleSignInResult = zzXg;
      if (paramGoogleSignInResult != null) {
        return zzWk;
      }
      Log.e(TAG, "getIdToken: GoogleSignInAccount is null");
    }
    for (;;)
    {
      return null;
      Log.e(TAG, "getIdToken: GoogleSignInResult failed");
    }
  }
  
  private void onIdTokenResult(String paramString, GoogleIdTokenListener paramGoogleIdTokenListener)
  {
    disconnect();
    if (!TextUtils.isEmpty(paramString))
    {
      paramGoogleIdTokenListener.onFetchSucceed(paramString);
      return;
    }
    Log.e(TAG, "onIdTokenResult: ID token is null");
    paramGoogleIdTokenListener.onFetchFailed();
  }
  
  public final void sendTrackingEvent(String paramString)
  {
    new ControlInteractionEvent(tracker, paramString, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */