package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzb<R extends Result>
  extends PendingResult<R>
{
  private boolean zzL;
  private final Object zzagI = new Object();
  protected final zza<R> zzagJ;
  private final WeakReference<GoogleApiClient> zzagK;
  private final ArrayList<Object> zzagL = new ArrayList();
  private ResultCallback<? super R> zzagM;
  private volatile boolean zzagN;
  private boolean zzagO;
  private boolean zzagP;
  private zzq zzagQ;
  Integer zzagR;
  private volatile zzx<R> zzagS;
  private volatile R zzagy;
  private final CountDownLatch zzpJ = new CountDownLatch(1);
  
  public zzb(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null) {}
    for (Looper localLooper = paramGoogleApiClient.getLooper();; localLooper = Looper.getMainLooper())
    {
      zzagJ = new zza(localLooper);
      zzagK = new WeakReference(paramGoogleApiClient);
      return;
    }
  }
  
  private R get()
  {
    boolean bool = true;
    synchronized (zzagI)
    {
      if (!zzagN)
      {
        com.google.android.gms.common.internal.zzx.zza(bool, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzx.zza(isReady(), "Result is not ready.");
        Result localResult = zzagy;
        zzagy = null;
        zzagM = null;
        zzagN = true;
        zzpf();
        return localResult;
      }
      bool = false;
    }
  }
  
  private boolean isCanceled()
  {
    synchronized (zzagI)
    {
      boolean bool = zzL;
      return bool;
    }
  }
  
  private void zzb(R paramR)
  {
    zzagy = paramR;
    zzagQ = null;
    zzpJ.countDown();
    zzagy.getStatus();
    if (zzagM != null)
    {
      zzagJ.removeMessages(2);
      if (!zzL) {
        zzagJ.zza(zzagM, get());
      }
    }
    paramR = zzagL.iterator();
    while (paramR.hasNext()) {
      paramR.next();
    }
    zzagL.clear();
  }
  
  public final R await$140a99d0(TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((0L <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      com.google.android.gms.common.internal.zzx.zza(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!zzagN)
      {
        bool1 = true;
        label34:
        com.google.android.gms.common.internal.zzx.zza(bool1, "Result has already been consumed.");
        if (zzagS != null) {
          break label98;
        }
        bool1 = bool2;
        com.google.android.gms.common.internal.zzx.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!zzpJ.await(0L, paramTimeUnit)) {
          zzx(Status.zzagF);
        }
        com.google.android.gms.common.internal.zzx.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label34;
        label98:
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          zzx(Status.zzagD);
        }
      }
    }
  }
  
  public final void cancel()
  {
    synchronized (zzagI)
    {
      if ((zzL) || (zzagN)) {
        return;
      }
      Result localResult = zzagy;
      zzagM = null;
      zzL = true;
      zzb(zzc(Status.zzagG));
      return;
    }
  }
  
  public final boolean isReady()
  {
    return zzpJ.getCount() == 0L;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!zzagN)
    {
      bool1 = true;
      com.google.android.gms.common.internal.zzx.zza(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (zzagI)
      {
        if (zzagS != null) {
          break label129;
        }
        bool1 = bool2;
        com.google.android.gms.common.internal.zzx.zza(bool1, "Cannot set callbacks if then() has been called.");
        if (isCanceled()) {
          return;
        }
        if ((zzagP) && (((GoogleApiClient)zzagK.get() == null) || (!(paramResultCallback instanceof zzx))))
        {
          cancel();
          return;
        }
      }
      if (isReady()) {
        zzagJ.zza(paramResultCallback, get());
      }
      for (;;)
      {
        return;
        zzagM = paramResultCallback;
      }
      bool1 = false;
      break;
      label129:
      bool1 = false;
    }
  }
  
  public final void zza(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (zzagI)
      {
        if ((zzagO) || (zzL)) {
          return;
        }
        if (!isReady())
        {
          bool1 = true;
          com.google.android.gms.common.internal.zzx.zza(bool1, "Results have already been set");
          if (zzagN) {
            break label79;
          }
          bool1 = bool2;
          com.google.android.gms.common.internal.zzx.zza(bool1, "Result has already been consumed");
          zzb(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label79:
      bool1 = false;
    }
  }
  
  public abstract R zzc(Status paramStatus);
  
  public final Integer zzpa()
  {
    return zzagR;
  }
  
  protected void zzpf() {}
  
  public final void zzpg()
  {
    for (;;)
    {
      synchronized (zzagI)
      {
        if ((GoogleApiClient)zzagK.get() == null)
        {
          cancel();
          return;
        }
        if ((zzagM == null) || ((zzagM instanceof zzx)))
        {
          zzagP = true;
          return;
        }
      }
      cancel();
    }
  }
  
  public final void zzx(Status paramStatus)
  {
    synchronized (zzagI)
    {
      if (!isReady())
      {
        zza(zzc(paramStatus));
        zzagO = true;
      }
      return;
    }
  }
  
  public static final class zza<R extends Result>
    extends Handler
  {
    public zza()
    {
      this(Looper.getMainLooper());
    }
    
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.wtf("BasePendingResult", "Don't know how to handle message: " + what, new Exception());
        return;
      case 1: 
        Object localObject = (Pair)obj;
        paramMessage = (ResultCallback)first;
        localObject = (Result)second;
        try
        {
          paramMessage.onResult((Result)localObject);
          return;
        }
        catch (RuntimeException paramMessage)
        {
          throw paramMessage;
        }
      }
      ((zzb)obj).zzx(Status.zzagF);
    }
    
    public final void zza(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */