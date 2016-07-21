package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

final class DrawableWrapperLollipop$DrawableWrapperStateLollipop
  extends DrawableWrapperDonut.DrawableWrapperState
{
  DrawableWrapperLollipop$DrawableWrapperStateLollipop(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState)
  {
    super(paramDrawableWrapperState);
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    return new DrawableWrapperLollipop(this, paramResources);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableWrapperLollipop.DrawableWrapperStateLollipop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */