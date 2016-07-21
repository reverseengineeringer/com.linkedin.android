package com.linkedin.android.imageloader;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.ManagedDrawable;

public final class ManagedBitmapDrawable
  extends BitmapDrawable
  implements ManagedDrawable
{
  private ManagedBitmap managedBitmap;
  
  public ManagedBitmapDrawable(Resources paramResources, ManagedBitmap paramManagedBitmap)
  {
    super(paramResources, paramManagedBitmap.getBitmap());
    managedBitmap = paramManagedBitmap;
    paramManagedBitmap.retain();
  }
  
  protected final void finalize()
    throws Throwable
  {
    if (managedBitmap != null) {
      throw new RuntimeException("ManagedBitmapDrawable was finalized without releasing its bitmap.");
    }
    super.finalize();
  }
  
  public final void release()
  {
    if (managedBitmap != null)
    {
      managedBitmap.release();
      managedBitmap = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.ManagedBitmapDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */