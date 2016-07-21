package org.acra.log;

public abstract interface ACRALog
{
  public abstract int d(String paramString1, String paramString2);
  
  public abstract int d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int e(String paramString1, String paramString2);
  
  public abstract int e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int i(String paramString1, String paramString2);
  
  public abstract int v(String paramString1, String paramString2);
  
  public abstract int w(String paramString1, String paramString2);
  
  public abstract int w(String paramString1, String paramString2, Throwable paramThrowable);
}

/* Location:
 * Qualified Name:     org.acra.log.ACRALog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */