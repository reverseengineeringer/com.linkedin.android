package com.google.android.gms.auth.api.signin.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class zzm
{
  private static final WeakHashMap<String, zzm> zzXE = new WeakHashMap();
  private static final Lock zzXF = new ReentrantLock();
  private final Lock zzXG = new ReentrantLock();
  private final Map<String, zza> zzXH;
  
  private zzm(Map<String, zza> paramMap)
  {
    zzXH = paramMap;
  }
  
  public static zzm zzbN(String paramString)
  {
    zzx.zzcM(paramString);
    zzXF.lock();
    try
    {
      zzm localzzm2 = (zzm)zzXE.get(paramString);
      zzm localzzm1 = localzzm2;
      if (localzzm2 == null)
      {
        localzzm1 = new zzm(new zzb());
        zzXE.put(paramString, localzzm1);
      }
      return localzzm1;
    }
    finally
    {
      zzXF.unlock();
    }
  }
  
  public final boolean zza(Set<String> paramSet, zza paramzza)
  {
    zzx.zzz(paramSet);
    zzx.zzz(paramzza);
    if (paramSet.size() != 0) {
      if (zzqW.currentTimeMillis() / 1000L < zzXJ - 300L) {
        break label52;
      }
    }
    label52:
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    paramSet = new ArrayList(paramSet);
    Collections.sort(paramSet);
    zzXG.lock();
    try
    {
      paramSet = TextUtils.join(" ", paramSet);
      zzXH.put(paramSet, paramzza);
      return true;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  public static final class zza
  {
    private final String zzXI;
    final long zzXJ;
    final zzmq zzqW;
    
    public zza(String paramString, long paramLong)
    {
      this(paramString, paramLong, zzmt.zzsc());
    }
    
    private zza(String paramString, long paramLong, zzmq paramzzmq)
    {
      zzXI = zzx.zzcM(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzac(bool);
        zzXJ = paramLong;
        zzqW = ((zzmq)zzx.zzz(paramzzmq));
        return;
      }
    }
  }
  
  static final class zzb<K, V>
    extends LinkedHashMap<K, V>
  {
    private final int zzav = 20;
    
    protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      return size() > zzav;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */