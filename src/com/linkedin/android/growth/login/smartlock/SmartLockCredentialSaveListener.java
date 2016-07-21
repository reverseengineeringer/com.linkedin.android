package com.linkedin.android.growth.login.smartlock;

import com.google.android.gms.common.api.Status;

public abstract interface SmartLockCredentialSaveListener
{
  public abstract void onCredentialSaveFail();
  
  public abstract void onCredentialSaveResolution(Status paramStatus);
  
  public abstract void onCredentialSaveSuccess();
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.smartlock.SmartLockCredentialSaveListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */