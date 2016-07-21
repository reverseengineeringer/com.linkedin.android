package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzl
  implements zzp
{
  final Context mContext;
  final Lock zzXG;
  final zzj zzagW;
  final com.google.android.gms.common.zzc zzags;
  final Api.zza<? extends zzrn, zzro> zzagt;
  final Map<Api<?>, Integer> zzahA;
  final Map<Api.zzc<?>, Api.zzb> zzahT;
  final zzf zzahz;
  final Condition zzaim;
  final zzb zzain;
  final Map<Api.zzc<?>, ConnectionResult> zzaio = new HashMap();
  volatile zzk zzaip;
  private ConnectionResult zzaiq = null;
  int zzair;
  final zzp.zza zzais;
  
  public zzl(Context paramContext, zzj paramzzj, Lock paramLock, Looper paramLooper, com.google.android.gms.common.zzc paramzzc, Map<Api.zzc<?>, Api.zzb> paramMap, zzf paramzzf, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzrn, zzro> paramzza, ArrayList<zzc> paramArrayList, zzp.zza paramzza1)
  {
    mContext = paramContext;
    zzXG = paramLock;
    zzags = paramzzc;
    zzahT = paramMap;
    zzahz = paramzzf;
    zzahA = paramMap1;
    zzagt = paramzza;
    zzagW = paramzzj;
    zzais = paramzza1;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      nextzzagV = this;
    }
    zzain = new zzb(paramLooper);
    zzaim = paramLock.newCondition();
    zzaip = new zzi(this);
  }
  
  public final ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting()) {
      try
      {
        zzaim.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.zzafB;
    }
    if (zzaiq != null) {
      return zzaiq;
    }
    return new ConnectionResult(13, null);
  }
  
  public final void connect()
  {
    zzaip.connect();
  }
  
  public final boolean disconnect()
  {
    boolean bool = zzaip.disconnect();
    if (bool) {
      zzaio.clear();
    }
    return bool;
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramFileDescriptor = paramString + "  ";
    paramArrayOfString = zzahA.keySet().iterator();
    while (paramArrayOfString.hasNext())
    {
      Api localApi = (Api)paramArrayOfString.next();
      paramPrintWriter.append(paramString).append(mName).println(":");
      ((Api.zzb)zzahT.get(localApi.zzoR())).dump$ec96877(paramFileDescriptor, paramPrintWriter);
    }
  }
  
  public final boolean isConnected()
  {
    return zzaip instanceof zzg;
  }
  
  public final boolean isConnecting()
  {
    return zzaip instanceof zzh;
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzXG.lock();
    try
    {
      zzaip.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  public final <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    return zzaip.zza(paramT);
  }
  
  final void zza(zza paramzza)
  {
    paramzza = zzain.obtainMessage(1, paramzza);
    zzain.sendMessage(paramzza);
  }
  
  public final boolean zza(zzu paramzzu)
  {
    return false;
  }
  
  public final <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    return zzaip.zzb(paramT);
  }
  
  final void zzh(ConnectionResult paramConnectionResult)
  {
    zzXG.lock();
    try
    {
      zzaiq = paramConnectionResult;
      zzaip = new zzi(this);
      zzaip.begin();
      zzaim.signalAll();
      return;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  public final void zzoW() {}
  
  public final void zzpj()
  {
    if (isConnected())
    {
      zzg localzzg = (zzg)zzaip;
      if (zzahk)
      {
        zzahk = false;
        zzahj.zzagW.zzaa(false);
        localzzg.disconnect();
      }
    }
  }
  
  static abstract class zza
  {
    private final zzk zzait;
    
    protected zza(zzk paramzzk)
    {
      zzait = paramzzk;
    }
    
    public final void zzd(zzl paramzzl)
    {
      zzXG.lock();
      try
      {
        zzk localzzk1 = zzaip;
        zzk localzzk2 = zzait;
        if (localzzk1 != localzzk2) {
          return;
        }
        zzpt();
        return;
      }
      finally
      {
        zzXG.unlock();
      }
    }
    
    protected abstract void zzpt();
  }
  
  final class zzb
    extends Handler
  {
    zzb(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.w("GACStateManager", "Unknown message id: " + what);
        return;
      case 1: 
        ((zzl.zza)obj).zzd(zzl.this);
        return;
      }
      throw ((RuntimeException)obj);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */