package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.util.Pair;
import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

final class CrossPromoImageLoader$Adapter
  implements ImageListener
{
  private final CrossPromoImageListener adaptee;
  
  private CrossPromoImageLoader$Adapter(CrossPromoImageListener paramCrossPromoImageListener)
  {
    adaptee = paramCrossPromoImageListener;
  }
  
  public final Pair<Integer, Integer> getTargetDimensions()
  {
    return null;
  }
  
  public final void onErrorResponse(String paramString, Exception paramException)
  {
    adaptee.onError(paramString, paramException);
  }
  
  public final void onResponse(String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
  {
    adaptee.onSuccess(paramString, paramManagedBitmap);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoImageLoader.Adapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */