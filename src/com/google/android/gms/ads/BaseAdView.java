package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzgi;

class BaseAdView
  extends ViewGroup
{
  private final zzab zzoJ;
  
  public AdListener getAdListener()
  {
    return zzoJ.zztA;
  }
  
  public AdSize getAdSize()
  {
    return zzoJ.getAdSize();
  }
  
  public String getAdUnitId()
  {
    return zzoJ.zzpS;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zzoJ.zzuO;
  }
  
  public String getMediationAdapterClassName()
  {
    return zzoJ.getMediationAdapterClassName();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1 - i) / 2;
      paramInt2 = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = getChildAt(0);
    int j;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      measureChild((View)localObject, paramInt1, paramInt2);
      j = ((View)localObject).getMeasuredWidth();
      i = ((View)localObject).getMeasuredHeight();
    }
    for (;;)
    {
      j = Math.max(j, getSuggestedMinimumWidth());
      i = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(j, paramInt1), View.resolveSize(i, paramInt2));
      return;
      localObject = getAdSize();
      if (localObject != null)
      {
        Context localContext = getContext();
        j = ((AdSize)localObject).getWidthInPixels(localContext);
        i = ((AdSize)localObject).getHeightInPixels(localContext);
      }
      else
      {
        j = 0;
      }
    }
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zzoJ.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zza))) {
      zzoJ.zza((zza)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    zzoJ.zza(null);
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    zzoJ.setAdSizes(new AdSize[] { paramAdSize });
  }
  
  public void setAdUnitId(String paramString)
  {
    zzoJ.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zzab localzzab = zzoJ;
    if (zzuP != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      zzuO = paramInAppPurchaseListener;
      if ((zzuL != null) && (paramInAppPurchaseListener != null)) {
        new zzgi(paramInAppPurchaseListener);
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      zzb.zzd("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.BaseAdView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */