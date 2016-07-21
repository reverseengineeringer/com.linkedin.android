package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface GoogleSignInApi
{
  public abstract PendingResult<Status> revokeAccess(GoogleApiClient paramGoogleApiClient);
  
  public abstract OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient paramGoogleApiClient);
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */