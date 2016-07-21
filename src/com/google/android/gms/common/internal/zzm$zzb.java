package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.zzb;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzm$zzb
{
  int mState;
  IBinder zzakD;
  ComponentName zzamc;
  final zza zzamd;
  final Set<ServiceConnection> zzame;
  boolean zzamf;
  final zzm.zza zzamg;
  
  public zzm$zzb(zzm paramzzm, zzm.zza paramzza)
  {
    zzamg = paramzza;
    zzamd = new zza();
    zzame = new HashSet();
    mState = 2;
  }
  
  public final void zza(ServiceConnection paramServiceConnection, String paramString)
  {
    zzb localzzb = zzm.zzc(zzamh);
    Context localContext = zzm.zzb(zzamh);
    Intent localIntent = zzamg.zzqS();
    localzzb.zza(localContext, zzb.zzb(paramServiceConnection), paramString, localIntent, 3);
    zzame.add(paramServiceConnection);
  }
  
  public final boolean zza(ServiceConnection paramServiceConnection)
  {
    return zzame.contains(paramServiceConnection);
  }
  
  @TargetApi(14)
  public final void zzcH(String paramString)
  {
    mState = 3;
    zzamf = zzm.zzc(zzamh).zza(zzm.zzb(zzamh), paramString, zzamg.zzqS(), zzamd, 129);
    if (!zzamf) {
      mState = 2;
    }
    try
    {
      zzm.zzc(zzamh).zza(zzm.zzb(zzamh), zzamd);
      return;
    }
    catch (IllegalArgumentException paramString) {}
  }
  
  public final boolean zzqT()
  {
    return zzame.isEmpty();
  }
  
  public final class zza
    implements ServiceConnection
  {
    public zza() {}
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      synchronized (zzm.zza(zzamh))
      {
        zzakD = paramIBinder;
        zzamc = paramComponentName;
        Iterator localIterator = zzame.iterator();
        if (localIterator.hasNext()) {
          ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
        }
      }
      mState = 1;
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      synchronized (zzm.zza(zzamh))
      {
        zzakD = null;
        zzamc = paramComponentName;
        Iterator localIterator = zzame.iterator();
        if (localIterator.hasNext()) {
          ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
        }
      }
      mState = 2;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */