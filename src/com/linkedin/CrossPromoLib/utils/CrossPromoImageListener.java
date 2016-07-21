package com.linkedin.CrossPromoLib.utils;

import android.util.Log;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;

public abstract class CrossPromoImageListener
{
  private static final String TAG = CrossPromoImageListener.class.getName();
  
  public void onError(String paramString, Exception paramException)
  {
    Log.e(TAG, "Failed to retrieve image from url: " + paramString, paramException);
  }
  
  public abstract void onSuccess(String paramString, ManagedBitmap paramManagedBitmap);
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.CrossPromoImageListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */