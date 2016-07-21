package com.crashlytics.android.core;

import java.util.concurrent.Callable;

public final class CrashlyticsUncaughtExceptionHandler$8
  implements Callable<Void>
{
  public CrashlyticsUncaughtExceptionHandler$8(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler, String paramString1, String paramString2, String paramString3) {}
  
  /* Error */
  private Void call()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 19	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$8:this$0	Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;
    //   6: invokestatic 37	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:access$500	(Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;)Ljava/lang/String;
    //   9: astore_3
    //   10: new 39	com/crashlytics/android/core/MetaDataStore
    //   13: dup
    //   14: aload_0
    //   15: getfield 19	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$8:this$0	Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;
    //   18: invokestatic 43	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:access$600	(Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;)Ljava/io/File;
    //   21: invokespecial 46	com/crashlytics/android/core/MetaDataStore:<init>	(Ljava/io/File;)V
    //   24: astore 4
    //   26: new 48	com/crashlytics/android/core/UserMetaData
    //   29: dup
    //   30: aload_0
    //   31: getfield 21	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$8:val$userId	Ljava/lang/String;
    //   34: aload_0
    //   35: getfield 23	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$8:val$userName	Ljava/lang/String;
    //   38: aload_0
    //   39: getfield 25	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$8:val$userEmail	Ljava/lang/String;
    //   42: invokespecial 51	com/crashlytics/android/core/UserMetaData:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload 4
    //   48: aload_3
    //   49: invokevirtual 55	com/crashlytics/android/core/MetaDataStore:getUserDataFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore 4
    //   54: aload_2
    //   55: invokestatic 59	com/crashlytics/android/core/MetaDataStore:userDataToJson	(Lcom/crashlytics/android/core/UserMetaData;)Ljava/lang/String;
    //   58: astore_3
    //   59: new 61	java/io/BufferedWriter
    //   62: dup
    //   63: new 63	java/io/OutputStreamWriter
    //   66: dup
    //   67: new 65	java/io/FileOutputStream
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: getstatic 70	com/crashlytics/android/core/MetaDataStore:UTF_8	Ljava/nio/charset/Charset;
    //   79: invokespecial 73	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   82: invokespecial 76	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: aload_2
    //   89: aload_3
    //   90: invokevirtual 82	java/io/Writer:write	(Ljava/lang/String;)V
    //   93: aload_2
    //   94: astore_1
    //   95: aload_2
    //   96: invokevirtual 85	java/io/Writer:flush	()V
    //   99: aload_2
    //   100: ldc 87
    //   102: invokestatic 93	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: invokestatic 99	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   115: ldc 101
    //   117: ldc 103
    //   119: aload_3
    //   120: invokeinterface 109 4 0
    //   125: aload_2
    //   126: ldc 87
    //   128: invokestatic 93	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_3
    //   134: aload_1
    //   135: astore_2
    //   136: aload_3
    //   137: astore_1
    //   138: aload_2
    //   139: ldc 87
    //   141: invokestatic 93	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   144: aload_1
    //   145: athrow
    //   146: astore_3
    //   147: aload_1
    //   148: astore_2
    //   149: aload_3
    //   150: astore_1
    //   151: goto -13 -> 138
    //   154: astore_3
    //   155: goto -45 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	8
    //   1	150	1	localObject1	Object
    //   45	104	2	localObject2	Object
    //   9	81	3	str	String
    //   107	13	3	localException1	Exception
    //   133	4	3	localObject3	Object
    //   146	4	3	localObject4	Object
    //   154	1	3	localException2	Exception
    //   24	48	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   54	86	107	java/lang/Exception
    //   54	86	133	finally
    //   88	93	146	finally
    //   95	99	146	finally
    //   112	125	146	finally
    //   88	93	154	java/lang/Exception
    //   95	99	154	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */