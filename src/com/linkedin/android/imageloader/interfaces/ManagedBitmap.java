package com.linkedin.android.imageloader.interfaces;

import android.graphics.Bitmap;

public abstract interface ManagedBitmap
{
  public abstract Bitmap getBitmap();
  
  public abstract int getSize();
  
  public abstract boolean isGif();
  
  public abstract void release();
  
  public abstract ManagedBitmap retain();
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.interfaces.ManagedBitmap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */