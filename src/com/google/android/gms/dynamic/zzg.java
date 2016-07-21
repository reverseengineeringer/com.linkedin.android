package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;

public abstract class zzg<T>
{
  private final String zzavI;
  private T zzavJ;
  
  public zzg(String paramString)
  {
    zzavI = paramString;
  }
  
  public final T zzaB(Context paramContext)
    throws zzg.zza
  {
    if (zzavJ == null)
    {
      zzx.zzz(paramContext);
      paramContext = zze.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new zza("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      zzavJ = zzd((IBinder)paramContext.loadClass(zzavI).newInstance());
      return (T)zzavJ;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new zza("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new zza("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new zza("Could not access creator.", paramContext);
    }
  }
  
  public abstract T zzd(IBinder paramIBinder);
  
  public static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
    
    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */