package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompat$KitKatDrawableImpl
  extends DrawableCompat.JellybeanMr1DrawableImpl
{
  public final int getAlpha(Drawable paramDrawable)
  {
    return paramDrawable.getAlpha();
  }
  
  public final boolean isAutoMirrored(Drawable paramDrawable)
  {
    return paramDrawable.isAutoMirrored();
  }
  
  public final void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    paramDrawable.setAutoMirrored(paramBoolean);
  }
  
  public Drawable wrap(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof TintAwareDrawable)) {
      localObject = new DrawableWrapperKitKat(paramDrawable);
    }
    return (Drawable)localObject;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat.KitKatDrawableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */