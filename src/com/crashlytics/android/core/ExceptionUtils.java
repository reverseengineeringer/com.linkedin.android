package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.Writer;

final class ExceptionUtils
{
  private static void writeStackTrace(Throwable paramThrowable, Writer paramWriter)
  {
    int i = 1;
    Throwable localThrowable = paramThrowable;
    if (localThrowable != null) {}
    for (;;)
    {
      try
      {
        paramThrowable = localThrowable.getLocalizedMessage();
        int j;
        if (paramThrowable == null)
        {
          paramThrowable = null;
          break label169;
          paramWriter.write(str + localThrowable.getClass().getName() + ": " + paramThrowable + "\n");
          j = 0;
          paramThrowable = localThrowable.getStackTrace();
          int k = paramThrowable.length;
          i = 0;
          if (i < k)
          {
            str = paramThrowable[i];
            paramWriter.write("\tat " + str.toString() + "\n");
            i += 1;
            continue;
          }
        }
        else
        {
          paramThrowable = paramThrowable.replaceAll("(\r\n|\n|\f)", " ");
          break label169;
        }
        localThrowable = localThrowable.getCause();
        i = j;
      }
      catch (Exception paramThrowable)
      {
        Fabric.getLogger().e("CrashlyticsCore", "Could not write stack trace", paramThrowable);
      }
      return;
      label169:
      if (paramThrowable != null) {}
      for (;;)
      {
        if (i == 0) {
          break label190;
        }
        str = "";
        break;
        paramThrowable = "";
      }
      label190:
      String str = "Caused by: ";
    }
  }
  
  /* Error */
  public static void writeStackTraceIfNotNull(Throwable paramThrowable, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +25 -> 26
    //   4: new 97	java/io/PrintWriter
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 100	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   12: astore_2
    //   13: aload_2
    //   14: astore_1
    //   15: aload_0
    //   16: aload_2
    //   17: invokestatic 102	com/crashlytics/android/core/ExceptionUtils:writeStackTrace	(Ljava/lang/Throwable;Ljava/io/Writer;)V
    //   20: aload_2
    //   21: ldc 104
    //   23: invokestatic 110	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   26: return
    //   27: astore_3
    //   28: aconst_null
    //   29: astore_0
    //   30: aload_0
    //   31: astore_1
    //   32: invokestatic 79	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   35: ldc 81
    //   37: ldc 112
    //   39: aload_3
    //   40: invokeinterface 89 4 0
    //   45: aload_0
    //   46: ldc 104
    //   48: invokestatic 110	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   51: return
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: ldc 104
    //   58: invokestatic 110	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   61: aload_0
    //   62: athrow
    //   63: astore_0
    //   64: goto -9 -> 55
    //   67: astore_3
    //   68: aload_2
    //   69: astore_0
    //   70: goto -40 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramThrowable	Throwable
    //   0	73	1	paramOutputStream	java.io.OutputStream
    //   12	57	2	localPrintWriter	java.io.PrintWriter
    //   27	13	3	localException1	Exception
    //   67	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   4	13	27	java/lang/Exception
    //   4	13	52	finally
    //   15	20	63	finally
    //   32	45	63	finally
    //   15	20	67	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.ExceptionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */