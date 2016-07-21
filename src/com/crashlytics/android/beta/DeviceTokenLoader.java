package com.crashlytics.android.beta;

import io.fabric.sdk.android.services.cache.ValueLoader;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class DeviceTokenLoader
  implements ValueLoader<String>
{
  private static String determineDeviceToken(ZipInputStream paramZipInputStream)
    throws IOException
  {
    Object localObject;
    do
    {
      localObject = paramZipInputStream.getNextEntry();
      if (localObject == null) {
        break;
      }
      localObject = ((ZipEntry)localObject).getName();
    } while (!((String)localObject).startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token="));
    return ((String)localObject).substring(59, ((String)localObject).length() - 1);
    return "";
  }
  
  /* Error */
  private static String load(android.content.Context paramContext)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: invokestatic 61	java/lang/System:nanoTime	()J
    //   3: lstore_3
    //   4: ldc 46
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 6
    //   20: new 18	java/util/zip/ZipInputStream
    //   23: dup
    //   24: new 63	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokevirtual 69	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   32: aload_0
    //   33: invokevirtual 72	android/content/Context:getPackageName	()Ljava/lang/String;
    //   36: iconst_0
    //   37: invokevirtual 78	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   40: getfield 84	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   43: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 90	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokestatic 92	com/crashlytics/android/beta/DeviceTokenLoader:determineDeviceToken	(Ljava/util/zip/ZipInputStream;)Ljava/lang/String;
    //   54: astore 5
    //   56: aload_0
    //   57: invokevirtual 95	java/util/zip/ZipInputStream:close	()V
    //   60: invokestatic 61	java/lang/System:nanoTime	()J
    //   63: lload_3
    //   64: lsub
    //   65: l2d
    //   66: ldc2_w 96
    //   69: ddiv
    //   70: dstore_1
    //   71: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   74: ldc 105
    //   76: new 107	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 109
    //   82: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: dload_1
    //   86: invokevirtual 114	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   89: ldc 116
    //   91: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokeinterface 128 3 0
    //   102: aload 5
    //   104: areturn
    //   105: astore_0
    //   106: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   109: ldc 105
    //   111: ldc -126
    //   113: aload_0
    //   114: invokeinterface 134 4 0
    //   119: goto -59 -> 60
    //   122: astore 5
    //   124: aload 6
    //   126: astore_0
    //   127: aload 5
    //   129: astore 6
    //   131: aload_0
    //   132: astore 5
    //   134: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   137: ldc 105
    //   139: ldc -120
    //   141: aload 6
    //   143: invokeinterface 134 4 0
    //   148: aload 7
    //   150: astore 5
    //   152: aload_0
    //   153: ifnull -93 -> 60
    //   156: aload_0
    //   157: invokevirtual 95	java/util/zip/ZipInputStream:close	()V
    //   160: aload 7
    //   162: astore 5
    //   164: goto -104 -> 60
    //   167: astore_0
    //   168: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   171: ldc 105
    //   173: ldc -126
    //   175: aload_0
    //   176: invokeinterface 134 4 0
    //   181: aload 7
    //   183: astore 5
    //   185: goto -125 -> 60
    //   188: astore 6
    //   190: aload 8
    //   192: astore_0
    //   193: aload_0
    //   194: astore 5
    //   196: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   199: ldc 105
    //   201: ldc -118
    //   203: aload 6
    //   205: invokeinterface 134 4 0
    //   210: aload 7
    //   212: astore 5
    //   214: aload_0
    //   215: ifnull -155 -> 60
    //   218: aload_0
    //   219: invokevirtual 95	java/util/zip/ZipInputStream:close	()V
    //   222: aload 7
    //   224: astore 5
    //   226: goto -166 -> 60
    //   229: astore_0
    //   230: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   233: ldc 105
    //   235: ldc -126
    //   237: aload_0
    //   238: invokeinterface 134 4 0
    //   243: aload 7
    //   245: astore 5
    //   247: goto -187 -> 60
    //   250: astore 6
    //   252: aload 9
    //   254: astore_0
    //   255: aload_0
    //   256: astore 5
    //   258: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   261: ldc 105
    //   263: ldc -116
    //   265: aload 6
    //   267: invokeinterface 134 4 0
    //   272: aload 7
    //   274: astore 5
    //   276: aload_0
    //   277: ifnull -217 -> 60
    //   280: aload_0
    //   281: invokevirtual 95	java/util/zip/ZipInputStream:close	()V
    //   284: aload 7
    //   286: astore 5
    //   288: goto -228 -> 60
    //   291: astore_0
    //   292: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   295: ldc 105
    //   297: ldc -126
    //   299: aload_0
    //   300: invokeinterface 134 4 0
    //   305: aload 7
    //   307: astore 5
    //   309: goto -249 -> 60
    //   312: astore_0
    //   313: aload 5
    //   315: ifnull +8 -> 323
    //   318: aload 5
    //   320: invokevirtual 95	java/util/zip/ZipInputStream:close	()V
    //   323: aload_0
    //   324: athrow
    //   325: astore 5
    //   327: invokestatic 103	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   330: ldc 105
    //   332: ldc -126
    //   334: aload 5
    //   336: invokeinterface 134 4 0
    //   341: goto -18 -> 323
    //   344: astore 6
    //   346: aload_0
    //   347: astore 5
    //   349: aload 6
    //   351: astore_0
    //   352: goto -39 -> 313
    //   355: astore 6
    //   357: goto -102 -> 255
    //   360: astore 6
    //   362: goto -169 -> 193
    //   365: astore 6
    //   367: goto -236 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramContext	android.content.Context
    //   70	16	1	d	double
    //   3	61	3	l	long
    //   15	88	5	str1	String
    //   122	6	5	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   132	187	5	localObject1	Object
    //   325	10	5	localIOException1	IOException
    //   347	1	5	localContext	android.content.Context
    //   18	124	6	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   188	16	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   250	16	6	localIOException2	IOException
    //   344	6	6	localObject2	Object
    //   355	1	6	localIOException3	IOException
    //   360	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   365	1	6	localNameNotFoundException3	android.content.pm.PackageManager.NameNotFoundException
    //   6	300	7	str2	String
    //   9	182	8	localObject3	Object
    //   12	241	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   56	60	105	java/io/IOException
    //   20	50	122	android/content/pm/PackageManager$NameNotFoundException
    //   156	160	167	java/io/IOException
    //   20	50	188	java/io/FileNotFoundException
    //   218	222	229	java/io/IOException
    //   20	50	250	java/io/IOException
    //   280	284	291	java/io/IOException
    //   20	50	312	finally
    //   134	148	312	finally
    //   196	210	312	finally
    //   258	272	312	finally
    //   318	323	325	java/io/IOException
    //   50	56	344	finally
    //   50	56	355	java/io/IOException
    //   50	56	360	java/io/FileNotFoundException
    //   50	56	365	android/content/pm/PackageManager$NameNotFoundException
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.DeviceTokenLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */