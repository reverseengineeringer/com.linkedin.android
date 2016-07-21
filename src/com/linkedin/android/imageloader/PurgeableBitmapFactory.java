package com.linkedin.android.imageloader;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.linkedin.android.imageloader.interfaces.IBitmapFactory;
import com.linkedin.android.logger.Log;
import java.io.InputStream;

@TargetApi(9)
public class PurgeableBitmapFactory
  implements IBitmapFactory
{
  private static final String TAG = PurgeableBitmapFactory.class.getSimpleName();
  private static boolean nativeLibsLoaded;
  
  static
  {
    try
    {
      System.loadLibrary("jnigraphics");
      System.loadLibrary("BitmapUtils");
      nativeLibsLoaded = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.e(TAG, "Error loading native library", localUnsatisfiedLinkError);
      nativeLibsLoaded = false;
    }
  }
  
  private int attemptPin(Bitmap paramBitmap)
  {
    int i;
    if (!nativeLibsLoaded)
    {
      Log.e(TAG, "Failed to pin bitmap");
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = pinBitmap(paramBitmap);
      i = j;
    } while (j >= 0);
    Log.e(TAG, "Failed to pin bitmap");
    paramBitmap.recycle();
    return j;
  }
  
  public final Bitmap getBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Object localObject = paramConfig;
    if (paramConfig == null) {
      localObject = Bitmap.Config.ARGB_8888;
    }
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
    paramConfig = (Bitmap.Config)localObject;
    if (localObject != null)
    {
      paramConfig = (Bitmap.Config)localObject;
      if (nativeLibsLoaded)
      {
        paramConfig = (Bitmap.Config)localObject;
        if (attemptPin((Bitmap)localObject) < 0) {
          paramConfig = null;
        }
      }
    }
    return paramConfig;
  }
  
  public final Bitmap getBitmap(InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    if (nativeLibsLoaded) {
      inPurgeable = true;
    }
    paramOptions = BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
    paramInputStream = paramOptions;
    if (paramOptions != null)
    {
      paramInputStream = paramOptions;
      if (nativeLibsLoaded)
      {
        paramInputStream = paramOptions;
        if (attemptPin(paramOptions) < 0) {
          paramInputStream = null;
        }
      }
    }
    return paramInputStream;
  }
  
  public native int pinBitmap(Bitmap paramBitmap);
  
  public final void recycle(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    paramBitmap.recycle();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.PurgeableBitmapFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */