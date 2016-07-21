package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

public final class zzf
{
  private static final zzf zzafS = new zzf();
  
  static zzd.zza zza(PackageInfo paramPackageInfo, zzd.zza... paramVarArgs)
  {
    if (signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = new zzd.zzb(signatures[0].toByteArray());
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
      Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(paramPackageInfo.getBytes(), 0));
    }
    return null;
  }
  
  public static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (signatures != null))
    {
      if (paramBoolean) {}
      for (paramPackageInfo = zza(paramPackageInfo, zzd.zzd.zzafK); paramPackageInfo != null; paramPackageInfo = zza(paramPackageInfo, new zzd.zza[] { zzd.zzd.zzafK[0] })) {
        return true;
      }
    }
    return false;
  }
  
  public static zzf zzoO()
  {
    return zzafS;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */