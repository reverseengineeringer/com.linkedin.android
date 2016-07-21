package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public final class ProviderInstaller
{
  private static final zzc zzbgP = ;
  private static Method zzbgQ = null;
  private static final Object zzqy = new Object();
  
  public static void installIfNeeded(Context arg0)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    zzx.zzb(???, "Context must not be null");
    zzc.zzak(???);
    Context localContext = zze.getRemoteContext(???);
    if (localContext == null)
    {
      Log.e("ProviderInstaller", "Failed to get remote context");
      throw new GooglePlayServicesNotAvailableException(8);
    }
    synchronized (zzqy)
    {
      try
      {
        if (zzbgQ == null) {
          zzbgQ = localContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
        }
        zzbgQ.invoke(null, new Object[] { localContext });
        return;
      }
      catch (Exception localException)
      {
        Log.e("ProviderInstaller", "Failed to install provider: " + localException.getMessage());
        throw new GooglePlayServicesNotAvailableException(8);
      }
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, final ProviderInstallListener paramProviderInstallListener)
  {
    zzx.zzb(paramContext, "Context must not be null");
    zzx.zzb(paramProviderInstallListener, "Listener must not be null");
    zzx.zzcD("Must be called on the UI thread");
    new AsyncTask()
    {
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
    }.execute(new Void[0]);
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed$10b55c15(int paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.security.ProviderInstaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */