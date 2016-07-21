package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public final class zzx<R extends Result>
  extends TransformedResult<R>
  implements ResultCallback<R>
{
  final Object zzagI;
  final WeakReference<GoogleApiClient> zzagK;
  ResultTransform<? super R, ? extends Result> zzaiN;
  zzx<? extends Result> zzaiO;
  ResultCallbacks<? super R> zzaiP;
  PendingResult<R> zzaiQ;
  Status zzaiR;
  final zzx<R>.com.google.android.gms.common.api.internal.zzx.com.google.android.gms.common.api.internal.zzx.com.google.android.gms.common.api.internal.zzx.com.google.android.gms.common.api.internal.zzx.com.google.android.gms.common.api.internal.zzx.com.google.android.gms.common.api.internal.zzx.zza zzaiS;
  
  private boolean zzpV()
  {
    GoogleApiClient localGoogleApiClient = (GoogleApiClient)zzagK.get();
    return (zzaiP != null) && (localGoogleApiClient != null);
  }
  
  public final void onResult(final R paramR)
  {
    synchronized (zzagI)
    {
      if (paramR.getStatus().isSuccess())
      {
        if (zzaiN != null) {
          zzs.zzpN().submit(new Runnable()
          {
            public final void run()
            {
              try
              {
                Object localObject1 = zzaiN.onSuccess$1e5d55c();
                zzaiS.sendMessage(zzaiS.obtainMessage(0, localObject1));
                localObject1 = (GoogleApiClient)zzagK.get();
                if (localObject1 != null) {
                  ((GoogleApiClient)localObject1).zzb(zzx.this);
                }
                return;
              }
              catch (RuntimeException localRuntimeException)
              {
                zzaiS.sendMessage(zzaiS.obtainMessage(1, localRuntimeException));
                GoogleApiClient localGoogleApiClient1;
                return;
              }
              finally
              {
                GoogleApiClient localGoogleApiClient2 = (GoogleApiClient)zzagK.get();
                if (localGoogleApiClient2 != null) {
                  localGoogleApiClient2.zzb(zzx.this);
                }
              }
            }
          });
        }
        for (;;)
        {
          return;
          if (!zzpV()) {}
        }
      }
      zzy(paramR.getStatus());
    }
  }
  
  final void zzy(Status paramStatus)
  {
    synchronized (zzagI)
    {
      zzaiR = paramStatus;
      zzz(zzaiR);
      return;
    }
  }
  
  final void zzz(Status paramStatus)
  {
    synchronized (zzagI)
    {
      if (zzaiN != null)
      {
        com.google.android.gms.common.internal.zzx.zzb(paramStatus, "onFailure must not return null");
        zzaiO.zzy(paramStatus);
        return;
      }
      zzpV();
    }
  }
  
  private final class zza
    extends Handler
  {
    public final void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + what);
        return;
      case 0: 
        Object localObject3 = (PendingResult)obj;
        paramMessage = zzaiU.zzagI;
        if (localObject3 == null) {}
        for (;;)
        {
          try
          {
            zzaiU.zzaiO.zzy(new Status(13, "Transform returned null"));
            return;
          }
          finally {}
          if (!(localObject3 instanceof zzt)) {
            break;
          }
          zzaiU.zzaiO.zzy(zzUX);
        }
        zzx localzzx = zzaiU.zzaiO;
        for (;;)
        {
          synchronized (zzagI)
          {
            zzaiQ = ((PendingResult)localObject3);
            if ((zzaiN != null) || (zzaiP != null))
            {
              localObject3 = (GoogleApiClient)zzagK.get();
              if ((zzaiN != null) && (localObject3 != null)) {
                ((GoogleApiClient)localObject3).zza(localzzx);
              }
              if (zzaiR == null) {
                break label226;
              }
              localzzx.zzz(zzaiR);
            }
          }
          label226:
          if (zzaiQ != null) {
            zzaiQ.setResultCallback(localResultCallback);
          }
        }
      }
      paramMessage = (RuntimeException)obj;
      Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: " + paramMessage.getMessage());
      throw paramMessage;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */