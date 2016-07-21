package com.linkedin.CrossPromoLib.utils.Network;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import com.linkedin.CrossPromoLib.utils.CrossPromoImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

public abstract class AbstractCrossPromoImageLoader
{
  public void loadImage(String paramString, ImageView paramImageView, CrossPromoImageListener paramCrossPromoImageListener)
  {
    if (paramImageView == null) {}
    for (;;)
    {
      loadImage(paramString, paramCrossPromoImageListener);
      return;
      paramCrossPromoImageListener = new CopyImage(paramImageView, paramCrossPromoImageListener);
    }
  }
  
  public abstract void loadImage(String paramString, CrossPromoImageListener paramCrossPromoImageListener);
  
  private static final class CopyImage
    extends CrossPromoImageListener
  {
    private final CrossPromoImageListener delegate;
    private final ImageView view;
    
    public CopyImage(ImageView paramImageView, CrossPromoImageListener paramCrossPromoImageListener)
    {
      view = paramImageView;
      delegate = paramCrossPromoImageListener;
    }
    
    public final void onError(String paramString, Exception paramException)
    {
      if (delegate != null) {
        delegate.onError(paramString, paramException);
      }
    }
    
    public final void onSuccess(String paramString, ManagedBitmap paramManagedBitmap)
    {
      Bitmap localBitmap = paramManagedBitmap.getBitmap();
      if (localBitmap == null) {
        Log.w(getClass().getName(), "image.getBitmap() == null");
      }
      for (;;)
      {
        if (delegate != null) {
          delegate.onSuccess(paramString, paramManagedBitmap);
        }
        return;
        localBitmap = localBitmap.copy(localBitmap.getConfig(), true);
        view.setImageBitmap(localBitmap);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Network.AbstractCrossPromoImageLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */