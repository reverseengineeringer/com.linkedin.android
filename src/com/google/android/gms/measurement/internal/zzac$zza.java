package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.AppMeasurementService;

public final class zzac$zza
  implements ServiceConnection, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  volatile boolean zzaYV;
  volatile zzo zzaYW;
  
  protected zzac$zza(zzac paramzzac) {}
  
  /* Error */
  public final void onConnected(final android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 53	com/google/android/gms/common/internal/zzx:zzcD	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 55	com/google/android/gms/measurement/internal/zzac$zza:zzaYW	Lcom/google/android/gms/measurement/internal/zzo;
    //   11: invokevirtual 61	com/google/android/gms/measurement/internal/zzo:zzqJ	()Landroid/os/IInterface;
    //   14: checkcast 63	com/google/android/gms/measurement/internal/zzm
    //   17: astore_1
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 55	com/google/android/gms/measurement/internal/zzac$zza:zzaYW	Lcom/google/android/gms/measurement/internal/zzo;
    //   23: aload_0
    //   24: getfield 31	com/google/android/gms/measurement/internal/zzac$zza:zzaYU	Lcom/google/android/gms/measurement/internal/zzac;
    //   27: invokevirtual 67	com/google/android/gms/measurement/internal/zzac:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   30: new 19	com/google/android/gms/measurement/internal/zzac$zza$3
    //   33: dup
    //   34: aload_0
    //   35: aload_1
    //   36: invokespecial 70	com/google/android/gms/measurement/internal/zzac$zza$3:<init>	(Lcom/google/android/gms/measurement/internal/zzac$zza;Lcom/google/android/gms/measurement/internal/zzm;)V
    //   39: invokevirtual 76	com/google/android/gms/measurement/internal/zzv:zzg	(Ljava/lang/Runnable;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 55	com/google/android/gms/measurement/internal/zzac$zza:zzaYW	Lcom/google/android/gms/measurement/internal/zzo;
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 39	com/google/android/gms/measurement/internal/zzac$zza:zzaYV	Z
    //   55: goto -13 -> 42
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    //   63: astore_1
    //   64: goto -19 -> 45
    //   67: astore_1
    //   68: goto -23 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	zza
    //   0	71	1	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   7	42	58	finally
    //   42	44	58	finally
    //   45	55	58	finally
    //   59	61	58	finally
    //   7	42	63	android/os/DeadObjectException
    //   7	42	67	java/lang/IllegalStateException
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    Object localObject2 = null;
    zzx.zzcD("MeasurementServiceConnection.onConnectionFailed");
    zzw localzzw = zzaYU.zzaTV;
    Object localObject1 = localObject2;
    if (zzaXZ != null)
    {
      localObject1 = localObject2;
      if (zzaXZ.isInitialized()) {
        localObject1 = zzaXZ;
      }
    }
    if (localObject1 != null) {
      zzaWF.zzj("Service connection failed", paramConnectionResult);
    }
    try
    {
      zzaYV = false;
      zzaYW = null;
      return;
    }
    finally {}
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzx.zzcD("MeasurementServiceConnection.onConnectionSuspended");
    zzaYU.zzAo().zzaWJ.zzfg("Service connection suspended");
    zzaYU.zzCn().zzg(new Runnable()
    {
      public final void run()
      {
        zzac.zza(zzaYU, new ComponentName(zzaYU.getContext(), AppMeasurementService.class));
      }
    });
  }
  
  /* Error */
  public final void onServiceConnected(final ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: ldc -121
    //   2: invokestatic 53	com/google/android/gms/common/internal/zzx:zzcD	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_2
    //   8: ifnonnull +26 -> 34
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 39	com/google/android/gms/measurement/internal/zzac$zza:zzaYV	Z
    //   16: aload_0
    //   17: getfield 31	com/google/android/gms/measurement/internal/zzac$zza:zzaYU	Lcom/google/android/gms/measurement/internal/zzac;
    //   20: invokevirtual 116	com/google/android/gms/measurement/internal/zzac:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   23: getfield 138	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   26: ldc -116
    //   28: invokevirtual 124	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aconst_null
    //   35: astore 4
    //   37: aconst_null
    //   38: astore_3
    //   39: aload 4
    //   41: astore_1
    //   42: aload_2
    //   43: invokeinterface 146 1 0
    //   48: astore 5
    //   50: aload 4
    //   52: astore_1
    //   53: ldc -108
    //   55: aload 5
    //   57: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +67 -> 127
    //   63: aload 4
    //   65: astore_1
    //   66: aload_2
    //   67: invokestatic 160	com/google/android/gms/measurement/internal/zzm$zza:zzdn	(Landroid/os/IBinder;)Lcom/google/android/gms/measurement/internal/zzm;
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 31	com/google/android/gms/measurement/internal/zzac$zza:zzaYU	Lcom/google/android/gms/measurement/internal/zzac;
    //   77: invokevirtual 116	com/google/android/gms/measurement/internal/zzac:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   80: getfield 163	com/google/android/gms/measurement/internal/zzp:zzaWK	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   83: ldc -91
    //   85: invokevirtual 124	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: astore_1
    //   90: aload_1
    //   91: ifnonnull +80 -> 171
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 39	com/google/android/gms/measurement/internal/zzac$zza:zzaYV	Z
    //   99: invokestatic 171	com/google/android/gms/common/stats/zzb:zzrP	()Lcom/google/android/gms/common/stats/zzb;
    //   102: aload_0
    //   103: getfield 31	com/google/android/gms/measurement/internal/zzac$zza:zzaYU	Lcom/google/android/gms/measurement/internal/zzac;
    //   106: invokevirtual 175	com/google/android/gms/measurement/internal/zzac:getContext	()Landroid/content/Context;
    //   109: aload_0
    //   110: getfield 31	com/google/android/gms/measurement/internal/zzac$zza:zzaYU	Lcom/google/android/gms/measurement/internal/zzac;
    //   113: getfield 179	com/google/android/gms/measurement/internal/zzac:zzaYN	Lcom/google/android/gms/measurement/internal/zzac$zza;
    //   116: invokevirtual 182	com/google/android/gms/common/stats/zzb:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    //   127: aload 4
    //   129: astore_1
    //   130: aload_0
    //   131: getfield 31	com/google/android/gms/measurement/internal/zzac$zza:zzaYU	Lcom/google/android/gms/measurement/internal/zzac;
    //   134: invokevirtual 116	com/google/android/gms/measurement/internal/zzac:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   137: getfield 138	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   140: ldc -72
    //   142: aload 5
    //   144: invokevirtual 108	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   147: aload_3
    //   148: astore_1
    //   149: goto -59 -> 90
    //   152: astore_2
    //   153: aload_0
    //   154: getfield 31	com/google/android/gms/measurement/internal/zzac$zza:zzaYU	Lcom/google/android/gms/measurement/internal/zzac;
    //   157: invokevirtual 116	com/google/android/gms/measurement/internal/zzac:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   160: getfield 138	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   163: ldc -70
    //   165: invokevirtual 124	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   168: goto -78 -> 90
    //   171: aload_0
    //   172: getfield 31	com/google/android/gms/measurement/internal/zzac$zza:zzaYU	Lcom/google/android/gms/measurement/internal/zzac;
    //   175: invokevirtual 67	com/google/android/gms/measurement/internal/zzac:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   178: new 15	com/google/android/gms/measurement/internal/zzac$zza$1
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 187	com/google/android/gms/measurement/internal/zzac$zza$1:<init>	(Lcom/google/android/gms/measurement/internal/zzac$zza;Lcom/google/android/gms/measurement/internal/zzm;)V
    //   187: invokevirtual 76	com/google/android/gms/measurement/internal/zzv:zzg	(Ljava/lang/Runnable;)V
    //   190: goto -71 -> 119
    //   193: astore_1
    //   194: goto -75 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	zza
    //   0	197	1	paramComponentName	ComponentName
    //   0	197	2	paramIBinder	android.os.IBinder
    //   38	110	3	localObject1	Object
    //   35	93	4	localObject2	Object
    //   48	95	5	str	String
    // Exception table:
    //   from	to	target	type
    //   11	33	122	finally
    //   42	50	122	finally
    //   53	63	122	finally
    //   66	71	122	finally
    //   73	88	122	finally
    //   94	99	122	finally
    //   99	119	122	finally
    //   119	121	122	finally
    //   123	125	122	finally
    //   130	147	122	finally
    //   153	168	122	finally
    //   171	190	122	finally
    //   42	50	152	android/os/RemoteException
    //   53	63	152	android/os/RemoteException
    //   66	71	152	android/os/RemoteException
    //   73	88	152	android/os/RemoteException
    //   130	147	152	android/os/RemoteException
    //   99	119	193	java/lang/IllegalArgumentException
  }
  
  public final void onServiceDisconnected(final ComponentName paramComponentName)
  {
    zzx.zzcD("MeasurementServiceConnection.onServiceDisconnected");
    zzaYU.zzAo().zzaWJ.zzfg("Service disconnected");
    zzaYU.zzCn().zzg(new Runnable()
    {
      public final void run()
      {
        zzac.zza(zzaYU, paramComponentName);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzac.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */