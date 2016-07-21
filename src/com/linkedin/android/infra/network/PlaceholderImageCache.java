package com.linkedin.android.infra.network;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;

public final class PlaceholderImageCache
{
  public final LruCache<Integer, BitmapDrawable> cache = new PlaceholderImageCache.1(this, getCacheSize());
  
  public static int getCacheSize()
  {
    return (int)(Runtime.getRuntime().maxMemory() / 1024L) / 32;
  }
  
  public final BitmapDrawable get(int paramInt)
  {
    return (BitmapDrawable)cache.get(Integer.valueOf(paramInt));
  }
  
  public final void put(int paramInt, BitmapDrawable paramBitmapDrawable)
  {
    cache.put(Integer.valueOf(paramInt), paramBitmapDrawable);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.PlaceholderImageCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */