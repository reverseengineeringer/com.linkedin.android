package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;

public final class zzan
{
  static final String[] zzov = { "/aclk", "/pcs/click" };
  private String zzot;
  private String[] zzou;
  zzaj zzow;
  
  private boolean zza(Uri paramUri)
  {
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      boolean bool = paramUri.getHost().equals(zzot);
      return bool;
    }
    catch (NullPointerException paramUri) {}
    return false;
  }
  
  private Uri zza$30807dd5(Uri paramUri)
    throws zzao
  {
    boolean bool;
    try
    {
      bool = zza(paramUri);
      if (bool)
      {
        if (!paramUri.toString().contains("dc_ms=")) {
          break label64;
        }
        throw new zzao("Parameter already exists: dc_ms");
      }
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new zzao("Provided Uri is not in a valid state");
    }
    if (paramUri.getQueryParameter("ms") != null) {
      throw new zzao("Query parameter already exists: ms");
    }
    label64:
    String str1 = zzow.zzb$5b1592bd();
    if (bool)
    {
      str2 = paramUri.toString();
      i = str2.indexOf(";adurl");
      if (i != -1) {
        return Uri.parse(str2.substring(0, i + 1) + "dc_ms" + "=" + str1 + ";" + str2.substring(i + 1));
      }
      paramUri = paramUri.getEncodedPath();
      i = str2.indexOf(paramUri);
      return Uri.parse(str2.substring(0, paramUri.length() + i) + ";" + "dc_ms" + "=" + str1 + ";" + str2.substring(paramUri.length() + i));
    }
    String str2 = paramUri.toString();
    int j = str2.indexOf("&adurl");
    int i = j;
    if (j == -1) {
      i = str2.indexOf("?adurl");
    }
    if (i != -1) {
      return Uri.parse(str2.substring(0, i + 1) + "ms" + "=" + str1 + "&" + str2.substring(i + 1));
    }
    paramUri = paramUri.buildUpon().appendQueryParameter("ms", str1).build();
    return paramUri;
  }
  
  public final Uri zza$7d090533(Uri paramUri)
    throws zzao
  {
    try
    {
      paramUri.getQueryParameter("ai");
      paramUri = zza$30807dd5(paramUri);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      throw new zzao("Provided Uri is not in a valid state");
    }
  }
  
  public final boolean zzb(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      throw new NullPointerException();
    }
    try
    {
      paramUri = paramUri.getHost();
      String[] arrayOfString = zzou;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          bool1 = paramUri.endsWith(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (NullPointerException paramUri) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */