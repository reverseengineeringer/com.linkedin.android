package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzhb
public final class zzcb
{
  final Object zzpV = new Object();
  private final Map<String, String> zzxA = new LinkedHashMap();
  zzcb zzxD;
  boolean zzxi = true;
  private final List<zzbz> zzxz = new LinkedList();
  
  public zzcb(String paramString1, String paramString2)
  {
    zzxA.put("action", paramString1);
    zzxA.put("ad_format", paramString2);
  }
  
  public final boolean zza(zzbz paramzzbz, long paramLong, String... paramVarArgs)
  {
    synchronized (zzpV)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        zzbz localzzbz = new zzbz(paramLong, paramVarArgs[i], paramzzbz);
        zzxz.add(localzzbz);
        i += 1;
      }
      return true;
    }
  }
  
  public final zzbz zzb(long paramLong)
  {
    if (!zzxi) {
      return null;
    }
    return new zzbz(paramLong, null, null);
  }
  
  public final void zzc(String paramString1, String paramString2)
  {
    if ((!zzxi) || (TextUtils.isEmpty(paramString2))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = zzr.zzbF().zzhb();
    } while (localObject1 == null);
    for (;;)
    {
      synchronized (zzpV)
      {
        localObject1 = (zzby)zzxo.get(paramString1);
        if (localObject1 != null)
        {
          Map localMap = zzxA;
          localMap.put(paramString1, ((zzby)localObject1).zzb((String)localMap.get(paramString1), paramString2));
          return;
        }
      }
      localObject1 = zzby.zzxs;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */