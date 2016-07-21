package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

final class zzx$1
  implements Runnable
{
  zzx$1(zzx paramzzx, Result paramResult) {}
  
  public final void run()
  {
    try
    {
      Object localObject1 = zzaiU.zzaiN.onSuccess$1e5d55c();
      zzaiU.zzaiS.sendMessage(zzaiU.zzaiS.obtainMessage(0, localObject1));
      localObject1 = (GoogleApiClient)zzaiU.zzagK.get();
      if (localObject1 != null) {
        ((GoogleApiClient)localObject1).zzb(zzaiU);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzaiU.zzaiS.sendMessage(zzaiU.zzaiS.obtainMessage(1, localRuntimeException));
      GoogleApiClient localGoogleApiClient1;
      return;
    }
    finally
    {
      GoogleApiClient localGoogleApiClient2 = (GoogleApiClient)zzaiU.zzagK.get();
      if (localGoogleApiClient2 != null) {
        localGoogleApiClient2.zzb(zzaiU);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzx.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */