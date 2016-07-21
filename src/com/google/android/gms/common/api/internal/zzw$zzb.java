package com.google.android.gms.common.api.internal;

import android.content.IntentSender.SendIntentException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.zzc;
import java.util.List;

final class zzw$zzb
  implements Runnable
{
  private final int zzaiJ;
  private final ConnectionResult zzaiK;
  
  public zzw$zzb(zzw paramzzw, int paramInt, ConnectionResult paramConnectionResult)
  {
    zzaiJ = paramInt;
    zzaiK = paramConnectionResult;
  }
  
  public final void run()
  {
    if ((!zzw.zza(zzaiI)) || (zzw.zzb(zzaiI))) {
      return;
    }
    zzw.zza$63adf358(zzaiI);
    zzw.zza(zzaiI, zzaiJ);
    zzw.zza(zzaiI, zzaiK);
    if (zzaiK.hasResolution()) {
      try
      {
        int i = zzaiI.getActivity().getSupportFragmentManager().getFragments().indexOf(zzaiI);
        zzaiK.startResolutionForResult(zzaiI.getActivity(), (i + 1 << 16) + 1);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        zzaiI.zzpP();
        return;
      }
    }
    if (zzaiI.zzpQ().isUserResolvableError(zzaiK.zzade))
    {
      zzaiI.zzb(zzaiJ, zzaiK);
      return;
    }
    if (zzaiK.zzade == 18)
    {
      zzaiI.zzc(zzaiJ, zzaiK);
      return;
    }
    zzw.zza(zzaiI, zzaiJ, zzaiK);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzw.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */