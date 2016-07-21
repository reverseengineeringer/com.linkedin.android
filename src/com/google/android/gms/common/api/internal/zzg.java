package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzg
  implements zzk
{
  final zzl zzahj;
  boolean zzahk = false;
  
  public zzg(zzl paramzzl)
  {
    zzahj = paramzzl;
  }
  
  public final void begin() {}
  
  public final void connect()
  {
    if (zzahk)
    {
      zzahk = false;
      zzahj.zza(new zzl.zza(this)
      {
        public final void zzpt()
        {
          zzahj.zzais.zzi(null);
        }
      });
    }
  }
  
  public final boolean disconnect()
  {
    if (zzahk) {
      return false;
    }
    if (zzahj.zzagW.zzpG())
    {
      zzahk = true;
      Iterator localIterator = zzahj.zzagW.zzaia.iterator();
      while (localIterator.hasNext())
      {
        zzx localzzx = (zzx)localIterator.next();
        synchronized (zzagI)
        {
          zzaiP = null;
        }
      }
      return false;
    }
    zzahj.zzh(null);
    return true;
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzahj.zzh(null);
    zzahj.zzais.zzc(paramInt, zzahk);
  }
  
  public final <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    return zzb(paramT);
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public final <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    try
    {
      zzahj.zzagW.zzb(paramT);
      Api.zzb localzzb = zzahj.zzagW.zza(paramT.zzoR());
      if ((!localzzb.isConnected()) && (zzahj.zzaio.containsKey(paramT.zzoR())))
      {
        paramT.zzw(new Status(17));
        return paramT;
      }
      paramT.zzb(localzzb);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      zzahj.zza(new zzl.zza(this)
      {
        public final void zzpt()
        {
          onConnectionSuspended(1);
        }
      });
    }
    return paramT;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */