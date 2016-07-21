package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzlz<T>
{
  static zza zzaiV = null;
  private static int zzaiW = 0;
  private static String zzaiX = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private static final Object zzqy = new Object();
  private T zzSC = null;
  protected final String zzvs;
  protected final T zzvt;
  
  protected zzlz(String paramString, T paramT)
  {
    zzvs = paramString;
    zzvt = paramT;
  }
  
  public static boolean isInitialized()
  {
    return zzaiV != null;
  }
  
  public static zzlz<Integer> zza(String paramString, Integer paramInteger)
  {
    new zzlz(paramString, paramInteger) {};
  }
  
  public static zzlz<Long> zza(String paramString, Long paramLong)
  {
    new zzlz(paramString, paramLong) {};
  }
  
  public static zzlz<Boolean> zzk$15457046(String paramString)
  {
    new zzlz(paramString, Boolean.valueOf(true)) {};
  }
  
  public static int zzpW()
  {
    return zzaiW;
  }
  
  public static zzlz<String> zzv(String paramString1, String paramString2)
  {
    new zzlz(paramString1, paramString2) {};
  }
  
  public final T get()
  {
    if (zzSC != null) {
      return (T)zzSC;
    }
    return (T)zzct$9543ced();
  }
  
  protected abstract T zzct$9543ced();
  
  public final T zzpX()
  {
    long l = Binder.clearCallingIdentity();
    try
    {
      Object localObject1 = get();
      return (T)localObject1;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  private static abstract interface zza
  {
    public abstract Long getLong$4885d6e9();
    
    public abstract String getString$7157d249();
    
    public abstract Boolean zza$6de378eb();
    
    public abstract Integer zzb$1b7f1b3f();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */