package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzab
{
  public boolean zzpE;
  public String zzpS;
  public AdListener zztA;
  private zza zztz;
  public zzu zzuL;
  private ViewGroup zzuN;
  public InAppPurchaseListener zzuO;
  public PlayStorePurchaseListener zzuP;
  public OnCustomRenderedAdLoadedListener zzuQ;
  public Correlator zzuR;
  private boolean zzuS;
  public AppEventListener zzun;
  public AdSize[] zzuo;
  
  public final AdSize getAdSize()
  {
    try
    {
      if (zzuL != null)
      {
        Object localObject = zzuL.zzaN();
        if (localObject != null)
        {
          localObject = new AdSize(width, height, zzuh);
          return (AdSize)localObject;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the current AdSize.", localRemoteException);
      if (zzuo != null) {
        return zzuo[0];
      }
    }
    return null;
  }
  
  public final String getMediationAdapterClassName()
  {
    try
    {
      if (zzuL != null)
      {
        String str = zzuL.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public final void setAdListener(AdListener paramAdListener)
  {
    try
    {
      zztA = paramAdListener;
      if ((zzuL != null) && (paramAdListener != null)) {
        new zzc(paramAdListener);
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public final void setAdSizes(AdSize... paramVarArgs)
  {
    if (zzuo != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    zza(paramVarArgs);
  }
  
  public final void setAdUnitId(String paramString)
  {
    if (zzpS != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    zzpS = paramString;
  }
  
  public final void zza(zza paramzza)
  {
    try
    {
      zztz = paramzza;
      if ((zzuL != null) && (paramzza != null)) {
        new zzb(paramzza);
      }
      return;
    }
    catch (RemoteException paramzza)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", paramzza);
    }
  }
  
  public final void zza(AdSize... paramVarArgs)
  {
    zzuo = paramVarArgs;
    try
    {
      if (zzuL != null)
      {
        paramVarArgs = zzuN.getContext();
        AdSize[] arrayOfAdSize = zzuo;
        boolean bool = zzuS;
        AdSizeParcelzzum = bool;
      }
      zzuN.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */