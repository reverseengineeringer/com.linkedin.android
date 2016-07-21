package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperKitKat
  extends DrawableWrapperHoneycomb
{
  DrawableWrapperKitKat(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  DrawableWrapperKitKat(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }
  
  public boolean isAutoMirrored()
  {
    return mDrawable.isAutoMirrored();
  }
  
  DrawableWrapperDonut.DrawableWrapperState mutateConstantState()
  {
    return new DrawableWrapperStateKitKat(mState);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    mDrawable.setAutoMirrored(paramBoolean);
  }
  
  private static final class DrawableWrapperStateKitKat
    extends DrawableWrapperDonut.DrawableWrapperState
  {
    DrawableWrapperStateKitKat(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new DrawableWrapperKitKat(this, paramResources);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableWrapperKitKat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */