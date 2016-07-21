package com.linkedin.CrossPromoLib.api.PromoBase;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.crosspromo.fe.api.android.Image;

final class BasePromo$3
  extends CrossPromoImageListener
{
  BasePromo$3(BasePromo paramBasePromo, int paramInt, ImageView paramImageView, Image paramImage) {}
  
  public final void onSuccess(String paramString, ManagedBitmap paramManagedBitmap)
  {
    if (val$width > 0)
    {
      paramString = paramManagedBitmap.getBitmap();
      i = (int)(paramString.getHeight() / paramString.getWidth() * val$width);
      paramString = val$imageView.getLayoutParams();
      height = i;
      val$imageView.setLayoutParams(paramString);
    }
    while ((val$image == null) || (!val$image.hasAspectRatio) || (val$image.aspectRatio == 1.0F))
    {
      int i;
      return;
    }
    paramString = val$imageView.getLayoutParams();
    height = ((int)(height * val$image.aspectRatio));
    val$imageView.setLayoutParams(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoBase.BasePromo.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */