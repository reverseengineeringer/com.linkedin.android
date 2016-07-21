package com.linkedin.android.imageloader;

import android.graphics.drawable.Drawable;
import com.linkedin.android.imageloader.interfaces.ManagedDrawable;

public final class ManagedDrawableWrapper
  implements ManagedDrawable
{
  public Drawable drawable;
  
  public ManagedDrawableWrapper()
  {
    this(null);
  }
  
  public ManagedDrawableWrapper(Drawable paramDrawable)
  {
    drawable = paramDrawable;
  }
  
  public final void release()
  {
    if ((drawable instanceof ManagedDrawable)) {
      ((ManagedDrawable)drawable).release();
    }
  }
  
  public final void setDrawable(Drawable paramDrawable)
  {
    release();
    drawable = paramDrawable;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.ManagedDrawableWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */