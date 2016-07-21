package com.google.android.gms.common;

import android.content.Intent;

public final class GooglePlayServicesRepairableException
  extends UserRecoverableException
{
  public final int zzVn;
  
  GooglePlayServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    zzVn = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesRepairableException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */