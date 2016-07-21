package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;

final class DrawableWrapperLollipop
  extends DrawableWrapperKitKat
{
  DrawableWrapperLollipop(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  DrawableWrapperLollipop(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }
  
  public final Rect getDirtyBounds()
  {
    return mDrawable.getDirtyBounds();
  }
  
  public final void getOutline(Outline paramOutline)
  {
    mDrawable.getOutline(paramOutline);
  }
  
  protected final boolean isCompatTintEnabled()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT == 21)
    {
      Drawable localDrawable = mDrawable;
      if ((!(localDrawable instanceof GradientDrawable)) && (!(localDrawable instanceof DrawableContainer)))
      {
        bool1 = bool2;
        if (!(localDrawable instanceof InsetDrawable)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  final DrawableWrapperDonut.DrawableWrapperState mutateConstantState()
  {
    return new DrawableWrapperStateLollipop(mState);
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2)
  {
    mDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void setTint(int paramInt)
  {
    if (isCompatTintEnabled())
    {
      super.setTint(paramInt);
      return;
    }
    mDrawable.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (isCompatTintEnabled())
    {
      super.setTintList(paramColorStateList);
      return;
    }
    mDrawable.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (isCompatTintEnabled())
    {
      super.setTintMode(paramMode);
      return;
    }
    mDrawable.setTintMode(paramMode);
  }
  
  private static final class DrawableWrapperStateLollipop
    extends DrawableWrapperDonut.DrawableWrapperState
  {
    DrawableWrapperStateLollipop(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new DrawableWrapperLollipop(this, paramResources);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableWrapperLollipop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */