package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zznf;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzb
{
  private static final Object zzalX = new Object();
  private static zzb zzanp;
  private static Integer zzanv;
  private final List<String> zzanq;
  private final List<String> zzanr;
  private final List<String> zzans;
  private final List<String> zzant;
  private zze zzanu;
  private zze zzanw;
  
  private zzb()
  {
    if (getLogLevel() == zzd.LOG_LEVEL_OFF)
    {
      zzanq = Collections.EMPTY_LIST;
      zzanr = Collections.EMPTY_LIST;
      zzans = Collections.EMPTY_LIST;
      zzant = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)zzc.zza.zzanA.get();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      zzanq = ((List)localObject);
      localObject = (String)zzc.zza.zzanB.get();
      if (localObject != null) {
        break label194;
      }
      localObject = Collections.EMPTY_LIST;
      label83:
      zzanr = ((List)localObject);
      localObject = (String)zzc.zza.zzanC.get();
      if (localObject != null) {
        break label207;
      }
      localObject = Collections.EMPTY_LIST;
      label106:
      zzans = ((List)localObject);
      localObject = (String)zzc.zza.zzanD.get();
      if (localObject != null) {
        break label220;
      }
    }
    label194:
    label207:
    label220:
    for (localObject = Collections.EMPTY_LIST;; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      zzant = ((List)localObject);
      zzanu = new zze(((Long)zzc.zza.zzanE.get()).longValue());
      zzanw = new zze(((Long)zzc.zza.zzanE.get()).longValue());
      return;
      localObject = Arrays.asList(((String)localObject).split(","));
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label83;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label106;
    }
  }
  
  private static int getLogLevel()
  {
    if (zzanv == null) {}
    for (;;)
    {
      try
      {
        if (!zzmp.zzkr()) {
          continue;
        }
        i = ((Integer)zzc.zza.zzanz.get()).intValue();
        zzanv = Integer.valueOf(i);
      }
      catch (SecurityException localSecurityException)
      {
        int i;
        zzanv = Integer.valueOf(zzd.LOG_LEVEL_OFF);
        continue;
      }
      return zzanv.intValue();
      i = zzd.LOG_LEVEL_OFF;
    }
  }
  
  public static String zzb(ServiceConnection paramServiceConnection)
  {
    return String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramServiceConnection));
  }
  
  public static zzb zzrP()
  {
    synchronized (zzalX)
    {
      if (zzanp == null) {
        zzanp = new zzb();
      }
      return zzanp;
    }
  }
  
  @SuppressLint({"UntrackedBindService"})
  public final void zza(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
    zza(paramContext, zzb(paramServiceConnection), null, null, 1);
  }
  
  public final void zza(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    int i;
    if (!com.google.android.gms.common.internal.zzd.zzakE)
    {
      i = 0;
      if ((i != 0) && (zzanu != null)) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      if (getLogLevel() == zzd.LOG_LEVEL_OFF)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      if ((paramInt != 4) && (paramInt != 1)) {
        break label200;
      }
    } while (!zzanu.zzcT(paramString1));
    Object localObject1 = null;
    Object localObject2 = null;
    paramIntent = null;
    long l2 = System.currentTimeMillis();
    Object localObject4 = null;
    Object localObject3 = localObject4;
    if ((getLogLevel() & zzd.zzanJ) != 0)
    {
      localObject3 = localObject4;
      if (paramInt != 13) {
        localObject3 = zznf.zzn$13d12155(5);
      }
    }
    long l1 = 0L;
    if ((getLogLevel() & zzd.zzanL) != 0) {
      l1 = Debug.getNativeHeapAllocatedSize();
    }
    if ((paramInt == 1) || (paramInt == 4) || (paramInt == 14)) {}
    for (paramString1 = new ConnectionEvent(l2, paramInt, null, null, null, null, (String)localObject3, paramString1, SystemClock.elapsedRealtime(), l1);; paramString1 = new ConnectionEvent(l2, paramInt, paramIntent, paramString2, (String)localObject1, (String)localObject2, (String)localObject3, paramString1, SystemClock.elapsedRealtime(), l1))
    {
      paramContext.startService(new Intent().setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
      label200:
      localObject1 = paramContext.getPackageManager().queryIntentServices(paramIntent, 128);
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), zznf.zzn$13d12155(20) }));
        localObject1 = null;
      }
      while (localObject1 == null)
      {
        Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[] { paramString2, paramIntent.toUri(0) }));
        return;
        if (((List)localObject1).size() > 1)
        {
          Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), zznf.zzn$13d12155(20) }));
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            Log.w("ConnectionTracker", nextserviceInfo.name);
            localObject1 = null;
            continue;
          }
        }
        localObject1 = get0serviceInfo;
      }
      localObject2 = processName;
      localObject3 = name;
      paramIntent = zznf.zzi(paramContext, Binder.getCallingPid());
      i = getLogLevel();
      if ((zzanq.contains(paramIntent)) || (zzanr.contains(paramString2)) || (zzans.contains(localObject2)) || (zzant.contains(localObject3)) || ((((String)localObject2).equals(paramIntent)) && ((i & zzd.zzanK) != 0))) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label543;
        }
        zzanu.zzcS(paramString1);
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
      }
      label543:
      break;
    }
  }
  
  public final boolean zza(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  @SuppressLint({"UntrackedBindService"})
  public final boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if ((localComponentName == null) || ((com.google.android.gms.common.internal.zzd.zzakE) && ("com.google.android.gms".equals(localComponentName.getPackageName())))) {}
    for (boolean bool = false; bool; bool = zzmp.zzk(paramContext, localComponentName.getPackageName()))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    if (bool) {
      zza(paramContext, zzb(paramServiceConnection), paramString, paramIntent, 2);
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */