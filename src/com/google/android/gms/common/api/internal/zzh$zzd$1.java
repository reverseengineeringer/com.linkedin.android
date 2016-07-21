package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzp.zza;
import com.google.android.gms.signin.internal.SignInResponse;

final class zzh$zzd$1
  extends zzl.zza
{
  zzh$zzd$1(zzh.zzd paramzzd, zzk paramzzk, zzh paramzzh, SignInResponse paramSignInResponse)
  {
    super(paramzzk);
  }
  
  public final void zzpt()
  {
    zzh localzzh = zzahI;
    Object localObject = zzahJ;
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzh.zzd.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */