package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

final class ProviderInstaller$1
  extends AsyncTask<Void, Void, Integer>
{
  ProviderInstaller$1(Context paramContext, ProviderInstaller.ProviderInstallListener paramProviderInstallListener) {}
  
  private Integer zzc$9ecd34e()
  {
    try
    {
      ProviderInstaller.installIfNeeded(zzxh);
      return Integer.valueOf(0);
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      return Integer.valueOf(zzVn);
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      return Integer.valueOf(errorCode);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.security.ProviderInstaller.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */