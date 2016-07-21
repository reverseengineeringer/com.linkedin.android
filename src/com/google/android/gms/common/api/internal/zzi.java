package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzi
  implements zzk
{
  private final zzl zzahj;
  
  public zzi(zzl paramzzl)
  {
    zzahj = paramzzl;
  }
  
  public final void begin()
  {
    Iterator localIterator = zzahj.zzahT.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zzb)localIterator.next()).disconnect();
    }
    zzahj.zzagW.zzahU = Collections.emptySet();
  }
  
  public final void connect()
  {
    zzl localzzl = zzahj;
    zzXG.lock();
    try
    {
      zzaip = new zzh(localzzl, zzahz, zzahA, zzags, zzagt, zzXG, mContext);
      zzaip.begin();
      zzaim.signalAll();
      return;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  public final boolean disconnect()
  {
    return true;
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt) {}
  
  public final <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    zzahj.zzagW.zzahN.add(paramT);
    return paramT;
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public final <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */