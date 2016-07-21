package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzp.zza;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;

final class zzh$zzd
  extends zzb
{
  private final WeakReference<zzh> zzahD;
  
  zzh$zzd(zzh paramzzh)
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
        zzahw = zzp.zza.zzaP(zzakA);
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

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzh.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */