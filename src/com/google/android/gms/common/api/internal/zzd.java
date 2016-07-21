package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

public final class zzd
  implements zzp
{
  private final Context mContext;
  final Lock zzXG;
  private final zzj zzagW;
  final zzl zzagX;
  final zzl zzagY;
  private final Map<Api.zzc<?>, zzl> zzagZ = new ArrayMap();
  private final Looper zzagr;
  private final Set<zzu> zzaha = Collections.newSetFromMap(new WeakHashMap());
  private final Api.zzb zzahb;
  Bundle zzahc;
  ConnectionResult zzahd = null;
  ConnectionResult zzahe = null;
  boolean zzahf = false;
  private int zzahg = 0;
  
  public zzd(Context paramContext, zzj paramzzj, Lock paramLock, Looper paramLooper, com.google.android.gms.common.zzc paramzzc, Map<Api.zzc<?>, Api.zzb> paramMap, zzf paramzzf, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzrn, zzro> paramzza, ArrayList<zzc> paramArrayList)
  {
    mContext = paramContext;
    zzagW = paramzzj;
    zzXG = paramLock;
    zzagr = paramLooper;
    paramzzj = null;
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramMap.keySet().iterator();
    Api.zzc localzzc;
    while (((Iterator)localObject2).hasNext())
    {
      localzzc = (Api.zzc)((Iterator)localObject2).next();
      localObject1 = (Api.zzb)paramMap.get(localzzc);
      if (((Api.zzb)localObject1).zznb()) {
        paramzzj = (zzj)localObject1;
      }
      if (((Api.zzb)localObject1).zzmE()) {
        localArrayMap1.put(localzzc, localObject1);
      } else {
        localArrayMap2.put(localzzc, localObject1);
      }
    }
    zzahb = paramzzj;
    if (localArrayMap1.isEmpty()) {
      throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    }
    paramzzj = new ArrayMap();
    paramMap = new ArrayMap();
    Object localObject1 = paramMap1.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Api)((Iterator)localObject1).next();
      localzzc = ((Api)localObject2).zzoR();
      if (localArrayMap1.containsKey(localzzc)) {
        paramzzj.put(localObject2, paramMap1.get(localObject2));
      } else if (localArrayMap2.containsKey(localzzc)) {
        paramMap.put(localObject2, paramMap1.get(localObject2));
      } else {
        throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
      }
    }
    paramMap1 = new ArrayList();
    localObject1 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject2 = (zzc)paramArrayList.next();
      if (paramzzj.containsKey(zzagT)) {
        paramMap1.add(localObject2);
      } else if (paramMap.containsKey(zzagT)) {
        ((ArrayList)localObject1).add(localObject2);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
      }
    }
    paramArrayList = new zzp.zza()
    {
      public final void zzc(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        zzXG.lock();
        try
        {
          if ((zzahf) || (zzahe == null) || (!zzahe.isSuccess()))
          {
            zzahf = false;
            zzd.zza(zzd.this, paramAnonymousInt, paramAnonymousBoolean);
            return;
          }
          zzahf = true;
          zzagY.onConnectionSuspended(paramAnonymousInt);
          return;
        }
        finally
        {
          zzXG.unlock();
        }
      }
      
      public final void zzd(ConnectionResult paramAnonymousConnectionResult)
      {
        zzXG.lock();
        try
        {
          zzahd = paramAnonymousConnectionResult;
          zzd.zzb(zzd.this);
          return;
        }
        finally
        {
          zzXG.unlock();
        }
      }
      
      /* Error */
      public final void zzi(Bundle paramAnonymousBundle)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
        //   4: getfield 26	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
        //   7: invokeinterface 31 1 0
        //   12: aload_0
        //   13: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
        //   16: astore_2
        //   17: aload_2
        //   18: getfield 76	com/google/android/gms/common/api/internal/zzd:zzahc	Landroid/os/Bundle;
        //   21: ifnonnull +38 -> 59
        //   24: aload_2
        //   25: aload_1
        //   26: putfield 76	com/google/android/gms/common/api/internal/zzd:zzahc	Landroid/os/Bundle;
        //   29: aload_0
        //   30: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
        //   33: getstatic 79	com/google/android/gms/common/ConnectionResult:zzafB	Lcom/google/android/gms/common/ConnectionResult;
        //   36: putfield 67	com/google/android/gms/common/api/internal/zzd:zzahd	Lcom/google/android/gms/common/ConnectionResult;
        //   39: aload_0
        //   40: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
        //   43: invokestatic 70	com/google/android/gms/common/api/internal/zzd:zzb	(Lcom/google/android/gms/common/api/internal/zzd;)V
        //   46: aload_0
        //   47: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
        //   50: getfield 26	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
        //   53: invokeinterface 52 1 0
        //   58: return
        //   59: aload_1
        //   60: ifnull -31 -> 29
        //   63: aload_2
        //   64: getfield 76	com/google/android/gms/common/api/internal/zzd:zzahc	Landroid/os/Bundle;
        //   67: aload_1
        //   68: invokevirtual 84	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
        //   71: goto -42 -> 29
        //   74: astore_1
        //   75: aload_0
        //   76: getfield 16	com/google/android/gms/common/api/internal/zzd$1:zzahh	Lcom/google/android/gms/common/api/internal/zzd;
        //   79: getfield 26	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
        //   82: invokeinterface 52 1 0
        //   87: aload_1
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	1
        //   0	89	1	paramAnonymousBundle	Bundle
        //   16	48	2	localzzd	zzd
        // Exception table:
        //   from	to	target	type
        //   12	29	74	finally
        //   29	46	74	finally
        //   63	71	74	finally
      }
    };
    zzagX = new zzl(paramContext, zzagW, paramLock, paramLooper, paramzzc, localArrayMap2, null, paramMap, null, (ArrayList)localObject1, paramArrayList);
    paramMap = new zzp.zza()
    {
      public final void zzc(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        zzXG.lock();
        try
        {
          if (zzahf)
          {
            zzahf = false;
            zzd.zza(zzd.this, paramAnonymousInt, paramAnonymousBoolean);
            return;
          }
          zzahf = true;
          zzagX.onConnectionSuspended(paramAnonymousInt);
          return;
        }
        finally
        {
          zzXG.unlock();
        }
      }
      
      public final void zzd(ConnectionResult paramAnonymousConnectionResult)
      {
        zzXG.lock();
        try
        {
          zzahe = paramAnonymousConnectionResult;
          zzd.zzb(zzd.this);
          return;
        }
        finally
        {
          zzXG.unlock();
        }
      }
      
      public final void zzi(Bundle paramAnonymousBundle)
      {
        zzXG.lock();
        try
        {
          zzahe = ConnectionResult.zzafB;
          zzd.zzb(zzd.this);
          return;
        }
        finally
        {
          zzXG.unlock();
        }
      }
    };
    zzagY = new zzl(paramContext, zzagW, paramLock, paramLooper, paramzzc, localArrayMap1, paramzzf, paramzzj, paramzza, paramMap1, paramMap);
    paramContext = localArrayMap2.keySet().iterator();
    while (paramContext.hasNext())
    {
      paramzzj = (Api.zzc)paramContext.next();
      zzagZ.put(paramzzj, zzagX);
    }
    paramContext = localArrayMap1.keySet().iterator();
    while (paramContext.hasNext())
    {
      paramzzj = (Api.zzc)paramContext.next();
      zzagZ.put(paramzzj, zzagY);
    }
  }
  
  private void zzb(ConnectionResult paramConnectionResult)
  {
    switch (zzahg)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      zzahg = 0;
      return;
      zzagW.zzd(paramConnectionResult);
      zzpo();
    }
  }
  
  private static boolean zzc(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }
  
  private boolean zzc(zza.zza<? extends Result, ? extends Api.zzb> paramzza)
  {
    paramzza = zzaeE;
    zzx.zzb(zzagZ.containsKey(paramzza), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzl)zzagZ.get(paramzza)).equals(zzagY);
  }
  
  private void zzpo()
  {
    Iterator localIterator = zzaha.iterator();
    while (localIterator.hasNext()) {
      ((zzu)localIterator.next()).zzna();
    }
    zzaha.clear();
  }
  
  private boolean zzpp()
  {
    return (zzahe != null) && (zzahe.zzade == 4);
  }
  
  private PendingIntent zzpq()
  {
    if (zzahb == null) {
      return null;
    }
    return PendingIntent.getActivity(mContext, System.identityHashCode(zzagW), zzahb.zznc(), 134217728);
  }
  
  public final ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void connect()
  {
    zzahg = 2;
    zzahf = false;
    zzahe = null;
    zzahd = null;
    zzagX.connect();
    zzagY.connect();
  }
  
  public final boolean disconnect()
  {
    boolean bool2 = false;
    zzahe = null;
    zzahd = null;
    zzahg = 0;
    boolean bool3 = zzagX.disconnect();
    boolean bool4 = zzagY.disconnect();
    zzpo();
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    zzagY.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    zzagX.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  /* Error */
  public final boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 321 1 0
    //   11: aload_0
    //   12: getfield 166	com/google/android/gms/common/api/internal/zzd:zzagX	Lcom/google/android/gms/common/api/internal/zzl;
    //   15: invokevirtual 323	com/google/android/gms/common/api/internal/zzl:isConnected	()Z
    //   18: ifeq +47 -> 65
    //   21: iload_3
    //   22: istore_2
    //   23: aload_0
    //   24: getfield 169	com/google/android/gms/common/api/internal/zzd:zzagY	Lcom/google/android/gms/common/api/internal/zzl;
    //   27: invokevirtual 323	com/google/android/gms/common/api/internal/zzl:isConnected	()Z
    //   30: ifne +24 -> 54
    //   33: iload_3
    //   34: istore_2
    //   35: aload_0
    //   36: invokespecial 207	com/google/android/gms/common/api/internal/zzd:zzpp	()Z
    //   39: ifne +15 -> 54
    //   42: aload_0
    //   43: getfield 69	com/google/android/gms/common/api/internal/zzd:zzahg	I
    //   46: istore_1
    //   47: iload_1
    //   48: iconst_1
    //   49: if_icmpne +16 -> 65
    //   52: iload_3
    //   53: istore_2
    //   54: aload_0
    //   55: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   58: invokeinterface 326 1 0
    //   63: iload_2
    //   64: ireturn
    //   65: iconst_0
    //   66: istore_2
    //   67: goto -13 -> 54
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   76: invokeinterface 326 1 0
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	zzd
    //   46	4	1	i	int
    //   22	45	2	bool1	boolean
    //   1	52	3	bool2	boolean
    //   70	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	70	finally
    //   23	33	70	finally
    //   35	47	70	finally
  }
  
  /* Error */
  public final boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 321 1 0
    //   9: aload_0
    //   10: getfield 69	com/google/android/gms/common/api/internal/zzd:zzahg	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 326 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 326 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	zzd
    //   13	4	1	i	int
    //   20	14	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
  }
  
  public final <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    if (zzc(paramT))
    {
      if (zzpp())
      {
        paramT.zzw(new Status(4, null, zzpq()));
        return paramT;
      }
      return zzagY.zza(paramT);
    }
    return zzagX.zza(paramT);
  }
  
  public final boolean zza(zzu paramzzu)
  {
    zzXG.lock();
    try
    {
      if (((isConnecting()) || (isConnected())) && (!zzagY.isConnected()))
      {
        zzaha.add(paramzzu);
        if (zzahg == 0) {
          zzahg = 1;
        }
        zzahe = null;
        zzagY.connect();
        return true;
      }
      return false;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  public final <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    if (zzc(paramT))
    {
      if (zzpp())
      {
        paramT.zzw(new Status(4, null, zzpq()));
        return paramT;
      }
      return zzagY.zzb(paramT);
    }
    return zzagX.zzb(paramT);
  }
  
  /* Error */
  public final void zzoW()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 321 1 0
    //   9: aload_0
    //   10: invokevirtual 347	com/google/android/gms/common/api/internal/zzd:isConnecting	()Z
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 169	com/google/android/gms/common/api/internal/zzd:zzagY	Lcom/google/android/gms/common/api/internal/zzl;
    //   18: invokevirtual 220	com/google/android/gms/common/api/internal/zzl:disconnect	()Z
    //   21: pop
    //   22: aload_0
    //   23: new 225	com/google/android/gms/common/ConnectionResult
    //   26: dup
    //   27: iconst_4
    //   28: invokespecial 356	com/google/android/gms/common/ConnectionResult:<init>	(I)V
    //   31: putfield 65	com/google/android/gms/common/api/internal/zzd:zzahe	Lcom/google/android/gms/common/ConnectionResult;
    //   34: iload_1
    //   35: ifeq +36 -> 71
    //   38: new 358	android/os/Handler
    //   41: dup
    //   42: aload_0
    //   43: getfield 77	com/google/android/gms/common/api/internal/zzd:zzagr	Landroid/os/Looper;
    //   46: invokespecial 361	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   49: new 12	com/google/android/gms/common/api/internal/zzd$3
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 362	com/google/android/gms/common/api/internal/zzd$3:<init>	(Lcom/google/android/gms/common/api/internal/zzd;)V
    //   57: invokevirtual 366	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 326 1 0
    //   70: return
    //   71: aload_0
    //   72: invokespecial 201	com/google/android/gms/common/api/internal/zzd:zzpo	()V
    //   75: goto -14 -> 61
    //   78: astore_2
    //   79: aload_0
    //   80: getfield 75	com/google/android/gms/common/api/internal/zzd:zzXG	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 326 1 0
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	zzd
    //   13	22	1	bool	boolean
    //   78	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	34	78	finally
    //   38	61	78	finally
    //   71	75	78	finally
  }
  
  public final void zzpj()
  {
    zzagX.zzpj();
    zzagY.zzpj();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */