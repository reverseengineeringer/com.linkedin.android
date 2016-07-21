package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzv
  implements zzb
{
  private final int zzaA;
  private final Map<String, zza> zzax = new LinkedHashMap(16, 0.75F, true);
  private long zzay = 0L;
  private final File zzaz;
  
  private zzv(File paramFile)
  {
    zzaz = paramFile;
    zzaA = 5242880;
  }
  
  public zzv(File paramFile, byte paramByte)
  {
    this(paramFile);
  }
  
  private void remove(String paramString)
  {
    try
    {
      boolean bool = zzf(paramString).delete();
      zza localzza = (zza)zzax.get(paramString);
      if (localzza != null)
      {
        zzay -= zzaB;
        zzax.remove(paramString);
      }
      if (!bool) {
        zzs.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, zze(paramString) });
      }
      return;
    }
    finally {}
  }
  
  private static int zza(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  static void zza(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void zza(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void zza(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    zza(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  private void zza(String paramString, zza paramzza)
  {
    if (!zzax.containsKey(paramString)) {}
    zza localzza;
    long l;
    for (zzay += zzaB;; zzay = (zzaB - zzaB + l))
    {
      zzax.put(paramString, paramzza);
      return;
      localzza = (zza)zzax.get(paramString);
      l = zzay;
    }
  }
  
  private static byte[] zza(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i != paramInt) {
      throw new IOException("Expected " + paramInt + " bytes, read " + i + " bytes");
    }
    return arrayOfByte;
  }
  
  static int zzb(InputStream paramInputStream)
    throws IOException
  {
    return zza(paramInputStream) << 0 | 0x0 | zza(paramInputStream) << 8 | zza(paramInputStream) << 16 | zza(paramInputStream) << 24;
  }
  
  static long zzc(InputStream paramInputStream)
    throws IOException
  {
    return 0L | (zza(paramInputStream) & 0xFF) << 0 | (zza(paramInputStream) & 0xFF) << 8 | (zza(paramInputStream) & 0xFF) << 16 | (zza(paramInputStream) & 0xFF) << 24 | (zza(paramInputStream) & 0xFF) << 32 | (zza(paramInputStream) & 0xFF) << 40 | (zza(paramInputStream) & 0xFF) << 48 | (zza(paramInputStream) & 0xFF) << 56;
  }
  
  static String zzd(InputStream paramInputStream)
    throws IOException
  {
    return new String(zza(paramInputStream, (int)zzc(paramInputStream)), "UTF-8");
  }
  
  private static String zze(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  static Map<String, String> zze(InputStream paramInputStream)
    throws IOException
  {
    int j = zzb(paramInputStream);
    if (j == 0) {}
    for (Object localObject = Collections.emptyMap();; localObject = new HashMap(j))
    {
      int i = 0;
      while (i < j)
      {
        ((Map)localObject).put(zzd(paramInputStream).intern(), zzd(paramInputStream).intern());
        i += 1;
      }
    }
    return (Map<String, String>)localObject;
  }
  
  private File zzf(String paramString)
  {
    return new File(zzaz, zze(paramString));
  }
  
  /* Error */
  public final zzb.zza zza(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/google/android/gms/internal/zzv:zzax	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 63 2 0
    //   12: checkcast 8	com/google/android/gms/internal/zzv$zza
    //   15: astore 5
    //   17: aload 5
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 51	com/google/android/gms/internal/zzv:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 4
    //   35: new 11	com/google/android/gms/internal/zzv$zzb
    //   38: dup
    //   39: new 207	java/io/FileInputStream
    //   42: dup
    //   43: aload 4
    //   45: invokespecial 208	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: iconst_0
    //   49: invokespecial 211	com/google/android/gms/internal/zzv$zzb:<init>	(Ljava/io/InputStream;B)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokestatic 214	com/google/android/gms/internal/zzv$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzv$zza;
    //   57: pop
    //   58: aload_2
    //   59: aload 4
    //   61: invokevirtual 217	java/io/File:length	()J
    //   64: aload_2
    //   65: invokestatic 220	com/google/android/gms/internal/zzv$zzb:zza	(Lcom/google/android/gms/internal/zzv$zzb;)I
    //   68: i2l
    //   69: lsub
    //   70: l2i
    //   71: invokestatic 161	com/google/android/gms/internal/zzv:zza	(Ljava/io/InputStream;I)[B
    //   74: astore 6
    //   76: new 222	com/google/android/gms/internal/zzb$zza
    //   79: dup
    //   80: invokespecial 223	com/google/android/gms/internal/zzb$zza:<init>	()V
    //   83: astore_3
    //   84: aload_3
    //   85: aload 6
    //   87: putfield 227	com/google/android/gms/internal/zzb$zza:data	[B
    //   90: aload_3
    //   91: aload 5
    //   93: getfield 230	com/google/android/gms/internal/zzv$zza:zzb	Ljava/lang/String;
    //   96: putfield 231	com/google/android/gms/internal/zzb$zza:zzb	Ljava/lang/String;
    //   99: aload_3
    //   100: aload 5
    //   102: getfield 233	com/google/android/gms/internal/zzv$zza:zzc	J
    //   105: putfield 234	com/google/android/gms/internal/zzb$zza:zzc	J
    //   108: aload_3
    //   109: aload 5
    //   111: getfield 236	com/google/android/gms/internal/zzv$zza:zzd	J
    //   114: putfield 237	com/google/android/gms/internal/zzb$zza:zzd	J
    //   117: aload_3
    //   118: aload 5
    //   120: getfield 239	com/google/android/gms/internal/zzv$zza:zze	J
    //   123: putfield 240	com/google/android/gms/internal/zzb$zza:zze	J
    //   126: aload_3
    //   127: aload 5
    //   129: getfield 242	com/google/android/gms/internal/zzv$zza:zzf	J
    //   132: putfield 243	com/google/android/gms/internal/zzb$zza:zzf	J
    //   135: aload_3
    //   136: aload 5
    //   138: getfield 246	com/google/android/gms/internal/zzv$zza:zzg	Ljava/util/Map;
    //   141: putfield 247	com/google/android/gms/internal/zzb$zza:zzg	Ljava/util/Map;
    //   144: aload_2
    //   145: invokevirtual 250	com/google/android/gms/internal/zzv$zzb:close	()V
    //   148: aload_3
    //   149: astore_1
    //   150: goto -126 -> 24
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -132 -> 24
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_2
    //   162: ldc -4
    //   164: iconst_2
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload 4
    //   172: invokevirtual 255	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload_3
    //   179: invokevirtual 256	java/io/IOException:toString	()Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 79	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload_0
    //   187: aload_1
    //   188: invokespecial 258	com/google/android/gms/internal/zzv:remove	(Ljava/lang/String;)V
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 250	com/google/android/gms/internal/zzv$zzb:close	()V
    //   199: aconst_null
    //   200: astore_1
    //   201: goto -177 -> 24
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -183 -> 24
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_2
    //   213: aload_2
    //   214: ifnull +7 -> 221
    //   217: aload_2
    //   218: invokevirtual 250	com/google/android/gms/internal/zzv$zzb:close	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: aconst_null
    //   230: astore_1
    //   231: goto -207 -> 24
    //   234: astore_1
    //   235: goto -22 -> 213
    //   238: astore_1
    //   239: goto -26 -> 213
    //   242: astore_3
    //   243: goto -81 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	zzv
    //   0	246	1	paramString	String
    //   52	166	2	localzzb	zzb
    //   83	66	3	localzza	zzb.zza
    //   159	20	3	localIOException1	IOException
    //   242	1	3	localIOException2	IOException
    //   33	138	4	localFile	File
    //   15	122	5	localzza1	zza
    //   74	12	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   144	148	153	java/io/IOException
    //   35	53	159	java/io/IOException
    //   195	199	204	java/io/IOException
    //   35	53	210	finally
    //   2	17	223	finally
    //   28	35	223	finally
    //   144	148	223	finally
    //   195	199	223	finally
    //   217	221	223	finally
    //   221	223	223	finally
    //   217	221	228	java/io/IOException
    //   53	144	234	finally
    //   162	191	238	finally
    //   53	144	242	java/io/IOException
  }
  
  /* Error */
  public final void zza()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/google/android/gms/internal/zzv:zzaz	Ljava/io/File;
    //   6: invokevirtual 261	java/io/File:exists	()Z
    //   9: ifne +36 -> 45
    //   12: aload_0
    //   13: getfield 38	com/google/android/gms/internal/zzv:zzaz	Ljava/io/File;
    //   16: invokevirtual 264	java/io/File:mkdirs	()Z
    //   19: ifne +23 -> 42
    //   22: ldc_w 266
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 38	com/google/android/gms/internal/zzv:zzaz	Ljava/io/File;
    //   35: invokevirtual 255	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: invokestatic 268	com/google/android/gms/internal/zzs:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 38	com/google/android/gms/internal/zzv:zzaz	Ljava/io/File;
    //   49: invokevirtual 272	java/io/File:listFiles	()[Ljava/io/File;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnull -14 -> 42
    //   59: aload 5
    //   61: arraylength
    //   62: istore_2
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iload_2
    //   67: if_icmpge -25 -> 42
    //   70: aload 5
    //   72: iload_1
    //   73: aaload
    //   74: astore 6
    //   76: aconst_null
    //   77: astore_3
    //   78: new 274	java/io/BufferedInputStream
    //   81: dup
    //   82: new 207	java/io/FileInputStream
    //   85: dup
    //   86: aload 6
    //   88: invokespecial 208	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 277	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: invokestatic 214	com/google/android/gms/internal/zzv$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzv$zza;
    //   104: astore 7
    //   106: aload 4
    //   108: astore_3
    //   109: aload 7
    //   111: aload 6
    //   113: invokevirtual 217	java/io/File:length	()J
    //   116: putfield 66	com/google/android/gms/internal/zzv$zza:zzaB	J
    //   119: aload 4
    //   121: astore_3
    //   122: aload_0
    //   123: aload 7
    //   125: getfield 280	com/google/android/gms/internal/zzv$zza:key	Ljava/lang/String;
    //   128: aload 7
    //   130: invokespecial 282	com/google/android/gms/internal/zzv:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzv$zza;)V
    //   133: aload 4
    //   135: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   138: iload_1
    //   139: iconst_1
    //   140: iadd
    //   141: istore_1
    //   142: goto -77 -> 65
    //   145: astore_3
    //   146: aconst_null
    //   147: astore 4
    //   149: aload 6
    //   151: ifnull +12 -> 163
    //   154: aload 4
    //   156: astore_3
    //   157: aload 6
    //   159: invokevirtual 57	java/io/File:delete	()Z
    //   162: pop
    //   163: aload 4
    //   165: ifnull -27 -> 138
    //   168: aload 4
    //   170: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   173: goto -35 -> 138
    //   176: astore_3
    //   177: goto -39 -> 138
    //   180: astore 5
    //   182: aload_3
    //   183: astore 4
    //   185: aload 5
    //   187: astore_3
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   198: aload_3
    //   199: athrow
    //   200: astore_3
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_3
    //   204: athrow
    //   205: astore_3
    //   206: goto -68 -> 138
    //   209: astore 4
    //   211: goto -13 -> 198
    //   214: astore 5
    //   216: aload_3
    //   217: astore 4
    //   219: aload 5
    //   221: astore_3
    //   222: goto -34 -> 188
    //   225: astore_3
    //   226: goto -77 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	zzv
    //   64	78	1	i	int
    //   62	6	2	j	int
    //   77	45	3	localObject1	Object
    //   145	1	3	localIOException1	IOException
    //   156	1	3	localObject2	Object
    //   176	7	3	localIOException2	IOException
    //   187	12	3	localObject3	Object
    //   200	4	3	localObject4	Object
    //   205	12	3	localIOException3	IOException
    //   221	1	3	localObject5	Object
    //   225	1	3	localIOException4	IOException
    //   94	100	4	localObject6	Object
    //   209	1	4	localIOException5	IOException
    //   217	1	4	localIOException6	IOException
    //   52	19	5	arrayOfFile	File[]
    //   180	6	5	localObject7	Object
    //   214	6	5	localObject8	Object
    //   74	84	6	localFile	File
    //   104	25	7	localzza	zza
    // Exception table:
    //   from	to	target	type
    //   78	96	145	java/io/IOException
    //   168	173	176	java/io/IOException
    //   78	96	180	finally
    //   2	42	200	finally
    //   45	54	200	finally
    //   59	63	200	finally
    //   133	138	200	finally
    //   168	173	200	finally
    //   193	198	200	finally
    //   198	200	200	finally
    //   133	138	205	java/io/IOException
    //   193	198	209	java/io/IOException
    //   99	106	214	finally
    //   109	119	214	finally
    //   122	133	214	finally
    //   157	163	214	finally
    //   99	106	225	java/io/IOException
    //   109	119	225	java/io/IOException
    //   122	133	225	java/io/IOException
  }
  
  public final void zza(String paramString, zzb.zza paramzza)
  {
    int i = 0;
    label347:
    label371:
    label374:
    for (;;)
    {
      Object localObject2;
      zza localzza;
      try
      {
        int j = data.length;
        if (zzay + j >= zzaA)
        {
          if (zzs.DEBUG) {
            zzs.zza("Pruning old cache entries.", new Object[0]);
          }
          long l1 = zzay;
          long l2 = SystemClock.elapsedRealtime();
          localObject1 = zzax.entrySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label374;
          }
          localObject2 = (zza)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if (!zzf(key).delete()) {
            continue;
          }
          zzay -= zzaB;
          ((Iterator)localObject1).remove();
          i += 1;
          if ((float)(zzay + j) >= zzaA * 0.9F) {
            break label371;
          }
          if (zzs.DEBUG) {
            zzs.zza("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(zzay - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
          }
        }
        Object localObject1 = zzf(paramString);
        try
        {
          localObject2 = new FileOutputStream((File)localObject1);
          localzza = new zza(paramString, paramzza);
          if (localzza.zza((OutputStream)localObject2)) {
            break label347;
          }
          ((FileOutputStream)localObject2).close();
          zzs.zzb("Failed to write header for %s", new Object[] { ((File)localObject1).getAbsolutePath() });
          throw new IOException();
        }
        catch (IOException paramString)
        {
          if (!((File)localObject1).delete()) {
            zzs.zzb("Could not clean up file %s", new Object[] { ((File)localObject1).getAbsolutePath() });
          }
        }
        return;
        zzs.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { key, zze(key) });
        continue;
        ((FileOutputStream)localObject2).write(data);
      }
      finally {}
      ((FileOutputStream)localObject2).close();
      zza(paramString, localzza);
      continue;
    }
  }
  
  static final class zza
  {
    public String key;
    public long zzaB;
    public String zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public long zzf;
    public Map<String, String> zzg;
    
    private zza() {}
    
    public zza(String paramString, zzb.zza paramzza)
    {
      key = paramString;
      zzaB = data.length;
      zzb = zzb;
      zzc = zzc;
      zzd = zzd;
      zze = zze;
      zzf = zzf;
      zzg = zzg;
    }
    
    public static zza zzf(InputStream paramInputStream)
      throws IOException
    {
      zza localzza = new zza();
      if (zzv.zzb(paramInputStream) != 538247942) {
        throw new IOException();
      }
      key = zzv.zzd(paramInputStream);
      zzb = zzv.zzd(paramInputStream);
      if (zzb.equals("")) {
        zzb = null;
      }
      zzc = zzv.zzc(paramInputStream);
      zzd = zzv.zzc(paramInputStream);
      zze = zzv.zzc(paramInputStream);
      zzf = zzv.zzc(paramInputStream);
      zzg = zzv.zze(paramInputStream);
      return localzza;
    }
    
    public final boolean zza(OutputStream paramOutputStream)
    {
      for (;;)
      {
        try
        {
          zzv.zza(paramOutputStream, 538247942);
          zzv.zza(paramOutputStream, key);
          if (zzb == null)
          {
            localObject = "";
            zzv.zza(paramOutputStream, (String)localObject);
            zzv.zza(paramOutputStream, zzc);
            zzv.zza(paramOutputStream, zzd);
            zzv.zza(paramOutputStream, zze);
            zzv.zza(paramOutputStream, zzf);
            localObject = zzg;
            if (localObject == null) {
              break;
            }
            zzv.zza(paramOutputStream, ((Map)localObject).size());
            localObject = ((Map)localObject).entrySet().iterator();
            if (!((Iterator)localObject).hasNext()) {
              break label172;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            zzv.zza(paramOutputStream, (String)localEntry.getKey());
            zzv.zza(paramOutputStream, (String)localEntry.getValue());
            continue;
          }
          Object localObject = zzb;
        }
        catch (IOException paramOutputStream)
        {
          zzs.zzb("%s", new Object[] { paramOutputStream.toString() });
          return false;
        }
      }
      zzv.zza(paramOutputStream, 0);
      label172:
      paramOutputStream.flush();
      return true;
    }
  }
  
  private static final class zzb
    extends FilterInputStream
  {
    private int zzaC = 0;
    
    private zzb(InputStream paramInputStream)
    {
      super();
    }
    
    public final int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1) {
        zzaC += 1;
      }
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        zzaC += paramInt1;
      }
      return paramInt1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */