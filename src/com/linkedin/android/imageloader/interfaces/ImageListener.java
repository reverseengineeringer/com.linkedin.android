package com.linkedin.android.imageloader.interfaces;

import android.util.Pair;

public abstract interface ImageListener
{
  public abstract Pair<Integer, Integer> getTargetDimensions();
  
  public abstract void onErrorResponse(String paramString, Exception paramException);
  
  public abstract void onResponse(String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.interfaces.ImageListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */