package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.concurrent.atomic.AtomicReference;

final class zzj$3
  implements GoogleApiClient.ConnectionCallbacks
{
  zzj$3(zzj paramzzj, AtomicReference paramAtomicReference, zzv paramzzv) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    zzj.zza$61295dcf(zzaid, (GoogleApiClient)zzaie.get(), zzaif);
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzj.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */