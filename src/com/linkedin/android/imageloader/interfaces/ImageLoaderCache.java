package com.linkedin.android.imageloader.interfaces;

public abstract interface ImageLoaderCache
{
  public abstract void clear();
  
  public abstract ManagedBitmap get(String paramString);
  
  public abstract void put(String paramString, ManagedBitmap paramManagedBitmap);
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.interfaces.ImageLoaderCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */