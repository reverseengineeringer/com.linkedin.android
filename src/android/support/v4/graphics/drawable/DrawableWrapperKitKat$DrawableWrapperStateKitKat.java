package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

final class DrawableWrapperKitKat$DrawableWrapperStateKitKat
  extends DrawableWrapperDonut.DrawableWrapperState
{
  DrawableWrapperKitKat$DrawableWrapperStateKitKat(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState)
  {
    super(paramDrawableWrapperState);
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    return new DrawableWrapperKitKat(this, paramResources);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableWrapperKitKat.DrawableWrapperStateKitKat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */