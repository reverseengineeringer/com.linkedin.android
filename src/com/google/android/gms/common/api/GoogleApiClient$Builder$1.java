package com.google.android.gms.common.api;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.api.internal.zzw;

final class GoogleApiClient$Builder$1
  implements Runnable
{
  GoogleApiClient$Builder$1(GoogleApiClient.Builder paramBuilder, GoogleApiClient paramGoogleApiClient) {}
  
  public final void run()
  {
    if ((zzagw.zzago.isFinishing()) || (zzagw.zzago.getSupportFragmentManager().isDestroyed())) {
      return;
    }
    zzagw.zza(zzw.zzb(zzagw.zzago), zzabL);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient.Builder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */