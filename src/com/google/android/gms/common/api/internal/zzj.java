package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzk.zza;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzj
  extends GoogleApiClient
  implements zzp.zza
{
  private final Context mContext;
  private final Lock zzXG;
  private final int zzagp;
  final Looper zzagr;
  private final com.google.android.gms.common.zzc zzags;
  final Api.zza<? extends zzrn, zzro> zzagt;
  final Map<Api<?>, Integer> zzahA;
  private final zzk zzahL;
  private zzp zzahM = null;
  final Queue<zza.zza<?, ?>> zzahN = new LinkedList();
  private volatile boolean zzahO;
  private long zzahP = 120000L;
  private long zzahQ = 5000L;
  private final zza zzahR;
  zzc zzahS;
  final Map<Api.zzc<?>, Api.zzb> zzahT;
  Set<Scope> zzahU = new HashSet();
  private final Set<zzq<?>> zzahV = Collections.newSetFromMap(new WeakHashMap());
  final Set<zze<?>> zzahW = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
  private zza zzahX;
  private final ArrayList<zzc> zzahY;
  private Integer zzahZ = null;
  final zzf zzahz;
  Set<zzx> zzaia = null;
  private final zzd zzaib = new zzd()
  {
    public final void zzc(zzj.zze<?> paramAnonymouszze)
    {
      zzahW.remove(paramAnonymouszze);
      if ((paramAnonymouszze.zzpa() != null) && (zzj.zza(zzj.this) != null))
      {
        zza localzza = zzj.zza(zzj.this);
        paramAnonymouszze.zzpa().intValue();
        localzza.remove$13462e();
      }
    }
  };
  private final zzk.zza zzaic = new zzk.zza()
  {
    public final boolean isConnected()
    {
      return zzj.this.isConnected();
    }
  };
  
  public zzj(Context arg1, Lock paramLock, Looper paramLooper, zzf paramzzf, com.google.android.gms.common.zzc paramzzc, Api.zza<? extends zzrn, zzro> paramzza, Map<Api<?>, Integer> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.zzc<?>, Api.zzb> paramMap1, int paramInt1, int paramInt2, ArrayList<zzc> paramArrayList)
  {
    mContext = ???;
    zzXG = paramLock;
    zzahL = new zzk(paramLooper, zzaic);
    zzagr = paramLooper;
    zzahR = new zza(paramLooper);
    zzags = paramzzc;
    zzagp = paramInt1;
    if (zzagp >= 0) {
      zzahZ = Integer.valueOf(paramInt2);
    }
    zzahA = paramMap;
    zzahT = paramMap1;
    zzahY = paramArrayList;
    paramLock = paramList.iterator();
    while (paramLock.hasNext())
    {
      paramLooper = (GoogleApiClient.ConnectionCallbacks)paramLock.next();
      paramzzc = zzahL;
      com.google.android.gms.common.internal.zzx.zzz(paramLooper);
      synchronized (zzpV)
      {
        if (zzalR.contains(paramLooper))
        {
          Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramLooper + " is already registered");
          if (zzalQ.isConnected()) {
            mHandler.sendMessage(mHandler.obtainMessage(1, paramLooper));
          }
        }
        else
        {
          zzalR.add(paramLooper);
        }
      }
    }
    ??? = paramList1.iterator();
    while (???.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)???.next();
      zzahL.registerConnectionFailedListener(paramLock);
    }
    zzahz = paramzzf;
    zzagt = paramzza;
  }
  
  public static int zza(Iterable<Api.zzb> paramIterable, boolean paramBoolean)
  {
    int k = 1;
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j = 0;
    if (paramIterable.hasNext())
    {
      Api.zzb localzzb = (Api.zzb)paramIterable.next();
      if (localzzb.zzmE()) {
        j = 1;
      }
      if (!localzzb.zznb()) {
        break label85;
      }
      i = 1;
    }
    label85:
    for (;;)
    {
      break;
      if (j != 0)
      {
        j = k;
        if (i != 0)
        {
          j = k;
          if (paramBoolean) {
            j = 2;
          }
        }
        return j;
      }
      return 3;
    }
  }
  
  private void zza(final GoogleApiClient paramGoogleApiClient, final zzv paramzzv, final boolean paramBoolean)
  {
    zzmf.zzamA.zzf(paramGoogleApiClient).setResultCallback(new ResultCallback() {});
  }
  
  private void zzbB(int paramInt)
  {
    if (zzahZ == null) {
      zzahZ = Integer.valueOf(paramInt);
    }
    while (zzahM != null)
    {
      return;
      if (zzahZ.intValue() != paramInt) {
        throw new IllegalStateException("Cannot use sign-in mode: " + zzbC(paramInt) + ". Mode was already set to " + zzbC(zzahZ.intValue()));
      }
    }
    Iterator localIterator = zzahT.values().iterator();
    paramInt = 0;
    int i = 0;
    if (localIterator.hasNext())
    {
      Api.zzb localzzb = (Api.zzb)localIterator.next();
      if (localzzb.zzmE()) {
        i = 1;
      }
      if (!localzzb.zznb()) {
        break label313;
      }
      paramInt = 1;
    }
    label313:
    for (;;)
    {
      break;
      switch (zzahZ.intValue())
      {
      }
      do
      {
        do
        {
          zzahM = new zzl(mContext, this, zzXG, zzagr, zzags, zzahT, zzahz, zzahA, zzagt, zzahY, this);
          return;
          if (i == 0) {
            throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
          }
        } while (paramInt == 0);
        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
      } while (i == 0);
      zzahM = new zzd(mContext, this, zzXG, zzagr, zzags, zzahT, zzahz, zzahA, zzagt, zzahY);
      return;
    }
  }
  
  private static String zzbC(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 3: 
      return "SIGN_IN_MODE_NONE";
    case 1: 
      return "SIGN_IN_MODE_REQUIRED";
    }
    return "SIGN_IN_MODE_OPTIONAL";
  }
  
  private void zzpC()
  {
    zzahL.zzalU = true;
    zzahM.connect();
  }
  
  public final ConnectionResult blockingConnect()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      com.google.android.gms.common.internal.zzx.zza(bool1, "blockingConnect must not be called on the UI thread");
      zzXG.lock();
      try
      {
        if (zzagp >= 0) {
          if (zzahZ != null)
          {
            bool1 = bool2;
            label45:
            com.google.android.gms.common.internal.zzx.zza(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
          }
        }
        do
        {
          for (;;)
          {
            zzbB(zzahZ.intValue());
            zzahL.zzalU = true;
            ConnectionResult localConnectionResult = zzahM.blockingConnect();
            return localConnectionResult;
            bool1 = false;
            break;
            bool1 = false;
            break label45;
            if (zzahZ != null) {
              break label144;
            }
            zzahZ = Integer.valueOf(zza(zzahT.values(), false));
          }
        } while (zzahZ.intValue() != 2);
      }
      finally
      {
        zzXG.unlock();
      }
    }
    label144:
    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  public final PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    com.google.android.gms.common.internal.zzx.zza(isConnected(), "GoogleApiClient is not connected yet.");
    if (zzahZ.intValue() != 2) {}
    final zzv localzzv;
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.zzx.zza(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      localzzv = new zzv(this);
      if (!zzahT.containsKey(zzmf.zzUI)) {
        break;
      }
      zza(this, localzzv, false);
      return localzzv;
    }
    final AtomicReference localAtomicReference = new AtomicReference();
    Object localObject1 = new GoogleApiClient.ConnectionCallbacks()
    {
      public final void onConnected(Bundle paramAnonymousBundle)
      {
        zzj.zza$61295dcf(zzj.this, (GoogleApiClient)localAtomicReference.get(), localzzv);
      }
      
      public final void onConnectionSuspended(int paramAnonymousInt) {}
    };
    Object localObject2 = new GoogleApiClient.OnConnectionFailedListener()
    {
      public final void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        localzzv.zza(new Status(8));
      }
    };
    localObject1 = new GoogleApiClient.Builder(mContext).addApi(zzmf.API).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject1).addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)localObject2);
    localObject2 = zzahR;
    com.google.android.gms.common.internal.zzx.zzb(localObject2, "Handler must not be null");
    zzagr = ((Handler)localObject2).getLooper();
    localObject1 = ((GoogleApiClient.Builder)localObject1).build();
    localAtomicReference.set(localObject1);
    ((GoogleApiClient)localObject1).connect();
    return localzzv;
  }
  
  public final void connect()
  {
    boolean bool2 = false;
    zzXG.lock();
    do
    {
      for (;;)
      {
        try
        {
          if (zzagp >= 0) {
            if (zzahZ != null)
            {
              bool1 = true;
              com.google.android.gms.common.internal.zzx.zza(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
              i = zzahZ.intValue();
              zzXG.lock();
              if ((i != 3) && (i != 1))
              {
                bool1 = bool2;
                if (i != 2) {}
              }
              else
              {
                bool1 = true;
              }
            }
          }
        }
        finally
        {
          boolean bool1;
          int i;
          zzXG.unlock();
        }
        try
        {
          com.google.android.gms.common.internal.zzx.zzb(bool1, "Illegal sign-in mode: " + i);
          zzbB(i);
          zzpC();
          zzXG.unlock();
          zzXG.unlock();
          return;
        }
        finally
        {
          zzXG.unlock();
        }
        bool1 = false;
        continue;
        if (zzahZ != null) {
          break;
        }
        zzahZ = Integer.valueOf(zza(zzahT.values(), false));
      }
    } while (zzahZ.intValue() != 2);
    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  public final void disconnect()
  {
    zzXG.lock();
    for (;;)
    {
      try
      {
        if ((zzahM != null) && (!zzahM.disconnect()))
        {
          bool = true;
          zzaa(bool);
          Iterator localIterator = zzahV.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          nextmListener = null;
          continue;
        }
        boolean bool = false;
      }
      finally
      {
        zzXG.unlock();
      }
    }
    zzahV.clear();
    Object localObject2 = zzahN.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      zze localzze = (zze)((Iterator)localObject2).next();
      localzze.zza(null);
      localzze.cancel();
    }
    zzahN.clear();
    localObject2 = zzahM;
    if (localObject2 == null)
    {
      zzXG.unlock();
      return;
    }
    zzpF();
    zzahL.zzqQ();
    zzXG.unlock();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(zzahO);
    paramPrintWriter.append(" mWorkQueue.size()=").print(zzahN.size());
    paramPrintWriter.append(" mUnconsumedRunners.size()=").println(zzahW.size());
    if (zzahM != null) {
      zzahM.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public final Looper getLooper()
  {
    return zzagr;
  }
  
  public final boolean isConnected()
  {
    return (zzahM != null) && (zzahM.isConnected());
  }
  
  public final boolean isConnecting()
  {
    return (zzahM != null) && (zzahM.isConnecting());
  }
  
  public final void reconnect()
  {
    disconnect();
    connect();
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzahL.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzk localzzk = zzahL;
    com.google.android.gms.common.internal.zzx.zzz(paramOnConnectionFailedListener);
    synchronized (zzpV)
    {
      if (!zzalT.remove(paramOnConnectionFailedListener)) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  public final <C extends Api.zzb> C zza(Api.zzc<C> paramzzc)
  {
    paramzzc = (Api.zzb)zzahT.get(paramzzc);
    com.google.android.gms.common.internal.zzx.zzb(paramzzc, "Appropriate Api was not requested.");
    return paramzzc;
  }
  
  public final <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    boolean bool;
    if (zzaeE != null) {
      bool = true;
    }
    for (;;)
    {
      com.google.android.gms.common.internal.zzx.zzb(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      com.google.android.gms.common.internal.zzx.zzb(zzahT.containsKey(zzaeE), "GoogleApiClient is not configured to use the API required for this call.");
      zzXG.lock();
      try
      {
        if (zzahM == null)
        {
          zzahN.add(paramT);
          return paramT;
          bool = false;
          continue;
        }
        paramT = zzahM.zza(paramT);
        return paramT;
      }
      finally
      {
        zzXG.unlock();
      }
    }
  }
  
  public final void zza(zzx paramzzx)
  {
    zzXG.lock();
    try
    {
      if (zzaia == null) {
        zzaia = new HashSet();
      }
      zzaia.add(paramzzx);
      return;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  public final boolean zza(Api<?> paramApi)
  {
    return zzahT.containsKey(paramApi.zzoR());
  }
  
  public final boolean zza(zzu paramzzu)
  {
    return (zzahM != null) && (zzahM.zza(paramzzu));
  }
  
  final void zzaa(boolean paramBoolean)
  {
    Iterator localIterator = zzahW.iterator();
    while (localIterator.hasNext())
    {
      zze localzze = (zze)localIterator.next();
      if (localzze.zzpa() == null)
      {
        if (paramBoolean)
        {
          localzze.zzpg();
        }
        else
        {
          localzze.cancel();
          zzahW.remove(localzze);
        }
      }
      else
      {
        localzze.zzpe();
        IBinder localIBinder = zza(localzze.zzoR()).zzoT();
        zza localzza = zzahX;
        if (localzze.isReady()) {
          localzze.zza(new zzb(localzze, localzza, localIBinder, (byte)0));
        }
        for (;;)
        {
          zzahW.remove(localzze);
          break;
          if ((localIBinder != null) && (localIBinder.isBinderAlive()))
          {
            zzb localzzb = new zzb(localzze, localzza, localIBinder, (byte)0);
            localzze.zza(localzzb);
            try
            {
              localIBinder.linkToDeath(localzzb, 0);
            }
            catch (RemoteException localRemoteException)
            {
              localzze.cancel();
              localzze.zzpa().intValue();
              localzza.remove$13462e();
            }
          }
          else
          {
            localzze.zza(null);
            localzze.cancel();
            localzze.zzpa().intValue();
            localzza.remove$13462e();
          }
        }
      }
    }
  }
  
  public final <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    if (zzaeE != null) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.zzx.zzb(bool, "This task can not be executed (it's probably a Batch or malformed)");
      zzXG.lock();
      try
      {
        if (zzahM != null) {
          break;
        }
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
      }
      finally
      {
        zzXG.unlock();
      }
    }
    if (zzahO)
    {
      zzahN.add(paramT);
      while (!zzahN.isEmpty())
      {
        zze localzze = (zze)zzahN.remove();
        zzb(localzze);
        localzze.zzw(Status.zzagE);
      }
      zzXG.unlock();
      return paramT;
    }
    paramT = zzahM.zzb(paramT);
    zzXG.unlock();
    return paramT;
  }
  
  final <A extends Api.zzb> void zzb(zze<A> paramzze)
  {
    zzahW.add(paramzze);
    paramzze.zza(zzaib);
  }
  
  public final void zzb(zzx paramzzx)
  {
    zzXG.lock();
    for (;;)
    {
      try
      {
        if (zzaia == null)
        {
          Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
          return;
        }
        if (!zzaia.remove(paramzzx))
        {
          Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
          continue;
        }
        if (zzpG()) {
          continue;
        }
      }
      finally
      {
        zzXG.unlock();
      }
      zzahM.zzpj();
    }
  }
  
  public final void zzc(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean) && (!zzahO))
    {
      zzahO = true;
      if (zzahS == null) {
        zzahS = ((zzc)zzn.zza$245690a7(mContext.getApplicationContext(), new zzc(this)));
      }
      zzahR.sendMessageDelayed(zzahR.obtainMessage(1), zzahP);
      zzahR.sendMessageDelayed(zzahR.obtainMessage(2), zzahQ);
    }
    ??? = zzahW.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (zze)((Iterator)???).next();
      if (paramBoolean) {
        ((zze)localObject2).zzpe();
      }
      ((zze)localObject2).zzx(new Status(8, "The connection to Google Play services was lost"));
    }
    zzahW.clear();
    Object localObject2 = zzahL;
    if (Looper.myLooper() == mHandler.getLooper()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.google.android.gms.common.internal.zzx.zza(paramBoolean, "onUnintentionalDisconnection must only be called on the Handler thread");
      mHandler.removeMessages(1);
      synchronized (zzpV)
      {
        zzalW = true;
        Object localObject4 = new ArrayList(zzalR);
        int i = zzalV.get();
        localObject4 = ((ArrayList)localObject4).iterator();
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject4).next();
          if ((!zzalU) || (zzalV.get() != i)) {
            break;
          }
        } while (!zzalR.contains(localConnectionCallbacks));
        localConnectionCallbacks.onConnectionSuspended(paramInt);
      }
    }
    zzalS.clear();
    zzalW = false;
    zzahL.zzqQ();
    if (paramInt == 2) {
      zzpC();
    }
  }
  
  public final void zzd(ConnectionResult paramConnectionResult)
  {
    if (!zzags.zzd(mContext, zzade)) {
      zzpF();
    }
    zzk localzzk;
    boolean bool;
    if (!zzahO)
    {
      localzzk = zzahL;
      if (Looper.myLooper() != mHandler.getLooper()) {
        break label161;
      }
      bool = true;
      com.google.android.gms.common.internal.zzx.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      mHandler.removeMessages(1);
    }
    for (;;)
    {
      synchronized (zzpV)
      {
        Object localObject2 = new ArrayList(zzalT);
        int i = zzalV.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          if ((!zzalU) || (zzalV.get() != i))
          {
            zzahL.zzqQ();
            return;
            label161:
            bool = false;
            break;
          }
          if (!zzalT.contains(localOnConnectionFailedListener)) {
            continue;
          }
          localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  public final void zzi(Bundle paramBundle)
  {
    boolean bool2 = true;
    while (!zzahN.isEmpty()) {
      zzb((zza.zza)zzahN.remove());
    }
    zzk localzzk = zzahL;
    boolean bool1;
    if (Looper.myLooper() == mHandler.getLooper())
    {
      bool1 = true;
      com.google.android.gms.common.internal.zzx.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (zzpV)
      {
        if (zzalW) {
          break label241;
        }
        bool1 = true;
        com.google.android.gms.common.internal.zzx.zzab(bool1);
        mHandler.removeMessages(1);
        zzalW = true;
        if (zzalS.size() != 0) {
          break label246;
        }
        bool1 = bool2;
        com.google.android.gms.common.internal.zzx.zzab(bool1);
        Object localObject2 = new ArrayList(zzalR);
        int i = zzalV.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label251;
        }
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
        if ((!zzalU) || (!zzalQ.isConnected()) || (zzalV.get() != i)) {
          break label251;
        }
        if (zzalS.contains(localConnectionCallbacks)) {
          continue;
        }
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool1 = false;
      break;
      label241:
      bool1 = false;
      continue;
      label246:
      bool1 = false;
    }
    label251:
    zzalS.clear();
    zzalW = false;
  }
  
  public final void zzoW()
  {
    if (zzahM != null) {
      zzahM.zzoW();
    }
  }
  
  final boolean zzpF()
  {
    if (!zzahO) {
      return false;
    }
    zzahO = false;
    zzahR.removeMessages(2);
    zzahR.removeMessages(1);
    if (zzahS != null)
    {
      zzahS.unregister();
      zzahS = null;
    }
    return true;
  }
  
  final boolean zzpG()
  {
    boolean bool1 = false;
    zzXG.lock();
    try
    {
      Set localSet = zzaia;
      if (localSet == null) {
        return false;
      }
      boolean bool2 = zzaia.isEmpty();
      if (!bool2) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      zzXG.unlock();
    }
  }
  
  final String zzpH()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  final class zza
    extends Handler
  {
    zza(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.w("GoogleApiClientImpl", "Unknown message id: " + what);
        return;
      case 1: 
        zzj.zzc(zzj.this);
        return;
      }
      zzj.zzb(zzj.this);
    }
  }
  
  private static final class zzb
    implements IBinder.DeathRecipient, zzj.zzd
  {
    private final WeakReference<zzj.zze<?>> zzaii;
    private final WeakReference<zza> zzaij;
    private final WeakReference<IBinder> zzaik;
    
    private zzb(zzj.zze paramzze, zza paramzza, IBinder paramIBinder)
    {
      zzaij = new WeakReference(paramzza);
      zzaii = new WeakReference(paramzze);
      zzaik = new WeakReference(paramIBinder);
    }
    
    private void zzpI()
    {
      Object localObject = (zzj.zze)zzaii.get();
      zza localzza = (zza)zzaij.get();
      if ((localzza != null) && (localObject != null))
      {
        ((zzj.zze)localObject).zzpa().intValue();
        localzza.remove$13462e();
      }
      localObject = (IBinder)zzaik.get();
      if (zzaik != null) {
        ((IBinder)localObject).unlinkToDeath(this, 0);
      }
    }
    
    public final void binderDied()
    {
      zzpI();
    }
    
    public final void zzc(zzj.zze<?> paramzze)
    {
      zzpI();
    }
  }
  
  static final class zzc
    extends zzn
  {
    private WeakReference<zzj> zzail;
    
    zzc(zzj paramzzj)
    {
      zzail = new WeakReference(paramzzj);
    }
    
    public final void zzpJ()
    {
      zzj localzzj = (zzj)zzail.get();
      if (localzzj == null) {
        return;
      }
      zzj.zzb(localzzj);
    }
  }
  
  static abstract interface zzd
  {
    public abstract void zzc(zzj.zze<?> paramzze);
  }
  
  static abstract interface zze<A extends Api.zzb>
  {
    public abstract void cancel();
    
    public abstract boolean isReady();
    
    public abstract void zza(zzj.zzd paramzzd);
    
    public abstract void zzb(A paramA)
      throws DeadObjectException;
    
    public abstract Api.zzc<A> zzoR();
    
    public abstract Integer zzpa();
    
    public abstract void zzpe();
    
    public abstract void zzpg();
    
    public abstract void zzw(Status paramStatus);
    
    public abstract void zzx(Status paramStatus);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */