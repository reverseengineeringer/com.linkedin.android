package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzqa.zzb;
import com.google.android.gms.internal.zzqb.zzb;
import com.google.android.gms.internal.zzqb.zzd;
import com.google.android.gms.internal.zzqb.zze;
import com.google.android.gms.internal.zzqb.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class zzw
{
  private static zzaa zzaXV;
  private static volatile zzw zzaXW;
  final Context mContext;
  private final boolean zzQk;
  final zzd zzaXX;
  private final zzt zzaXY;
  final zzp zzaXZ;
  final zzv zzaYa;
  final zzad zzaYb;
  private final zzu zzaYc;
  public final AppMeasurement zzaYd;
  private final zzaj zzaYe;
  private final zze zzaYf;
  private final zzq zzaYg;
  final zzac zzaYh;
  private final zzg zzaYi;
  private final zzab zzaYj;
  private final zzn zzaYk;
  private final zzr zzaYl;
  private final zzag zzaYm;
  private final zzc zzaYn;
  private Boolean zzaYo;
  private List<Long> zzaYp;
  int zzaYq;
  int zzaYr;
  final zzmq zzqW;
  
  private zzw(zzaa paramzzaa)
  {
    zzx.zzz(paramzzaa);
    mContext = mContext;
    zzqW = zzmt.zzsc();
    zzaXX = new zzd(this);
    paramzzaa = new zzt(this);
    paramzzaa.zza();
    zzaXY = paramzzaa;
    paramzzaa = new zzp(this);
    paramzzaa.zza();
    zzaXZ = paramzzaa;
    zzAozzaWI.zzj("App measurement is starting up, version", Long.valueOf(zzd.zzBp()));
    zzAozzaWI.zzfg("To enable debug logging run: adb shell setprop log.tag.GMPM VERBOSE");
    zzAozzaWJ.zzfg("Debug logging enabled");
    zzaYe = new zzaj(this);
    paramzzaa = new zzg(this);
    paramzzaa.zza();
    zzaYi = paramzzaa;
    paramzzaa = new zzn(this);
    paramzzaa.zza();
    zzaYk = paramzzaa;
    paramzzaa = new zze(this);
    paramzzaa.zza();
    zzaYf = paramzzaa;
    paramzzaa = new zzc(this);
    paramzzaa.zza();
    zzaYn = paramzzaa;
    paramzzaa = new zzq(this);
    paramzzaa.zza();
    zzaYg = paramzzaa;
    paramzzaa = zzaa.zzm(this);
    paramzzaa.zza();
    zzaYh = paramzzaa;
    paramzzaa = zzaa.zzh(this);
    paramzzaa.zza();
    zzaYj = paramzzaa;
    paramzzaa = zzaa.zzq(this);
    paramzzaa.zza();
    zzaYm = paramzzaa;
    zzaYl = new zzr(this);
    zzaYd = new AppMeasurement(this);
    paramzzaa = new zzad(this);
    paramzzaa.zza();
    zzaYb = paramzzaa;
    paramzzaa = new zzu(this);
    paramzzaa.zza();
    zzaYc = paramzzaa;
    paramzzaa = new zzv(this);
    paramzzaa.zza();
    zzaYa = paramzzaa;
    if (zzaYq != zzaYr) {
      zzAozzaWC.zze("Not all components initialized", Integer.valueOf(zzaYq), Integer.valueOf(zzaYr));
    }
    zzQk = true;
    if (!zzd.zzkr())
    {
      if (!(mContext.getApplicationContext() instanceof Application)) {
        break label444;
      }
      if (Build.VERSION.SDK_INT < 14) {
        break label428;
      }
      zzCf().zzDk();
    }
    for (;;)
    {
      zzaYa.zzg(new Runnable()
      {
        public final void run()
        {
          start();
        }
      });
      return;
      label428:
      zzAozzaWJ.zzfg("Not tracking deep linking pre-ICS");
      continue;
      label444:
      zzAozzaWF.zzfg("Application context is not an Application");
    }
  }
  
  private zzr zzCX()
  {
    if (zzaYl == null) {
      throw new IllegalStateException("Network broadcast receiver not created");
    }
    return zzaYl;
  }
  
  private zzag zzCY()
  {
    zza(zzaYm);
    return zzaYm;
  }
  
  private boolean zzDd()
  {
    boolean bool = false;
    zzCn().zzjk();
    zzjv();
    if (zzCj().zzb("select count(1) > 0 from raw_events", null) != 0L) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (!TextUtils.isEmpty(zzCj().zzCq()))) {
        bool = true;
      }
      return bool;
    }
  }
  
  private void zza(zzh paramzzh, AppMetadata paramAppMetadata)
  {
    zzCn().zzjk();
    zzjv();
    zzx.zzz(paramzzh);
    zzx.zzz(paramAppMetadata);
    zzx.zzcM(zzaUa);
    zzx.zzac(zzaUa.equals(packageName));
    zzqb.zze localzze = new zzqb.zze();
    zzbal = Integer.valueOf(1);
    zzbat = "android";
    appId = packageName;
    zzaVu = zzaVu;
    zzaMV = zzaMV;
    zzbax = Long.valueOf(zzaVv);
    zzaVt = zzaVt;
    if (zzaVw == 0L) {}
    for (Object localObject = null;; localObject = Long.valueOf(zzaVw))
    {
      zzbaC = ((Long)localObject);
      localObject = zzCo().zzfh(packageName);
      if ((first != null) && (second != null))
      {
        zzbaz = ((String)first);
        zzbaA = ((Boolean)second);
      }
      zzbau = zzCh().zzht();
      osVersion = zzCh().zzCy();
      zzbaw = Integer.valueOf((int)zzCh().zzCz());
      zzbav = zzCh().zzCA();
      zzbay = null;
      zzbao = null;
      zzbap = null;
      zzbaq = null;
      zza localzza = zzCj().zzeY(packageName);
      localObject = localzza;
      if (localzza == null)
      {
        localObject = new zza(this, packageName);
        ((zza)localObject).zzeM(zzCo().zzCM());
        ((zza)localObject).zzeN(zzaVt);
        ((zza)localObject).zzeO(zzCo().zzfi(packageName));
        ((zza)localObject).zzS(0L);
        ((zza)localObject).zzO(0L);
        ((zza)localObject).zzP(0L);
        ((zza)localObject).setAppVersion(zzaMV);
        ((zza)localObject).zzeP(zzaVu);
        ((zza)localObject).zzQ(zzaVv);
        ((zza)localObject).zzR(zzaVw);
        ((zza)localObject).setMeasurementEnabled(zzaVy);
        zzCj().zza((zza)localObject);
      }
      zzbaB = ((zza)localObject).zzBj();
      paramAppMetadata = zzCj().zzeX(packageName);
      zzban = new zzqb.zzg[paramAppMetadata.size()];
      int i = 0;
      while (i < paramAppMetadata.size())
      {
        localObject = new zzqb.zzg();
        zzban[i] = localObject;
        name = getmName;
        zzbaJ = Long.valueOf(getzzaZp);
        zzCk().zza((zzqb.zzg)localObject, getzzNc);
        i += 1;
      }
    }
    try
    {
      long l = zzCj().zzb(localzze);
      zzCj().zza(paramzzh, l);
      return;
    }
    catch (IOException paramzzh)
    {
      zzAozzaWC.zzj("Data loss. Failed to insert raw event metadata", paramzzh);
    }
  }
  
  private static void zza(zzy paramzzy)
  {
    if (paramzzy == null) {
      throw new IllegalStateException("Component not created");
    }
  }
  
  static void zza(zzz paramzzz)
  {
    if (paramzzz == null) {
      throw new IllegalStateException("Component not created");
    }
    if (!paramzzz.isInitialized()) {
      throw new IllegalStateException("Component not initialized");
    }
  }
  
  /* Error */
  public static zzw zzaT(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 76	com/google/android/gms/common/internal/zzx:zzz	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 266	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   9: invokestatic 76	com/google/android/gms/common/internal/zzx:zzz	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: getstatic 696	com/google/android/gms/measurement/internal/zzw:zzaXW	Lcom/google/android/gms/measurement/internal/zzw;
    //   16: ifnonnull +36 -> 52
    //   19: ldc 2
    //   21: monitorenter
    //   22: getstatic 696	com/google/android/gms/measurement/internal/zzw:zzaXW	Lcom/google/android/gms/measurement/internal/zzw;
    //   25: ifnonnull +24 -> 49
    //   28: getstatic 698	com/google/android/gms/measurement/internal/zzw:zzaXV	Lcom/google/android/gms/measurement/internal/zzaa;
    //   31: ifnull +25 -> 56
    //   34: getstatic 698	com/google/android/gms/measurement/internal/zzw:zzaXV	Lcom/google/android/gms/measurement/internal/zzaa;
    //   37: astore_0
    //   38: new 2	com/google/android/gms/measurement/internal/zzw
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 700	com/google/android/gms/measurement/internal/zzw:<init>	(Lcom/google/android/gms/measurement/internal/zzaa;)V
    //   46: putstatic 696	com/google/android/gms/measurement/internal/zzw:zzaXW	Lcom/google/android/gms/measurement/internal/zzw;
    //   49: ldc 2
    //   51: monitorexit
    //   52: getstatic 696	com/google/android/gms/measurement/internal/zzw:zzaXW	Lcom/google/android/gms/measurement/internal/zzw;
    //   55: areturn
    //   56: new 78	com/google/android/gms/measurement/internal/zzaa
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 703	com/google/android/gms/measurement/internal/zzaa:<init>	(Landroid/content/Context;)V
    //   64: astore_0
    //   65: goto -27 -> 38
    //   68: astore_0
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   22	38	68	finally
    //   38	49	68	finally
    //   49	52	68	finally
    //   56	65	68	finally
    //   69	72	68	finally
  }
  
  /* Error */
  private boolean zzg$505cfb57(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   4: invokevirtual 616	com/google/android/gms/measurement/internal/zze:beginTransaction	()V
    //   7: new 12	com/google/android/gms/measurement/internal/zzw$zza
    //   10: dup
    //   11: aload_0
    //   12: iconst_0
    //   13: invokespecial 710	com/google/android/gms/measurement/internal/zzw$zza:<init>	(Lcom/google/android/gms/measurement/internal/zzw;B)V
    //   16: astore 8
    //   18: aload_0
    //   19: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   22: aconst_null
    //   23: lload_1
    //   24: aload 8
    //   26: invokevirtual 713	com/google/android/gms/measurement/internal/zze:zza	(Ljava/lang/String;JLcom/google/android/gms/measurement/internal/zze$zzb;)V
    //   29: aload 8
    //   31: getfield 716	com/google/android/gms/measurement/internal/zzw$zza:zzpH	Ljava/util/List;
    //   34: ifnull +726 -> 760
    //   37: aload 8
    //   39: getfield 716	com/google/android/gms/measurement/internal/zzw$zza:zzpH	Ljava/util/List;
    //   42: invokeinterface 718 1 0
    //   47: ifeq +727 -> 774
    //   50: goto +710 -> 760
    //   53: iload_3
    //   54: ifne +684 -> 738
    //   57: aload 8
    //   59: getfield 722	com/google/android/gms/measurement/internal/zzw$zza:zzaYt	Lcom/google/android/gms/internal/zzqb$zze;
    //   62: astore 9
    //   64: aload 9
    //   66: aload 8
    //   68: getfield 716	com/google/android/gms/measurement/internal/zzw$zza:zzpH	Ljava/util/List;
    //   71: invokeinterface 542 1 0
    //   76: anewarray 724	com/google/android/gms/internal/zzqb$zzb
    //   79: putfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   82: iconst_0
    //   83: istore_3
    //   84: iconst_0
    //   85: istore 4
    //   87: iload 4
    //   89: aload 8
    //   91: getfield 716	com/google/android/gms/measurement/internal/zzw$zza:zzpH	Ljava/util/List;
    //   94: invokeinterface 542 1 0
    //   99: if_icmpge +102 -> 201
    //   102: aload_0
    //   103: invokevirtual 663	com/google/android/gms/measurement/internal/zzw:zzCl	()Lcom/google/android/gms/measurement/internal/zzu;
    //   106: aload 8
    //   108: getfield 722	com/google/android/gms/measurement/internal/zzw$zza:zzaYt	Lcom/google/android/gms/internal/zzqb$zze;
    //   111: getfield 380	com/google/android/gms/internal/zzqb$zze:appId	Ljava/lang/String;
    //   114: aload 8
    //   116: getfield 716	com/google/android/gms/measurement/internal/zzw$zza:zzpH	Ljava/util/List;
    //   119: iload 4
    //   121: invokeinterface 553 2 0
    //   126: checkcast 724	com/google/android/gms/internal/zzqb$zzb
    //   129: getfield 729	com/google/android/gms/internal/zzqb$zzb:name	Ljava/lang/String;
    //   132: invokevirtual 732	com/google/android/gms/measurement/internal/zzu:zzP	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: ifeq +37 -> 172
    //   138: aload_0
    //   139: invokevirtual 113	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   142: getfield 611	com/google/android/gms/measurement/internal/zzp:zzaWK	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   145: ldc_w 734
    //   148: aload 8
    //   150: getfield 716	com/google/android/gms/measurement/internal/zzw$zza:zzpH	Ljava/util/List;
    //   153: iload 4
    //   155: invokeinterface 553 2 0
    //   160: checkcast 724	com/google/android/gms/internal/zzqb$zzb
    //   163: getfield 729	com/google/android/gms/internal/zzqb$zzb:name	Ljava/lang/String;
    //   166: invokevirtual 135	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   169: goto +596 -> 765
    //   172: aload 9
    //   174: getfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   177: iload_3
    //   178: aload 8
    //   180: getfield 716	com/google/android/gms/measurement/internal/zzw$zza:zzpH	Ljava/util/List;
    //   183: iload 4
    //   185: invokeinterface 553 2 0
    //   190: checkcast 724	com/google/android/gms/internal/zzqb$zzb
    //   193: aastore
    //   194: iload_3
    //   195: iconst_1
    //   196: iadd
    //   197: istore_3
    //   198: goto +567 -> 765
    //   201: iload_3
    //   202: aload 8
    //   204: getfield 716	com/google/android/gms/measurement/internal/zzw$zza:zzpH	Ljava/util/List;
    //   207: invokeinterface 542 1 0
    //   212: if_icmpge +20 -> 232
    //   215: aload 9
    //   217: aload 9
    //   219: getfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   222: iload_3
    //   223: invokestatic 740	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   226: checkcast 741	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   229: putfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   232: aload 8
    //   234: getfield 722	com/google/android/gms/measurement/internal/zzw$zza:zzaYt	Lcom/google/android/gms/internal/zzqb$zze;
    //   237: getfield 380	com/google/android/gms/internal/zzqb$zze:appId	Ljava/lang/String;
    //   240: astore 7
    //   242: aload 8
    //   244: getfield 722	com/google/android/gms/measurement/internal/zzw$zza:zzaYt	Lcom/google/android/gms/internal/zzqb$zze;
    //   247: getfield 548	com/google/android/gms/internal/zzqb$zze:zzban	[Lcom/google/android/gms/internal/zzqb$zzg;
    //   250: astore 10
    //   252: aload 9
    //   254: getfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   257: astore 11
    //   259: aload 7
    //   261: invokestatic 350	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   264: pop
    //   265: aload 9
    //   267: aload_0
    //   268: invokevirtual 745	com/google/android/gms/measurement/internal/zzw:zzCe	()Lcom/google/android/gms/measurement/internal/zzc;
    //   271: aload 7
    //   273: aload 11
    //   275: aload 10
    //   277: invokevirtual 748	com/google/android/gms/measurement/internal/zzc:zza	(Ljava/lang/String;[Lcom/google/android/gms/internal/zzqb$zzb;[Lcom/google/android/gms/internal/zzqb$zzg;)[Lcom/google/android/gms/internal/zzqb$zza;
    //   280: putfield 752	com/google/android/gms/internal/zzqb$zze:zzbaF	[Lcom/google/android/gms/internal/zzqb$zza;
    //   283: aload 9
    //   285: aload 9
    //   287: getfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   290: iconst_0
    //   291: aaload
    //   292: getfield 755	com/google/android/gms/internal/zzqb$zzb:zzbaf	Ljava/lang/Long;
    //   295: putfield 468	com/google/android/gms/internal/zzqb$zze:zzbap	Ljava/lang/Long;
    //   298: aload 9
    //   300: aload 9
    //   302: getfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   305: iconst_0
    //   306: aaload
    //   307: getfield 755	com/google/android/gms/internal/zzqb$zzb:zzbaf	Ljava/lang/Long;
    //   310: putfield 471	com/google/android/gms/internal/zzqb$zze:zzbaq	Ljava/lang/Long;
    //   313: iconst_1
    //   314: istore_3
    //   315: iload_3
    //   316: aload 9
    //   318: getfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   321: arraylength
    //   322: if_icmpge +75 -> 397
    //   325: aload 9
    //   327: getfield 728	com/google/android/gms/internal/zzqb$zze:zzbam	[Lcom/google/android/gms/internal/zzqb$zzb;
    //   330: iload_3
    //   331: aaload
    //   332: astore 7
    //   334: aload 7
    //   336: getfield 755	com/google/android/gms/internal/zzqb$zzb:zzbaf	Ljava/lang/Long;
    //   339: invokevirtual 632	java/lang/Long:longValue	()J
    //   342: aload 9
    //   344: getfield 468	com/google/android/gms/internal/zzqb$zze:zzbap	Ljava/lang/Long;
    //   347: invokevirtual 632	java/lang/Long:longValue	()J
    //   350: lcmp
    //   351: ifge +13 -> 364
    //   354: aload 9
    //   356: aload 7
    //   358: getfield 755	com/google/android/gms/internal/zzqb$zzb:zzbaf	Ljava/lang/Long;
    //   361: putfield 468	com/google/android/gms/internal/zzqb$zze:zzbap	Ljava/lang/Long;
    //   364: aload 7
    //   366: getfield 755	com/google/android/gms/internal/zzqb$zzb:zzbaf	Ljava/lang/Long;
    //   369: invokevirtual 632	java/lang/Long:longValue	()J
    //   372: aload 9
    //   374: getfield 471	com/google/android/gms/internal/zzqb$zze:zzbaq	Ljava/lang/Long;
    //   377: invokevirtual 632	java/lang/Long:longValue	()J
    //   380: lcmp
    //   381: ifle +398 -> 779
    //   384: aload 9
    //   386: aload 7
    //   388: getfield 755	com/google/android/gms/internal/zzqb$zzb:zzbaf	Ljava/lang/Long;
    //   391: putfield 471	com/google/android/gms/internal/zzqb$zze:zzbaq	Ljava/lang/Long;
    //   394: goto +385 -> 779
    //   397: aload 8
    //   399: getfield 722	com/google/android/gms/measurement/internal/zzw$zza:zzaYt	Lcom/google/android/gms/internal/zzqb$zze;
    //   402: getfield 380	com/google/android/gms/internal/zzqb$zze:appId	Ljava/lang/String;
    //   405: astore 10
    //   407: aload_0
    //   408: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   411: aload 10
    //   413: invokevirtual 475	com/google/android/gms/measurement/internal/zze:zzeY	(Ljava/lang/String;)Lcom/google/android/gms/measurement/internal/zza;
    //   416: astore 11
    //   418: aload 11
    //   420: ifnonnull +100 -> 520
    //   423: aload_0
    //   424: invokevirtual 113	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   427: getfield 243	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   430: ldc_w 757
    //   433: invokevirtual 141	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   436: aload 9
    //   438: aload_0
    //   439: invokevirtual 113	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   442: invokevirtual 760	com/google/android/gms/measurement/internal/zzp:zzCL	()Ljava/lang/String;
    //   445: putfield 763	com/google/android/gms/internal/zzqb$zze:zzaVx	Ljava/lang/String;
    //   448: aload_0
    //   449: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   452: aload 9
    //   454: invokevirtual 766	com/google/android/gms/measurement/internal/zze:zza	(Lcom/google/android/gms/internal/zzqb$zze;)V
    //   457: aload_0
    //   458: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   461: aload 8
    //   463: getfield 769	com/google/android/gms/measurement/internal/zzw$zza:zzaYu	Ljava/util/List;
    //   466: invokevirtual 772	com/google/android/gms/measurement/internal/zze:zzz	(Ljava/util/List;)V
    //   469: aload_0
    //   470: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   473: astore 7
    //   475: aload 7
    //   477: invokevirtual 776	com/google/android/gms/measurement/internal/zze:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   480: astore 8
    //   482: aload 8
    //   484: ldc_w 778
    //   487: iconst_2
    //   488: anewarray 357	java/lang/String
    //   491: dup
    //   492: iconst_0
    //   493: aload 10
    //   495: aastore
    //   496: dup
    //   497: iconst_1
    //   498: aload 10
    //   500: aastore
    //   501: invokevirtual 784	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: aload_0
    //   505: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   508: invokevirtual 641	com/google/android/gms/measurement/internal/zze:setTransactionSuccessful	()V
    //   511: aload_0
    //   512: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   515: invokevirtual 638	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   518: iconst_1
    //   519: ireturn
    //   520: aload 11
    //   522: invokevirtual 787	com/google/android/gms/measurement/internal/zza:zzBn	()J
    //   525: lstore_1
    //   526: lload_1
    //   527: lconst_0
    //   528: lcmp
    //   529: ifeq +176 -> 705
    //   532: lload_1
    //   533: invokestatic 129	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   536: astore 7
    //   538: aload 9
    //   540: aload 7
    //   542: putfield 790	com/google/android/gms/internal/zzqb$zze:zzbas	Ljava/lang/Long;
    //   545: aload 11
    //   547: invokevirtual 793	com/google/android/gms/measurement/internal/zza:zzBm	()J
    //   550: lstore 5
    //   552: lload 5
    //   554: lconst_0
    //   555: lcmp
    //   556: ifne +198 -> 754
    //   559: lload_1
    //   560: lconst_0
    //   561: lcmp
    //   562: ifeq +149 -> 711
    //   565: lload_1
    //   566: invokestatic 129	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   569: astore 7
    //   571: aload 9
    //   573: aload 7
    //   575: putfield 796	com/google/android/gms/internal/zzqb$zze:zzbar	Ljava/lang/Long;
    //   578: aload 11
    //   580: getfield 799	com/google/android/gms/measurement/internal/zza:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   583: invokevirtual 311	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   586: invokevirtual 314	com/google/android/gms/measurement/internal/zzv:zzjk	()V
    //   589: aload 11
    //   591: getfield 802	com/google/android/gms/measurement/internal/zza:zzaVf	J
    //   594: lconst_1
    //   595: ladd
    //   596: lstore 5
    //   598: lload 5
    //   600: lstore_1
    //   601: lload 5
    //   603: ldc2_w 803
    //   606: lcmp
    //   607: ifle +22 -> 629
    //   610: aload 11
    //   612: getfield 799	com/google/android/gms/measurement/internal/zza:zzaTV	Lcom/google/android/gms/measurement/internal/zzw;
    //   615: invokevirtual 113	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   618: getfield 290	com/google/android/gms/measurement/internal/zzp:zzaWF	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   621: ldc_w 806
    //   624: invokevirtual 141	com/google/android/gms/measurement/internal/zzp$zza:zzfg	(Ljava/lang/String;)V
    //   627: lconst_0
    //   628: lstore_1
    //   629: aload 11
    //   631: iconst_1
    //   632: putfield 809	com/google/android/gms/measurement/internal/zza:zzaVq	Z
    //   635: aload 11
    //   637: lload_1
    //   638: putfield 802	com/google/android/gms/measurement/internal/zza:zzaVf	J
    //   641: aload 9
    //   643: aload 11
    //   645: invokevirtual 812	com/google/android/gms/measurement/internal/zza:zzBr	()J
    //   648: l2i
    //   649: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: putfield 815	com/google/android/gms/internal/zzqb$zze:zzbaD	Ljava/lang/Integer;
    //   655: aload 11
    //   657: aload 9
    //   659: getfield 468	com/google/android/gms/internal/zzqb$zze:zzbap	Ljava/lang/Long;
    //   662: invokevirtual 632	java/lang/Long:longValue	()J
    //   665: invokevirtual 502	com/google/android/gms/measurement/internal/zza:zzO	(J)V
    //   668: aload 11
    //   670: aload 9
    //   672: getfield 471	com/google/android/gms/internal/zzqb$zze:zzbaq	Ljava/lang/Long;
    //   675: invokevirtual 632	java/lang/Long:longValue	()J
    //   678: invokevirtual 505	com/google/android/gms/measurement/internal/zza:zzP	(J)V
    //   681: aload_0
    //   682: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   685: aload 11
    //   687: invokevirtual 526	com/google/android/gms/measurement/internal/zze:zza	(Lcom/google/android/gms/measurement/internal/zza;)V
    //   690: goto -254 -> 436
    //   693: astore 7
    //   695: aload_0
    //   696: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   699: invokevirtual 638	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   702: aload 7
    //   704: athrow
    //   705: aconst_null
    //   706: astore 7
    //   708: goto -170 -> 538
    //   711: aconst_null
    //   712: astore 7
    //   714: goto -143 -> 571
    //   717: astore 8
    //   719: aload 7
    //   721: invokevirtual 816	com/google/android/gms/measurement/internal/zze:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   724: getfield 243	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   727: ldc_w 818
    //   730: aload 8
    //   732: invokevirtual 135	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   735: goto -231 -> 504
    //   738: aload_0
    //   739: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   742: invokevirtual 641	com/google/android/gms/measurement/internal/zze:setTransactionSuccessful	()V
    //   745: aload_0
    //   746: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   749: invokevirtual 638	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   752: iconst_0
    //   753: ireturn
    //   754: lload 5
    //   756: lstore_1
    //   757: goto -198 -> 559
    //   760: iconst_1
    //   761: istore_3
    //   762: goto -709 -> 53
    //   765: iload 4
    //   767: iconst_1
    //   768: iadd
    //   769: istore 4
    //   771: goto -684 -> 87
    //   774: iconst_0
    //   775: istore_3
    //   776: goto -723 -> 53
    //   779: iload_3
    //   780: iconst_1
    //   781: iadd
    //   782: istore_3
    //   783: goto -468 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	786	0	this	zzw
    //   0	786	1	paramLong	long
    //   53	730	3	i	int
    //   85	685	4	j	int
    //   550	205	5	l	long
    //   240	334	7	localObject1	Object
    //   693	10	7	localObject2	Object
    //   706	14	7	localObject3	Object
    //   16	467	8	localObject4	Object
    //   717	14	8	localSQLiteException	android.database.sqlite.SQLiteException
    //   62	609	9	localzze	zzqb.zze
    //   250	249	10	localObject5	Object
    //   257	429	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   7	50	693	finally
    //   57	82	693	finally
    //   87	169	693	finally
    //   172	194	693	finally
    //   201	232	693	finally
    //   232	313	693	finally
    //   315	364	693	finally
    //   364	394	693	finally
    //   397	418	693	finally
    //   423	436	693	finally
    //   436	482	693	finally
    //   482	504	693	finally
    //   504	511	693	finally
    //   520	526	693	finally
    //   532	538	693	finally
    //   538	552	693	finally
    //   565	571	693	finally
    //   571	598	693	finally
    //   610	627	693	finally
    //   629	690	693	finally
    //   719	735	693	finally
    //   738	745	693	finally
    //   482	504	717	android/database/sqlite/SQLiteException
  }
  
  protected final void start()
  {
    zzCn().zzjk();
    zzCj().zzCr();
    if (!zzCS()) {
      if (zzCo().zzAr())
      {
        if (!zzCk().zzbk("android.permission.INTERNET")) {
          zzAozzaWC.zzfg("App is missing INTERNET permission");
        }
        if (!zzCk().zzbk("android.permission.ACCESS_NETWORK_STATE")) {
          zzAozzaWC.zzfg("App is missing ACCESS_NETWORK_STATE permission");
        }
        if (!AppMeasurementReceiver.zzY(mContext)) {
          zzAozzaWC.zzfg("AppMeasurementReceiver not registered/enabled");
        }
        if (!AppMeasurementService.zzZ(mContext)) {
          zzAozzaWC.zzfg("AppMeasurementService not registered/enabled");
        }
        zzAozzaWC.zzfg("Uploading is not possible. App measurement disabled");
      }
    }
    for (;;)
    {
      zzDe();
      return;
      if ((!zzd.zzkr()) && (!TextUtils.isEmpty(zzCg().zzBk()))) {
        zzCf().zzDl();
      }
    }
  }
  
  public final zzp zzAo()
  {
    zza(zzaXZ);
    return zzaXZ;
  }
  
  protected final boolean zzCS()
  {
    boolean bool2 = true;
    zzjv();
    zzCn().zzjk();
    if (zzaYo == null)
    {
      if ((!zzCk().zzbk("android.permission.INTERNET")) || (!zzCk().zzbk("android.permission.ACCESS_NETWORK_STATE")) || (!AppMeasurementReceiver.zzY(mContext)) || (!AppMeasurementService.zzZ(mContext))) {
        break label123;
      }
      bool1 = true;
      zzaYo = Boolean.valueOf(bool1);
      if ((zzaYo.booleanValue()) && (!zzd.zzkr())) {
        if (TextUtils.isEmpty(zzCg().zzBk())) {
          break label128;
        }
      }
    }
    label123:
    label128:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzaYo = Boolean.valueOf(bool1);
      return zzaYo.booleanValue();
      bool1 = false;
      break;
    }
  }
  
  public final zzq zzCW()
  {
    zza(zzaYg);
    return zzaYg;
  }
  
  public final zzc zzCe()
  {
    zza(zzaYn);
    return zzaYn;
  }
  
  public final zzab zzCf()
  {
    zza(zzaYj);
    return zzaYj;
  }
  
  public final zzn zzCg()
  {
    zza(zzaYk);
    return zzaYk;
  }
  
  public final zzg zzCh()
  {
    zza(zzaYi);
    return zzaYi;
  }
  
  public final zze zzCj()
  {
    zza(zzaYf);
    return zzaYf;
  }
  
  public final zzaj zzCk()
  {
    zza(zzaYe);
    return zzaYe;
  }
  
  public final zzu zzCl()
  {
    zza(zzaYc);
    return zzaYc;
  }
  
  public final zzv zzCn()
  {
    zza(zzaYa);
    return zzaYa;
  }
  
  public final zzt zzCo()
  {
    zza(zzaXY);
    return zzaXY;
  }
  
  public final void zzDc()
  {
    Object localObject4 = null;
    boolean bool = false;
    zzCn().zzjk();
    zzjv();
    if (!zzd.zzkr())
    {
      localObject1 = zzCo().zzCP();
      if (localObject1 == null) {
        zzAozzaWF.zzfg("Upload data called on the client side before use of service was decided");
      }
    }
    int i;
    long l1;
    String str;
    do
    {
      return;
      if (((Boolean)localObject1).booleanValue())
      {
        zzAozzaWC.zzfg("Upload called in the client side when service should be used");
        return;
      }
      zzCn().zzjk();
      if (zzaYp != null) {}
      for (i = 1; i != 0; i = 0)
      {
        zzAozzaWF.zzfg("Uploading requested multiple times");
        return;
      }
      if (!zzCW().zzlB())
      {
        zzAozzaWF.zzfg("Network not connected, ignoring upload request");
        zzDe();
        return;
      }
      l1 = zzqW.currentTimeMillis();
      zzg$505cfb57(l1 - zzd.zzBW());
      long l2 = zzCozzaXj.get();
      if (l2 != 0L) {
        zzAozzaWJ.zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(l1 - l2)));
      }
      str = zzCj().zzCq();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      i = zzaXX.zzb(str, zzl.zzaWg);
      int j = Math.max(0, zzaXX.zzb(str, zzl.zzaWh));
      localObject4 = zzCj().zzn(str, i, j);
    } while (((List)localObject4).isEmpty());
    Object localObject1 = ((List)localObject4).iterator();
    Object localObject5;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject5 = (zzqb.zze)nextfirst;
    } while (TextUtils.isEmpty(zzbaz));
    Object localObject3;
    for (localObject1 = zzbaz;; localObject3 = null)
    {
      if (localObject1 != null)
      {
        i = 0;
        if (i < ((List)localObject4).size())
        {
          localObject5 = (zzqb.zze)getfirst;
          if ((TextUtils.isEmpty(zzbaz)) || (zzbaz.equals(localObject1))) {}
        }
      }
      for (localObject1 = ((List)localObject4).subList(0, i);; localObject3 = localObject4)
      {
        localObject5 = new zzqb.zzd();
        zzbaj = new zzqb.zze[((List)localObject1).size()];
        localObject4 = new ArrayList(((List)localObject1).size());
        i = 0;
        for (;;)
        {
          if (i < zzbaj.length)
          {
            zzbaj[i] = ((zzqb.zze)getfirst);
            ((List)localObject4).add(getsecond);
            zzbaj[i].zzbay = Long.valueOf(zzd.zzBp());
            zzbaj[i].zzbao = Long.valueOf(l1);
            zzbaj[i].zzbaE = Boolean.valueOf(zzd.zzkr());
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
        if (zzAo().zzQ(2)) {}
        for (localObject1 = zzaj.zzb((zzqb.zzd)localObject5);; localObject3 = null)
        {
          Object localObject7 = zzCk().zza((zzqb.zzd)localObject5);
          Object localObject6 = zzd.zzBV();
          for (;;)
          {
            try
            {
              URL localURL = new URL((String)localObject6);
              if (!((List)localObject4).isEmpty()) {
                bool = true;
              }
              zzx.zzac(bool);
              if (zzaYp != null)
              {
                zzAozzaWC.zzfg("Set uploading progress before finishing the previous upload");
                zzCozzaXk.set(l1);
                localObject4 = "?";
                if (zzbaj.length > 0) {
                  localObject4 = zzbaj[0].appId;
                }
                zzAozzaWK.zzd("Uploading data. app, uncompressed size, data", localObject4, Integer.valueOf(localObject7.length), localObject1);
                zzCW().zza$73165fc8(str, localURL, (byte[])localObject7, new zzq.zza()
                {
                  public final void zza(String paramAnonymousString, int paramAnonymousInt, Throwable paramAnonymousThrowable, byte[] paramAnonymousArrayOfByte)
                  {
                    zzw.zza(zzw.this, paramAnonymousInt, paramAnonymousThrowable, paramAnonymousArrayOfByte);
                  }
                });
                return;
              }
            }
            catch (MalformedURLException localMalformedURLException1)
            {
              zzAozzaWC.zzj("Failed to parse upload URL. Not uploading", localObject6);
              return;
            }
            zzaYp = new ArrayList((Collection)localObject4);
          }
          str = zzCj().zzaa(l1 - zzd.zzBW());
          if (TextUtils.isEmpty(str)) {
            break;
          }
          Object localObject2 = zzCj().zzeY(str);
          if (localObject2 == null) {
            break;
          }
          localObject5 = ((zza)localObject2).zzBk();
          localObject6 = ((zza)localObject2).zzBj();
          localObject7 = new Uri.Builder();
          ((Uri.Builder)localObject7).scheme((String)zzl.zzaWe.get()).authority((String)zzl.zzaWf.get()).path("config/app/" + (String)localObject5).appendQueryParameter("app_instance_id", (String)localObject6).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzd.zzBp()));
          localObject5 = ((Uri.Builder)localObject7).build().toString();
          try
          {
            localObject6 = new URL((String)localObject5);
            zzAozzaWK.zzj("Fetching remote configuration", ((zza)localObject2).zzwK());
            localObject7 = zzCl().zzfk(((zza)localObject2).zzwK());
            localObject2 = localObject4;
            if (localObject7 != null)
            {
              localObject2 = localObject4;
              if (zzaZT != null)
              {
                localObject2 = new ArrayMap();
                ((Map)localObject2).put("Config-Version", String.valueOf(zzaZT));
              }
            }
            zzCW().zza(str, (URL)localObject6, (Map)localObject2, new zzq.zza()
            {
              public final void zza(String paramAnonymousString, int paramAnonymousInt, Throwable paramAnonymousThrowable, byte[] paramAnonymousArrayOfByte)
              {
                zzw.zza(zzw.this, paramAnonymousString, paramAnonymousInt, paramAnonymousThrowable, paramAnonymousArrayOfByte);
              }
            });
            return;
          }
          catch (MalformedURLException localMalformedURLException2)
          {
            zzAozzaWC.zzj("Failed to parse config URL. Not fetching", localObject5);
            return;
          }
        }
      }
    }
  }
  
  final void zzDe()
  {
    zzCn().zzjk();
    zzjv();
    if ((!zzCS()) || (!zzDd()))
    {
      zzCX().unregister();
      zzCY().cancel();
      return;
    }
    long l5 = zzqW.currentTimeMillis();
    long l1 = zzd.zzCa();
    long l2 = zzd.zzBY();
    long l6 = zzCozzaXj.get();
    long l4 = zzCozzaXk.get();
    long l3 = Math.max(zzCj().zza$6e791f8("select max(bundle_end_timestamp) from queue", null), zzCj().zza$6e791f8("select max(timestamp) from raw_events", null));
    if (l3 == 0L) {
      l1 = 0L;
    }
    while (l1 == 0L)
    {
      zzCX().unregister();
      zzCY().cancel();
      return;
      l3 = l5 - Math.abs(l3 - l5);
      l6 = Math.abs(l6 - l5);
      l4 = l5 - Math.abs(l4 - l5);
      l5 = Math.max(l5 - l6, l4);
      l1 += l3;
      if (!zzCk().zzc(l5, l2)) {
        l1 = l5 + l2;
      }
      if ((l4 != 0L) && (l4 >= l3))
      {
        int i = 0;
        for (;;)
        {
          if (i >= zzd.zzCc()) {
            break label266;
          }
          l1 += (1 << i) * zzd.zzCb();
          if (l1 > l4) {
            break;
          }
          i += 1;
        }
        label266:
        l1 = 0L;
      }
    }
    if (!zzCW().zzlB())
    {
      zzr localzzr = zzCX();
      zzaTV.zzjv();
      zzaTV.zzCn().zzjk();
      if (!zzTa)
      {
        zzaTV.mContext.registerReceiver(localzzr, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        zzTb = zzaTV.zzCW().zzlB();
        zzaTV.zzAo().zzaWK.zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(zzTb));
        zzTa = true;
      }
      zzCY().cancel();
      return;
    }
    l3 = zzCozzaXl.get();
    l4 = zzd.zzBX();
    l2 = l1;
    if (!zzCk().zzc(l3, l4)) {
      l2 = Math.max(l1, l3 + l4);
    }
    zzCX().unregister();
    l1 = l2 - zzqW.currentTimeMillis();
    if (l1 <= 0L)
    {
      zzCY().zzt(1L);
      return;
    }
    zzAozzaWK.zzj("Upload scheduled in approximately ms", Long.valueOf(l1));
    zzCY().zzt(l1);
  }
  
  final void zza(EventParcel paramEventParcel, String paramString)
  {
    zza localzza = zzCj().zzeY(paramString);
    if ((localzza == null) || (TextUtils.isEmpty(localzza.zzli())))
    {
      zzAozzaWJ.zzj("No app data available; dropping event", paramString);
      return;
    }
    try
    {
      String str = mContext.getPackageManager().getPackageInfo(paramString, 0).versionName;
      if ((localzza.zzli() != null) && (!localzza.zzli().equals(str)))
      {
        zzAozzaWF.zzj("App version does not match; dropping event", paramString);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      zzAozzaWF.zzj("Could not find package", paramString);
      zzb(paramEventParcel, new AppMetadata(paramString, localzza.zzBk(), localzza.zzli(), localzza.zzBo(), localzza.zzBp(), localzza.zzBq(), null, localzza.zzAr(), false));
    }
  }
  
  final void zzb(EventParcel paramEventParcel, AppMetadata paramAppMetadata)
  {
    long l1 = System.nanoTime();
    zzCn().zzjk();
    zzjv();
    String str = packageName;
    zzx.zzcM(str);
    if (TextUtils.isEmpty(zzaVt)) {
      return;
    }
    if (!zzaVy)
    {
      zze(paramAppMetadata);
      return;
    }
    if (zzCl().zzP(str, name))
    {
      zzAozzaWK.zzj("Dropping blacklisted event", name);
      return;
    }
    if (zzAo().zzQ(2)) {
      zzAozzaWK.zzj("Logging event", paramEventParcel);
    }
    zzCj().beginTransaction();
    Bundle localBundle;
    boolean bool2;
    int i;
    for (;;)
    {
      try
      {
        localBundle = zzaVV.zzCC();
        zze(paramAppMetadata);
        zzai localzzai;
        if (("_iap".equals(name)) || ("ecommerce_purchase".equals(name)))
        {
          localObject = localBundle.getString("currency");
          l2 = localBundle.getLong("value");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (l2 > 0L))
          {
            localObject = ((String)localObject).toUpperCase(Locale.US);
            if (((String)localObject).matches("[A-Z]{3}"))
            {
              localObject = "_ltv_" + (String)localObject;
              localzzai = zzCj().zzK(str, (String)localObject);
              if ((localzzai != null) && ((zzNc instanceof Long))) {
                continue;
              }
              zzCj().zzA(str, zzaXX.zzb(str, zzl.zzaWx) - 1);
              localObject = new zzai(str, (String)localObject, zzqW.currentTimeMillis(), Long.valueOf(l2));
              zzCj().zza((zzai)localObject);
            }
          }
        }
        bool2 = zzaj.zzfq(name);
        if (localBundle.getLong("_c") == 1L)
        {
          i = 1;
          localObject = zzCj();
          l2 = (zzqW.currentTimeMillis() + zzCo().zzCN()) / 1000L / 60L / 60L / 24L;
          if ((!bool2) || (i == 0)) {
            break label541;
          }
          bool1 = true;
          localObject = ((zze)localObject).zza(l2, str, bool2, bool1);
          l2 = zzaVF - zzd.zzBI();
          if (l2 <= 0L) {
            break;
          }
          if (l2 % 1000L == 1L) {
            zzAozzaWF.zzj("Data loss. Too many events logged. count", Long.valueOf(zzaVF));
          }
          zzCj().setTransactionSuccessful();
          return;
          long l3 = ((Long)zzNc).longValue();
          localObject = new zzai(str, (String)localObject, zzqW.currentTimeMillis(), Long.valueOf(l2 + l3));
          continue;
        }
        i = 0;
      }
      finally
      {
        zzCj().endTransaction();
      }
      continue;
      label541:
      boolean bool1 = false;
    }
    if (bool2)
    {
      l2 = zzaVE - zzd.zzBJ();
      if (l2 > 0L)
      {
        if (l2 % 1000L == 1L) {
          zzAozzaWF.zzj("Data loss. Too many public events logged. count", Long.valueOf(zzaVE));
        }
        zzCj().setTransactionSuccessful();
        zzCj().endTransaction();
        return;
      }
    }
    if ((bool2) && (i != 0) && (zzaVG - zzd.zzBK() > 0L))
    {
      localBundle.remove("_c");
      if (localBundle.getLong("_err") == 0L) {
        localBundle.putLong("_err", 4L);
      }
    }
    long l2 = zzCj().zzeZ(str);
    if (l2 > 0L) {
      zzAozzaWF.zzj("Data lost. Too many events stored on disk, deleted", Long.valueOf(l2));
    }
    Object localObject = new zzh(this, zzaVW, str, name, zzaVX, localBundle);
    paramEventParcel = zzCj().zzI(str, mName);
    if (paramEventParcel == null)
    {
      paramEventParcel = zzCj();
      zzx.zzcM(str);
      l2 = paramEventParcel.zza$6e791f8("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[] { str });
      zzd.zzBH();
      if (l2 >= 500L)
      {
        zzAozzaWF.zze("Too many event names used, ignoring event. name, supported count", mName, Integer.valueOf(zzd.zzBH()));
        zzCj().endTransaction();
        return;
      }
    }
    for (paramEventParcel = new zzi(str, mName, 0L, 0L, zzaez);; paramEventParcel = new zzi(zzaUa, mName, zzaVP, zzaVQ, l2))
    {
      zzCj().zza(paramEventParcel);
      zza((zzh)localObject, paramAppMetadata);
      zzCj().setTransactionSuccessful();
      if (zzAo().zzQ(2)) {
        zzAozzaWK.zzj("Event recorded", localObject);
      }
      zzCj().endTransaction();
      zzDe();
      zzAozzaWK.zzj("Background event processing time, ms", Long.valueOf((System.nanoTime() - l1 + 500000L) / 1000000L));
      return;
      l2 = zzaVR;
      localObject = new zzh(this, zzaVM, zzaUa, mName, zzaez, l2, zzaVO);
      l2 = zzaez;
    }
  }
  
  /* Error */
  final void zzb(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 311	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   4: invokevirtual 314	com/google/android/gms/measurement/internal/zzv:zzjk	()V
    //   7: aload_0
    //   8: invokevirtual 317	com/google/android/gms/measurement/internal/zzw:zzjv	()V
    //   11: aload_2
    //   12: getfield 399	com/google/android/gms/measurement/internal/AppMetadata:zzaVt	Ljava/lang/String;
    //   15: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +4 -> 22
    //   21: return
    //   22: aload_2
    //   23: getfield 520	com/google/android/gms/measurement/internal/AppMetadata:zzaVy	Z
    //   26: ifne +9 -> 35
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual 1182	com/google/android/gms/measurement/internal/zzw:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   34: return
    //   35: aload_0
    //   36: invokevirtual 571	com/google/android/gms/measurement/internal/zzw:zzCk	()Lcom/google/android/gms/measurement/internal/zzaj;
    //   39: pop
    //   40: aload_1
    //   41: getfield 1375	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   44: invokestatic 1378	com/google/android/gms/measurement/internal/zzaj:zzfs	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: invokevirtual 571	com/google/android/gms/measurement/internal/zzw:zzCk	()Lcom/google/android/gms/measurement/internal/zzaj;
    //   51: pop
    //   52: aload_1
    //   53: getfield 1375	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 1381	com/google/android/gms/measurement/internal/UserAttributeParcel:getValue	()Ljava/lang/Object;
    //   60: invokestatic 1384	com/google/android/gms/measurement/internal/zzaj:zzm	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull -46 -> 21
    //   70: new 555	com/google/android/gms/measurement/internal/zzai
    //   73: dup
    //   74: aload_2
    //   75: getfield 355	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   78: aload_1
    //   79: getfield 1375	com/google/android/gms/measurement/internal/UserAttributeParcel:name	Ljava/lang/String;
    //   82: aload_1
    //   83: getfield 1387	com/google/android/gms/measurement/internal/UserAttributeParcel:zzaZm	J
    //   86: aload 4
    //   88: invokespecial 1247	com/google/android/gms/measurement/internal/zzai:<init>	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   91: astore_1
    //   92: aload_0
    //   93: invokevirtual 113	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   96: getfield 144	com/google/android/gms/measurement/internal/zzp:zzaWJ	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   99: ldc_w 1389
    //   102: aload_1
    //   103: getfield 558	com/google/android/gms/measurement/internal/zzai:mName	Ljava/lang/String;
    //   106: aload 4
    //   108: invokevirtual 254	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   111: aload_0
    //   112: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   115: invokevirtual 616	com/google/android/gms/measurement/internal/zze:beginTransaction	()V
    //   118: aload_0
    //   119: aload_2
    //   120: invokevirtual 1182	com/google/android/gms/measurement/internal/zzw:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   123: aload_0
    //   124: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   127: aload_1
    //   128: invokevirtual 1250	com/google/android/gms/measurement/internal/zze:zza	(Lcom/google/android/gms/measurement/internal/zzai;)Z
    //   131: istore_3
    //   132: aload_0
    //   133: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   136: invokevirtual 641	com/google/android/gms/measurement/internal/zze:setTransactionSuccessful	()V
    //   139: iload_3
    //   140: ifeq +32 -> 172
    //   143: aload_0
    //   144: invokevirtual 113	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   147: getfield 144	com/google/android/gms/measurement/internal/zzp:zzaWJ	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   150: ldc_w 1391
    //   153: aload_1
    //   154: getfield 558	com/google/android/gms/measurement/internal/zzai:mName	Ljava/lang/String;
    //   157: aload_1
    //   158: getfield 574	com/google/android/gms/measurement/internal/zzai:zzNc	Ljava/lang/Object;
    //   161: invokevirtual 254	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: aload_0
    //   165: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   168: invokevirtual 638	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   171: return
    //   172: aload_0
    //   173: invokevirtual 113	com/google/android/gms/measurement/internal/zzw:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
    //   176: getfield 1394	com/google/android/gms/measurement/internal/zzp:zzaWH	Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   179: ldc_w 1396
    //   182: aload_1
    //   183: getfield 558	com/google/android/gms/measurement/internal/zzai:mName	Ljava/lang/String;
    //   186: aload_1
    //   187: getfield 574	com/google/android/gms/measurement/internal/zzai:zzNc	Ljava/lang/Object;
    //   190: invokevirtual 254	com/google/android/gms/measurement/internal/zzp$zza:zze	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   193: goto -29 -> 164
    //   196: astore_1
    //   197: aload_0
    //   198: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   201: invokevirtual 638	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	zzw
    //   0	206	1	paramUserAttributeParcel	UserAttributeParcel
    //   0	206	2	paramAppMetadata	AppMetadata
    //   131	9	3	bool	boolean
    //   63	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   118	139	196	finally
    //   143	164	196	finally
    //   172	193	196	finally
  }
  
  /* Error */
  public final void zzd(AppMetadata paramAppMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 311	com/google/android/gms/measurement/internal/zzw:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
    //   4: invokevirtual 314	com/google/android/gms/measurement/internal/zzv:zzjk	()V
    //   7: aload_0
    //   8: invokevirtual 317	com/google/android/gms/measurement/internal/zzw:zzjv	()V
    //   11: aload_1
    //   12: invokestatic 76	com/google/android/gms/common/internal/zzx:zzz	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_1
    //   17: getfield 355	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   20: invokestatic 350	com/google/android/gms/common/internal/zzx:zzcM	(Ljava/lang/String;)Ljava/lang/String;
    //   23: pop
    //   24: aload_1
    //   25: getfield 399	com/google/android/gms/measurement/internal/AppMetadata:zzaVt	Ljava/lang/String;
    //   28: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifeq +4 -> 35
    //   34: return
    //   35: aload_1
    //   36: getfield 520	com/google/android/gms/measurement/internal/AppMetadata:zzaVy	Z
    //   39: ifne +9 -> 48
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 1182	com/google/android/gms/measurement/internal/zzw:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   47: return
    //   48: aload_0
    //   49: getfield 89	com/google/android/gms/measurement/internal/zzw:zzqW	Lcom/google/android/gms/internal/zzmq;
    //   52: invokeinterface 597 1 0
    //   57: lstore_2
    //   58: aload_0
    //   59: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   62: invokevirtual 616	com/google/android/gms/measurement/internal/zze:beginTransaction	()V
    //   65: aload_0
    //   66: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   69: aload_1
    //   70: getfield 355	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   73: invokevirtual 475	com/google/android/gms/measurement/internal/zze:zzeY	(Ljava/lang/String;)Lcom/google/android/gms/measurement/internal/zza;
    //   76: astore 4
    //   78: aload 4
    //   80: ifnull +76 -> 156
    //   83: aload 4
    //   85: invokevirtual 1139	com/google/android/gms/measurement/internal/zza:zzli	()Ljava/lang/String;
    //   88: ifnull +68 -> 156
    //   91: aload 4
    //   93: invokevirtual 1139	com/google/android/gms/measurement/internal/zza:zzli	()Ljava/lang/String;
    //   96: aload_1
    //   97: getfield 387	com/google/android/gms/measurement/internal/AppMetadata:zzaMV	Ljava/lang/String;
    //   100: invokevirtual 361	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifne +53 -> 156
    //   106: new 1207	android/os/Bundle
    //   109: dup
    //   110: invokespecial 1397	android/os/Bundle:<init>	()V
    //   113: astore 5
    //   115: aload 5
    //   117: ldc_w 1399
    //   120: aload 4
    //   122: invokevirtual 1139	com/google/android/gms/measurement/internal/zza:zzli	()Ljava/lang/String;
    //   125: invokevirtual 1403	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: new 1184	com/google/android/gms/measurement/internal/EventParcel
    //   132: dup
    //   133: ldc_w 1405
    //   136: new 1195	com/google/android/gms/measurement/internal/EventParams
    //   139: dup
    //   140: aload 5
    //   142: invokespecial 1408	com/google/android/gms/measurement/internal/EventParams:<init>	(Landroid/os/Bundle;)V
    //   145: ldc_w 1410
    //   148: lload_2
    //   149: invokespecial 1413	com/google/android/gms/measurement/internal/EventParcel:<init>	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/EventParams;Ljava/lang/String;J)V
    //   152: aload_1
    //   153: invokevirtual 1174	com/google/android/gms/measurement/internal/zzw:zzb	(Lcom/google/android/gms/measurement/internal/EventParcel;Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   156: aload_0
    //   157: aload_1
    //   158: invokevirtual 1182	com/google/android/gms/measurement/internal/zzw:zze	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   161: aload_0
    //   162: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   165: aload_1
    //   166: getfield 355	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   169: ldc_w 1415
    //   172: invokevirtual 1321	com/google/android/gms/measurement/internal/zze:zzI	(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/measurement/internal/zzi;
    //   175: ifnonnull +97 -> 272
    //   178: aload_0
    //   179: new 1374	com/google/android/gms/measurement/internal/UserAttributeParcel
    //   182: dup
    //   183: ldc_w 1417
    //   186: lload_2
    //   187: lload_2
    //   188: ldc2_w 1418
    //   191: ldiv
    //   192: lconst_1
    //   193: ladd
    //   194: ldc2_w 1418
    //   197: lmul
    //   198: invokestatic 129	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   201: ldc_w 1410
    //   204: invokespecial 1422	com/google/android/gms/measurement/internal/UserAttributeParcel:<init>	(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   207: aload_1
    //   208: invokevirtual 1424	com/google/android/gms/measurement/internal/zzw:zzb	(Lcom/google/android/gms/measurement/internal/UserAttributeParcel;Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   211: new 1207	android/os/Bundle
    //   214: dup
    //   215: invokespecial 1397	android/os/Bundle:<init>	()V
    //   218: astore 4
    //   220: aload 4
    //   222: ldc_w 1255
    //   225: lconst_1
    //   226: invokevirtual 1302	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   229: aload_0
    //   230: new 1184	com/google/android/gms/measurement/internal/EventParcel
    //   233: dup
    //   234: ldc_w 1415
    //   237: new 1195	com/google/android/gms/measurement/internal/EventParams
    //   240: dup
    //   241: aload 4
    //   243: invokespecial 1408	com/google/android/gms/measurement/internal/EventParams:<init>	(Landroid/os/Bundle;)V
    //   246: ldc_w 1410
    //   249: lload_2
    //   250: invokespecial 1413	com/google/android/gms/measurement/internal/EventParcel:<init>	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/EventParams;Ljava/lang/String;J)V
    //   253: aload_1
    //   254: invokevirtual 1174	com/google/android/gms/measurement/internal/zzw:zzb	(Lcom/google/android/gms/measurement/internal/EventParcel;Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   257: aload_0
    //   258: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   261: invokevirtual 641	com/google/android/gms/measurement/internal/zze:setTransactionSuccessful	()V
    //   264: aload_0
    //   265: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   268: invokevirtual 638	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   271: return
    //   272: aload_1
    //   273: getfield 1427	com/google/android/gms/measurement/internal/AppMetadata:zzaVz	Z
    //   276: ifeq -19 -> 257
    //   279: aload_0
    //   280: new 1184	com/google/android/gms/measurement/internal/EventParcel
    //   283: dup
    //   284: ldc_w 1429
    //   287: new 1195	com/google/android/gms/measurement/internal/EventParams
    //   290: dup
    //   291: new 1207	android/os/Bundle
    //   294: dup
    //   295: invokespecial 1397	android/os/Bundle:<init>	()V
    //   298: invokespecial 1408	com/google/android/gms/measurement/internal/EventParams:<init>	(Landroid/os/Bundle;)V
    //   301: ldc_w 1410
    //   304: lload_2
    //   305: invokespecial 1413	com/google/android/gms/measurement/internal/EventParcel:<init>	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/EventParams;Ljava/lang/String;J)V
    //   308: aload_1
    //   309: invokevirtual 1174	com/google/android/gms/measurement/internal/zzw:zzb	(Lcom/google/android/gms/measurement/internal/EventParcel;Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   312: goto -55 -> 257
    //   315: astore_1
    //   316: aload_0
    //   317: invokevirtual 321	com/google/android/gms/measurement/internal/zzw:zzCj	()Lcom/google/android/gms/measurement/internal/zze;
    //   320: invokevirtual 638	com/google/android/gms/measurement/internal/zze:endTransaction	()V
    //   323: aload_1
    //   324: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	zzw
    //   0	325	1	paramAppMetadata	AppMetadata
    //   57	248	2	l	long
    //   76	166	4	localObject	Object
    //   113	28	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   65	78	315	finally
    //   83	156	315	finally
    //   156	257	315	finally
    //   257	264	315	finally
    //   272	312	315	finally
  }
  
  final void zze(AppMetadata paramAppMetadata)
  {
    int k = 1;
    zzCn().zzjk();
    zzjv();
    zzx.zzz(paramAppMetadata);
    zzx.zzcM(packageName);
    zza localzza2 = zzCj().zzeY(packageName);
    String str = zzCo().zzfi(packageName);
    int i = 0;
    zza localzza1;
    if (localzza2 == null)
    {
      localzza1 = new zza(this, packageName);
      localzza1.zzeM(zzCo().zzCM());
      localzza1.zzeO(str);
      i = 1;
      int j = i;
      if (!TextUtils.isEmpty(zzaVt))
      {
        j = i;
        if (!zzaVt.equals(localzza1.zzBk()))
        {
          localzza1.zzeN(zzaVt);
          j = 1;
        }
      }
      i = j;
      if (zzaVv != 0L)
      {
        i = j;
        if (zzaVv != localzza1.zzBp())
        {
          localzza1.zzQ(zzaVv);
          i = 1;
        }
      }
      j = i;
      if (!TextUtils.isEmpty(zzaMV))
      {
        j = i;
        if (!zzaMV.equals(localzza1.zzli()))
        {
          localzza1.setAppVersion(zzaMV);
          j = 1;
        }
      }
      i = j;
      if (!TextUtils.isEmpty(zzaVu))
      {
        i = j;
        if (!zzaVu.equals(localzza1.zzBo()))
        {
          localzza1.zzeP(zzaVu);
          i = 1;
        }
      }
      if (zzaVw != localzza1.zzBq())
      {
        localzza1.zzR(zzaVw);
        i = 1;
      }
      if (zzaVy == localzza1.zzAr()) {
        break label359;
      }
      localzza1.setMeasurementEnabled(zzaVy);
      i = k;
    }
    label359:
    for (;;)
    {
      if (i != 0) {
        zzCj().zza(localzza1);
      }
      return;
      localzza1 = localzza2;
      if (str.equals(localzza2.zzBl())) {
        break;
      }
      localzza2.zzeO(str);
      localzza2.zzeM(zzCo().zzCM());
      i = 1;
      localzza1 = localzza2;
      break;
    }
  }
  
  final void zzjv()
  {
    if (!zzQk) {
      throw new IllegalStateException("AppMeasurement is not initialized");
    }
  }
  
  private final class zza
    implements zze.zzb
  {
    zzqb.zze zzaYt;
    List<Long> zzaYu;
    long zzaYv;
    List<zzqb.zzb> zzpH;
    
    private zza() {}
    
    private static long zza(zzqb.zzb paramzzb)
    {
      return zzbaf.longValue() / 1000L / 60L / 60L;
    }
    
    public final boolean zza(long paramLong, zzqb.zzb paramzzb)
    {
      zzx.zzz(paramzzb);
      if (zzpH == null) {
        zzpH = new ArrayList();
      }
      if (zzaYu == null) {
        zzaYu = new ArrayList();
      }
      if ((zzpH.size() > 0) && (zza((zzqb.zzb)zzpH.get(0)) != zza(paramzzb))) {
        return false;
      }
      long l = zzaYv + paramzzb.getSerializedSize();
      if (l >= zzd.zzBT()) {
        return false;
      }
      zzaYv = l;
      zzpH.add(paramzzb);
      zzaYu.add(Long.valueOf(paramLong));
      return zzpH.size() < zzd.zzBU();
    }
    
    public final void zzc(zzqb.zze paramzze)
    {
      zzx.zzz(paramzze);
      zzaYt = paramzze;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */