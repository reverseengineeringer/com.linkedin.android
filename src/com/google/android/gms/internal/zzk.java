package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

public abstract class zzk<T>
  implements Comparable<zzk<T>>
{
  private final zzs.zza zzD;
  final int zzE;
  final String zzF;
  final int zzG;
  final zzm.zza zzH;
  Integer zzI;
  zzl zzJ;
  boolean zzK;
  boolean zzL;
  boolean zzM;
  private long zzN;
  zzo zzO;
  zzb.zza zzP;
  
  public zzk(String paramString, zzm.zza paramzza)
  {
    zzs.zza localzza;
    if (zzs.zza.zzak)
    {
      localzza = new zzs.zza();
      zzD = localzza;
      zzK = true;
      zzL = false;
      zzM = false;
      zzN = 0L;
      zzP = null;
      zzE = 0;
      zzF = paramString;
      zzH = paramzza;
      zzO = new zzd();
      if (TextUtils.isEmpty(paramString)) {
        break label118;
      }
      paramString = Uri.parse(paramString);
      if (paramString == null) {
        break label118;
      }
      paramString = paramString.getHost();
      if (paramString == null) {
        break label118;
      }
    }
    label118:
    for (int i = paramString.hashCode();; i = 0)
    {
      zzG = i;
      return;
      localzza = null;
      break;
    }
  }
  
  protected static zzr zzb(zzr paramzzr)
  {
    return paramzzr;
  }
  
  public static String zzp()
  {
    return "application/x-www-form-urlencoded; charset=UTF-8";
  }
  
  public Map<String, String> getHeaders()
    throws zza
  {
    return Collections.emptyMap();
  }
  
  public String toString()
  {
    String str2 = "0x" + Integer.toHexString(zzG);
    StringBuilder localStringBuilder = new StringBuilder();
    if (zzL) {}
    for (String str1 = "[X] ";; str1 = "[ ] ") {
      return str1 + zzF + " " + str2 + " " + zza.zzU + " " + zzI;
    }
  }
  
  protected abstract zzm<T> zza(zzi paramzzi);
  
  protected abstract void zza(T paramT);
  
  public final void zzc(String paramString)
  {
    if (zzs.zza.zzak) {
      zzD.zza(paramString, Thread.currentThread().getId());
    }
    while (zzN != 0L) {
      return;
    }
    zzN = SystemClock.elapsedRealtime();
  }
  
  final void zzd(final String paramString)
  {
    zzl localzzl;
    Object localObject2;
    if (zzJ != null)
    {
      localzzl = zzJ;
      synchronized (zzaa)
      {
        zzaa.remove(this);
        synchronized (zzaf)
        {
          localObject2 = zzaf.iterator();
          if (((Iterator)localObject2).hasNext()) {
            ((Iterator)localObject2).next();
          }
        }
      }
      if (!zzK) {}
    }
    final long l;
    label262:
    do
    {
      synchronized (zzZ)
      {
        localObject2 = zzF;
        Queue localQueue = (Queue)zzZ.remove(localObject2);
        if (localQueue != null)
        {
          if (zzs.DEBUG) {
            zzs.zza("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(localQueue.size()), localObject2 });
          }
          zzab.addAll(localQueue);
        }
        if (!zzs.zza.zzak) {
          break label262;
        }
        l = Thread.currentThread().getId();
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              zzk.zzd(zzk.this).zza(paramString, l);
              zzk.zzd(zzk.this).zzd(toString());
            }
          });
          return;
        }
      }
      zzD.zza(paramString, l);
      zzD.zzd(toString());
      return;
      l = SystemClock.elapsedRealtime() - zzN;
    } while (l < 3000L);
    zzs.zzb("%d ms: %s", new Object[] { Long.valueOf(l), toString() });
  }
  
  public final int zzt()
  {
    return zzO.zzd();
  }
  
  public static enum zza
  {
    private zza() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */