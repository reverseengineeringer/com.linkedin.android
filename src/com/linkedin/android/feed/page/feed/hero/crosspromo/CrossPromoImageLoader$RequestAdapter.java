package com.linkedin.android.feed.page.feed.hero.crosspromo;

import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.infra.network.ImageRequest.ImageRequestListener;

final class CrossPromoImageLoader$RequestAdapter
  implements ImageRequest.ImageRequestListener
{
  private final CrossPromoImageListener adaptee;
  
  private CrossPromoImageLoader$RequestAdapter(CrossPromoImageListener paramCrossPromoImageListener)
  {
    adaptee = paramCrossPromoImageListener;
  }
  
  public final void onErrorResponse(Object paramObject, String paramString, Exception paramException)
  {
    adaptee.onError(paramString, paramException);
  }
  
  public final void onResponse(Object paramObject, String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
  {
    adaptee.onSuccess(paramString, paramManagedBitmap);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoImageLoader.RequestAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */