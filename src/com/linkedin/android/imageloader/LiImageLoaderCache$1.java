package com.linkedin.android.imageloader;

import android.support.v4.util.LruCache;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

final class LiImageLoaderCache$1
  extends LruCache<String, ManagedBitmap>
{
  LiImageLoaderCache$1(LiImageLoaderCache paramLiImageLoaderCache, int paramInt)
  {
    super(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageLoaderCache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */