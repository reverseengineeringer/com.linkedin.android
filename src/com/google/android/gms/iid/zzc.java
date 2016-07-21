package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class zzc
{
  static String zzaNg = null;
  static int zzaNh = 0;
  static int zzaNi = 0;
  static int zzaNj = 0;
  Context context;
  PendingIntent zzaLQ;
  Messenger zzaLU;
  Map<String, Object> zzaNk = new HashMap();
  Messenger zzaNl;
  MessengerCompat zzaNm;
  long zzaNn;
  long zzaNo;
  int zzaNp;
  int zzaNq;
  long zzaNr;
  
  public zzc(Context paramContext)
  {
    context = paramContext;
  }
  
  private void zzE(Object paramObject)
  {
    synchronized (getClass())
    {
      Iterator localIterator = zzaNk.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = zzaNk.get(str);
        zzaNk.put(str, paramObject);
        zzg(localObject, paramObject);
      }
    }
  }
  
  /* Error */
  private static String zza(java.security.KeyPair paramKeyPair, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 102
    //   2: aload_1
    //   3: invokestatic 108	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   6: ldc 110
    //   8: invokevirtual 114	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   11: astore_1
    //   12: aload_0
    //   13: invokevirtual 120	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   16: astore_2
    //   17: aload_2
    //   18: instanceof 122
    //   21: ifeq +43 -> 64
    //   24: ldc 124
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic 130	java/security/Signature:getInstance	(Ljava/lang/String;)Ljava/security/Signature;
    //   31: astore_0
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 134	java/security/Signature:initSign	(Ljava/security/PrivateKey;)V
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 138	java/security/Signature:update	([B)V
    //   42: aload_0
    //   43: invokevirtual 142	java/security/Signature:sign	()[B
    //   46: invokestatic 148	com/google/android/gms/iid/InstanceID:zzn	([B)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc -106
    //   55: ldc -104
    //   57: aload_0
    //   58: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   61: pop
    //   62: aconst_null
    //   63: areturn
    //   64: ldc -96
    //   66: astore_0
    //   67: goto -40 -> 27
    //   70: astore_0
    //   71: ldc -106
    //   73: ldc -94
    //   75: aload_0
    //   76: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   79: pop
    //   80: aconst_null
    //   81: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramKeyPair	java.security.KeyPair
    //   0	82	1	paramVarArgs	String[]
    //   16	18	2	localPrivateKey	java.security.PrivateKey
    // Exception table:
    //   from	to	target	type
    //   0	12	52	java/io/UnsupportedEncodingException
    //   12	24	70	java/security/GeneralSecurityException
    //   27	50	70	java/security/GeneralSecurityException
  }
  
  public static String zzaN(Context paramContext)
  {
    if (zzaNg != null) {
      return zzaNg;
    }
    zzaNh = Process.myUid();
    paramContext = paramContext.getPackageManager();
    Object localObject1 = paramContext.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      if (paramContext.checkPermission("com.google.android.c2dm.permission.RECEIVE", serviceInfo.packageName) == 0) {
        try
        {
          ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo(serviceInfo.packageName, 0);
          Log.w("InstanceID/Rpc", "Found " + uid);
          zzaNi = uid;
          localObject2 = serviceInfo.packageName;
          zzaNg = (String)localObject2;
          return (String)localObject2;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
      } else {
        Log.w("InstanceID/Rpc", "Possible malicious package " + serviceInfo.packageName + " declares com.google.android.c2dm.intent.REGISTER without permission");
      }
    }
    Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
    try
    {
      localObject1 = paramContext.getApplicationInfo("com.google.android.gms", 0);
      zzaNg = packageName;
      zzaNi = uid;
      localObject1 = zzaNg;
      return (String)localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      try
      {
        paramContext = paramContext.getApplicationInfo("com.google.android.gsf", 0);
        zzaNg = packageName;
        zzaNi = uid;
        paramContext = zzaNg;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
      }
    }
    return null;
  }
  
  private static void zzg(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof ConditionVariable)) {
      ((ConditionVariable)paramObject1).open();
    }
    Message localMessage;
    if ((paramObject1 instanceof Messenger))
    {
      paramObject1 = (Messenger)paramObject1;
      localMessage = Message.obtain();
      obj = paramObject2;
    }
    try
    {
      ((Messenger)paramObject1).send(localMessage);
      return;
    }
    catch (RemoteException paramObject1)
    {
      Log.w("InstanceID/Rpc", "Failed to send response " + paramObject1);
    }
  }
  
  private void zzi(String paramString, Object paramObject)
  {
    synchronized (getClass())
    {
      Object localObject = zzaNk.get(paramString);
      zzaNk.put(paramString, paramObject);
      zzg(localObject, paramObject);
      return;
    }
  }
  
  private void zzt(Intent paramIntent)
  {
    try
    {
      if (zzaLQ == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        zzaLQ = PendingIntent.getBroadcast(context, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", zzaLQ);
      return;
    }
    finally {}
  }
  
  static String zzu(Intent paramIntent)
    throws IOException
  {
    if (paramIntent == null) {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    String str2 = paramIntent.getStringExtra("registration_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramIntent.getStringExtra("unregistered");
    }
    paramIntent.getLongExtra("Retry-After", 0L);
    if (str1 == null)
    {
      str1 = paramIntent.getStringExtra("error");
      if (str1 != null) {
        throw new IOException(str1);
      }
      Log.w("InstanceID/Rpc", "Unexpected response from GCM " + paramIntent.getExtras(), new Throwable());
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    return str1;
  }
  
  public static String zzyF()
  {
    try
    {
      int i = zzaNj;
      zzaNj = i + 1;
      String str = Integer.toString(i);
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  final Intent zzb(android.os.Bundle arg1, java.security.KeyPair paramKeyPair)
    throws IOException
  {
    // Byte code:
    //   0: new 256	android/os/ConditionVariable
    //   3: dup
    //   4: invokespecial 349	android/os/ConditionVariable:<init>	()V
    //   7: astore 7
    //   9: invokestatic 351	com/google/android/gms/iid/zzc:zzyF	()Ljava/lang/String;
    //   12: astore 6
    //   14: aload_0
    //   15: invokevirtual 58	java/lang/Object:getClass	()Ljava/lang/Class;
    //   18: astore 8
    //   20: aload 8
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 50	com/google/android/gms/iid/zzc:zzaNk	Ljava/util/Map;
    //   27: aload 6
    //   29: aload 7
    //   31: invokeinterface 90 3 0
    //   36: pop
    //   37: aload 8
    //   39: monitorexit
    //   40: invokestatic 357	android/os/SystemClock:elapsedRealtime	()J
    //   43: lstore_3
    //   44: aload_0
    //   45: getfield 359	com/google/android/gms/iid/zzc:zzaNr	J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifeq +70 -> 120
    //   53: lload_3
    //   54: aload_0
    //   55: getfield 359	com/google/android/gms/iid/zzc:zzaNr	J
    //   58: lcmp
    //   59: ifgt +61 -> 120
    //   62: ldc -106
    //   64: new 217	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 361
    //   71: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 359	com/google/android/gms/iid/zzc:zzaNr	J
    //   78: lload_3
    //   79: lsub
    //   80: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: ldc_w 366
    //   86: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 368	com/google/android/gms/iid/zzc:zzaNq	I
    //   93: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 236	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   102: pop
    //   103: new 309	java/io/IOException
    //   106: dup
    //   107: ldc_w 370
    //   110: invokespecial 312	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   113: athrow
    //   114: astore_1
    //   115: aload 8
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    //   120: aload_0
    //   121: getfield 372	com/google/android/gms/iid/zzc:zzaLU	Landroid/os/Messenger;
    //   124: ifnonnull +33 -> 157
    //   127: aload_0
    //   128: getfield 52	com/google/android/gms/iid/zzc:context	Landroid/content/Context;
    //   131: invokestatic 374	com/google/android/gms/iid/zzc:zzaN	(Landroid/content/Context;)Ljava/lang/String;
    //   134: pop
    //   135: aload_0
    //   136: new 261	android/os/Messenger
    //   139: dup
    //   140: new 6	com/google/android/gms/iid/zzc$1
    //   143: dup
    //   144: aload_0
    //   145: invokestatic 380	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   148: invokespecial 383	com/google/android/gms/iid/zzc$1:<init>	(Lcom/google/android/gms/iid/zzc;Landroid/os/Looper;)V
    //   151: invokespecial 386	android/os/Messenger:<init>	(Landroid/os/Handler;)V
    //   154: putfield 372	com/google/android/gms/iid/zzc:zzaLU	Landroid/os/Messenger;
    //   157: getstatic 34	com/google/android/gms/iid/zzc:zzaNg	Ljava/lang/String;
    //   160: ifnonnull +14 -> 174
    //   163: new 309	java/io/IOException
    //   166: dup
    //   167: ldc_w 388
    //   170: invokespecial 312	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   173: athrow
    //   174: aload_0
    //   175: invokestatic 357	android/os/SystemClock:elapsedRealtime	()J
    //   178: putfield 390	com/google/android/gms/iid/zzc:zzaNn	J
    //   181: new 180	android/content/Intent
    //   184: dup
    //   185: ldc -74
    //   187: invokespecial 185	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   190: astore 8
    //   192: aload 8
    //   194: getstatic 34	com/google/android/gms/iid/zzc:zzaNg	Ljava/lang/String;
    //   197: invokevirtual 293	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   200: pop
    //   201: aload_1
    //   202: ldc_w 392
    //   205: aload_0
    //   206: getfield 52	com/google/android/gms/iid/zzc:context	Landroid/content/Context;
    //   209: invokestatic 398	com/google/android/gms/gcm/GoogleCloudMessaging:zzaK	(Landroid/content/Context;)I
    //   212: invokestatic 346	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   215: invokevirtual 404	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_1
    //   219: ldc_w 406
    //   222: getstatic 411	android/os/Build$VERSION:SDK_INT	I
    //   225: invokestatic 346	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   228: invokevirtual 404	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_1
    //   232: ldc_w 413
    //   235: aload_0
    //   236: getfield 52	com/google/android/gms/iid/zzc:context	Landroid/content/Context;
    //   239: invokestatic 416	com/google/android/gms/iid/InstanceID:zzaL	(Landroid/content/Context;)I
    //   242: invokestatic 346	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   245: invokevirtual 404	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_1
    //   249: ldc_w 418
    //   252: ldc_w 420
    //   255: invokevirtual 404	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_1
    //   259: ldc_w 422
    //   262: aload_2
    //   263: invokestatic 425	com/google/android/gms/iid/InstanceID:zza	(Ljava/security/KeyPair;)Ljava/lang/String;
    //   266: invokevirtual 404	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_2
    //   270: invokevirtual 429	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   273: invokeinterface 434 1 0
    //   278: invokestatic 148	com/google/android/gms/iid/InstanceID:zzn	([B)Ljava/lang/String;
    //   281: astore 9
    //   283: aload_1
    //   284: ldc_w 436
    //   287: aload 9
    //   289: invokevirtual 404	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_1
    //   293: ldc_w 438
    //   296: aload_2
    //   297: iconst_2
    //   298: anewarray 82	java/lang/String
    //   301: dup
    //   302: iconst_0
    //   303: aload_0
    //   304: getfield 52	com/google/android/gms/iid/zzc:context	Landroid/content/Context;
    //   307: invokevirtual 441	android/content/Context:getPackageName	()Ljava/lang/String;
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload 9
    //   315: aastore
    //   316: invokestatic 443	com/google/android/gms/iid/zzc:zza	(Ljava/security/KeyPair;[Ljava/lang/String;)Ljava/lang/String;
    //   319: invokevirtual 404	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload 8
    //   324: aload_1
    //   325: invokevirtual 447	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_0
    //   330: aload 8
    //   332: invokespecial 449	com/google/android/gms/iid/zzc:zzt	(Landroid/content/Intent;)V
    //   335: aload_0
    //   336: invokestatic 357	android/os/SystemClock:elapsedRealtime	()J
    //   339: putfield 390	com/google/android/gms/iid/zzc:zzaNn	J
    //   342: aload 8
    //   344: ldc_w 451
    //   347: new 217	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 453
    //   354: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload 6
    //   359: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc_w 455
    //   365: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   374: pop
    //   375: aload 8
    //   377: ldc_w 460
    //   380: new 217	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 453
    //   387: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload 6
    //   392: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc_w 455
    //   398: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   407: pop
    //   408: ldc -6
    //   410: getstatic 34	com/google/android/gms/iid/zzc:zzaNg	Ljava/lang/String;
    //   413: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: istore 5
    //   418: aload 8
    //   420: ldc_w 466
    //   423: invokevirtual 318	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   426: astore_1
    //   427: aload_1
    //   428: ifnull +12 -> 440
    //   431: ldc_w 420
    //   434: aload_1
    //   435: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   438: istore 5
    //   440: ldc -106
    //   442: iconst_3
    //   443: invokestatic 470	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   446: ifeq +30 -> 476
    //   449: ldc -106
    //   451: new 217	java/lang/StringBuilder
    //   454: dup
    //   455: ldc_w 472
    //   458: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   461: aload 8
    //   463: invokevirtual 334	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   466: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 475	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   475: pop
    //   476: aload_0
    //   477: getfield 477	com/google/android/gms/iid/zzc:zzaNl	Landroid/os/Messenger;
    //   480: ifnull +97 -> 577
    //   483: aload 8
    //   485: ldc_w 479
    //   488: aload_0
    //   489: getfield 372	com/google/android/gms/iid/zzc:zzaLU	Landroid/os/Messenger;
    //   492: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   495: pop
    //   496: invokestatic 267	android/os/Message:obtain	()Landroid/os/Message;
    //   499: astore_1
    //   500: aload_1
    //   501: aload 8
    //   503: putfield 271	android/os/Message:obj	Ljava/lang/Object;
    //   506: aload_0
    //   507: getfield 477	com/google/android/gms/iid/zzc:zzaNl	Landroid/os/Messenger;
    //   510: aload_1
    //   511: invokevirtual 275	android/os/Messenger:send	(Landroid/os/Message;)V
    //   514: aload 7
    //   516: ldc2_w 480
    //   519: invokevirtual 485	android/os/ConditionVariable:block	(J)Z
    //   522: pop
    //   523: aload_0
    //   524: invokevirtual 58	java/lang/Object:getClass	()Ljava/lang/Class;
    //   527: astore_1
    //   528: aload_1
    //   529: monitorenter
    //   530: aload_0
    //   531: getfield 50	com/google/android/gms/iid/zzc:zzaNk	Ljava/util/Map;
    //   534: aload 6
    //   536: invokeinterface 488 2 0
    //   541: astore_2
    //   542: aload_2
    //   543: instanceof 180
    //   546: ifeq +191 -> 737
    //   549: aload_2
    //   550: checkcast 180	android/content/Intent
    //   553: astore_2
    //   554: aload_1
    //   555: monitorexit
    //   556: aload_2
    //   557: areturn
    //   558: astore_1
    //   559: ldc -106
    //   561: iconst_3
    //   562: invokestatic 470	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   565: ifeq +12 -> 577
    //   568: ldc -106
    //   570: ldc_w 490
    //   573: invokestatic 475	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   576: pop
    //   577: iload 5
    //   579: ifeq +48 -> 627
    //   582: new 180	android/content/Intent
    //   585: dup
    //   586: ldc_w 492
    //   589: invokespecial 185	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   592: astore_1
    //   593: aload_1
    //   594: aload_0
    //   595: getfield 52	com/google/android/gms/iid/zzc:context	Landroid/content/Context;
    //   598: invokevirtual 441	android/content/Context:getPackageName	()Ljava/lang/String;
    //   601: invokevirtual 293	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   604: pop
    //   605: aload_1
    //   606: ldc_w 494
    //   609: aload 8
    //   611: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   614: pop
    //   615: aload_0
    //   616: getfield 52	com/google/android/gms/iid/zzc:context	Landroid/content/Context;
    //   619: aload_1
    //   620: invokevirtual 498	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   623: pop
    //   624: goto -110 -> 514
    //   627: aload 8
    //   629: ldc_w 479
    //   632: aload_0
    //   633: getfield 372	com/google/android/gms/iid/zzc:zzaLU	Landroid/os/Messenger;
    //   636: invokevirtual 305	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   639: pop
    //   640: aload 8
    //   642: ldc_w 500
    //   645: ldc_w 420
    //   648: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   651: pop
    //   652: aload_0
    //   653: getfield 502	com/google/android/gms/iid/zzc:zzaNm	Lcom/google/android/gms/iid/MessengerCompat;
    //   656: ifnull +55 -> 711
    //   659: invokestatic 267	android/os/Message:obtain	()Landroid/os/Message;
    //   662: astore_1
    //   663: aload_1
    //   664: aload 8
    //   666: putfield 271	android/os/Message:obj	Ljava/lang/Object;
    //   669: aload_0
    //   670: getfield 502	com/google/android/gms/iid/zzc:zzaNm	Lcom/google/android/gms/iid/MessengerCompat;
    //   673: astore_2
    //   674: aload_2
    //   675: getfield 507	com/google/android/gms/iid/MessengerCompat:zzaNd	Landroid/os/Messenger;
    //   678: ifnull +46 -> 724
    //   681: aload_2
    //   682: getfield 507	com/google/android/gms/iid/MessengerCompat:zzaNd	Landroid/os/Messenger;
    //   685: aload_1
    //   686: invokevirtual 275	android/os/Messenger:send	(Landroid/os/Message;)V
    //   689: goto -175 -> 514
    //   692: astore_1
    //   693: ldc -106
    //   695: iconst_3
    //   696: invokestatic 470	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   699: ifeq +12 -> 711
    //   702: ldc -106
    //   704: ldc_w 490
    //   707: invokestatic 475	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   710: pop
    //   711: aload_0
    //   712: getfield 52	com/google/android/gms/iid/zzc:context	Landroid/content/Context;
    //   715: aload 8
    //   717: invokevirtual 498	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   720: pop
    //   721: goto -207 -> 514
    //   724: aload_2
    //   725: getfield 511	com/google/android/gms/iid/MessengerCompat:zzaNe	Lcom/google/android/gms/iid/zzb;
    //   728: aload_1
    //   729: invokeinterface 514 2 0
    //   734: goto -220 -> 514
    //   737: aload_2
    //   738: instanceof 82
    //   741: ifeq +20 -> 761
    //   744: new 309	java/io/IOException
    //   747: dup
    //   748: aload_2
    //   749: checkcast 82	java/lang/String
    //   752: invokespecial 312	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   755: athrow
    //   756: astore_2
    //   757: aload_1
    //   758: monitorexit
    //   759: aload_2
    //   760: athrow
    //   761: ldc -106
    //   763: new 217	java/lang/StringBuilder
    //   766: dup
    //   767: ldc_w 516
    //   770: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   773: aload_2
    //   774: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   777: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 236	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   783: pop
    //   784: new 309	java/io/IOException
    //   787: dup
    //   788: ldc_w 518
    //   791: invokespecial 312	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   794: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	795	0	this	zzc
    //   0	795	2	paramKeyPair	java.security.KeyPair
    //   43	36	3	l	long
    //   416	162	5	bool	boolean
    //   12	523	6	str1	String
    //   7	508	7	localConditionVariable	ConditionVariable
    //   18	698	8	localObject	Object
    //   281	33	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   23	40	114	finally
    //   115	118	114	finally
    //   506	514	558	android/os/RemoteException
    //   669	689	692	android/os/RemoteException
    //   724	734	692	android/os/RemoteException
    //   530	556	756	finally
    //   737	756	756	finally
    //   757	759	756	finally
    //   761	795	756	finally
  }
  
  final void zzw(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (Log.isLoggable("InstanceID/Rpc", 3)) {
        Log.d("InstanceID/Rpc", "Unexpected response: null");
      }
    }
    do
    {
      return;
      localObject1 = paramIntent.getAction();
      if (("com.google.android.c2dm.intent.REGISTRATION".equals(localObject1)) || ("com.google.android.gms.iid.InstanceID".equals(localObject1))) {
        break;
      }
    } while (!Log.isLoggable("InstanceID/Rpc", 3));
    Log.d("InstanceID/Rpc", "Unexpected response " + paramIntent.getAction());
    return;
    Object localObject1 = paramIntent.getStringExtra("registration_id");
    if (localObject1 == null) {
      localObject1 = paramIntent.getStringExtra("unregistered");
    }
    for (;;)
    {
      Object localObject3;
      if (localObject1 == null)
      {
        String str = paramIntent.getStringExtra("error");
        if (str == null)
        {
          Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + paramIntent.getExtras());
          return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
          Log.d("InstanceID/Rpc", "Received InstanceID error " + str);
        }
        localObject2 = null;
        localObject3 = null;
        localObject1 = str;
        if (str.startsWith("|"))
        {
          localObject1 = str.split("\\|");
          if (!"ID".equals(localObject1[1])) {
            Log.w("InstanceID/Rpc", "Unexpected structured response " + str);
          }
          if (localObject1.length > 2)
          {
            localObject3 = localObject1[2];
            str = localObject1[3];
            localObject2 = localObject3;
            localObject1 = str;
            if (str.startsWith(":"))
            {
              localObject1 = str.substring(1);
              localObject2 = localObject3;
            }
            paramIntent.putExtra("error", (String)localObject1);
          }
        }
        else
        {
          if (localObject2 != null) {
            break label412;
          }
          zzE(localObject1);
        }
        for (;;)
        {
          long l = paramIntent.getLongExtra("Retry-After", 0L);
          if (l <= 0L) {
            break label423;
          }
          zzaNo = SystemClock.elapsedRealtime();
          zzaNq = ((int)l * 1000);
          zzaNr = (SystemClock.elapsedRealtime() + zzaNq);
          Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + zzaNq);
          return;
          localObject1 = "UNKNOWN";
          localObject2 = localObject3;
          break;
          label412:
          zzi((String)localObject2, localObject1);
        }
        label423:
        if (((!"SERVICE_NOT_AVAILABLE".equals(localObject1)) && (!"AUTHENTICATION_FAILED".equals(localObject1))) || (!"com.google.android.gsf".equals(zzaNg))) {
          break;
        }
        zzaNp += 1;
        if (zzaNp < 3) {
          break;
        }
        if (zzaNp == 3) {
          zzaNq = (new Random().nextInt(1000) + 1000);
        }
        zzaNq *= 2;
        zzaNr = (SystemClock.elapsedRealtime() + zzaNq);
        Log.w("InstanceID/Rpc", "Backoff due to " + (String)localObject1 + " for " + zzaNq);
        return;
      }
      zzaNn = SystemClock.elapsedRealtime();
      zzaNr = 0L;
      zzaNp = 0;
      zzaNq = 0;
      if (Log.isLoggable("InstanceID/Rpc", 3)) {
        Log.d("InstanceID/Rpc", "AppIDResponse: " + (String)localObject1 + " " + paramIntent.getExtras());
      }
      Object localObject2 = null;
      if (((String)localObject1).startsWith("|"))
      {
        localObject3 = ((String)localObject1).split("\\|");
        if (!"ID".equals(localObject3[1])) {
          Log.w("InstanceID/Rpc", "Unexpected structured response " + (String)localObject1);
        }
        localObject2 = localObject3[2];
        if (localObject3.length > 4)
        {
          if (!"SYNC".equals(localObject3[3])) {
            break label780;
          }
          InstanceIDListenerService.zzaM(context);
        }
      }
      label780:
      while (!"RST".equals(localObject3[3]))
      {
        localObject3 = localObject3[(localObject3.length - 1)];
        localObject1 = localObject3;
        if (((String)localObject3).startsWith(":")) {
          localObject1 = ((String)localObject3).substring(1);
        }
        paramIntent.putExtra("registration_id", (String)localObject1);
        if (localObject2 != null) {
          break;
        }
        zzE(paramIntent);
        return;
      }
      localObject1 = context;
      InstanceID.getInstance(context);
      InstanceIDListenerService.zza((Context)localObject1, InstanceID.zzyB());
      paramIntent.removeExtra("registration_id");
      zzi((String)localObject2, paramIntent);
      return;
      zzi((String)localObject2, paramIntent);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */