package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zzb;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzm
  extends zzl
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<zza, zzb> zzalZ = new HashMap();
  private final zzb zzama;
  private final long zzamb;
  private final Context zzsa;
  
  zzm(Context paramContext)
  {
    zzsa = paramContext.getApplicationContext();
    mHandler = new Handler(paramContext.getMainLooper(), this);
    zzama = zzb.zzrP();
    zzamb = 5000L;
  }
  
  private boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzx.zzb(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zzb localzzb;
      synchronized (zzalZ)
      {
        localzzb = (zzb)zzalZ.get(paramzza);
        if (localzzb == null)
        {
          localzzb = new zzb(paramzza);
          localzzb.zza(paramServiceConnection, paramString);
          localzzb.zzcH(paramString);
          zzalZ.put(paramzza, localzzb);
          paramzza = localzzb;
          boolean bool = zzamf;
          return bool;
        }
        mHandler.removeMessages(0, localzzb);
        if (localzzb.zza(paramServiceConnection)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramzza);
        }
      }
      localzzb.zza(paramServiceConnection, paramString);
      switch (mState)
      {
      case 1: 
        paramServiceConnection.onServiceConnected(zzamc, zzakD);
        paramzza = localzzb;
        break;
      case 2: 
        localzzb.zzcH(paramString);
        paramzza = localzzb;
        break;
      default: 
        paramzza = localzzb;
      }
    }
  }
  
  private void zzb$37710f84(zza paramzza, ServiceConnection paramServiceConnection)
  {
    zzx.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzb localzzb;
    synchronized (zzalZ)
    {
      localzzb = (zzb)zzalZ.get(paramzza);
      if (localzzb == null) {
        throw new IllegalStateException("Nonexistent connection status for service config: " + paramzza);
      }
    }
    if (!localzzb.zza(paramServiceConnection)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
    }
    zzamh.zzama.zza(zzamh.zzsa, zzb.zzb(paramServiceConnection), null, null, 4);
    zzame.remove(paramServiceConnection);
    if (localzzb.zzqT())
    {
      paramzza = mHandler.obtainMessage(0, localzzb);
      mHandler.sendMessageDelayed(paramzza, zzamb);
    }
  }
  
  public final boolean handleMessage(Message arg1)
  {
    switch (what)
    {
    default: 
      return false;
    }
    zzb localzzb = (zzb)obj;
    synchronized (zzalZ)
    {
      if (localzzb.zzqT())
      {
        if (zzamf)
        {
          zzamh.zzama.zza(zzamh.zzsa, zzamd);
          zzamf = false;
          mState = 2;
        }
        zzalZ.remove(zzamg);
      }
      return true;
    }
  }
  
  public final boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public final boolean zza(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return zza(new zza(paramString1), paramServiceConnection, paramString2);
  }
  
  public final void zzb$5fe800ef(String paramString, ServiceConnection paramServiceConnection)
  {
    zzb$37710f84(new zza(paramString), paramServiceConnection);
  }
  
  public final void zzb$9b3168c(ComponentName paramComponentName, ServiceConnection paramServiceConnection)
  {
    zzb$37710f84(new zza(paramComponentName), paramServiceConnection);
  }
  
  private static final class zza
  {
    private final String zzSU;
    private final ComponentName zzamc;
    
    public zza(ComponentName paramComponentName)
    {
      zzSU = null;
      zzamc = ((ComponentName)zzx.zzz(paramComponentName));
    }
    
    public zza(String paramString)
    {
      zzSU = zzx.zzcM(paramString);
      zzamc = null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
      } while ((zzw.equal(zzSU, zzSU)) && (zzw.equal(zzamc, zzamc)));
      return false;
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(new Object[] { zzSU, zzamc });
    }
    
    public final String toString()
    {
      if (zzSU == null) {
        return zzamc.flattenToString();
      }
      return zzSU;
    }
    
    public final Intent zzqS()
    {
      if (zzSU != null) {
        return new Intent(zzSU).setPackage("com.google.android.gms");
      }
      return new Intent().setComponent(zzamc);
    }
  }
  
  private final class zzb
  {
    int mState;
    IBinder zzakD;
    ComponentName zzamc;
    final zza zzamd;
    final Set<ServiceConnection> zzame;
    boolean zzamf;
    final zzm.zza zzamg;
    
    public zzb(zzm.zza paramzza)
    {
      zzamg = paramzza;
      zzamd = new zza();
      zzame = new HashSet();
      mState = 2;
    }
    
    public final void zza(ServiceConnection paramServiceConnection, String paramString)
    {
      zzb localzzb = zzm.zzc(zzm.this);
      Context localContext = zzm.zzb(zzm.this);
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
      zzamf = zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramString, zzamg.zzqS(), zzamd, 129);
      if (!zzamf) {
        mState = 2;
      }
      try
      {
        zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), zzamd);
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
        synchronized (zzm.zza(zzm.this))
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
        synchronized (zzm.zza(zzm.this))
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */