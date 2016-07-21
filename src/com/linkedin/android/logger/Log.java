package com.linkedin.android.logger;

public final class Log
{
  private static int logLevel = 2;
  private static boolean loggingEnabled = true;
  private static int maximumLineLength = 4000;
  
  public static int d(String paramString)
  {
    return println(3, getTag(), paramString);
  }
  
  public static int d(String paramString1, String paramString2)
  {
    return println(3, paramString1, paramString2);
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return println(3, paramString1, paramString2 + "\n" + paramThrowable.toString());
  }
  
  public static int e(String paramString)
  {
    return println(6, getTag(), paramString);
  }
  
  public static int e(String paramString1, String paramString2)
  {
    return println(6, paramString1, paramString2);
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return println(6, paramString1, paramString2 + "\n" + android.util.Log.getStackTraceString(paramThrowable));
  }
  
  public static int e(String paramString, Throwable paramThrowable)
  {
    return e(getTag(), paramString, paramThrowable);
  }
  
  public static void enableLogging(boolean paramBoolean)
  {
    loggingEnabled = paramBoolean;
  }
  
  private static String getTag()
  {
    Object localObject2 = "";
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < arrayOfStackTraceElement.length)
      {
        if ((!arrayOfStackTraceElement[i].getMethodName().equals("getTag")) || (i + 2 >= arrayOfStackTraceElement.length)) {
          break label97;
        }
        localObject2 = arrayOfStackTraceElement[(i + 2)].getClassName();
        localObject1 = localObject2;
        if (((String)localObject2).lastIndexOf('.') != -1) {
          localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf('.') + 1);
        }
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() > 23) {
        localObject2 = ((String)localObject1).substring(0, 23);
      }
      return (String)localObject2;
      label97:
      i += 1;
    }
  }
  
  public static int i(String paramString)
  {
    return println(4, getTag(), paramString);
  }
  
  public static int i(String paramString1, String paramString2)
  {
    return println(4, paramString1, paramString2);
  }
  
  private static int println(int paramInt, String paramString1, String paramString2)
  {
    int i = 0;
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.length() > 23) {
        str = paramString1.substring(0, 23);
      }
    }
    boolean bool;
    if (android.util.Log.isLoggable(str, paramInt)) {
      bool = true;
    }
    while (bool)
    {
      int k = 0;
      if (paramString2.length() > maximumLineLength)
      {
        int m = paramString2.length();
        paramString1 = new String[(int)Math.ceil(m / maximumLineLength)];
        int j = 0;
        for (;;)
        {
          if (i < paramString1.length)
          {
            paramString1[i] = paramString2.substring(j, Math.min(maximumLineLength, m - j) + j);
            j += maximumLineLength;
            i += 1;
            continue;
            bool = loggingEnabled;
            break;
          }
        }
        j = 0;
        i = k;
        for (;;)
        {
          k = i;
          if (j >= paramString1.length) {
            break;
          }
          i += android.util.Log.println(paramInt, str, paramString1[j]);
          j += 1;
        }
      }
      k = android.util.Log.println(paramInt, str, paramString2);
      FileLog.logToFile(str, paramString2);
      return k;
    }
    return 0;
  }
  
  public static int v(String paramString1, String paramString2)
  {
    return println(2, paramString1, paramString2);
  }
  
  public static int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return println(2, paramString1, paramString2 + "\n" + android.util.Log.getStackTraceString(paramThrowable));
  }
  
  public static int w(String paramString)
  {
    return println(5, getTag(), paramString);
  }
  
  public static int w(String paramString1, String paramString2)
  {
    return println(5, paramString1, paramString2);
  }
  
  public static int wtf(String paramString1, String paramString2)
  {
    return println(7, paramString1, paramString2);
  }
  
  public static int wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return println(7, paramString1, paramString2 + "\n" + android.util.Log.getStackTraceString(paramThrowable));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.logger.Log
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */