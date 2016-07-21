package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class SupportLifecycleFragmentImpl
  extends zzw
{
  protected final void zzb(int paramInt, ConnectionResult paramConnectionResult)
  {
    GooglePlayServicesUtil.showErrorDialogFragment(zzade, getActivity(), this, 2, this);
  }
  
  protected final void zzc(int paramInt, final ConnectionResult paramConnectionResult)
  {
    GoogleApiAvailability.getInstance();
    paramConnectionResult = GoogleApiAvailability.zza(getActivity(), this);
    zzaiD = zzn.zza(getActivity().getApplicationContext(), new zzn()
    {
      protected final void zzpJ()
      {
        zzpP();
        paramConnectionResult.dismiss();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */