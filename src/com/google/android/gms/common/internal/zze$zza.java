package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zze$zza
  extends zze
{
  List<zze> zzala;
  
  zze$zza(List<zze> paramList)
  {
    zzala = paramList;
  }
  
  public final zze zza(zze paramzze)
  {
    ArrayList localArrayList = new ArrayList(zzala);
    localArrayList.add(zzx.zzz(paramzze));
    return new zza(localArrayList);
  }
  
  public final boolean zzd(char paramChar)
  {
    Iterator localIterator = zzala.iterator();
    while (localIterator.hasNext()) {
      if (((zze)localIterator.next()).zzd(paramChar)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zze.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */