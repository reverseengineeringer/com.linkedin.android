package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

final class zzx$zza
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

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzx.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */