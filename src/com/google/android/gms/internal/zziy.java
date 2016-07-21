package com.google.android.gms.internal;

import android.content.Context;

@zzhb
public final class zziy
  extends zzim
{
  private final Context mContext;
  private final String zzF;
  private final String zzsy;
  private String zzzN = null;
  
  public zziy(Context paramContext, String paramString1, String paramString2)
  {
    mContext = paramContext;
    zzsy = paramString1;
    zzF = paramString2;
  }
  
  public zziy(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    mContext = paramContext;
    zzsy = paramString1;
    zzF = paramString2;
    zzzN = paramString3;
  }
  
  /* Error */
  public final void zzbr()
  {
    // Byte code:
    //   0: new 35	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 37
    //   6: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 24	com/google/android/gms/internal/zziy:zzF	Ljava/lang/String;
    //   13: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 53	com/google/android/gms/internal/zzin:v	(Ljava/lang/String;)V
    //   22: new 55	java/net/URL
    //   25: dup
    //   26: aload_0
    //   27: getfield 24	com/google/android/gms/internal/zziy:zzF	Ljava/lang/String;
    //   30: invokespecial 56	java/net/URL:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 60	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   36: checkcast 62	java/net/HttpURLConnection
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 18	com/google/android/gms/internal/zziy:zzzN	Ljava/lang/String;
    //   44: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +74 -> 121
    //   50: invokestatic 74	com/google/android/gms/ads/internal/zzr:zzbC	()Lcom/google/android/gms/internal/zzir;
    //   53: aload_0
    //   54: getfield 20	com/google/android/gms/internal/zziy:mContext	Landroid/content/Context;
    //   57: aload_0
    //   58: getfield 22	com/google/android/gms/internal/zziy:zzsy	Ljava/lang/String;
    //   61: iconst_1
    //   62: aload_2
    //   63: invokevirtual 80	com/google/android/gms/internal/zzir:zza	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   66: aload_2
    //   67: invokevirtual 84	java/net/HttpURLConnection:getResponseCode	()I
    //   70: istore_1
    //   71: iload_1
    //   72: sipush 200
    //   75: if_icmplt +10 -> 85
    //   78: iload_1
    //   79: sipush 300
    //   82: if_icmplt +34 -> 116
    //   85: new 35	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 86
    //   91: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: iload_1
    //   95: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc 91
    //   100: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 24	com/google/android/gms/internal/zziy:zzF	Ljava/lang/String;
    //   107: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 94	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   116: aload_2
    //   117: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
    //   120: return
    //   121: invokestatic 74	com/google/android/gms/ads/internal/zzr:zzbC	()Lcom/google/android/gms/internal/zzir;
    //   124: pop
    //   125: aload_2
    //   126: aload_0
    //   127: getfield 18	com/google/android/gms/internal/zziy:zzzN	Ljava/lang/String;
    //   130: invokestatic 101	com/google/android/gms/internal/zzir:zza$2d8d796a$11657ff2	(Ljava/net/HttpURLConnection;Ljava/lang/String;)V
    //   133: goto -67 -> 66
    //   136: astore_3
    //   137: aload_2
    //   138: invokevirtual 97	java/net/HttpURLConnection:disconnect	()V
    //   141: aload_3
    //   142: athrow
    //   143: astore_2
    //   144: new 35	java/lang/StringBuilder
    //   147: dup
    //   148: ldc 103
    //   150: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: aload_0
    //   154: getfield 24	com/google/android/gms/internal/zziy:zzF	Ljava/lang/String;
    //   157: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 105
    //   162: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_2
    //   166: invokevirtual 108	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   169: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 94	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   178: return
    //   179: astore_2
    //   180: new 35	java/lang/StringBuilder
    //   183: dup
    //   184: ldc 110
    //   186: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_0
    //   190: getfield 24	com/google/android/gms/internal/zziy:zzF	Ljava/lang/String;
    //   193: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 105
    //   198: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_2
    //   202: invokevirtual 111	java/io/IOException:getMessage	()Ljava/lang/String;
    //   205: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 94	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   214: return
    //   215: astore_2
    //   216: new 35	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 110
    //   222: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: aload_0
    //   226: getfield 24	com/google/android/gms/internal/zziy:zzF	Ljava/lang/String;
    //   229: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 105
    //   234: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_2
    //   238: invokevirtual 112	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 94	com/google/android/gms/internal/zzin:zzaK	(Ljava/lang/String;)V
    //   250: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	zziy
    //   70	25	1	i	int
    //   39	99	2	localHttpURLConnection	java.net.HttpURLConnection
    //   143	23	2	localIndexOutOfBoundsException	IndexOutOfBoundsException
    //   179	23	2	localIOException	java.io.IOException
    //   215	23	2	localRuntimeException	RuntimeException
    //   136	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	66	136	finally
    //   66	71	136	finally
    //   85	116	136	finally
    //   121	133	136	finally
    //   0	40	143	java/lang/IndexOutOfBoundsException
    //   116	120	143	java/lang/IndexOutOfBoundsException
    //   137	143	143	java/lang/IndexOutOfBoundsException
    //   0	40	179	java/io/IOException
    //   116	120	179	java/io/IOException
    //   137	143	179	java/io/IOException
    //   0	40	215	java/lang/RuntimeException
    //   116	120	215	java/lang/RuntimeException
    //   137	143	215	java/lang/RuntimeException
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */