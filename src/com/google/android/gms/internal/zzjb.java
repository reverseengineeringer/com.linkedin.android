package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Callable;

@zzhb
public final class zzjb
{
  public static <T> T zzb(Callable<T> paramCallable)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    try
    {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitDiskReads().permitDiskWrites().build());
      paramCallable = paramCallable.call();
      return paramCallable;
    }
    catch (Throwable paramCallable)
    {
      zzin.zzb("Unexpected exception.", paramCallable);
      zzr.zzbF().zzb(paramCallable, true);
      return null;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */