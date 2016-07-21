package com.linkedin.android.imageloader;

import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.imageloader.interfaces.ManagedDrawable;
import com.makeramen.roundedimageview.RoundedDrawable;

public final class ManagedRoundedDrawable
  extends RoundedDrawable
  implements ManagedDrawable
{
  private ManagedBitmap managedBitmap;
  
  public ManagedRoundedDrawable(ManagedBitmap paramManagedBitmap)
  {
    super(paramManagedBitmap.getBitmap());
    managedBitmap = paramManagedBitmap;
    paramManagedBitmap.retain();
  }
  
  protected final void finalize()
    throws Throwable
  {
    if (managedBitmap != null) {
      throw new RuntimeException("ManagedRoundedDrawable was finalized without releasing its bitmap.");
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
 * Qualified Name:     com.linkedin.android.imageloader.ManagedRoundedDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */