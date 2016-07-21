package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zza.zza;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.api.internal.zzw;
import com.google.android.gms.common.api.internal.zzw.zza;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient
{
  private static final Set<GoogleApiClient> zzagg = Collections.newSetFromMap(new WeakHashMap());
  
  public static Set<GoogleApiClient> zzoV()
  {
    return zzagg;
  }
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void reconnect();
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public <C extends Api.zzb> C zza(Api.zzc<C> paramzzc)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zza(com.google.android.gms.common.api.internal.zzx paramzzx)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean zza(zzu paramzzu)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzb(com.google.android.gms.common.api.internal.zzx paramzzx)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzoW()
  {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder
  {
    private final Context mContext;
    private Account zzTI;
    private String zzUW;
    private final Set<Scope> zzagh = new HashSet();
    private final Set<Scope> zzagi = new HashSet();
    private int zzagj;
    private View zzagk;
    private String zzagl;
    private final Map<Api<?>, zzf.zza> zzagm = new ArrayMap();
    private final Map<Api<?>, Api.ApiOptions> zzagn = new ArrayMap();
    FragmentActivity zzago;
    private int zzagp = -1;
    private GoogleApiClient.OnConnectionFailedListener zzagq;
    public Looper zzagr;
    private com.google.android.gms.common.zzc zzags = com.google.android.gms.common.zzc.zzoK();
    private Api.zza<? extends zzrn, zzro> zzagt = zzrl.zzUJ;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzagu = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzagv = new ArrayList();
    
    public Builder(Context paramContext)
    {
      mContext = paramContext;
      zzagr = paramContext.getMainLooper();
      zzUW = paramContext.getPackageName();
      zzagl = paramContext.getClass().getName();
    }
    
    public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      com.google.android.gms.common.internal.zzx.zzb(paramApi, "Api must not be null");
      zzagn.put(paramApi, null);
      paramApi = paramApi.zzoP().zzo(null);
      zzagi.addAll(paramApi);
      zzagh.addAll(paramApi);
      return this;
    }
    
    public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      com.google.android.gms.common.internal.zzx.zzb(paramApi, "Api must not be null");
      com.google.android.gms.common.internal.zzx.zzb(paramO, "Null options are not permitted for this Api");
      zzagn.put(paramApi, paramO);
      paramApi = paramApi.zzoP().zzo(paramO);
      zzagi.addAll(paramApi);
      zzagh.addAll(paramApi);
      return this;
    }
    
    public final Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      com.google.android.gms.common.internal.zzx.zzb(paramConnectionCallbacks, "Listener must not be null");
      zzagu.add(paramConnectionCallbacks);
      return this;
    }
    
    public final Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      com.google.android.gms.common.internal.zzx.zzb(paramOnConnectionFailedListener, "Listener must not be null");
      zzagv.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public final GoogleApiClient build()
    {
      boolean bool;
      zzf localzzf;
      ArrayMap localArrayMap1;
      ArrayMap localArrayMap2;
      ArrayList localArrayList;
      final Object localObject1;
      label81:
      Api localApi;
      Object localObject4;
      int i;
      label150:
      Object localObject3;
      if (!zzagn.isEmpty())
      {
        bool = true;
        com.google.android.gms.common.internal.zzx.zzb(bool, "must call addApi() to add at least one API");
        localzzf = zzoY();
        ??? = null;
        Map localMap = zzalc;
        localArrayMap1 = new ArrayMap();
        localArrayMap2 = new ArrayMap();
        localArrayList = new ArrayList();
        Iterator localIterator = zzagn.keySet().iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label406;
        }
        localApi = (Api)localIterator.next();
        localObject4 = zzagn.get(localApi);
        i = 0;
        if (localMap.get(localApi) != null)
        {
          if (!getzzalf) {
            break label351;
          }
          i = 1;
        }
        localArrayMap1.put(localApi, Integer.valueOf(i));
        localObject3 = new com.google.android.gms.common.api.internal.zzc(localApi, i);
        localArrayList.add(localObject3);
        if (zzafY == null) {
          break label356;
        }
        i = 1;
        label194:
        if (i == 0) {
          break label366;
        }
        if (zzafX == null) {
          break label361;
        }
        bool = true;
        label208:
        com.google.android.gms.common.internal.zzx.zza(bool, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        localObject4 = zzafX;
        if (((Api.zze)localObject4).getPriority() != 1) {
          break label668;
        }
        localObject1 = localApi;
      }
      label351:
      label356:
      label361:
      label366:
      label395:
      label399:
      label406:
      label648:
      label668:
      for (;;)
      {
        for (localObject3 = new zzad(mContext, zzagr, ((Api.zze)localObject4).zzoU(), (GoogleApiClient.ConnectionCallbacks)localObject3, (GoogleApiClient.OnConnectionFailedListener)localObject3, localzzf, ((Api.zze)localObject4).zzq$55e35557());; localObject3 = localApi.zzoP().zza(mContext, zzagr, localzzf, localObject4, (GoogleApiClient.ConnectionCallbacks)localObject3, (GoogleApiClient.OnConnectionFailedListener)localObject3))
        {
          localArrayMap2.put(localApi.zzoR(), localObject3);
          if (!((Api.zzb)localObject3).zznb()) {
            break label395;
          }
          localObject3 = localApi;
          if (??? == null) {
            break label399;
          }
          throw new IllegalStateException(mName + " cannot be used with " + mName);
          bool = false;
          break;
          i = 2;
          break label150;
          i = 0;
          break label194;
          bool = false;
          break label208;
        }
        localObject3 = ???;
        ??? = localObject3;
        break label81;
        if (??? != null)
        {
          if (localObject1 != null) {
            throw new IllegalStateException(mName + " cannot be used with " + mName);
          }
          if (zzTI != null) {
            break label648;
          }
          bool = true;
        }
        for (;;)
        {
          com.google.android.gms.common.internal.zzx.zza(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { mName });
          com.google.android.gms.common.internal.zzx.zza(zzagh.equals(zzagi), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { mName });
          i = zzj.zza(localArrayMap2.values(), true);
          localObject1 = new zzj(mContext, new ReentrantLock(), zzagr, localzzf, zzags, zzagt, localArrayMap1, zzagu, zzagv, localArrayMap2, zzagp, i, localArrayList);
          synchronized (GoogleApiClient.zzoX())
          {
            GoogleApiClient.zzoX().add(localObject1);
            if (zzagp >= 0)
            {
              ??? = zzw.zza(zzago);
              if (??? == null) {
                new Handler(mContext.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    if ((zzago.isFinishing()) || (zzago.getSupportFragmentManager().isDestroyed())) {
                      return;
                    }
                    zza(zzw.zzb(zzago), localObject1);
                  }
                });
              }
            }
            else
            {
              return (GoogleApiClient)localObject1;
              bool = false;
            }
          }
        }
        zza((zzw)???, localGoogleApiClient);
        return localGoogleApiClient;
      }
    }
    
    final void zza(zzw paramzzw, GoogleApiClient paramGoogleApiClient)
    {
      int i = zzagp;
      Object localObject = zzagq;
      com.google.android.gms.common.internal.zzx.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
      if (zzaiE.indexOfKey(i) < 0) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.gms.common.internal.zzx.zza(bool, "Already managing a GoogleApiClient with id " + i);
        localObject = new zzw.zza(paramzzw, i, paramGoogleApiClient, (GoogleApiClient.OnConnectionFailedListener)localObject);
        zzaiE.put(i, localObject);
        if ((mStarted) && (!zzaiz)) {
          paramGoogleApiClient.connect();
        }
        return;
      }
    }
    
    public final zzf zzoY()
    {
      zzro localzzro = zzro.zzbgV;
      if (zzagn.containsKey(zzrl.API)) {
        localzzro = (zzro)zzagn.get(zzrl.API);
      }
      return new zzf(zzTI, zzagh, zzagm, zzagj, zzagk, zzUW, zzagl, localzzro);
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
  
  public static abstract interface zza
  {
    public abstract void zza(ConnectionResult paramConnectionResult);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */