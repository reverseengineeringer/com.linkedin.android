package com.linkedin.android.growth.login.smartlock;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract interface SmartLockCredentialRequestListener
{
  public abstract void onCredentialRequestFailed();
  
  public abstract void onCredentialRequestHintSelector(Status paramStatus);
  
  public abstract void onCredentialRequestMultipleResults(Status paramStatus);
  
  public abstract void onCredentialRequestSuccess(Credential paramCredential);
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.smartlock.SmartLockCredentialRequestListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */