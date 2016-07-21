package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;

@zzhb
public final class zziw
{
  static zzl zzMy;
  public static final zza<Void> zzMz = new zza() {};
  private static final Object zzqy = new Object();
  
  public zziw(Context paramContext)
  {
    zzMy = zzS(paramContext);
  }
  
  private static zzl zzS(Context paramContext)
  {
    synchronized (zzqy)
    {
      if (zzMy == null) {
        zzMy = zzac.zza$575a9856(paramContext.getApplicationContext());
      }
      paramContext = zzMy;
      return paramContext;
    }
  }
  
  public static abstract interface zza<T> {}
  
  private final class zzc<T>
    extends zzjd<T>
    implements zzm.zzb<T>
  {
    private zzc() {}
    
    public final void zzb(T paramT)
    {
      super.zzg(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */