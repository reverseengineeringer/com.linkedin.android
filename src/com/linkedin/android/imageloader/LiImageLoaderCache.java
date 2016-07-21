package com.linkedin.android.imageloader;

import android.support.v4.util.LruCache;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

public final class LiImageLoaderCache
  implements ImageLoaderCache
{
  private final LruCache<String, ManagedBitmap> mCache = new LruCache(Math.max(16384, (int)(Runtime.getRuntime().maxMemory() / 1024L / 8L))) {};
  
  public final void clear()
  {
    mCache.trimToSize(-1);
  }
  
  public final ManagedBitmap get(String paramString)
  {
    return (ManagedBitmap)mCache.get(paramString);
  }
  
  public final void put(String paramString, ManagedBitmap paramManagedBitmap)
  {
    if (paramManagedBitmap.isGif()) {
      return;
    }
    mCache.put(paramString, paramManagedBitmap.retain());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageLoaderCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */