package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzd
{
  Context context;
  SharedPreferences zzaNt;
  
  public zzd(Context paramContext)
  {
    this(paramContext, "com.google.android.gms.appid");
  }
  
  private zzd(Context paramContext, String paramString)
  {
    context = paramContext;
    zzaNt = paramContext.getSharedPreferences(paramString, 4);
    paramString = paramString + "-no-backup";
    new ContextCompat();
    paramContext = context;
    if (Build.VERSION.SDK_INT >= 21) {
      paramContext = paramContext.getNoBackupFilesDir();
    }
    for (;;)
    {
      paramContext = new File(paramContext, paramString);
      if (!paramContext.exists()) {}
      try
      {
        if ((paramContext.createNewFile()) && (!isEmpty()))
        {
          Log.i("InstanceID/Store", "App restored, clearing state");
          InstanceIDListenerService.zza(context, this);
        }
        return;
        paramContext = ContextCompat.createFilesDir(new File(getApplicationInfodataDir, "no_backup"));
      }
      catch (IOException paramContext)
      {
        while (!Log.isLoggable("InstanceID/Store", 3)) {}
        Log.d("InstanceID/Store", "Error creating file in no backup dir: " + paramContext.getMessage());
      }
    }
  }
  
  private String get(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = zzaNt.getString(paramString1 + "|S|" + paramString2, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private void zza(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramEditor.putString(paramString1 + "|S|" + paramString2, paramString3);
      return;
    }
    finally
    {
      paramEditor = finally;
      throw paramEditor;
    }
  }
  
  private static String zzh(String paramString1, String paramString2, String paramString3)
  {
    return paramString1 + "|T|" + paramString2 + "|" + paramString3;
  }
  
  public final String get(String paramString)
  {
    try
    {
      paramString = zzaNt.getString(paramString, null);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final boolean isEmpty()
  {
    return zzaNt.getAll().isEmpty();
  }
  
  public final void zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = zzh(paramString1, paramString2, paramString3);
      paramString2 = zzaNt.edit();
      paramString2.putString(paramString1, paramString4);
      paramString2.putString("appVersion", paramString5);
      paramString2.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  final KeyPair zzd(String paramString, long paramLong)
  {
    try
    {
      KeyPair localKeyPair = zza.zzyy();
      SharedPreferences.Editor localEditor = zzaNt.edit();
      zza(localEditor, paramString, "|P|", InstanceID.zzn(localKeyPair.getPublic().getEncoded()));
      zza(localEditor, paramString, "|K|", InstanceID.zzn(localKeyPair.getPrivate().getEncoded()));
      zza(localEditor, paramString, "cre", Long.toString(paramLong));
      localEditor.commit();
      return localKeyPair;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void zzec(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = zzaNt.edit();
      Iterator localIterator = zzaNt.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
    }
    finally {}
  }
  
  public final void zzef(String paramString)
  {
    zzec(paramString + "|T|");
  }
  
  final KeyPair zzeg(String paramString)
  {
    Object localObject1 = get(paramString, "|P|");
    Object localObject2 = get(paramString, "|K|");
    if (localObject2 == null) {
      return null;
    }
    try
    {
      paramString = Base64.decode((String)localObject1, 8);
      localObject1 = Base64.decode((String)localObject2, 8);
      localObject2 = KeyFactory.getInstance("RSA");
      paramString = new KeyPair(((KeyFactory)localObject2).generatePublic(new X509EncodedKeySpec(paramString)), ((KeyFactory)localObject2).generatePrivate(new PKCS8EncodedKeySpec((byte[])localObject1)));
      return paramString;
    }
    catch (InvalidKeySpecException paramString)
    {
      Log.w("InstanceID/Store", "Invalid key stored " + paramString);
      InstanceIDListenerService.zza(context, this);
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
  }
  
  public final String zzi(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzh(paramString1, paramString2, paramString3);
      paramString1 = zzaNt.getString(paramString1, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void zzyG()
  {
    try
    {
      zzaNt.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */