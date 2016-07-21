package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class DrawableWrapperEclair
  extends DrawableWrapperDonut
{
  DrawableWrapperEclair(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  DrawableWrapperEclair(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }
  
  final DrawableWrapperDonut.DrawableWrapperState mutateConstantState()
  {
    return new DrawableWrapperStateEclair(mState);
  }
  
  protected final Drawable newDrawableFromState(Drawable.ConstantState paramConstantState, Resources paramResources)
  {
    return paramConstantState.newDrawable(paramResources);
  }
  
  private static final class DrawableWrapperStateEclair
    extends DrawableWrapperDonut.DrawableWrapperState
  {
    DrawableWrapperStateEclair(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState)
    {
      super();
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new DrawableWrapperEclair(this, paramResources);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableWrapperEclair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */