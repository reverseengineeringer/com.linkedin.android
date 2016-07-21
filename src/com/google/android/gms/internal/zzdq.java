package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzhb
public final class zzdq
  implements Iterable<zzdp>
{
  final List<zzdp> zzzM = new LinkedList();
  
  public static boolean zzd(zzjp paramzzjp)
  {
    return zzf(paramzzjp) != null;
  }
  
  static zzdp zzf(zzjp paramzzjp)
  {
    Iterator localIterator = zzr.zzbR().iterator();
    while (localIterator.hasNext())
    {
      zzdp localzzdp = (zzdp)localIterator.next();
      if (zzpD == paramzzjp) {
        return localzzdp;
      }
    }
    return null;
  }
  
  public final Iterator<zzdp> iterator()
  {
    return zzzM.iterator();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */