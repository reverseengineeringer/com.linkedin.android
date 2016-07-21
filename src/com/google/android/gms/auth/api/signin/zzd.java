package com.google.android.gms.auth.api.signin;

import android.util.Log;
import com.google.android.gms.R.string;

public enum zzd
{
  private final String zzVY;
  public final String zzXj;
  public final int zzXk;
  
  private zzd(String paramString1, int paramInt, String paramString2)
  {
    zzXj = paramString1;
    zzXk = paramInt;
    zzVY = paramString2;
  }
  
  public static zzd zzbL(String paramString)
  {
    if (paramString != null)
    {
      zzd[] arrayOfzzd = values();
      int j = arrayOfzzd.length;
      int i = 0;
      while (i < j)
      {
        zzd localzzd = arrayOfzzd[i];
        if (zzXj.equals(paramString)) {
          return localzzd;
        }
        i += 1;
      }
      Log.w("IdProvider", "Unrecognized providerId: " + paramString);
    }
    return null;
  }
  
  public final String toString()
  {
    return zzXj;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */