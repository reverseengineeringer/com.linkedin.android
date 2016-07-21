package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompat$EclairDrawableImpl
  extends DrawableCompat.BaseDrawableImpl
{
  public Drawable wrap(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof TintAwareDrawable)) {
      localObject = new DrawableWrapperEclair(paramDrawable);
    }
    return (Drawable)localObject;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat.EclairDrawableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */