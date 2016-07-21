package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

public final class zzg
  extends Thread
{
  private final zzb zzj;
  private final zzn zzk;
  volatile boolean zzl = false;
  private final BlockingQueue<zzk<?>> zzy;
  private final zzf zzz;
  
  public zzg(BlockingQueue<zzk<?>> paramBlockingQueue, zzf paramzzf, zzb paramzzb, zzn paramzzn)
  {
    zzy = paramBlockingQueue;
    zzz = paramzzf;
    zzj = paramzzb;
    zzk = paramzzn;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 46	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 52	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore_1
    //   9: aload_0
    //   10: getfield 24	com/google/android/gms/internal/zzg:zzy	Ljava/util/concurrent/BlockingQueue;
    //   13: invokeinterface 58 1 0
    //   18: checkcast 60	com/google/android/gms/internal/zzk
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 62
    //   25: invokevirtual 66	com/google/android/gms/internal/zzk:zzc	(Ljava/lang/String;)V
    //   28: aload_3
    //   29: getfield 69	com/google/android/gms/internal/zzk:zzL	Z
    //   32: ifeq +55 -> 87
    //   35: aload_3
    //   36: ldc 71
    //   38: invokevirtual 74	com/google/android/gms/internal/zzk:zzd	(Ljava/lang/String;)V
    //   41: goto -36 -> 5
    //   44: astore 4
    //   46: aload 4
    //   48: invokestatic 52	android/os/SystemClock:elapsedRealtime	()J
    //   51: lload_1
    //   52: lsub
    //   53: putfield 78	com/google/android/gms/internal/zzr:zzC	J
    //   56: aload 4
    //   58: invokestatic 82	com/google/android/gms/internal/zzk:zzb	(Lcom/google/android/gms/internal/zzr;)Lcom/google/android/gms/internal/zzr;
    //   61: astore 4
    //   63: aload_0
    //   64: getfield 30	com/google/android/gms/internal/zzg:zzk	Lcom/google/android/gms/internal/zzn;
    //   67: aload_3
    //   68: aload 4
    //   70: invokeinterface 88 3 0
    //   75: goto -70 -> 5
    //   78: astore_3
    //   79: aload_0
    //   80: getfield 22	com/google/android/gms/internal/zzg:zzl	Z
    //   83: ifeq -78 -> 5
    //   86: return
    //   87: getstatic 94	android/os/Build$VERSION:SDK_INT	I
    //   90: bipush 14
    //   92: if_icmplt +10 -> 102
    //   95: aload_3
    //   96: getfield 97	com/google/android/gms/internal/zzk:zzG	I
    //   99: invokestatic 102	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   102: aload_0
    //   103: getfield 26	com/google/android/gms/internal/zzg:zzz	Lcom/google/android/gms/internal/zzf;
    //   106: aload_3
    //   107: invokeinterface 107 2 0
    //   112: astore 4
    //   114: aload_3
    //   115: ldc 109
    //   117: invokevirtual 66	com/google/android/gms/internal/zzk:zzc	(Ljava/lang/String;)V
    //   120: aload 4
    //   122: getfield 114	com/google/android/gms/internal/zzi:zzB	Z
    //   125: ifeq +76 -> 201
    //   128: aload_3
    //   129: getfield 117	com/google/android/gms/internal/zzk:zzM	Z
    //   132: ifeq +69 -> 201
    //   135: aload_3
    //   136: ldc 119
    //   138: invokevirtual 74	com/google/android/gms/internal/zzk:zzd	(Ljava/lang/String;)V
    //   141: goto -136 -> 5
    //   144: astore 4
    //   146: aload 4
    //   148: ldc 121
    //   150: iconst_1
    //   151: anewarray 123	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 4
    //   158: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 132	com/google/android/gms/internal/zzs:zza	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: new 38	com/google/android/gms/internal/zzr
    //   168: dup
    //   169: aload 4
    //   171: invokespecial 135	com/google/android/gms/internal/zzr:<init>	(Ljava/lang/Throwable;)V
    //   174: astore 4
    //   176: aload 4
    //   178: invokestatic 52	android/os/SystemClock:elapsedRealtime	()J
    //   181: lload_1
    //   182: lsub
    //   183: putfield 78	com/google/android/gms/internal/zzr:zzC	J
    //   186: aload_0
    //   187: getfield 30	com/google/android/gms/internal/zzg:zzk	Lcom/google/android/gms/internal/zzn;
    //   190: aload_3
    //   191: aload 4
    //   193: invokeinterface 88 3 0
    //   198: goto -193 -> 5
    //   201: aload_3
    //   202: aload 4
    //   204: invokevirtual 138	com/google/android/gms/internal/zzk:zza	(Lcom/google/android/gms/internal/zzi;)Lcom/google/android/gms/internal/zzm;
    //   207: astore 4
    //   209: aload_3
    //   210: ldc -116
    //   212: invokevirtual 66	com/google/android/gms/internal/zzk:zzc	(Ljava/lang/String;)V
    //   215: aload_3
    //   216: getfield 143	com/google/android/gms/internal/zzk:zzK	Z
    //   219: ifeq +35 -> 254
    //   222: aload 4
    //   224: getfield 149	com/google/android/gms/internal/zzm:zzag	Lcom/google/android/gms/internal/zzb$zza;
    //   227: ifnull +27 -> 254
    //   230: aload_0
    //   231: getfield 28	com/google/android/gms/internal/zzg:zzj	Lcom/google/android/gms/internal/zzb;
    //   234: aload_3
    //   235: getfield 153	com/google/android/gms/internal/zzk:zzF	Ljava/lang/String;
    //   238: aload 4
    //   240: getfield 149	com/google/android/gms/internal/zzm:zzag	Lcom/google/android/gms/internal/zzb$zza;
    //   243: invokeinterface 158 3 0
    //   248: aload_3
    //   249: ldc -96
    //   251: invokevirtual 66	com/google/android/gms/internal/zzk:zzc	(Ljava/lang/String;)V
    //   254: aload_3
    //   255: iconst_1
    //   256: putfield 117	com/google/android/gms/internal/zzk:zzM	Z
    //   259: aload_0
    //   260: getfield 30	com/google/android/gms/internal/zzg:zzk	Lcom/google/android/gms/internal/zzn;
    //   263: aload_3
    //   264: aload 4
    //   266: invokeinterface 163 3 0
    //   271: goto -266 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	zzg
    //   8	174	1	l	long
    //   21	47	3	localzzk	zzk
    //   78	186	3	localInterruptedException	InterruptedException
    //   44	13	4	localzzr	zzr
    //   61	60	4	localObject1	Object
    //   144	26	4	localException	Exception
    //   174	91	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	41	44	com/google/android/gms/internal/zzr
    //   87	102	44	com/google/android/gms/internal/zzr
    //   102	141	44	com/google/android/gms/internal/zzr
    //   201	254	44	com/google/android/gms/internal/zzr
    //   254	271	44	com/google/android/gms/internal/zzr
    //   9	22	78	java/lang/InterruptedException
    //   22	41	144	java/lang/Exception
    //   87	102	144	java/lang/Exception
    //   102	141	144	java/lang/Exception
    //   201	254	144	java/lang/Exception
    //   254	271	144	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */