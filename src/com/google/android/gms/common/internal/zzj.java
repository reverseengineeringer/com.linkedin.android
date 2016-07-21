package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface>
  implements Api.zzb, zzk.zza
{
  public static final String[] zzalJ = { "service_esmobile", "service_googleme" };
  public final Context mContext;
  final Handler mHandler;
  private final Account zzTI;
  private final Set<Scope> zzXf;
  private final Looper zzagr;
  private final zzc zzags;
  public final zzf zzahz;
  private GoogleApiClient.zza zzalA = new zzf();
  private T zzalB;
  private final ArrayList<zzj<T>.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.zzc<?>> zzalC = new ArrayList();
  private zzj<T>.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.zze zzalD;
  private int zzalE = 1;
  private final GoogleApiClient.ConnectionCallbacks zzalF;
  private final GoogleApiClient.OnConnectionFailedListener zzalG;
  private final int zzalH;
  protected AtomicInteger zzalI = new AtomicInteger(0);
  int zzals;
  long zzalt;
  private long zzalu;
  private int zzalv;
  private long zzalw;
  private final zzl zzalx;
  private final Object zzaly = new Object();
  private zzs zzalz;
  private final Object zzpV = new Object();
  
  public zzj(Context paramContext, Looper paramLooper, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, zzl.zzau(paramContext), zzc.zzoK(), paramInt, paramzzf, (GoogleApiClient.ConnectionCallbacks)zzx.zzz(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzx.zzz(paramOnConnectionFailedListener));
  }
  
  private zzj(Context paramContext, Looper paramLooper, zzl paramzzl, zzc paramzzc, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    mContext = ((Context)zzx.zzb(paramContext, "Context must not be null"));
    zzagr = ((Looper)zzx.zzb(paramLooper, "Looper must not be null"));
    zzalx = ((zzl)zzx.zzb(paramzzl, "Supervisor must not be null"));
    zzags = ((zzc)zzx.zzb(paramzzc, "API availability must not be null"));
    mHandler = new zzb(paramLooper);
    zzalH = paramInt;
    zzahz = ((zzf)zzx.zzz(paramzzf));
    zzTI = zzTI;
    zzXf = zza(zzalb);
    zzalF = paramConnectionCallbacks;
    zzalG = paramOnConnectionFailedListener;
  }
  
  private static Set<Scope> zza(Set<Scope> paramSet)
  {
    if (paramSet == null) {}
    Iterator localIterator;
    do
    {
      while (!localIterator.hasNext())
      {
        return paramSet;
        localIterator = paramSet.iterator();
      }
    } while (paramSet.contains((Scope)localIterator.next()));
    throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
  }
  
  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (zzpV)
    {
      if (zzalE != paramInt1) {
        return false;
      }
      zzb(paramInt2, paramT);
      return true;
    }
  }
  
  private void zzb(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label275;
      }
      j = 1;
      label17:
      if (i != j) {
        break label281;
      }
    }
    for (;;)
    {
      zzx.zzac(bool);
      for (;;)
      {
        synchronized (zzpV)
        {
          zzalE = paramInt;
          zzalB = paramT;
          switch (paramInt)
          {
          case 2: 
            return;
            if (zzalD != null)
            {
              Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzgu());
              zzalx.zzb$5fe800ef(zzgu(), zzalD);
              zzalI.incrementAndGet();
            }
            zzalD = new zze(zzalI.get());
            if (zzalx.zza(zzgu(), zzalD, zzahz.zzagl)) {
              continue;
            }
            Log.e("GmsClient", "unable to connect to service: " + zzgu());
            zzm(8, zzalI.get());
          }
        }
        zzalu = System.currentTimeMillis();
        continue;
        if (zzalD != null)
        {
          zzalx.zzb$5fe800ef(zzgu(), zzalD);
          zzalD = null;
        }
      }
      i = 0;
      break;
      label275:
      j = 0;
      break label17;
      label281:
      bool = false;
    }
  }
  
  public void disconnect()
  {
    zzalI.incrementAndGet();
    synchronized (zzalC)
    {
      int j = zzalC.size();
      int i = 0;
      while (i < j)
      {
        ((zzc)zzalC.get(i)).zzqO();
        i += 1;
      }
      zzalC.clear();
    }
    synchronized (zzaly)
    {
      zzalz = null;
      zzb(1, null);
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public final void dump$ec96877(String paramString, PrintWriter paramPrintWriter)
  {
    for (;;)
    {
      IInterface localIInterface;
      synchronized (zzpV)
      {
        int i = zzalE;
        localIInterface = zzalB;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (localIInterface != null) {
            break label418;
          }
          paramPrintWriter.println("null");
          ??? = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          if (zzalu > 0L) {
            paramPrintWriter.append(paramString).append("lastConnectedTime=").println(zzalu + " " + ((SimpleDateFormat)???).format(new Date(zzalu)));
          }
          if (zzalt > 0L) {
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          }
          switch (zzals)
          {
          default: 
            paramPrintWriter.append(String.valueOf(zzals));
            paramPrintWriter.append(" lastSuspendedTime=").println(zzalt + " " + ((SimpleDateFormat)???).format(new Date(zzalt)));
            if (zzalw > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(zzalv));
              paramPrintWriter.append(" lastFailedTime=").println(zzalw + " " + ((SimpleDateFormat)???).format(new Date(zzalw)));
            }
            return;
          }
          break;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label418:
      paramPrintWriter.append(zzgv()).append("@").println(Integer.toHexString(System.identityHashCode(localIInterface.asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }
  
  public final boolean isConnected()
  {
    for (;;)
    {
      synchronized (zzpV)
      {
        if (zzalE == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final boolean isConnecting()
  {
    for (;;)
    {
      synchronized (zzpV)
      {
        if (zzalE == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  protected final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzalv = zzade;
    zzalw = System.currentTimeMillis();
  }
  
  public abstract T zzW(IBinder paramIBinder);
  
  public final void zza(GoogleApiClient.zza paramzza)
  {
    zzalA = ((GoogleApiClient.zza)zzx.zzb(paramzza, "Connection progress callbacks cannot be null."));
    zzb(2, null);
  }
  
  public final void zza(zzp arg1, Set<Scope> paramSet)
  {
    try
    {
      Bundle localBundle = zzml();
      localGetServiceRequest = new GetServiceRequest(zzalH);
      zzaln = mContext.getPackageName();
      zzalq = localBundle;
      if (paramSet != null) {
        zzalp = ((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
      }
      if (!zzmE()) {
        break label99;
      }
      if (zzTI == null) {
        break label141;
      }
      paramSet = zzTI;
    }
    catch (DeadObjectException ???)
    {
      synchronized (zzaly)
      {
        GetServiceRequest localGetServiceRequest;
        while (zzalz != null)
        {
          zzalz.zza(new zzd(this, zzalI.get()), localGetServiceRequest);
          return;
          paramSet = new Account("<<default account>>", "com.google");
          continue;
          ??? = ???;
          Log.w("GmsClient", "service died");
          mHandler.sendMessage(mHandler.obtainMessage(4, zzalI.get(), 1));
          return;
        }
        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
      }
    }
    catch (RemoteException ???)
    {
      label99:
      label141:
      Log.w("GmsClient", "Remote exception occurred", ???);
    }
    zzalr = paramSet;
    if (??? != null) {
      zzalo = ???.asBinder();
    }
  }
  
  public abstract String zzgu();
  
  public abstract String zzgv();
  
  protected final void zzm(int paramInt1, int paramInt2)
  {
    mHandler.sendMessage(mHandler.obtainMessage(5, paramInt2, -1, new zzh(paramInt1)));
  }
  
  public boolean zzmE()
  {
    return false;
  }
  
  public Bundle zzml()
  {
    return new Bundle();
  }
  
  public boolean zznb()
  {
    return false;
  }
  
  public Intent zznc()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  public final IBinder zzoT()
  {
    synchronized (zzaly)
    {
      if (zzalz == null) {
        return null;
      }
      IBinder localIBinder = zzalz.asBinder();
      return localIBinder;
    }
  }
  
  public final void zzqG()
  {
    int i = zzags.isGooglePlayServicesAvailable(mContext);
    if (i != 0)
    {
      zzb(1, null);
      zzalA = new zzf();
      mHandler.sendMessage(mHandler.obtainMessage(3, zzalI.get(), i));
      return;
    }
    zza(new zzf());
  }
  
  public final void zzqI()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public final T zzqJ()
    throws DeadObjectException
  {
    synchronized (zzpV)
    {
      if (zzalE == 4) {
        throw new DeadObjectException();
      }
    }
    zzqI();
    if (zzalB != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = zzalB;
      return localIInterface;
    }
  }
  
  private abstract class zza
    extends zzj<T>.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.zzc<Boolean>
  {
    public final int statusCode;
    public final Bundle zzalK;
    
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      statusCode = paramInt;
      zzalK = paramBundle;
    }
    
    protected abstract void zzj(ConnectionResult paramConnectionResult);
    
    protected abstract boolean zzqL();
  }
  
  final class zzb
    extends Handler
  {
    public zzb(Looper paramLooper)
    {
      super();
    }
    
    private static void zza(Message paramMessage)
    {
      ((zzj.zzc)obj).unregister();
    }
    
    private static boolean zzb(Message paramMessage)
    {
      return (what == 2) || (what == 1) || (what == 5);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (zzalI.get() != arg1)
      {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
        return;
      }
      if (((what == 1) || (what == 5)) && (!isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      if (what == 3)
      {
        paramMessage = new ConnectionResult(arg2, null);
        zzj.zzb(zzj.this).zza(paramMessage);
        onConnectionFailed(paramMessage);
        return;
      }
      if (what == 4)
      {
        zzj.zza$4495c6b5(zzj.this, 4);
        if (zzj.zzc(zzj.this) != null) {
          zzj.zzc(zzj.this).onConnectionSuspended(arg2);
        }
        zzj localzzj = zzj.this;
        zzals = arg2;
        zzalt = System.currentTimeMillis();
        zzj.zza(zzj.this, 4, 1, null);
        return;
      }
      if ((what == 2) && (!isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((zzj.zzc)obj).zzqN();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle message: " + what, new Exception());
    }
  }
  
  protected abstract class zzc<TListener>
  {
    private TListener mListener;
    private boolean zzalM;
    
    public zzc()
    {
      Object localObject;
      mListener = localObject;
      zzalM = false;
    }
    
    public final void unregister()
    {
      zzqO();
      synchronized (zzj.zzd(zzj.this))
      {
        zzj.zzd(zzj.this).remove(this);
        return;
      }
    }
    
    /* Error */
    public final void zzqN()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/zzj$zzc:mListener	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/zzj$zzc:zzalM	Z
      //   11: ifeq +30 -> 41
      //   14: ldc 48
      //   16: new 50	java/lang/StringBuilder
      //   19: dup
      //   20: ldc 52
      //   22: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   25: aload_0
      //   26: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   29: ldc 61
      //   31: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   34: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   37: invokestatic 74	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   40: pop
      //   41: aload_0
      //   42: monitorexit
      //   43: aload_1
      //   44: ifnull +8 -> 52
      //   47: aload_0
      //   48: aload_1
      //   49: invokevirtual 78	com/google/android/gms/common/internal/zzj$zzc:zzw	(Ljava/lang/Object;)V
      //   52: aload_0
      //   53: monitorenter
      //   54: aload_0
      //   55: iconst_1
      //   56: putfield 26	com/google/android/gms/common/internal/zzj$zzc:zzalM	Z
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_0
      //   62: invokevirtual 80	com/google/android/gms/common/internal/zzj$zzc:unregister	()V
      //   65: return
      //   66: astore_1
      //   67: aload_0
      //   68: monitorexit
      //   69: aload_1
      //   70: athrow
      //   71: astore_1
      //   72: aload_1
      //   73: athrow
      //   74: astore_1
      //   75: aload_0
      //   76: monitorexit
      //   77: aload_1
      //   78: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	79	0	this	zzc
      //   6	43	1	localObject1	Object
      //   66	4	1	localObject2	Object
      //   71	2	1	localRuntimeException	RuntimeException
      //   74	4	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	41	66	finally
      //   41	43	66	finally
      //   67	69	66	finally
      //   47	52	71	java/lang/RuntimeException
      //   54	61	74	finally
      //   75	77	74	finally
    }
    
    public final void zzqO()
    {
      try
      {
        mListener = null;
        return;
      }
      finally {}
    }
    
    protected abstract void zzw(TListener paramTListener);
  }
  
  public static final class zzd
    extends zzr.zza
  {
    private zzj zzalN;
    private final int zzalO;
    
    public zzd(zzj paramzzj, int paramInt)
    {
      zzalN = paramzzj;
      zzalO = paramInt;
    }
    
    public final void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      zzx.zzb(zzalN, "onPostInitComplete can be called only once per call to getRemoteService");
      zzj localzzj = zzalN;
      int i = zzalO;
      mHandler.sendMessage(mHandler.obtainMessage(1, i, -1, new zzj.zzg(localzzj, paramInt, paramIBinder, paramBundle)));
      zzalN = null;
    }
    
    public final void zzb(int paramInt, Bundle paramBundle)
    {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
  }
  
  public final class zze
    implements ServiceConnection
  {
    private final int zzalO;
    
    public zze(int paramInt)
    {
      zzalO = paramInt;
    }
    
    public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      zzx.zzb(paramIBinder, "Expecting a valid IBinder");
      synchronized (zzj.zza(zzj.this))
      {
        zzj.zza(zzj.this, zzs.zza.zzaS(paramIBinder));
        zzm(0, zzalO);
        return;
      }
    }
    
    public final void onServiceDisconnected(ComponentName arg1)
    {
      synchronized (zzj.zza(zzj.this))
      {
        zzj.zza(zzj.this, null);
        mHandler.sendMessage(mHandler.obtainMessage(4, zzalO, 1));
        return;
      }
    }
  }
  
  protected final class zzf
    implements GoogleApiClient.zza
  {
    public zzf() {}
    
    public final void zza(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess()) {
        zza(null, zzj.zze(zzj.this));
      }
      while (zzj.zzf(zzj.this) == null) {
        return;
      }
      zzj.zzf(zzj.this).onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class zzg
    extends zzj<T>.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.zza
  {
    public final IBinder zzalP;
    
    public zzg(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      zzalP = paramIBinder;
    }
    
    protected final void zzj(ConnectionResult paramConnectionResult)
    {
      if (zzj.zzf(zzj.this) != null) {
        zzj.zzf(zzj.this).onConnectionFailed(paramConnectionResult);
      }
      onConnectionFailed(paramConnectionResult);
    }
    
    protected final boolean zzqL()
    {
      IInterface localIInterface;
      do
      {
        try
        {
          String str = zzalP.getInterfaceDescriptor();
          if (!zzgv().equals(str))
          {
            Log.e("GmsClient", "service descriptor mismatch: " + zzgv() + " vs. " + str);
            return false;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("GmsClient", "service probably died");
          return false;
        }
        localIInterface = zzW(zzalP);
      } while ((localIInterface == null) || (!zzj.zza(zzj.this, 2, 3, localIInterface)));
      if (zzj.zzc(zzj.this) != null) {
        zzj.zzc(zzj.this).onConnected(null);
      }
      return true;
    }
  }
  
  protected final class zzh
    extends zzj<T>.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.com.google.android.gms.common.internal.zzj.zza
  {
    public zzh(int paramInt)
    {
      super(paramInt, null);
    }
    
    protected final void zzj(ConnectionResult paramConnectionResult)
    {
      zzj.zzb(zzj.this).zza(paramConnectionResult);
      onConnectionFailed(paramConnectionResult);
    }
    
    protected final boolean zzqL()
    {
      zzj.zzb(zzj.this).zza(ConnectionResult.zzafB);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */