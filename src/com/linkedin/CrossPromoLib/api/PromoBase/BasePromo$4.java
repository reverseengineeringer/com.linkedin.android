package com.linkedin.CrossPromoLib.api.PromoBase;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;
import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

public final class BasePromo$4
  extends CrossPromoImageListener
{
  public BasePromo$4(BasePromo paramBasePromo, View paramView) {}
  
  public final void onSuccess(String paramString, ManagedBitmap paramManagedBitmap)
  {
    paramString = paramManagedBitmap.getBitmap();
    if (Build.VERSION.SDK_INT >= 16) {
      val$view.setBackground(new BitmapDrawable(val$view.getResources(), paramString));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoBase.BasePromo.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */