package com.linkedin.android.imageloader;

import android.util.Pair;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.PerfEventListener;

final class LiImageLoader$2
  implements ImageListener
{
  LiImageLoader$2(LiImageLoader paramLiImageLoader, String paramString, ImageListener paramImageListener, PerfEventListener paramPerfEventListener) {}
  
  public final Pair<Integer, Integer> getTargetDimensions()
  {
    if (val$imageListener != null) {
      return val$imageListener.getTargetDimensions();
    }
    return null;
  }
  
  public final void onErrorResponse(String paramString, Exception paramException)
  {
    LiImageLoader.access$100$7891660f$5bc45bcf(paramString, paramException, val$imageListener);
  }
  
  public final void onResponse(String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
  {
    LiImageLoader.access$000$676ebb83(this$0, paramString, val$cacheKey, paramManagedBitmap, val$imageListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageLoader.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */