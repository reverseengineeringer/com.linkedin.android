package com.linkedin.android.imageloader.interfaces;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import java.io.InputStream;

public abstract interface IBitmapFactory
{
  public abstract Bitmap getBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract Bitmap getBitmap(InputStream paramInputStream, BitmapFactory.Options paramOptions);
  
  public abstract void recycle(Bitmap paramBitmap);
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.interfaces.IBitmapFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */