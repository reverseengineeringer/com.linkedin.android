package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzge.zza;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzis;

@zzhb
public final class zze
  extends zzge.zza
  implements ServiceConnection
{
  private final Activity mActivity;
  private zzb zzFC;
  zzh zzFD;
  private zzk zzFF;
  private Context zzFK;
  private zzgc zzFL;
  private zzf zzFM;
  private zzj zzFN;
  private String zzFO = null;
  
  public zze(Activity paramActivity)
  {
    mActivity = paramActivity;
    zzFD = zzh.zzy(mActivity.getApplicationContext());
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001) {}
    label230:
    label375:
    label384:
    label398:
    label401:
    for (;;)
    {
      Object localObject1;
      try
      {
        zzr.zzbM();
        Object localObject2;
        String str;
        if (paramIntent == null)
        {
          paramInt1 = 5;
          if (paramInt2 != -1) {
            continue;
          }
          zzr.zzbM();
          if (paramInt1 != 0) {
            continue;
          }
          localObject2 = zzFF;
          str = zzFO;
          if (str == null) {
            break label375;
          }
          if (paramIntent == null)
          {
            break label375;
            zzFL.recordPlayBillingResolution(paramInt1);
            mActivity.finish();
            zzFL.getProductId();
          }
        }
        else
        {
          localObject1 = paramIntent.getExtras().get("RESPONSE_CODE");
          if (localObject1 == null)
          {
            zzin.zzaK("Intent with no response code, assuming OK (known issue)");
            paramInt1 = 0;
            continue;
          }
          if ((localObject1 instanceof Integer))
          {
            paramInt1 = ((Integer)localObject1).intValue();
            continue;
          }
          if ((localObject1 instanceof Long))
          {
            paramInt1 = (int)((Long)localObject1).longValue();
            continue;
          }
          zzin.zzaK("Unexpected type for intent response code. " + localObject1.getClass().getName());
          paramInt1 = 5;
          continue;
        }
        zzr.zzbM();
        if (paramIntent == null)
        {
          localObject1 = null;
          zzr.zzbM();
          if (paramIntent == null)
          {
            paramIntent = null;
            break label384;
          }
        }
        else
        {
          localObject1 = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
          continue;
        }
        paramIntent = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
        break label384;
        zzr.zzbM();
        if (!str.equals(zzi.zzaq((String)localObject1)))
        {
          zzin.zzaK("Developer payload not match.");
          paramInt2 = 0;
        }
        else
        {
          if (zzuM == null) {
            break label398;
          }
          localObject2 = zzuM;
          boolean bool;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(paramIntent)))
          {
            zzin.e("Purchase verification failed: missing data.");
            bool = false;
            if (bool) {
              break label398;
            }
            zzin.zzaK("Fail to verify signature.");
            paramInt2 = 0;
          }
          else
          {
            bool = zzl.zza(zzl.zzas((String)localObject2), (String)localObject1, paramIntent);
            continue;
            zzFD.zza(zzFM);
            continue;
            paramInt2 = 0;
          }
        }
      }
      catch (RemoteException paramIntent)
      {
        zzin.zzaK("Fail to process purchase result.");
        mActivity.finish();
        return;
      }
      finally
      {
        zzFO = null;
      }
      for (;;)
      {
        if (paramInt2 == 0) {
          break label401;
        }
        break;
        if ((localObject1 != null) && (paramIntent != null)) {
          break label230;
        }
        paramInt2 = 0;
        continue;
        paramInt2 = 1;
      }
    }
  }
  
  public final void onCreate()
  {
    Object localObject = GInAppPurchaseManagerInfoParcel.zzc(mActivity.getIntent());
    zzFN = zzFy;
    zzFF = zzrI;
    zzFL = zzFw;
    zzFC = new zzb(mActivity.getApplicationContext());
    zzFK = zzFx;
    if (mActivity.getResources().getConfiguration().orientation == 2) {
      mActivity.setRequestedOrientation(zzr.zzbE().zzhv());
    }
    for (;;)
    {
      localObject = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      ((Intent)localObject).setPackage("com.android.vending");
      mActivity.bindService((Intent)localObject, this, 1);
      return;
      mActivity.setRequestedOrientation(zzr.zzbE().zzhw());
    }
  }
  
  public final void onDestroy()
  {
    mActivity.unbindService(this);
    zzFC.zzFz = null;
  }
  
  /* Error */
  public final void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 219	com/google/android/gms/ads/internal/purchase/zze:zzFC	Lcom/google/android/gms/ads/internal/purchase/zzb;
    //   4: astore_1
    //   5: aload_1
    //   6: aload_1
    //   7: getfield 288	com/google/android/gms/ads/internal/purchase/zzb:mContext	Landroid/content/Context;
    //   10: invokevirtual 294	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   13: ldc_w 296
    //   16: invokevirtual 302	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   19: ldc_w 304
    //   22: iconst_1
    //   23: anewarray 124	java/lang/Class
    //   26: dup
    //   27: iconst_0
    //   28: ldc_w 306
    //   31: aastore
    //   32: invokevirtual 310	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   35: aconst_null
    //   36: iconst_1
    //   37: anewarray 118	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_2
    //   43: aastore
    //   44: invokevirtual 316	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   47: putfield 277	com/google/android/gms/ads/internal/purchase/zzb:zzFz	Ljava/lang/Object;
    //   50: invokestatic 320	com/google/android/gms/ads/internal/zzr:zzbC	()Lcom/google/android/gms/internal/zzir;
    //   53: pop
    //   54: aload_0
    //   55: invokestatic 325	com/google/android/gms/internal/zzir:zzhs	()Ljava/lang/String;
    //   58: putfield 32	com/google/android/gms/ads/internal/purchase/zze:zzFO	Ljava/lang/String;
    //   61: aload_0
    //   62: getfield 219	com/google/android/gms/ads/internal/purchase/zze:zzFC	Lcom/google/android/gms/ads/internal/purchase/zzb;
    //   65: aload_0
    //   66: getfield 34	com/google/android/gms/ads/internal/purchase/zze:mActivity	Landroid/app/Activity;
    //   69: invokevirtual 328	android/app/Activity:getPackageName	()Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 63	com/google/android/gms/ads/internal/purchase/zze:zzFL	Lcom/google/android/gms/internal/zzgc;
    //   76: invokeinterface 76 1 0
    //   81: aload_0
    //   82: getfield 32	com/google/android/gms/ads/internal/purchase/zze:zzFO	Ljava/lang/String;
    //   85: invokevirtual 332	com/google/android/gms/ads/internal/purchase/zzb:zzb	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    //   88: astore_1
    //   89: aload_1
    //   90: ldc_w 334
    //   93: invokevirtual 338	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   96: checkcast 340	android/app/PendingIntent
    //   99: astore 7
    //   101: aload 7
    //   103: ifnonnull +138 -> 241
    //   106: invokestatic 59	com/google/android/gms/ads/internal/zzr:zzbM	()Lcom/google/android/gms/ads/internal/purchase/zzi;
    //   109: pop
    //   110: aload_1
    //   111: ldc 84
    //   113: invokevirtual 90	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   116: astore_1
    //   117: aload_1
    //   118: ifnonnull +56 -> 174
    //   121: ldc_w 342
    //   124: invokestatic 98	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   127: iconst_0
    //   128: istore_3
    //   129: aload_0
    //   130: getfield 63	com/google/android/gms/ads/internal/purchase/zze:zzFL	Lcom/google/android/gms/internal/zzgc;
    //   133: iload_3
    //   134: invokeinterface 69 2 0
    //   139: aload_0
    //   140: getfield 63	com/google/android/gms/ads/internal/purchase/zze:zzFL	Lcom/google/android/gms/internal/zzgc;
    //   143: invokeinterface 76 1 0
    //   148: pop
    //   149: aload_0
    //   150: getfield 34	com/google/android/gms/ads/internal/purchase/zze:mActivity	Landroid/app/Activity;
    //   153: invokevirtual 72	android/app/Activity:finish	()V
    //   156: return
    //   157: astore_2
    //   158: aload_1
    //   159: getfield 346	com/google/android/gms/ads/internal/purchase/zzb:zzFA	Z
    //   162: ifeq -112 -> 50
    //   165: ldc_w 348
    //   168: invokestatic 98	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   171: goto -121 -> 50
    //   174: aload_1
    //   175: instanceof 100
    //   178: ifeq +14 -> 192
    //   181: aload_1
    //   182: checkcast 100	java/lang/Integer
    //   185: invokevirtual 104	java/lang/Integer:intValue	()I
    //   188: istore_3
    //   189: goto -60 -> 129
    //   192: aload_1
    //   193: instanceof 106
    //   196: ifeq +15 -> 211
    //   199: aload_1
    //   200: checkcast 106	java/lang/Long
    //   203: invokevirtual 110	java/lang/Long:longValue	()J
    //   206: l2i
    //   207: istore_3
    //   208: goto -79 -> 129
    //   211: new 112	java/lang/StringBuilder
    //   214: dup
    //   215: ldc 114
    //   217: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: aload_1
    //   221: invokevirtual 122	java/lang/Object:getClass	()Ljava/lang/Class;
    //   224: invokevirtual 127	java/lang/Class:getName	()Ljava/lang/String;
    //   227: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 98	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   236: iconst_5
    //   237: istore_3
    //   238: goto -109 -> 129
    //   241: aload_0
    //   242: new 350	com/google/android/gms/ads/internal/purchase/zzf
    //   245: dup
    //   246: aload_0
    //   247: getfield 63	com/google/android/gms/ads/internal/purchase/zze:zzFL	Lcom/google/android/gms/internal/zzgc;
    //   250: invokeinterface 76 1 0
    //   255: aload_0
    //   256: getfield 32	com/google/android/gms/ads/internal/purchase/zze:zzFO	Ljava/lang/String;
    //   259: invokespecial 353	com/google/android/gms/ads/internal/purchase/zzf:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: putfield 185	com/google/android/gms/ads/internal/purchase/zze:zzFM	Lcom/google/android/gms/ads/internal/purchase/zzf;
    //   265: aload_0
    //   266: getfield 48	com/google/android/gms/ads/internal/purchase/zze:zzFD	Lcom/google/android/gms/ads/internal/purchase/zzh;
    //   269: astore 8
    //   271: aload_0
    //   272: getfield 185	com/google/android/gms/ads/internal/purchase/zze:zzFM	Lcom/google/android/gms/ads/internal/purchase/zzf;
    //   275: astore_1
    //   276: aload_1
    //   277: ifnull +24 -> 301
    //   280: getstatic 356	com/google/android/gms/ads/internal/purchase/zzh:zzpV	Ljava/lang/Object;
    //   283: astore 5
    //   285: aload 5
    //   287: monitorenter
    //   288: aload 8
    //   290: invokevirtual 360	com/google/android/gms/ads/internal/purchase/zzh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   293: astore_2
    //   294: aload_2
    //   295: ifnonnull +66 -> 361
    //   298: aload 5
    //   300: monitorexit
    //   301: aload_0
    //   302: getfield 34	com/google/android/gms/ads/internal/purchase/zze:mActivity	Landroid/app/Activity;
    //   305: aload 7
    //   307: invokevirtual 364	android/app/PendingIntent:getIntentSender	()Landroid/content/IntentSender;
    //   310: sipush 1001
    //   313: new 78	android/content/Intent
    //   316: dup
    //   317: invokespecial 365	android/content/Intent:<init>	()V
    //   320: iconst_0
    //   321: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: invokevirtual 104	java/lang/Integer:intValue	()I
    //   327: iconst_0
    //   328: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: invokevirtual 104	java/lang/Integer:intValue	()I
    //   334: iconst_0
    //   335: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: invokevirtual 104	java/lang/Integer:intValue	()I
    //   341: invokevirtual 373	android/app/Activity:startIntentSenderForResult	(Landroid/content/IntentSender;ILandroid/content/Intent;III)V
    //   344: return
    //   345: astore_1
    //   346: ldc_w 375
    //   349: aload_1
    //   350: invokestatic 379	com/google/android/gms/internal/zzin:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_0
    //   354: getfield 34	com/google/android/gms/ads/internal/purchase/zze:mActivity	Landroid/app/Activity;
    //   357: invokevirtual 72	android/app/Activity:finish	()V
    //   360: return
    //   361: new 381	android/content/ContentValues
    //   364: dup
    //   365: invokespecial 382	android/content/ContentValues:<init>	()V
    //   368: astore 4
    //   370: aload 4
    //   372: ldc_w 384
    //   375: aload_1
    //   376: getfield 387	com/google/android/gms/ads/internal/purchase/zzf:zzFR	Ljava/lang/String;
    //   379: invokevirtual 390	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload 4
    //   384: ldc_w 392
    //   387: aload_1
    //   388: getfield 395	com/google/android/gms/ads/internal/purchase/zzf:zzFQ	Ljava/lang/String;
    //   391: invokevirtual 390	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 4
    //   396: ldc_w 397
    //   399: invokestatic 402	android/os/SystemClock:elapsedRealtime	()J
    //   402: invokestatic 405	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   405: invokevirtual 408	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   408: aload_1
    //   409: aload_2
    //   410: ldc_w 410
    //   413: aconst_null
    //   414: aload 4
    //   416: invokevirtual 416	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   419: putfield 420	com/google/android/gms/ads/internal/purchase/zzf:zzFP	J
    //   422: aload 8
    //   424: invokevirtual 423	com/google/android/gms/ads/internal/purchase/zzh:getRecordCount	()I
    //   427: i2l
    //   428: ldc2_w 424
    //   431: lcmp
    //   432: ifle +24 -> 456
    //   435: getstatic 356	com/google/android/gms/ads/internal/purchase/zzh:zzpV	Ljava/lang/Object;
    //   438: astore 6
    //   440: aload 6
    //   442: monitorenter
    //   443: aload 8
    //   445: invokevirtual 360	com/google/android/gms/ads/internal/purchase/zzh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   448: astore_1
    //   449: aload_1
    //   450: ifnonnull +22 -> 472
    //   453: aload 6
    //   455: monitorexit
    //   456: aload 5
    //   458: monitorexit
    //   459: goto -158 -> 301
    //   462: astore_1
    //   463: aload 5
    //   465: monitorexit
    //   466: aload_1
    //   467: athrow
    //   468: astore_1
    //   469: goto -123 -> 346
    //   472: aload_1
    //   473: ldc_w 410
    //   476: aconst_null
    //   477: aconst_null
    //   478: aconst_null
    //   479: aconst_null
    //   480: aconst_null
    //   481: ldc_w 427
    //   484: ldc_w 429
    //   487: invokevirtual 433	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   490: astore_2
    //   491: aload_2
    //   492: ifnull +30 -> 522
    //   495: aload_2
    //   496: astore_1
    //   497: aload_2
    //   498: invokeinterface 439 1 0
    //   503: ifeq +19 -> 522
    //   506: aload_2
    //   507: ifnonnull +37 -> 544
    //   510: aconst_null
    //   511: astore 4
    //   513: aload_2
    //   514: astore_1
    //   515: aload 8
    //   517: aload 4
    //   519: invokevirtual 188	com/google/android/gms/ads/internal/purchase/zzh:zza	(Lcom/google/android/gms/ads/internal/purchase/zzf;)V
    //   522: aload_2
    //   523: ifnull +9 -> 532
    //   526: aload_2
    //   527: invokeinterface 442 1 0
    //   532: aload 6
    //   534: monitorexit
    //   535: goto -79 -> 456
    //   538: astore_1
    //   539: aload 6
    //   541: monitorexit
    //   542: aload_1
    //   543: athrow
    //   544: aload_2
    //   545: astore_1
    //   546: new 350	com/google/android/gms/ads/internal/purchase/zzf
    //   549: dup
    //   550: aload_2
    //   551: iconst_0
    //   552: invokeinterface 446 2 0
    //   557: aload_2
    //   558: iconst_1
    //   559: invokeinterface 450 2 0
    //   564: aload_2
    //   565: iconst_2
    //   566: invokeinterface 450 2 0
    //   571: invokespecial 453	com/google/android/gms/ads/internal/purchase/zzf:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   574: astore 4
    //   576: goto -63 -> 513
    //   579: astore 4
    //   581: aload_2
    //   582: astore_1
    //   583: new 112	java/lang/StringBuilder
    //   586: dup
    //   587: ldc_w 455
    //   590: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   593: aload 4
    //   595: invokevirtual 458	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   598: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 98	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   607: aload_2
    //   608: ifnull -76 -> 532
    //   611: aload_2
    //   612: invokeinterface 442 1 0
    //   617: goto -85 -> 532
    //   620: aload_1
    //   621: ifnull +9 -> 630
    //   624: aload_1
    //   625: invokeinterface 442 1 0
    //   630: aload_2
    //   631: athrow
    //   632: astore_2
    //   633: goto -13 -> 620
    //   636: astore 4
    //   638: aconst_null
    //   639: astore_2
    //   640: goto -59 -> 581
    //   643: astore_2
    //   644: aconst_null
    //   645: astore_1
    //   646: goto -26 -> 620
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	zze
    //   0	649	1	paramComponentName	ComponentName
    //   0	649	2	paramIBinder	android.os.IBinder
    //   128	110	3	i	int
    //   368	207	4	localObject1	Object
    //   579	15	4	localSQLiteException1	android.database.sqlite.SQLiteException
    //   636	1	4	localSQLiteException2	android.database.sqlite.SQLiteException
    //   283	181	5	localObject2	Object
    //   438	102	6	localObject3	Object
    //   99	207	7	localPendingIntent	android.app.PendingIntent
    //   269	247	8	localzzh	zzh
    // Exception table:
    //   from	to	target	type
    //   5	50	157	java/lang/Exception
    //   50	101	345	android/os/RemoteException
    //   106	117	345	android/os/RemoteException
    //   121	127	345	android/os/RemoteException
    //   129	156	345	android/os/RemoteException
    //   174	189	345	android/os/RemoteException
    //   192	208	345	android/os/RemoteException
    //   211	236	345	android/os/RemoteException
    //   241	276	345	android/os/RemoteException
    //   280	288	345	android/os/RemoteException
    //   301	344	345	android/os/RemoteException
    //   466	468	345	android/os/RemoteException
    //   288	294	462	finally
    //   298	301	462	finally
    //   361	443	462	finally
    //   456	459	462	finally
    //   463	466	462	finally
    //   542	544	462	finally
    //   50	101	468	android/content/IntentSender$SendIntentException
    //   106	117	468	android/content/IntentSender$SendIntentException
    //   121	127	468	android/content/IntentSender$SendIntentException
    //   129	156	468	android/content/IntentSender$SendIntentException
    //   174	189	468	android/content/IntentSender$SendIntentException
    //   192	208	468	android/content/IntentSender$SendIntentException
    //   211	236	468	android/content/IntentSender$SendIntentException
    //   241	276	468	android/content/IntentSender$SendIntentException
    //   280	288	468	android/content/IntentSender$SendIntentException
    //   301	344	468	android/content/IntentSender$SendIntentException
    //   466	468	468	android/content/IntentSender$SendIntentException
    //   443	449	538	finally
    //   453	456	538	finally
    //   526	532	538	finally
    //   532	535	538	finally
    //   539	542	538	finally
    //   611	617	538	finally
    //   624	630	538	finally
    //   630	632	538	finally
    //   497	506	579	android/database/sqlite/SQLiteException
    //   515	522	579	android/database/sqlite/SQLiteException
    //   546	576	579	android/database/sqlite/SQLiteException
    //   497	506	632	finally
    //   515	522	632	finally
    //   546	576	632	finally
    //   583	607	632	finally
    //   472	491	636	android/database/sqlite/SQLiteException
    //   472	491	643	finally
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzin.zzaJ("In-app billing service disconnected.");
    zzFC.zzFz = null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */