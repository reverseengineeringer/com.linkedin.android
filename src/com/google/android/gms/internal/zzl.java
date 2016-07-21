package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzl
{
  private AtomicInteger zzY = new AtomicInteger();
  final Map<String, Queue<zzk<?>>> zzZ = new HashMap();
  final Set<zzk<?>> zzaa = new HashSet();
  final PriorityBlockingQueue<zzk<?>> zzab = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<zzk<?>> zzac = new PriorityBlockingQueue();
  private zzg[] zzad;
  private zzc zzae;
  List<Object> zzaf = new ArrayList();
  private final zzb zzj;
  private final zzn zzk;
  private final zzf zzz;
  
  private zzl(zzb paramzzb, zzf paramzzf)
  {
    this(paramzzb, paramzzf, new zze(new Handler(Looper.getMainLooper())));
  }
  
  public zzl(zzb paramzzb, zzf paramzzf, byte paramByte)
  {
    this(paramzzb, paramzzf);
  }
  
  private zzl(zzb paramzzb, zzf paramzzf, zzn paramzzn)
  {
    zzj = paramzzb;
    zzz = paramzzf;
    zzad = new zzg[4];
    zzk = paramzzn;
  }
  
  public final void start()
  {
    int j = 0;
    Object localObject;
    if (zzae != null)
    {
      localObject = zzae;
      zzl = true;
      ((zzc)localObject).interrupt();
    }
    int i = 0;
    while (i < zzad.length)
    {
      if (zzad[i] != null)
      {
        localObject = zzad[i];
        zzl = true;
        ((zzg)localObject).interrupt();
      }
      i += 1;
    }
    zzae = new zzc(zzab, zzac, zzj, zzk);
    zzae.start();
    i = j;
    while (i < zzad.length)
    {
      localObject = new zzg(zzac, zzz, zzj, zzk);
      zzad[i] = localObject;
      ((zzg)localObject).start();
      i += 1;
    }
  }
  
  public final <T> zzk<T> zze(zzk<T> paramzzk)
  {
    zzJ = this;
    synchronized (zzaa)
    {
      zzaa.add(paramzzk);
      zzI = Integer.valueOf(zzY.incrementAndGet());
      paramzzk.zzc("add-to-queue");
      if (!zzK)
      {
        zzac.add(paramzzk);
        return paramzzk;
      }
    }
    for (;;)
    {
      String str;
      synchronized (zzZ)
      {
        str = zzF;
        if (zzZ.containsKey(str))
        {
          Queue localQueue = (Queue)zzZ.get(str);
          ??? = localQueue;
          if (localQueue == null) {
            ??? = new LinkedList();
          }
          ((Queue)???).add(paramzzk);
          zzZ.put(str, ???);
          if (zzs.DEBUG) {
            zzs.zza("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return paramzzk;
        }
      }
      zzZ.put(str, null);
      zzab.add(paramzzk);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */