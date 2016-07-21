package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzx;

public final class zzt$zza
{
  private final boolean zzaXy;
  private boolean zzaXz;
  private boolean zzagf;
  private final String zzvs;
  
  public zzt$zza(zzt paramzzt, String paramString)
  {
    zzx.zzcM(paramString);
    zzvs = paramString;
    zzaXy = true;
  }
  
  public final boolean get()
  {
    if (!zzaXz)
    {
      zzaXz = true;
      zzagf = zzt.zza(zzaXA).getBoolean(zzvs, zzaXy);
    }
    return zzagf;
  }
  
  public final void set(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = zzt.zza(zzaXA).edit();
    localEditor.putBoolean(zzvs, paramBoolean);
    localEditor.apply();
    zzagf = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzt.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */