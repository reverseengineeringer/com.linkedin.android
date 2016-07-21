package com.crashlytics.android.core;

import java.util.Map;
import java.util.concurrent.Callable;

public final class CrashlyticsUncaughtExceptionHandler$9
  implements Callable<Void>
{
  public CrashlyticsUncaughtExceptionHandler$9(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler, Map paramMap) {}
  
  /* Error */
  private Void call()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 17	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$9:this$0	Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;
    //   6: invokestatic 31	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:access$500	(Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;)Ljava/lang/String;
    //   9: astore_3
    //   10: new 33	com/crashlytics/android/core/MetaDataStore
    //   13: dup
    //   14: aload_0
    //   15: getfield 17	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$9:this$0	Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;
    //   18: invokestatic 37	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler:access$600	(Lcom/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler;)Ljava/io/File;
    //   21: invokespecial 40	com/crashlytics/android/core/MetaDataStore:<init>	(Ljava/io/File;)V
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 19	com/crashlytics/android/core/CrashlyticsUncaughtExceptionHandler$9:val$keyData	Ljava/util/Map;
    //   30: astore_2
    //   31: aload 4
    //   33: aload_3
    //   34: invokevirtual 44	com/crashlytics/android/core/MetaDataStore:getKeysFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   37: astore 4
    //   39: aload_2
    //   40: invokestatic 48	com/crashlytics/android/core/MetaDataStore:keysDataToJson	(Ljava/util/Map;)Ljava/lang/String;
    //   43: astore_3
    //   44: new 50	java/io/BufferedWriter
    //   47: dup
    //   48: new 52	java/io/OutputStreamWriter
    //   51: dup
    //   52: new 54	java/io/FileOutputStream
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: getstatic 59	com/crashlytics/android/core/MetaDataStore:UTF_8	Ljava/nio/charset/Charset;
    //   64: invokespecial 62	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   67: invokespecial 65	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: aload_2
    //   74: aload_3
    //   75: invokevirtual 71	java/io/Writer:write	(Ljava/lang/String;)V
    //   78: aload_2
    //   79: astore_1
    //   80: aload_2
    //   81: invokevirtual 74	java/io/Writer:flush	()V
    //   84: aload_2
    //   85: ldc 76
    //   87: invokestatic 82	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: astore_1
    //   97: invokestatic 88	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   100: ldc 90
    //   102: ldc 92
    //   104: aload_3
    //   105: invokeinterface 98 4 0
    //   110: aload_2
    //   111: ldc 76
    //   113: invokestatic 82	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_3
    //   119: aload_1
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: ldc 76
    //   126: invokestatic 82	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   129: aload_1
    //   130: athrow
    //   131: astore_3
    //   132: aload_1
    //   133: astore_2
    //   134: aload_3
    //   135: astore_1
    //   136: goto -13 -> 123
    //   139: astore_3
    //   140: goto -45 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	9
    //   1	135	1	localObject1	Object
    //   30	104	2	localObject2	Object
    //   9	66	3	str	String
    //   92	13	3	localException1	Exception
    //   118	4	3	localObject3	Object
    //   131	4	3	localObject4	Object
    //   139	1	3	localException2	Exception
    //   24	33	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   39	71	92	java/lang/Exception
    //   39	71	118	finally
    //   73	78	131	finally
    //   80	84	131	finally
    //   97	110	131	finally
    //   73	78	139	java/lang/Exception
    //   80	84	139	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */