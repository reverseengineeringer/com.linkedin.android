package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class zzq
  extends zzz
{
  public zzq(zzw paramzzw)
  {
    super(paramzzw);
  }
  
  static byte[] zzc(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = arrayOfByte;
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localObject = paramHttpURLConnection;
      arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        localObject = paramHttpURLConnection;
        int i = paramHttpURLConnection.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localObject = paramHttpURLConnection;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localObject = paramHttpURLConnection;
    }
    finally
    {
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.close();
    }
    return arrayOfByte;
  }
  
  public final void zza(String paramString, URL paramURL, Map<String, String> paramMap, zza paramzza)
  {
    super.zzjk();
    zzjv();
    zzx.zzz(paramURL);
    zzx.zzz(paramzza);
    super.zzCn().zzh(new zzc(paramString, paramURL, null, paramMap, paramzza));
  }
  
  public final void zza$73165fc8(String paramString, URL paramURL, byte[] paramArrayOfByte, zza paramzza)
  {
    super.zzjk();
    zzjv();
    zzx.zzz(paramURL);
    zzx.zzz(paramArrayOfByte);
    zzx.zzz(paramzza);
    super.zzCn().zzh(new zzc(paramString, paramURL, paramArrayOfByte, null, paramzza));
  }
  
  protected final void zziJ() {}
  
  public final boolean zzlB()
  {
    zzjv();
    Object localObject1 = (ConnectivityManager)super.getContext().getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected())) {
        return true;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    return false;
  }
  
  static abstract interface zza
  {
    public abstract void zza(String paramString, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte);
  }
  
  private static final class zzb
    implements Runnable
  {
    private final int zzBc;
    private final String zzTJ;
    private final zzq.zza zzaWP;
    private final Throwable zzaWQ;
    private final byte[] zzaWR;
    
    private zzb(String paramString, zzq.zza paramzza, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte)
    {
      zzx.zzz(paramzza);
      zzaWP = paramzza;
      zzBc = paramInt;
      zzaWQ = paramThrowable;
      zzaWR = paramArrayOfByte;
      zzTJ = paramString;
    }
    
    public final void run()
    {
      zzaWP.zza(zzTJ, zzBc, zzaWQ, zzaWR);
    }
  }
  
  private final class zzc
    implements Runnable
  {
    private final String zzTJ;
    private final byte[] zzaWS;
    private final zzq.zza zzaWT;
    private final Map<String, String> zzaWU;
    private final URL zzzq;
    
    public zzc(URL paramURL, byte[] paramArrayOfByte, Map<String, String> paramMap, zzq.zza paramzza)
    {
      zzx.zzcM(paramURL);
      zzx.zzz(paramArrayOfByte);
      Object localObject;
      zzx.zzz(localObject);
      zzzq = paramArrayOfByte;
      zzaWS = paramMap;
      zzaWT = ((zzq.zza)localObject);
      zzTJ = paramURL;
      zzaWU = paramzza;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzaWV	Lcom/google/android/gms/measurement/internal/zzq;
      //   4: invokevirtual 58	com/google/android/gms/measurement/internal/zzq:zzCd	()V
      //   7: aload_0
      //   8: getfield 41	com/google/android/gms/measurement/internal/zzq$zzc:zzzq	Ljava/net/URL;
      //   11: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   14: astore_2
      //   15: aload_2
      //   16: instanceof 66
      //   19: ifne +68 -> 87
      //   22: new 55	java/io/IOException
      //   25: dup
      //   26: ldc 68
      //   28: invokespecial 71	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   31: athrow
      //   32: astore 4
      //   34: iconst_0
      //   35: istore_1
      //   36: aconst_null
      //   37: astore_2
      //   38: aconst_null
      //   39: astore_3
      //   40: aload_2
      //   41: ifnull +7 -> 48
      //   44: aload_2
      //   45: invokevirtual 76	java/io/OutputStream:close	()V
      //   48: aload_3
      //   49: ifnull +7 -> 56
      //   52: aload_3
      //   53: invokevirtual 79	java/net/HttpURLConnection:disconnect	()V
      //   56: aload_0
      //   57: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzaWV	Lcom/google/android/gms/measurement/internal/zzq;
      //   60: invokevirtual 83	com/google/android/gms/measurement/internal/zzq:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
      //   63: new 85	com/google/android/gms/measurement/internal/zzq$zzb
      //   66: dup
      //   67: aload_0
      //   68: getfield 47	com/google/android/gms/measurement/internal/zzq$zzc:zzTJ	Ljava/lang/String;
      //   71: aload_0
      //   72: getfield 45	com/google/android/gms/measurement/internal/zzq$zzc:zzaWT	Lcom/google/android/gms/measurement/internal/zzq$zza;
      //   75: iload_1
      //   76: aload 4
      //   78: aconst_null
      //   79: iconst_0
      //   80: invokespecial 88	com/google/android/gms/measurement/internal/zzq$zzb:<init>	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzq$zza;ILjava/lang/Throwable;[BB)V
      //   83: invokevirtual 94	com/google/android/gms/measurement/internal/zzv:zzg	(Ljava/lang/Runnable;)V
      //   86: return
      //   87: aload_2
      //   88: checkcast 66	java/net/HttpURLConnection
      //   91: astore_2
      //   92: aload_2
      //   93: iconst_0
      //   94: invokevirtual 98	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
      //   97: invokestatic 104	com/google/android/gms/measurement/internal/zzd:zzBO	()J
      //   100: pop2
      //   101: aload_2
      //   102: ldc 105
      //   104: invokevirtual 109	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   107: invokestatic 112	com/google/android/gms/measurement/internal/zzd:zzBP	()J
      //   110: pop2
      //   111: aload_2
      //   112: ldc 113
      //   114: invokevirtual 116	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   117: aload_2
      //   118: iconst_0
      //   119: invokevirtual 119	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   122: aload_2
      //   123: iconst_1
      //   124: invokevirtual 122	java/net/HttpURLConnection:setDoInput	(Z)V
      //   127: aload_0
      //   128: getfield 49	com/google/android/gms/measurement/internal/zzq$zzc:zzaWU	Ljava/util/Map;
      //   131: ifnull +65 -> 196
      //   134: aload_0
      //   135: getfield 49	com/google/android/gms/measurement/internal/zzq$zzc:zzaWU	Ljava/util/Map;
      //   138: invokeinterface 128 1 0
      //   143: invokeinterface 134 1 0
      //   148: astore_3
      //   149: aload_3
      //   150: invokeinterface 140 1 0
      //   155: ifeq +41 -> 196
      //   158: aload_3
      //   159: invokeinterface 144 1 0
      //   164: checkcast 146	java/util/Map$Entry
      //   167: astore 4
      //   169: aload_2
      //   170: aload 4
      //   172: invokeinterface 149 1 0
      //   177: checkcast 151	java/lang/String
      //   180: aload 4
      //   182: invokeinterface 154 1 0
      //   187: checkcast 151	java/lang/String
      //   190: invokevirtual 158	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   193: goto -44 -> 149
      //   196: aload_0
      //   197: getfield 43	com/google/android/gms/measurement/internal/zzq$zzc:zzaWS	[B
      //   200: ifnull +79 -> 279
      //   203: aload_0
      //   204: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzaWV	Lcom/google/android/gms/measurement/internal/zzq;
      //   207: invokevirtual 162	com/google/android/gms/measurement/internal/zzq:zzCk	()Lcom/google/android/gms/measurement/internal/zzaj;
      //   210: aload_0
      //   211: getfield 43	com/google/android/gms/measurement/internal/zzq$zzc:zzaWS	[B
      //   214: invokevirtual 167	com/google/android/gms/measurement/internal/zzaj:zzg	([B)[B
      //   217: astore 4
      //   219: aload_0
      //   220: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzaWV	Lcom/google/android/gms/measurement/internal/zzq;
      //   223: invokevirtual 171	com/google/android/gms/measurement/internal/zzq:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
      //   226: getfield 177	com/google/android/gms/measurement/internal/zzp:zzaWK	Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   229: ldc -77
      //   231: aload 4
      //   233: arraylength
      //   234: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   237: invokevirtual 191	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   240: aload_2
      //   241: iconst_1
      //   242: invokevirtual 194	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   245: aload_2
      //   246: ldc -60
      //   248: ldc -58
      //   250: invokevirtual 158	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   253: aload_2
      //   254: aload 4
      //   256: arraylength
      //   257: invokevirtual 201	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
      //   260: aload_2
      //   261: invokevirtual 204	java/net/HttpURLConnection:connect	()V
      //   264: aload_2
      //   265: invokevirtual 208	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   268: astore_3
      //   269: aload_3
      //   270: aload 4
      //   272: invokevirtual 212	java/io/OutputStream:write	([B)V
      //   275: aload_3
      //   276: invokevirtual 76	java/io/OutputStream:close	()V
      //   279: aload_2
      //   280: invokevirtual 216	java/net/HttpURLConnection:getResponseCode	()I
      //   283: istore_1
      //   284: aload_2
      //   285: invokestatic 219	com/google/android/gms/measurement/internal/zzq:zzc	(Ljava/net/HttpURLConnection;)[B
      //   288: astore_3
      //   289: aload_2
      //   290: ifnull +7 -> 297
      //   293: aload_2
      //   294: invokevirtual 79	java/net/HttpURLConnection:disconnect	()V
      //   297: aload_0
      //   298: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzaWV	Lcom/google/android/gms/measurement/internal/zzq;
      //   301: invokevirtual 83	com/google/android/gms/measurement/internal/zzq:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
      //   304: new 85	com/google/android/gms/measurement/internal/zzq$zzb
      //   307: dup
      //   308: aload_0
      //   309: getfield 47	com/google/android/gms/measurement/internal/zzq$zzc:zzTJ	Ljava/lang/String;
      //   312: aload_0
      //   313: getfield 45	com/google/android/gms/measurement/internal/zzq$zzc:zzaWT	Lcom/google/android/gms/measurement/internal/zzq$zza;
      //   316: iload_1
      //   317: aconst_null
      //   318: aload_3
      //   319: iconst_0
      //   320: invokespecial 88	com/google/android/gms/measurement/internal/zzq$zzb:<init>	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzq$zza;ILjava/lang/Throwable;[BB)V
      //   323: invokevirtual 94	com/google/android/gms/measurement/internal/zzv:zzg	(Ljava/lang/Runnable;)V
      //   326: return
      //   327: astore_2
      //   328: aload_0
      //   329: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzaWV	Lcom/google/android/gms/measurement/internal/zzq;
      //   332: invokevirtual 171	com/google/android/gms/measurement/internal/zzq:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
      //   335: getfield 222	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   338: ldc -32
      //   340: aload_2
      //   341: invokevirtual 191	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   344: goto -296 -> 48
      //   347: astore_3
      //   348: iconst_0
      //   349: istore_1
      //   350: aconst_null
      //   351: astore_2
      //   352: aconst_null
      //   353: astore 4
      //   355: aload_2
      //   356: ifnull +7 -> 363
      //   359: aload_2
      //   360: invokevirtual 76	java/io/OutputStream:close	()V
      //   363: aload 4
      //   365: ifnull +8 -> 373
      //   368: aload 4
      //   370: invokevirtual 79	java/net/HttpURLConnection:disconnect	()V
      //   373: aload_0
      //   374: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzaWV	Lcom/google/android/gms/measurement/internal/zzq;
      //   377: invokevirtual 83	com/google/android/gms/measurement/internal/zzq:zzCn	()Lcom/google/android/gms/measurement/internal/zzv;
      //   380: new 85	com/google/android/gms/measurement/internal/zzq$zzb
      //   383: dup
      //   384: aload_0
      //   385: getfield 47	com/google/android/gms/measurement/internal/zzq$zzc:zzTJ	Ljava/lang/String;
      //   388: aload_0
      //   389: getfield 45	com/google/android/gms/measurement/internal/zzq$zzc:zzaWT	Lcom/google/android/gms/measurement/internal/zzq$zza;
      //   392: iload_1
      //   393: aconst_null
      //   394: aconst_null
      //   395: iconst_0
      //   396: invokespecial 88	com/google/android/gms/measurement/internal/zzq$zzb:<init>	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzq$zza;ILjava/lang/Throwable;[BB)V
      //   399: invokevirtual 94	com/google/android/gms/measurement/internal/zzv:zzg	(Ljava/lang/Runnable;)V
      //   402: aload_3
      //   403: athrow
      //   404: astore_2
      //   405: aload_0
      //   406: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzaWV	Lcom/google/android/gms/measurement/internal/zzq;
      //   409: invokevirtual 171	com/google/android/gms/measurement/internal/zzq:zzAo	()Lcom/google/android/gms/measurement/internal/zzp;
      //   412: getfield 222	com/google/android/gms/measurement/internal/zzp:zzaWC	Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   415: ldc -32
      //   417: aload_2
      //   418: invokevirtual 191	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   421: goto -58 -> 363
      //   424: astore_3
      //   425: iconst_0
      //   426: istore_1
      //   427: aconst_null
      //   428: astore 5
      //   430: aload_2
      //   431: astore 4
      //   433: aload 5
      //   435: astore_2
      //   436: goto -81 -> 355
      //   439: astore 5
      //   441: iconst_0
      //   442: istore_1
      //   443: aload_2
      //   444: astore 4
      //   446: aload_3
      //   447: astore_2
      //   448: aload 5
      //   450: astore_3
      //   451: goto -96 -> 355
      //   454: astore_3
      //   455: aconst_null
      //   456: astore 5
      //   458: aload_2
      //   459: astore 4
      //   461: aload 5
      //   463: astore_2
      //   464: goto -109 -> 355
      //   467: astore 5
      //   469: iconst_0
      //   470: istore_1
      //   471: aload_2
      //   472: astore 4
      //   474: aload_3
      //   475: astore_2
      //   476: aload 4
      //   478: astore_3
      //   479: aload 5
      //   481: astore 4
      //   483: goto -443 -> 40
      //   486: astore 4
      //   488: aload_2
      //   489: astore_3
      //   490: aconst_null
      //   491: astore_2
      //   492: goto -452 -> 40
      //   495: astore 4
      //   497: iconst_0
      //   498: istore_1
      //   499: aload_2
      //   500: astore_3
      //   501: aconst_null
      //   502: astore_2
      //   503: goto -463 -> 40
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	506	0	this	zzc
      //   35	464	1	i	int
      //   14	280	2	localObject1	Object
      //   327	14	2	localIOException1	IOException
      //   351	9	2	localObject2	Object
      //   404	27	2	localIOException2	IOException
      //   435	68	2	localObject3	Object
      //   39	280	3	localObject4	Object
      //   347	56	3	localObject5	Object
      //   424	23	3	localObject6	Object
      //   450	1	3	localObject7	Object
      //   454	21	3	localObject8	Object
      //   478	23	3	localObject9	Object
      //   32	45	4	localIOException3	IOException
      //   167	315	4	localObject10	Object
      //   486	1	4	localIOException4	IOException
      //   495	1	4	localIOException5	IOException
      //   428	6	5	localObject11	Object
      //   439	10	5	localObject12	Object
      //   456	6	5	localObject13	Object
      //   467	13	5	localIOException6	IOException
      // Exception table:
      //   from	to	target	type
      //   7	32	32	java/io/IOException
      //   87	127	32	java/io/IOException
      //   44	48	327	java/io/IOException
      //   7	32	347	finally
      //   87	127	347	finally
      //   359	363	404	java/io/IOException
      //   127	149	424	finally
      //   149	193	424	finally
      //   196	269	424	finally
      //   279	284	424	finally
      //   269	279	439	finally
      //   284	289	454	finally
      //   269	279	467	java/io/IOException
      //   284	289	486	java/io/IOException
      //   127	149	495	java/io/IOException
      //   149	193	495	java/io/IOException
      //   196	269	495	java/io/IOException
      //   279	284	495	java/io/IOException
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */