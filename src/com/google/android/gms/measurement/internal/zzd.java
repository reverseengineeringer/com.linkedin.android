package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.zzc;

public final class zzd
  extends zzy
{
  static final String zzaVA = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
  private Boolean zzRy;
  
  zzd(zzw paramzzw)
  {
    super(paramzzw);
  }
  
  public static int zzBA()
  {
    return 25;
  }
  
  static int zzBB()
  {
    return 32;
  }
  
  public static int zzBC()
  {
    return 24;
  }
  
  static int zzBD()
  {
    return 36;
  }
  
  static int zzBE()
  {
    return 256;
  }
  
  public static int zzBF()
  {
    return 36;
  }
  
  public static int zzBG()
  {
    return 2048;
  }
  
  static int zzBH()
  {
    return 500;
  }
  
  public static long zzBI()
  {
    return ((Integer)zzl.zzaWk.get()).intValue();
  }
  
  public static long zzBJ()
  {
    return ((Integer)zzl.zzaWl.get()).intValue();
  }
  
  public static long zzBK()
  {
    return ((Integer)zzl.zzaWm.get()).intValue();
  }
  
  static int zzBL()
  {
    return 25;
  }
  
  static int zzBM()
  {
    return 50;
  }
  
  static long zzBN()
  {
    return 3600000L;
  }
  
  static long zzBO()
  {
    return 60000L;
  }
  
  static long zzBP()
  {
    return 61000L;
  }
  
  public static long zzBQ()
  {
    return ((Long)zzl.zzaWw.get()).longValue();
  }
  
  public static long zzBR()
  {
    return ((Long)zzl.zzaWs.get()).longValue();
  }
  
  public static long zzBS()
  {
    return 1000L;
  }
  
  public static int zzBT()
  {
    return Math.max(0, ((Integer)zzl.zzaWi.get()).intValue());
  }
  
  public static int zzBU()
  {
    return Math.max(1, ((Integer)zzl.zzaWj.get()).intValue());
  }
  
  public static String zzBV()
  {
    return (String)zzl.zzaWo.get();
  }
  
  public static long zzBW()
  {
    return ((Long)zzl.zzaWd.get()).longValue();
  }
  
  public static long zzBX()
  {
    return Math.max(0L, ((Long)zzl.zzaWp.get()).longValue());
  }
  
  public static long zzBY()
  {
    return Math.max(0L, ((Long)zzl.zzaWr.get()).longValue());
  }
  
  public static long zzBZ()
  {
    return ((Long)zzl.zzaWq.get()).longValue();
  }
  
  public static long zzBp()
  {
    return zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000;
  }
  
  static String zzBz()
  {
    return (String)zzl.zzaWa.get();
  }
  
  public static long zzCa()
  {
    return Math.max(0L, ((Long)zzl.zzaWt.get()).longValue());
  }
  
  public static long zzCb()
  {
    return Math.max(0L, ((Long)zzl.zzaWu.get()).longValue());
  }
  
  public static int zzCc()
  {
    return Math.min(20, Math.max(0, ((Integer)zzl.zzaWv.get()).intValue()));
  }
  
  static long zzkM()
  {
    return ((Long)zzl.zzaWy.get()).longValue();
  }
  
  public static String zzkR()
  {
    return "google_app_measurement.db";
  }
  
  public static String zzkS()
  {
    return "google_app_measurement2.db";
  }
  
  public static long zzkX()
  {
    return Math.max(0L, ((Long)zzl.zzaWc.get()).longValue());
  }
  
  public static boolean zzkr()
  {
    return com.google.android.gms.common.internal.zzd.zzakE;
  }
  
  public final long zza(String paramString, zzl.zza<Long> paramzza)
  {
    if (paramString == null) {
      return ((Long)paramzza.get()).longValue();
    }
    paramString = super.zzCl().zzO(paramString, zzvs);
    if (TextUtils.isEmpty(paramString)) {
      return ((Long)paramzza.get()).longValue();
    }
    try
    {
      long l = ((Long)paramzza.get(Long.valueOf(Long.valueOf(paramString).longValue()))).longValue();
      return l;
    }
    catch (NumberFormatException paramString) {}
    return ((Long)paramzza.get()).longValue();
  }
  
  public final int zzb(String paramString, zzl.zza<Integer> paramzza)
  {
    if (paramString == null) {
      return ((Integer)paramzza.get()).intValue();
    }
    paramString = super.zzCl().zzO(paramString, zzvs);
    if (TextUtils.isEmpty(paramString)) {
      return ((Integer)paramzza.get()).intValue();
    }
    try
    {
      int i = ((Integer)paramzza.get(Integer.valueOf(Integer.valueOf(paramString).intValue()))).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return ((Integer)paramzza.get()).intValue();
  }
  
  /* Error */
  public final boolean zzks()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 290	com/google/android/gms/measurement/internal/zzd:zzRy	Ljava/lang/Boolean;
    //   4: ifnonnull +91 -> 95
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 290	com/google/android/gms/measurement/internal/zzd:zzRy	Ljava/lang/Boolean;
    //   13: ifnonnull +80 -> 93
    //   16: aload_0
    //   17: invokespecial 184	com/google/android/gms/measurement/internal/zzy:getContext	()Landroid/content/Context;
    //   20: invokevirtual 296	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   23: astore_3
    //   24: aload_0
    //   25: invokespecial 184	com/google/android/gms/measurement/internal/zzy:getContext	()Landroid/content/Context;
    //   28: invokestatic 301	android/os/Process:myPid	()I
    //   31: invokestatic 307	com/google/android/gms/internal/zznf:zzi	(Landroid/content/Context;I)Ljava/lang/String;
    //   34: astore_2
    //   35: aload_3
    //   36: ifnull +30 -> 66
    //   39: aload_3
    //   40: getfield 312	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +58 -> 103
    //   48: aload_3
    //   49: aload_2
    //   50: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +50 -> 103
    //   56: iconst_1
    //   57: istore_1
    //   58: aload_0
    //   59: iload_1
    //   60: invokestatic 321	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   63: putfield 290	com/google/android/gms/measurement/internal/zzd:zzRy	Ljava/lang/Boolean;
    //   66: aload_0
    //   67: getfield 290	com/google/android/gms/measurement/internal/zzd:zzRy	Ljava/lang/Boolean;
    //   70: ifnonnull +23 -> 93
    //   73: aload_0
    //   74: getstatic 324	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   77: putfield 290	com/google/android/gms/measurement/internal/zzd:zzRy	Ljava/lang/Boolean;
    //   80: aload_0
    //   81: invokespecial 188	com/google/android/gms/measurement/internal/zzy:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   84: getfield 330	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   87: ldc_w 332
    //   90: invokevirtual 338	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_0
    //   96: getfield 290	com/google/android/gms/measurement/internal/zzd:zzRy	Ljava/lang/Boolean;
    //   99: invokevirtual 341	java/lang/Boolean:booleanValue	()Z
    //   102: ireturn
    //   103: iconst_0
    //   104: istore_1
    //   105: goto -47 -> 58
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	zzd
    //   57	48	1	bool	boolean
    //   34	16	2	str	String
    //   108	4	2	localObject1	Object
    //   23	26	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	35	108	finally
    //   39	44	108	finally
    //   48	56	108	finally
    //   58	66	108	finally
    //   66	93	108	finally
    //   93	95	108	finally
    //   109	111	108	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */