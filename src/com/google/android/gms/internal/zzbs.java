package com.google.android.gms.internal;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

@zzhb
public final class zzbs
{
  private final Object zzpV = new Object();
  private boolean zzqA = false;
  SharedPreferences zzvx = null;
  
  public final <T> T zzd(final zzbp<T> paramzzbp)
  {
    synchronized (zzpV)
    {
      if (!zzqA)
      {
        paramzzbp = zzvt;
        return paramzzbp;
      }
      (T)zzjb.zzb(new Callable()
      {
        public final T call()
        {
          return (T)paramzzbp.zza(zzvx);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */