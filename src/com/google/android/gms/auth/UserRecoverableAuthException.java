package com.google.android.gms.auth;

import android.content.Intent;

public class UserRecoverableAuthException
  extends GoogleAuthException
{
  private final Intent mIntent;
  
  public UserRecoverableAuthException(String paramString, Intent paramIntent)
  {
    super(paramString);
    mIntent = paramIntent;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.UserRecoverableAuthException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */