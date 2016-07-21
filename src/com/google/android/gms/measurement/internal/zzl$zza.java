package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlz;

public final class zzl$zza<V>
{
  private final V zzSA;
  private final zzlz<V> zzSB;
  private V zzSC;
  final String zzvs;
  
  private zzl$zza(String paramString, zzlz<V> paramzzlz, V paramV)
  {
    zzx.zzz(paramzzlz);
    zzSB = paramzzlz;
    zzSA = paramV;
    zzvs = paramString;
  }
  
  static zza<Integer> zzD(String paramString, int paramInt)
  {
    return new zza(paramString, zzlz.zza(paramString, Integer.valueOf(paramInt)), Integer.valueOf(paramInt));
  }
  
  static zza<Long> zze(String paramString, long paramLong)
  {
    return new zza(paramString, zzlz.zza(paramString, Long.valueOf(paramLong)), Long.valueOf(paramLong));
  }
  
  static zza<String> zzl(String paramString1, String paramString2, String paramString3)
  {
    return new zza(paramString1, zzlz.zzv(paramString1, paramString3), paramString2);
  }
  
  static zza<Boolean> zzm$2f5d3f0e(String paramString)
  {
    return new zza(paramString, zzlz.zzk$15457046(paramString), Boolean.valueOf(true));
  }
  
  public final V get()
  {
    if (zzSC != null) {
      return (V)zzSC;
    }
    if ((zzd.zzakE) && (zzlz.isInitialized())) {
      return (V)zzSB.zzpX();
    }
    return (V)zzSA;
  }
  
  public final V get(V paramV)
  {
    Object localObject;
    if (zzSC != null) {
      localObject = zzSC;
    }
    do
    {
      return (V)localObject;
      localObject = paramV;
    } while (paramV != null);
    if ((zzd.zzakE) && (zzlz.isInitialized())) {
      return (V)zzSB.zzpX();
    }
    return (V)zzSA;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */