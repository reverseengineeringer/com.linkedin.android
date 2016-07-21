package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.UserRecoverableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;
import java.io.IOException;

public final class GoogleAuthUtil
  extends zzd
{
  public static final String KEY_ANDROID_PACKAGE_NAME = zzd.KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID = zzd.KEY_CALLER_UID;
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    paramString1 = new Account(paramString1, "com.google");
    Bundle localBundle = new Bundle();
    zzx.zzcE("Calling this from your main thread can lead to deadlock");
    try
    {
      zze.zzad(paramContext.getApplicationContext());
      localBundle = new Bundle(localBundle);
      String str = getApplicationInfopackageName;
      localBundle.putString("clientPackageName", str);
      if (TextUtils.isEmpty(localBundle.getString(zzd.KEY_ANDROID_PACKAGE_NAME))) {
        localBundle.putString(zzd.KEY_ANDROID_PACKAGE_NAME, str);
      }
      localBundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
      paramString1 = new zzd.1(paramString1, paramString2, localBundle);
      return zzazzVezzVo;
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(zzVn, paramContext.getMessage(), new Intent(mIntent));
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      throw new GoogleAuthException(paramContext.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.GoogleAuthUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */