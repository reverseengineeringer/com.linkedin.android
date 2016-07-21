package com.linkedin.CrossPromoLib.api.PromoBase;

import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

final class BasePromo$2
  extends CrossPromoImageListener
{
  BasePromo$2(BasePromo paramBasePromo, CrossPromoImageListener paramCrossPromoImageListener) {}
  
  public final void onError(String paramString, Exception paramException)
  {
    BasePromo.access$100(this$0);
    if (val$listener != null) {
      val$listener.onError(paramString, paramException);
    }
    super.onError(paramString, paramException);
  }
  
  public final void onSuccess(String paramString, ManagedBitmap paramManagedBitmap)
  {
    BasePromo.access$100(this$0);
    if (val$listener != null) {
      val$listener.onSuccess(paramString, paramManagedBitmap);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoBase.BasePromo.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */