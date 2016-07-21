package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  public final String mName;
  private final zzc<?> zzaeE;
  private final zza<?, O> zzafW;
  final zze<?, O> zzafX;
  final zzf<?> zzafY;
  
  public <C extends zzb> Api(String paramString, zza<C, O> paramzza, zzc<C> paramzzc)
  {
    zzx.zzb(paramzza, "Cannot construct an Api with a null ClientBuilder");
    zzx.zzb(paramzzc, "Cannot construct an Api with a null ClientKey");
    mName = paramString;
    zzafW = paramzza;
    zzafX = null;
    zzaeE = paramzzc;
    zzafY = null;
  }
  
  public final zza<?, O> zzoP()
  {
    if (zzafW != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return zzafW;
    }
  }
  
  public final zzc<?> zzoR()
  {
    if (zzaeE != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
      return zzaeE;
    }
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract class zza<T extends Api.zzb, O>
  {
    public abstract T zza(Context paramContext, Looper paramLooper, zzf paramzzf, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
    
    public List<Scope> zzo(O paramO)
    {
      return Collections.emptyList();
    }
  }
  
  public static abstract interface zzb
  {
    public abstract void disconnect();
    
    public abstract void dump$ec96877(String paramString, PrintWriter paramPrintWriter);
    
    public abstract boolean isConnected();
    
    public abstract void zza(GoogleApiClient.zza paramzza);
    
    public abstract void zza(zzp paramzzp, Set<Scope> paramSet);
    
    public abstract boolean zzmE();
    
    public abstract boolean zznb();
    
    public abstract Intent zznc();
    
    public abstract IBinder zzoT();
  }
  
  public static final class zzc<C extends Api.zzb> {}
  
  public static abstract interface zzd<T extends IInterface>
  {
    public abstract T zzW$13514312();
    
    public abstract String zzgu();
    
    public abstract String zzgv();
  }
  
  public static abstract interface zze<T extends Api.zzd, O>
  {
    public abstract int getPriority();
    
    public abstract int zzoU();
    
    public abstract T zzq$55e35557();
  }
  
  public static final class zzf<C extends Api.zzd> {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */