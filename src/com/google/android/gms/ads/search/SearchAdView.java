package com.google.android.gms.ads.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzab;

public final class SearchAdView
  extends ViewGroup
{
  private final zzab zzoJ;
  
  public final AdListener getAdListener()
  {
    return zzoJ.zztA;
  }
  
  public final AdSize getAdSize()
  {
    return zzoJ.getAdSize();
  }
  
  public final String getAdUnitId()
  {
    return zzoJ.zzpS;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  protected final void onMeasure(int paramInt1, int paramInt2)
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
  
  public final void setAdListener(AdListener paramAdListener)
  {
    zzoJ.setAdListener(paramAdListener);
  }
  
  public final void setAdSize(AdSize paramAdSize)
  {
    zzoJ.setAdSizes(new AdSize[] { paramAdSize });
  }
  
  public final void setAdUnitId(String paramString)
  {
    zzoJ.setAdUnitId(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.search.SearchAdView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */