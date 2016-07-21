package com.linkedin.android.imageloader;

import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

public abstract interface LiImageView$ImageViewLoadListener
{
  public abstract void onImageLoadFailure(String paramString, Exception paramException);
  
  public abstract void onImageLoadSuccess(ManagedBitmap paramManagedBitmap, String paramString, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageView.ImageViewLoadListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */