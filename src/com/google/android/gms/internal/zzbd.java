package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzhb
public final class zzbd
{
  final Object zzpV = new Object();
  int zzsW;
  List<zzbc> zzsX = new LinkedList();
  
  public final boolean zza(zzbc paramzzbc)
  {
    synchronized (zzpV)
    {
      return zzsX.contains(paramzzbc);
    }
  }
  
  public final boolean zzb(zzbc paramzzbc)
  {
    synchronized (zzpV)
    {
      Iterator localIterator = zzsX.iterator();
      while (localIterator.hasNext())
      {
        zzbc localzzbc = (zzbc)localIterator.next();
        if ((paramzzbc != localzzbc) && (zzsU.equals(zzsU)))
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */