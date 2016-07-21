package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;

@zzhb
public final class zzbx
{
  public static boolean zza(zzcb paramzzcb, zzbz paramzzbz, String... paramVarArgs)
  {
    if ((paramzzcb == null) || (paramzzbz == null)) {}
    while ((!zzxi) || (paramzzbz == null)) {
      return false;
    }
    return paramzzcb.zza(paramzzbz, zzr.zzbG().elapsedRealtime(), paramVarArgs);
  }
  
  public static zzbz zzb(zzcb paramzzcb)
  {
    if (paramzzcb == null) {
      return null;
    }
    return paramzzcb.zzb(zzr.zzbG().elapsedRealtime());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */