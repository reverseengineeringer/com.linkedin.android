package org.acra.log;

import android.util.Log;

public final class AndroidLogDelegate
  implements ACRALog
{
  public final int d(String paramString1, String paramString2)
  {
    return Log.d(paramString1, paramString2);
  }
  
  public final int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public final int e(String paramString1, String paramString2)
  {
    return Log.e(paramString1, paramString2);
  }
  
  public final int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public final int i(String paramString1, String paramString2)
  {
    return Log.i(paramString1, paramString2);
  }
  
  public final int v(String paramString1, String paramString2)
  {
    return Log.v(paramString1, paramString2);
  }
  
  public final int w(String paramString1, String paramString2)
  {
    return Log.w(paramString1, paramString2);
  }
  
  public final int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.w(paramString1, paramString2, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     org.acra.log.AndroidLogDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */