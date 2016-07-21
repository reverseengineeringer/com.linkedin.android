package com.google.android.gms.ads.internal;

import android.app.Activity;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.purchase.zze;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzge;

public class ClientApi
  implements zzm
{
  public static void retainReference()
  {
    com.google.android.gms.ads.internal.client.zzl.zzuq = ClientApi.class.getName();
  }
  
  public final zzfv createAdOverlay(Activity paramActivity)
  {
    return new zzd(paramActivity);
  }
  
  public final zzge createInAppPurchaseManager(Activity paramActivity)
  {
    return new zze(paramActivity);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.ClientApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */