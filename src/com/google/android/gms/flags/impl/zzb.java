package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzpl;
import java.util.concurrent.Callable;

public final class zzb
{
  private static SharedPreferences zzaBZ = null;
  
  public static SharedPreferences zzw(Context paramContext)
  {
    try
    {
      if (zzaBZ == null) {
        zzaBZ = (SharedPreferences)zzpl.zzb(new Callable() {});
      }
      paramContext = zzaBZ;
      return paramContext;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.flags.impl.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */