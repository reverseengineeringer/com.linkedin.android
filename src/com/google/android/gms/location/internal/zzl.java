package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

public final class zzl
  extends zzb
{
  final zzk zzaOM = new zzk(paramContext, zzaOt);
  
  public zzl(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramzzf);
  }
  
  /* Error */
  public final void disconnect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/google/android/gms/location/internal/zzl:zzaOM	Lcom/google/android/gms/location/internal/zzk;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 32	com/google/android/gms/location/internal/zzl:isConnected	()Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifeq +112 -> 125
    //   16: aload_0
    //   17: getfield 21	com/google/android/gms/location/internal/zzl:zzaOM	Lcom/google/android/gms/location/internal/zzk;
    //   20: astore_3
    //   21: aload_3
    //   22: getfield 36	com/google/android/gms/location/internal/zzk:zzaxd	Ljava/util/Map;
    //   25: astore 4
    //   27: aload 4
    //   29: monitorenter
    //   30: aload_3
    //   31: getfield 36	com/google/android/gms/location/internal/zzk:zzaxd	Ljava/util/Map;
    //   34: invokeinterface 42 1 0
    //   39: invokeinterface 48 1 0
    //   44: astore 5
    //   46: aload 5
    //   48: invokeinterface 53 1 0
    //   53: ifeq +79 -> 132
    //   56: aload 5
    //   58: invokeinterface 57 1 0
    //   63: checkcast 59	com/google/android/gms/location/internal/zzk$zzc
    //   66: astore 6
    //   68: aload 6
    //   70: ifnull -24 -> 46
    //   73: aload_3
    //   74: getfield 60	com/google/android/gms/location/internal/zzk:zzaOt	Lcom/google/android/gms/location/internal/zzp;
    //   77: invokeinterface 66 1 0
    //   82: checkcast 68	com/google/android/gms/location/internal/zzi
    //   85: aload 6
    //   87: aconst_null
    //   88: invokestatic 74	com/google/android/gms/location/internal/LocationRequestUpdateData:zza	(Lcom/google/android/gms/location/zzd;Lcom/google/android/gms/location/internal/zzg;)Lcom/google/android/gms/location/internal/LocationRequestUpdateData;
    //   91: invokeinterface 77 2 0
    //   96: goto -50 -> 46
    //   99: astore_3
    //   100: aload 4
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    //   105: astore_3
    //   106: new 79	java/lang/IllegalStateException
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 82	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   114: athrow
    //   115: astore_3
    //   116: ldc 84
    //   118: ldc 86
    //   120: aload_3
    //   121: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   124: pop
    //   125: aload_0
    //   126: invokespecial 94	com/google/android/gms/location/internal/zzb:disconnect	()V
    //   129: aload_2
    //   130: monitorexit
    //   131: return
    //   132: aload_3
    //   133: getfield 36	com/google/android/gms/location/internal/zzk:zzaxd	Ljava/util/Map;
    //   136: invokeinterface 97 1 0
    //   141: aload 4
    //   143: monitorexit
    //   144: aload_3
    //   145: getfield 100	com/google/android/gms/location/internal/zzk:zzaOI	Ljava/util/Map;
    //   148: astore 4
    //   150: aload 4
    //   152: monitorenter
    //   153: aload_3
    //   154: getfield 100	com/google/android/gms/location/internal/zzk:zzaOI	Ljava/util/Map;
    //   157: invokeinterface 42 1 0
    //   162: invokeinterface 48 1 0
    //   167: astore 5
    //   169: aload 5
    //   171: invokeinterface 53 1 0
    //   176: ifeq +56 -> 232
    //   179: aload 5
    //   181: invokeinterface 57 1 0
    //   186: checkcast 102	com/google/android/gms/location/internal/zzk$zza
    //   189: astore 6
    //   191: aload 6
    //   193: ifnull -24 -> 169
    //   196: aload_3
    //   197: getfield 60	com/google/android/gms/location/internal/zzk:zzaOt	Lcom/google/android/gms/location/internal/zzp;
    //   200: invokeinterface 66 1 0
    //   205: checkcast 68	com/google/android/gms/location/internal/zzi
    //   208: aload 6
    //   210: invokestatic 106	com/google/android/gms/location/internal/LocationRequestUpdateData:zza$4141d7	(Lcom/google/android/gms/location/zzc;)Lcom/google/android/gms/location/internal/LocationRequestUpdateData;
    //   213: invokeinterface 77 2 0
    //   218: goto -49 -> 169
    //   221: astore_3
    //   222: aload 4
    //   224: monitorexit
    //   225: aload_3
    //   226: athrow
    //   227: astore_3
    //   228: aload_2
    //   229: monitorexit
    //   230: aload_3
    //   231: athrow
    //   232: aload_3
    //   233: getfield 100	com/google/android/gms/location/internal/zzk:zzaOI	Ljava/util/Map;
    //   236: invokeinterface 97 1 0
    //   241: aload 4
    //   243: monitorexit
    //   244: aload_0
    //   245: getfield 21	com/google/android/gms/location/internal/zzl:zzaOM	Lcom/google/android/gms/location/internal/zzk;
    //   248: astore_3
    //   249: aload_3
    //   250: getfield 110	com/google/android/gms/location/internal/zzk:zzaOH	Z
    //   253: istore_1
    //   254: iload_1
    //   255: ifeq -130 -> 125
    //   258: aload_3
    //   259: getfield 60	com/google/android/gms/location/internal/zzk:zzaOt	Lcom/google/android/gms/location/internal/zzp;
    //   262: invokeinterface 113 1 0
    //   267: aload_3
    //   268: getfield 60	com/google/android/gms/location/internal/zzk:zzaOt	Lcom/google/android/gms/location/internal/zzp;
    //   271: invokeinterface 66 1 0
    //   276: checkcast 68	com/google/android/gms/location/internal/zzi
    //   279: iconst_0
    //   280: invokeinterface 117 2 0
    //   285: aload_3
    //   286: iconst_0
    //   287: putfield 110	com/google/android/gms/location/internal/zzk:zzaOH	Z
    //   290: goto -165 -> 125
    //   293: astore_3
    //   294: new 79	java/lang/IllegalStateException
    //   297: dup
    //   298: aload_3
    //   299: invokespecial 82	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	zzl
    //   11	244	1	bool	boolean
    //   4	225	2	localzzk1	zzk
    //   20	54	3	localzzk2	zzk
    //   99	5	3	localObject1	Object
    //   105	6	3	localRemoteException1	android.os.RemoteException
    //   115	82	3	localException	Exception
    //   221	5	3	localObject2	Object
    //   227	6	3	localObject3	Object
    //   248	38	3	localzzk3	zzk
    //   293	6	3	localRemoteException2	android.os.RemoteException
    //   44	136	5	localIterator	java.util.Iterator
    //   66	143	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   30	46	99	finally
    //   46	68	99	finally
    //   73	96	99	finally
    //   100	103	99	finally
    //   132	144	99	finally
    //   21	30	105	android/os/RemoteException
    //   103	105	105	android/os/RemoteException
    //   144	153	105	android/os/RemoteException
    //   225	227	105	android/os/RemoteException
    //   16	21	115	java/lang/Exception
    //   21	30	115	java/lang/Exception
    //   103	105	115	java/lang/Exception
    //   106	115	115	java/lang/Exception
    //   144	153	115	java/lang/Exception
    //   225	227	115	java/lang/Exception
    //   244	254	115	java/lang/Exception
    //   258	290	115	java/lang/Exception
    //   294	303	115	java/lang/Exception
    //   153	169	221	finally
    //   169	191	221	finally
    //   196	218	221	finally
    //   222	225	221	finally
    //   232	244	221	finally
    //   7	12	227	finally
    //   16	21	227	finally
    //   21	30	227	finally
    //   103	105	227	finally
    //   106	115	227	finally
    //   116	125	227	finally
    //   125	131	227	finally
    //   144	153	227	finally
    //   225	227	227	finally
    //   228	230	227	finally
    //   244	254	227	finally
    //   258	290	227	finally
    //   294	303	227	finally
    //   258	290	293	android/os/RemoteException
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */