package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zzh
  implements zzk
{
  final Context mContext;
  final Lock zzXG;
  final zzc zzags;
  private final Api.zza<? extends zzrn, zzro> zzagt;
  private final Map<Api<?>, Integer> zzahA;
  private ArrayList<Future<?>> zzahB = new ArrayList();
  final zzl zzahj;
  private ConnectionResult zzahm;
  private int zzahn;
  private int zzaho = 0;
  private int zzahp;
  private final Bundle zzahq = new Bundle();
  private final Set<Api.zzc> zzahr = new HashSet();
  zzrn zzahs;
  private int zzaht;
  boolean zzahu;
  boolean zzahv;
  zzp zzahw;
  boolean zzahx;
  boolean zzahy;
  final zzf zzahz;
  
  public zzh(zzl paramzzl, zzf paramzzf, Map<Api<?>, Integer> paramMap, zzc paramzzc, Api.zza<? extends zzrn, zzro> paramzza, Lock paramLock, Context paramContext)
  {
    zzahj = paramzzl;
    zzahz = paramzzf;
    zzahA = paramMap;
    zzags = paramzzc;
    zzagt = paramzza;
    zzXG = paramLock;
    mContext = paramContext;
  }
  
  private void zzZ(boolean paramBoolean)
  {
    if (zzahs != null)
    {
      if ((zzahs.isConnected()) && (paramBoolean)) {
        zzahs.zzFG();
      }
      zzahs.disconnect();
      zzahw = null;
    }
  }
  
  private static String zzbA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  /* Error */
  private void zzpx()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/google/android/gms/common/api/internal/zzh:zzahj	Lcom/google/android/gms/common/api/internal/zzl;
    //   4: astore_1
    //   5: aload_1
    //   6: getfield 139	com/google/android/gms/common/api/internal/zzl:zzXG	Ljava/util/concurrent/locks/Lock;
    //   9: invokeinterface 144 1 0
    //   14: aload_1
    //   15: getfield 148	com/google/android/gms/common/api/internal/zzl:zzagW	Lcom/google/android/gms/common/api/internal/zzj;
    //   18: invokevirtual 153	com/google/android/gms/common/api/internal/zzj:zzpF	()Z
    //   21: pop
    //   22: aload_1
    //   23: new 155	com/google/android/gms/common/api/internal/zzg
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 158	com/google/android/gms/common/api/internal/zzg:<init>	(Lcom/google/android/gms/common/api/internal/zzl;)V
    //   31: putfield 162	com/google/android/gms/common/api/internal/zzl:zzaip	Lcom/google/android/gms/common/api/internal/zzk;
    //   34: aload_1
    //   35: getfield 162	com/google/android/gms/common/api/internal/zzl:zzaip	Lcom/google/android/gms/common/api/internal/zzk;
    //   38: invokeinterface 165 1 0
    //   43: aload_1
    //   44: getfield 169	com/google/android/gms/common/api/internal/zzl:zzaim	Ljava/util/concurrent/locks/Condition;
    //   47: invokeinterface 174 1 0
    //   52: aload_1
    //   53: getfield 139	com/google/android/gms/common/api/internal/zzl:zzXG	Ljava/util/concurrent/locks/Lock;
    //   56: invokeinterface 177 1 0
    //   61: invokestatic 183	com/google/android/gms/common/api/internal/zzm:zzpN	()Ljava/util/concurrent/ExecutorService;
    //   64: new 8	com/google/android/gms/common/api/internal/zzh$1
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 186	com/google/android/gms/common/api/internal/zzh$1:<init>	(Lcom/google/android/gms/common/api/internal/zzh;)V
    //   72: invokeinterface 192 2 0
    //   77: aload_0
    //   78: getfield 113	com/google/android/gms/common/api/internal/zzh:zzahs	Lcom/google/android/gms/internal/zzrn;
    //   81: ifnull +32 -> 113
    //   84: aload_0
    //   85: getfield 194	com/google/android/gms/common/api/internal/zzh:zzahx	Z
    //   88: ifeq +20 -> 108
    //   91: aload_0
    //   92: getfield 113	com/google/android/gms/common/api/internal/zzh:zzahs	Lcom/google/android/gms/internal/zzrn;
    //   95: aload_0
    //   96: getfield 127	com/google/android/gms/common/api/internal/zzh:zzahw	Lcom/google/android/gms/common/internal/zzp;
    //   99: aload_0
    //   100: getfield 196	com/google/android/gms/common/api/internal/zzh:zzahy	Z
    //   103: invokeinterface 199 3 0
    //   108: aload_0
    //   109: iconst_0
    //   110: invokespecial 201	com/google/android/gms/common/api/internal/zzh:zzZ	(Z)V
    //   113: aload_0
    //   114: getfield 94	com/google/android/gms/common/api/internal/zzh:zzahj	Lcom/google/android/gms/common/api/internal/zzl;
    //   117: getfield 204	com/google/android/gms/common/api/internal/zzl:zzaio	Ljava/util/Map;
    //   120: invokeinterface 210 1 0
    //   125: invokeinterface 216 1 0
    //   130: astore_1
    //   131: aload_1
    //   132: invokeinterface 221 1 0
    //   137: ifeq +49 -> 186
    //   140: aload_1
    //   141: invokeinterface 225 1 0
    //   146: checkcast 227	com/google/android/gms/common/api/Api$zzc
    //   149: astore_2
    //   150: aload_0
    //   151: getfield 94	com/google/android/gms/common/api/internal/zzh:zzahj	Lcom/google/android/gms/common/api/internal/zzl;
    //   154: getfield 230	com/google/android/gms/common/api/internal/zzl:zzahT	Ljava/util/Map;
    //   157: aload_2
    //   158: invokeinterface 234 2 0
    //   163: checkcast 236	com/google/android/gms/common/api/Api$zzb
    //   166: invokeinterface 237 1 0
    //   171: goto -40 -> 131
    //   174: astore_2
    //   175: aload_1
    //   176: getfield 139	com/google/android/gms/common/api/internal/zzl:zzXG	Ljava/util/concurrent/locks/Lock;
    //   179: invokeinterface 177 1 0
    //   184: aload_2
    //   185: athrow
    //   186: aload_0
    //   187: getfield 82	com/google/android/gms/common/api/internal/zzh:zzahq	Landroid/os/Bundle;
    //   190: invokevirtual 240	android/os/Bundle:isEmpty	()Z
    //   193: ifeq +19 -> 212
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_0
    //   199: getfield 94	com/google/android/gms/common/api/internal/zzh:zzahj	Lcom/google/android/gms/common/api/internal/zzl;
    //   202: getfield 244	com/google/android/gms/common/api/internal/zzl:zzais	Lcom/google/android/gms/common/api/internal/zzp$zza;
    //   205: aload_1
    //   206: invokeinterface 250 2 0
    //   211: return
    //   212: aload_0
    //   213: getfield 82	com/google/android/gms/common/api/internal/zzh:zzahq	Landroid/os/Bundle;
    //   216: astore_1
    //   217: goto -19 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	zzh
    //   4	213	1	localObject1	Object
    //   149	9	2	localzzc	Api.zzc
    //   174	11	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	52	174	finally
  }
  
  private void zzpz()
  {
    Iterator localIterator = zzahB.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    zzahB.clear();
  }
  
  public final void begin()
  {
    zzahj.zzaio.clear();
    zzahu = false;
    zzahm = null;
    zzaho = 0;
    zzaht = 2;
    zzahv = false;
    zzahx = false;
    HashMap localHashMap = new HashMap();
    Object localObject = zzahA.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject).next();
      Api.zzb localzzb = (Api.zzb)zzahj.zzahT.get(localApi.zzoR());
      int i = ((Integer)zzahA.get(localApi)).intValue();
      localApi.zzoP();
      if (localzzb.zzmE())
      {
        zzahu = true;
        if (i < zzaht) {
          zzaht = i;
        }
        if (i != 0) {
          zzahr.add(localApi.zzoR());
        }
      }
      localHashMap.put(localzzb, new zza(this, localApi, i));
    }
    if (zzahu)
    {
      zzahz.zzale = Integer.valueOf(System.identityHashCode(zzahj.zzagW));
      localObject = new zze((byte)0);
      zzahs = ((zzrn)zzagt.zza(mContext, zzahj.zzagW.zzagr, zzahz, zzahz.zzald, (GoogleApiClient.ConnectionCallbacks)localObject, (GoogleApiClient.OnConnectionFailedListener)localObject));
    }
    zzahp = zzahj.zzahT.size();
    zzahB.add(zzm.zzpN().submit(new zzb(localHashMap)));
  }
  
  public final void connect() {}
  
  public final boolean disconnect()
  {
    zzpz();
    zzZ(true);
    zzahj.zzh(null);
    return true;
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    if (!zzbz(1)) {}
    do
    {
      return;
      if (paramBundle != null) {
        zzahq.putAll(paramBundle);
      }
    } while (!zzpu());
    zzpx();
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzg(new ConnectionResult(8, null));
  }
  
  public final <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T paramT)
  {
    zzahj.zzagW.zzahN.add(paramT);
    return paramT;
  }
  
  public final void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (!zzbz(1)) {}
    do
    {
      return;
      zzb(paramConnectionResult, paramApi, paramInt);
    } while (!zzpu());
    zzpx();
  }
  
  public final <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  final void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    int i = 1;
    if (paramInt != 2)
    {
      paramApi.zzoP();
      if (paramInt == 1)
      {
        if (!paramConnectionResult.hasResolution()) {
          break label89;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label113;
        }
      }
      paramInt = i;
      if (zzahm != null) {
        if (Integer.MAX_VALUE >= zzahn) {
          break label113;
        }
      }
    }
    label89:
    label113:
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        zzahm = paramConnectionResult;
        zzahn = Integer.MAX_VALUE;
      }
      zzahj.zzaio.put(paramApi.zzoR(), paramConnectionResult);
      return;
      if (zzags.zzbu(zzade) != null)
      {
        paramInt = 1;
        break;
      }
      paramInt = 0;
      break;
    }
  }
  
  final boolean zzbz(int paramInt)
  {
    if (zzaho != paramInt)
    {
      Log.i("GoogleApiClientConnecting", zzahj.zzagW.zzpH());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzbA(zzaho) + " but received callback for step " + zzbA(paramInt), new Exception());
      zzg(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  final boolean zzf(ConnectionResult paramConnectionResult)
  {
    return (zzaht == 2) || ((zzaht == 1) && (!paramConnectionResult.hasResolution()));
  }
  
  final void zzg(ConnectionResult paramConnectionResult)
  {
    zzpz();
    if (!paramConnectionResult.hasResolution()) {}
    for (boolean bool = true;; bool = false)
    {
      zzZ(bool);
      zzahj.zzh(paramConnectionResult);
      zzahj.zzais.zzd(paramConnectionResult);
      return;
    }
  }
  
  final boolean zzpu()
  {
    zzahp -= 1;
    if (zzahp > 0) {
      return false;
    }
    if (zzahp < 0)
    {
      Log.i("GoogleApiClientConnecting", zzahj.zzagW.zzpH());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zzg(new ConnectionResult(8, null));
      return false;
    }
    if (zzahm != null)
    {
      zzahj.zzair = zzahn;
      zzg(zzahm);
      return false;
    }
    return true;
  }
  
  final void zzpv()
  {
    if (zzahp != 0) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((zzahu) && (!zzahv));
      localArrayList = new ArrayList();
      zzaho = 1;
      zzahp = zzahj.zzahT.size();
      Iterator localIterator = zzahj.zzahT.keySet().iterator();
      while (localIterator.hasNext())
      {
        Api.zzc localzzc = (Api.zzc)localIterator.next();
        if (zzahj.zzaio.containsKey(localzzc))
        {
          if (zzpu()) {
            zzpx();
          }
        }
        else {
          localArrayList.add(zzahj.zzahT.get(localzzc));
        }
      }
    } while (localArrayList.isEmpty());
    zzahB.add(zzm.zzpN().submit(new zzc(localArrayList)));
  }
  
  final void zzpy()
  {
    zzahu = false;
    zzahj.zzagW.zzahU = Collections.emptySet();
    Iterator localIterator = zzahr.iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (!zzahj.zzaio.containsKey(localzzc)) {
        zzahj.zzaio.put(localzzc, new ConnectionResult(17, null));
      }
    }
  }
  
  private static final class zza
    implements GoogleApiClient.zza
  {
    private final Api<?> zzagT;
    private final int zzagU;
    private final WeakReference<zzh> zzahD;
    
    public zza(zzh paramzzh, Api<?> paramApi, int paramInt)
    {
      zzahD = new WeakReference(paramzzh);
      zzagT = paramApi;
      zzagU = paramInt;
    }
    
    public final void zza(ConnectionResult paramConnectionResult)
    {
      boolean bool = false;
      zzh localzzh = (zzh)zzahD.get();
      if (localzzh == null) {
        return;
      }
      if (Looper.myLooper() == zzahj.zzagW.zzagr) {
        bool = true;
      }
      zzx.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      zzXG.lock();
      try
      {
        bool = localzzh.zzbz(0);
        if (!bool) {
          return;
        }
        if (!paramConnectionResult.isSuccess()) {
          localzzh.zzb(paramConnectionResult, zzagT, zzagU);
        }
        if (localzzh.zzpu()) {
          localzzh.zzpv();
        }
        return;
      }
      finally
      {
        zzXG.unlock();
      }
    }
  }
  
  private final class zzb
    extends zzh.zzf
  {
    private final Map<Api.zzb, GoogleApiClient.zza> zzahE;
    
    public zzb()
    {
      super((byte)0);
      Map localMap;
      zzahE = localMap;
    }
    
    public final void zzpt()
    {
      int i = zzags.isGooglePlayServicesAvailable(mContext);
      final Object localObject;
      if (i != 0)
      {
        localObject = new ConnectionResult(i, null);
        zzahj.zza(new zzl.zza(zzh.this)
        {
          public final void zzpt()
          {
            zzg(localObject);
          }
        });
      }
      for (;;)
      {
        return;
        if (zzahu) {
          zzahs.connect();
        }
        localObject = zzahE.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Api.zzb localzzb = (Api.zzb)((Iterator)localObject).next();
          localzzb.zza((GoogleApiClient.zza)zzahE.get(localzzb));
        }
      }
    }
  }
  
  private final class zzc
    extends zzh.zzf
  {
    private final ArrayList<Api.zzb> zzahH;
    
    public zzc()
    {
      super((byte)0);
      ArrayList localArrayList;
      zzahH = localArrayList;
    }
    
    public final void zzpt()
    {
      zzj localzzj = zzahj.zzagW;
      zzh localzzh = zzh.this;
      Object localObject;
      if (zzahz == null) {
        localObject = Collections.emptySet();
      }
      for (;;)
      {
        zzahU = ((Set)localObject);
        localObject = zzahH.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Api.zzb)((Iterator)localObject).next()).zza(zzahw, zzahj.zzagW.zzahU);
        }
        localObject = new HashSet(zzahz.zzagh);
        Map localMap = zzahz.zzalc;
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          Api localApi = (Api)localIterator.next();
          if (!zzahj.zzaio.containsKey(localApi.zzoR())) {
            ((Set)localObject).addAll(getzzXf);
          }
        }
      }
    }
  }
  
  private static final class zzd
    extends zzb
  {
    private final WeakReference<zzh> zzahD;
    
    zzd(zzh paramzzh)
    {
      zzahD = new WeakReference(paramzzh);
    }
    
    public final void zzb(final SignInResponse paramSignInResponse)
    {
      final zzh localzzh = (zzh)zzahD.get();
      if (localzzh == null) {
        return;
      }
      zzahj.zza(new zzl.zza(localzzh)
      {
        public final void zzpt()
        {
          zzh localzzh = localzzh;
          Object localObject = paramSignInResponse;
          ConnectionResult localConnectionResult;
          if (localzzh.zzbz(0))
          {
            localConnectionResult = zzams;
            if (!localConnectionResult.isSuccess()) {
              break label119;
            }
            localObject = zzbhk;
            localConnectionResult = zzams;
            if (!localConnectionResult.isSuccess())
            {
              Log.wtf("GoogleApiClientConnecting", "Sign-in succeeded with resolve account failure: " + localConnectionResult, new Exception());
              localzzh.zzg(localConnectionResult);
            }
          }
          else
          {
            return;
          }
          zzahv = true;
          zzahw = com.google.android.gms.common.internal.zzp.zza.zzaP(zzakA);
          zzahx = zzahx;
          zzahy = zzamt;
          localzzh.zzpv();
          return;
          label119:
          if (localzzh.zzf(localConnectionResult))
          {
            localzzh.zzpy();
            localzzh.zzpv();
            return;
          }
          localzzh.zzg(localConnectionResult);
        }
      });
    }
  }
  
  private final class zze
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private zze() {}
    
    public final void onConnected(Bundle paramBundle)
    {
      zzahs.zza(new zzh.zzd(zzh.this));
    }
    
    /* Error */
    public final void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
      //   4: getfield 45	com/google/android/gms/common/api/internal/zzh:zzXG	Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 50 1 0
      //   12: aload_0
      //   13: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
      //   16: aload_1
      //   17: invokevirtual 54	com/google/android/gms/common/api/internal/zzh:zzf	(Lcom/google/android/gms/common/ConnectionResult;)Z
      //   20: ifeq +30 -> 50
      //   23: aload_0
      //   24: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
      //   27: invokevirtual 57	com/google/android/gms/common/api/internal/zzh:zzpy	()V
      //   30: aload_0
      //   31: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
      //   34: invokevirtual 60	com/google/android/gms/common/api/internal/zzh:zzpv	()V
      //   37: aload_0
      //   38: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
      //   41: getfield 45	com/google/android/gms/common/api/internal/zzh:zzXG	Ljava/util/concurrent/locks/Lock;
      //   44: invokeinterface 63 1 0
      //   49: return
      //   50: aload_0
      //   51: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
      //   54: aload_1
      //   55: invokevirtual 66	com/google/android/gms/common/api/internal/zzh:zzg	(Lcom/google/android/gms/common/ConnectionResult;)V
      //   58: goto -21 -> 37
      //   61: astore_1
      //   62: aload_0
      //   63: getfield 17	com/google/android/gms/common/api/internal/zzh$zze:zzahC	Lcom/google/android/gms/common/api/internal/zzh;
      //   66: getfield 45	com/google/android/gms/common/api/internal/zzh:zzXG	Ljava/util/concurrent/locks/Lock;
      //   69: invokeinterface 63 1 0
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zze
      //   0	76	1	paramConnectionResult	ConnectionResult
      // Exception table:
      //   from	to	target	type
      //   12	37	61	finally
      //   50	58	61	finally
    }
    
    public final void onConnectionSuspended(int paramInt) {}
  }
  
  private abstract class zzf
    implements Runnable
  {
    private zzf() {}
    
    public void run()
    {
      zzXG.lock();
      try
      {
        boolean bool = Thread.interrupted();
        if (bool) {
          return;
        }
        zzpt();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        zzl localzzl = zzahj;
        Message localMessage = zzain.obtainMessage(2, localRuntimeException);
        zzain.sendMessage(localMessage);
        return;
      }
      finally
      {
        zzXG.unlock();
      }
    }
    
    protected abstract void zzpt();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */