package com.linkedin.android.imageloader;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.linkedin.android.imageloader.interfaces.ManagedDrawable;

public class ManagedLayerDrawable
  extends LayerDrawable
  implements ManagedDrawable
{
  private boolean released;
  
  public ManagedLayerDrawable(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
  }
  
  protected void finalize()
    throws Throwable
  {
    if (!released) {
      throw new RuntimeException("ManagedLayerDrawable was finalized without being released.");
    }
    super.finalize();
  }
  
  public final void release()
  {
    int j = getNumberOfLayers();
    int i = 0;
    while (i < j)
    {
      Drawable localDrawable = getDrawable(i);
      if ((localDrawable instanceof ManagedDrawable)) {
        ((ManagedDrawable)localDrawable).release();
      }
      i += 1;
    }
    released = true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.ManagedLayerDrawable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */