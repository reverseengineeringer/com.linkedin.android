package com.google.android.gms.auth;

import android.content.Intent;

public final class GooglePlayServicesAvailabilityException
  extends UserRecoverableAuthException
{
  private final int zzVn;
  
  GooglePlayServicesAvailabilityException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    zzVn = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.GooglePlayServicesAvailabilityException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */