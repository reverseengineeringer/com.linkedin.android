package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzp.zza;
import com.google.android.gms.measurement.internal.zzw;

public final class AppMeasurementService
  extends Service
{
  private static Boolean zzOO;
  private final Handler mHandler = new Handler();
  
  public static boolean zzZ(Context paramContext)
  {
    com.google.android.gms.common.internal.zzx.zzz(paramContext);
    if (zzOO != null) {
      return zzOO.booleanValue();
    }
    boolean bool = zzaj.zza(paramContext, AppMeasurementService.class);
    zzOO = Boolean.valueOf(bool);
    return bool;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzaTzzAozzaWC.zzfg("onBind called with null intent");
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent)) {
      return new com.google.android.gms.measurement.internal.zzx(zzw.zzaT(this));
    }
    zzaTzzAozzaWF.zzj("onBind received unknown action", paramIntent);
    return null;
  }
  
  public final void onCreate()
  {
    super.onCreate();
    zzp localzzp = zzw.zzaT(this).zzAo();
    if (zzd.zzkr())
    {
      zzaWK.zzfg("Device AppMeasurementService is starting up");
      return;
    }
    zzaWK.zzfg("Local AppMeasurementService is starting up");
  }
  
  public final void onDestroy()
  {
    zzp localzzp = zzw.zzaT(this).zzAo();
    if (zzd.zzkr()) {
      zzaWK.zzfg("Device AppMeasurementService is shutting down");
    }
    for (;;)
    {
      super.onDestroy();
      return;
      zzaWK.zzfg("Local AppMeasurementService is shutting down");
    }
  }
  
  public final void onRebind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzaTzzAozzaWC.zzfg("onRebind called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    zzaTzzAozzaWK.zzj("onRebind called. action", paramIntent);
  }
  
  /* Error */
  public final int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    // Byte code:
    //   0: getstatic 141	com/google/android/gms/measurement/AppMeasurementReceiver:zzqy	Ljava/lang/Object;
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: getstatic 145	com/google/android/gms/measurement/AppMeasurementReceiver:zzOM	Lcom/google/android/gms/internal/zzrp;
    //   11: astore 6
    //   13: aload 6
    //   15: ifnull +247 -> 262
    //   18: aload 6
    //   20: getfield 151	com/google/android/gms/internal/zzrp:zzbhm	Landroid/os/PowerManager$WakeLock;
    //   23: invokevirtual 156	android/os/PowerManager$WakeLock:isHeld	()Z
    //   26: ifeq +236 -> 262
    //   29: aload 6
    //   31: invokevirtual 159	com/google/android/gms/internal/zzrp:zzfK$552c4dfd	()Z
    //   34: istore 4
    //   36: aload 6
    //   38: iload 4
    //   40: invokevirtual 163	com/google/android/gms/internal/zzrp:zzn$185c6b75	(Z)Ljava/lang/String;
    //   43: astore 7
    //   45: getstatic 167	com/google/android/gms/internal/zzrp:DEBUG	Z
    //   48: ifeq +98 -> 146
    //   51: getstatic 171	com/google/android/gms/internal/zzrp:TAG	Ljava/lang/String;
    //   54: new 173	java/lang/StringBuilder
    //   57: dup
    //   58: ldc -81
    //   60: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload 6
    //   65: getfield 180	com/google/android/gms/internal/zzrp:zzanQ	Ljava/lang/String;
    //   68: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc -70
    //   73: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 6
    //   78: getfield 189	com/google/android/gms/internal/zzrp:zzbhp	Ljava/lang/String;
    //   81: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc -65
    //   86: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 6
    //   91: getfield 194	com/google/android/gms/internal/zzrp:zzbhq	Z
    //   94: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   97: ldc -57
    //   99: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aconst_null
    //   103: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc -55
    //   108: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 6
    //   113: getfield 205	com/google/android/gms/internal/zzrp:zzbhs	I
    //   116: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc -46
    //   121: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 4
    //   126: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   129: ldc -44
    //   131: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 7
    //   136: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 221	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   145: pop
    //   146: aload 6
    //   148: monitorenter
    //   149: aload 6
    //   151: getfield 194	com/google/android/gms/internal/zzrp:zzbhq	Z
    //   154: ifeq +26 -> 180
    //   157: aload 6
    //   159: getfield 224	com/google/android/gms/internal/zzrp:zzbhr	I
    //   162: iconst_1
    //   163: isub
    //   164: istore_2
    //   165: aload 6
    //   167: iload_2
    //   168: putfield 224	com/google/android/gms/internal/zzrp:zzbhr	I
    //   171: iload_2
    //   172: ifeq +25 -> 197
    //   175: iload 4
    //   177: ifne +20 -> 197
    //   180: aload 6
    //   182: getfield 194	com/google/android/gms/internal/zzrp:zzbhq	Z
    //   185: ifne +66 -> 251
    //   188: aload 6
    //   190: getfield 205	com/google/android/gms/internal/zzrp:zzbhs	I
    //   193: iconst_1
    //   194: if_icmpne +57 -> 251
    //   197: invokestatic 230	com/google/android/gms/common/stats/zzi:zzrZ	()Lcom/google/android/gms/common/stats/zzi;
    //   200: pop
    //   201: aload 6
    //   203: getfield 234	com/google/android/gms/internal/zzrp:mContext	Landroid/content/Context;
    //   206: aload 6
    //   208: getfield 151	com/google/android/gms/internal/zzrp:zzbhm	Landroid/os/PowerManager$WakeLock;
    //   211: aload 7
    //   213: invokestatic 239	com/google/android/gms/common/stats/zzg:zza	(Landroid/os/PowerManager$WakeLock;Ljava/lang/String;)Ljava/lang/String;
    //   216: aload 6
    //   218: getfield 180	com/google/android/gms/internal/zzrp:zzanQ	Ljava/lang/String;
    //   221: aload 7
    //   223: aload 6
    //   225: getfield 242	com/google/android/gms/internal/zzrp:zzbho	I
    //   228: aload 6
    //   230: getfield 246	com/google/android/gms/internal/zzrp:zzbhn	Landroid/os/WorkSource;
    //   233: invokestatic 252	com/google/android/gms/internal/zznj:zzb	(Landroid/os/WorkSource;)Ljava/util/List;
    //   236: invokestatic 256	com/google/android/gms/common/stats/zzi:zza$2861d97a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V
    //   239: aload 6
    //   241: aload 6
    //   243: getfield 205	com/google/android/gms/internal/zzrp:zzbhs	I
    //   246: iconst_1
    //   247: isub
    //   248: putfield 205	com/google/android/gms/internal/zzrp:zzbhs	I
    //   251: aload 6
    //   253: monitorexit
    //   254: aload 6
    //   256: getfield 151	com/google/android/gms/internal/zzrp:zzbhm	Landroid/os/PowerManager$WakeLock;
    //   259: invokevirtual 259	android/os/PowerManager$WakeLock:release	()V
    //   262: aload 5
    //   264: monitorexit
    //   265: aload_0
    //   266: invokestatic 57	com/google/android/gms/measurement/internal/zzw:zzaT	(Landroid/content/Context;)Lcom/google/android/gms/measurement/internal/zzw;
    //   269: astore 5
    //   271: aload 5
    //   273: invokevirtual 61	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   276: astore 6
    //   278: aload_1
    //   279: invokevirtual 81	android/content/Intent:getAction	()Ljava/lang/String;
    //   282: astore_1
    //   283: invokestatic 111	com/google/android/gms/measurement/internal/zzd:zzkr	()Z
    //   286: ifeq +73 -> 359
    //   289: aload 6
    //   291: getfield 114	com/google/android/gms/measurement/internal/zzp:zzaWK	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   294: ldc_w 261
    //   297: iload_3
    //   298: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: aload_1
    //   302: invokevirtual 270	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   305: ldc_w 272
    //   308: aload_1
    //   309: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: ifeq +24 -> 336
    //   315: aload 5
    //   317: invokevirtual 276	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   320: new 6	com/google/android/gms/measurement/AppMeasurementService$1
    //   323: dup
    //   324: aload_0
    //   325: aload 5
    //   327: iload_3
    //   328: aload 6
    //   330: invokespecial 279	com/google/android/gms/measurement/AppMeasurementService$1:<init>	(Lcom/google/android/gms/measurement/AppMeasurementService;Lcom/google/android/gms/measurement/internal/zzw;ILcom/google/android/gms/measurement/internal/zzp;)V
    //   333: invokevirtual 285	com/google/android/gms/measurement/internal/zzv:zzg	(Ljava/lang/Runnable;)V
    //   336: iconst_2
    //   337: ireturn
    //   338: astore 7
    //   340: aload 6
    //   342: monitorexit
    //   343: aload 7
    //   345: athrow
    //   346: astore 6
    //   348: aload 5
    //   350: monitorexit
    //   351: aload 6
    //   353: athrow
    //   354: astore 5
    //   356: goto -91 -> 265
    //   359: aload 6
    //   361: getfield 114	com/google/android/gms/measurement/internal/zzp:zzaWK	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   364: ldc_w 287
    //   367: iload_3
    //   368: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   371: aload_1
    //   372: invokevirtual 270	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   375: goto -70 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	this	AppMeasurementService
    //   0	378	1	paramIntent	Intent
    //   0	378	2	paramInt1	int
    //   0	378	3	paramInt2	int
    //   34	142	4	bool	boolean
    //   354	1	5	localSecurityException	SecurityException
    //   11	330	6	localObject2	Object
    //   346	14	6	localObject3	Object
    //   43	179	7	str	String
    //   338	6	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   149	171	338	finally
    //   180	197	338	finally
    //   197	251	338	finally
    //   251	254	338	finally
    //   340	343	338	finally
    //   8	13	346	finally
    //   18	146	346	finally
    //   146	149	346	finally
    //   254	262	346	finally
    //   262	265	346	finally
    //   343	346	346	finally
    //   348	351	346	finally
    //   0	8	354	java/lang/SecurityException
    //   351	354	354	java/lang/SecurityException
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzaTzzAozzaWC.zzfg("onUnbind called with null intent");
      return true;
    }
    paramIntent = paramIntent.getAction();
    zzaTzzAozzaWK.zzj("onUnbind called for intent. action", paramIntent);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */