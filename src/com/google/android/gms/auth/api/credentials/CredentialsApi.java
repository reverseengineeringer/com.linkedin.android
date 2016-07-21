package com.google.android.gms.auth.api.credentials;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface CredentialsApi
{
  public abstract PendingResult<Status> disableAutoSignIn(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingIntent getHintPickerIntent(GoogleApiClient paramGoogleApiClient, HintRequest paramHintRequest);
  
  public abstract PendingResult<CredentialRequestResult> request(GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest);
  
  public abstract PendingResult<Status> save(GoogleApiClient paramGoogleApiClient, Credential paramCredential);
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialsApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */