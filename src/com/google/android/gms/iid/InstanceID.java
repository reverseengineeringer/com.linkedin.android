package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public final class InstanceID
{
  static Map<String, InstanceID> zzaMP = new HashMap();
  public static zzd zzaMQ;
  private static zzc zzaMR;
  public static String zzaMV;
  Context mContext;
  KeyPair zzaMS;
  public String zzaMT = "";
  long zzaMU;
  
  private InstanceID(Context paramContext, String paramString)
  {
    mContext = paramContext.getApplicationContext();
    zzaMT = paramString;
  }
  
  public static InstanceID getInstance(Context paramContext)
  {
    return zza(paramContext, null);
  }
  
  public static InstanceID zza(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      try
      {
        Context localContext = paramContext.getApplicationContext();
        if (zzaMQ == null)
        {
          zzaMQ = new zzd(localContext);
          zzaMR = new zzc(localContext);
        }
        zzaMV = Integer.toString(zzaL(localContext));
        InstanceID localInstanceID = (InstanceID)zzaMP.get(paramBundle);
        paramContext = localInstanceID;
        if (localInstanceID == null)
        {
          paramContext = new InstanceID(localContext, paramBundle);
          zzaMP.put(paramBundle, paramContext);
        }
        return paramContext;
      }
      finally {}
      paramBundle = paramBundle.getString("subtype");
      while (paramBundle != null) {
        break;
      }
      paramBundle = "";
    }
  }
  
  static String zza(KeyPair paramKeyPair)
  {
    paramKeyPair = paramKeyPair.getPublic().getEncoded();
    try
    {
      paramKeyPair = MessageDigest.getInstance("SHA1").digest(paramKeyPair);
      paramKeyPair[0] = ((byte)((paramKeyPair[0] & 0xF) + 112 & 0xFF));
      paramKeyPair = Base64.encodeToString(paramKeyPair, 0, 8, 11);
      return paramKeyPair;
    }
    catch (NoSuchAlgorithmException paramKeyPair)
    {
      Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
    }
    return null;
  }
  
  static int zzaL(Context paramContext)
  {
    try
    {
      int i = getPackageManagergetPackageInfogetPackageName0versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("InstanceID", "Never happens: can't find own package " + paramContext);
    }
    return 0;
  }
  
  static String zzn(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
  
  public static zzd zzyB()
  {
    return zzaMQ;
  }
  
  static zzc zzyC()
  {
    return zzaMR;
  }
  
  public final String zzc(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    paramBundle.putString("scope", paramString2);
    paramBundle.putString("sender", paramString1);
    if ("".equals(zzaMT)) {}
    for (paramString2 = paramString1;; paramString2 = zzaMT)
    {
      if (!paramBundle.containsKey("legacy.register"))
      {
        paramBundle.putString("subscription", paramString1);
        paramBundle.putString("subtype", paramString2);
        paramBundle.putString("X-subscription", paramString1);
        paramBundle.putString("X-subtype", paramString2);
      }
      zzc localzzc = zzaMR;
      if (zzaMS == null) {
        zzaMS = zzaMQ.zzeg(zzaMT);
      }
      if (zzaMS == null)
      {
        zzaMU = System.currentTimeMillis();
        zzaMS = zzaMQ.zzd(zzaMT, zzaMU);
      }
      KeyPair localKeyPair = zzaMS;
      paramString2 = localzzc.zzb(paramBundle, localKeyPair);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.hasExtra("google.messenger")) {
          paramString1 = localzzc.zzb(paramBundle, localKeyPair);
        }
      }
      return zzc.zzu(paramString1);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.InstanceID
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */