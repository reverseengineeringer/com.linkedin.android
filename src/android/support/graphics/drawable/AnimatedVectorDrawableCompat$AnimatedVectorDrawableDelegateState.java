package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState
  extends Drawable.ConstantState
{
  private final Drawable.ConstantState mDelegateState;
  
  public AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
  {
    mDelegateState = paramConstantState;
  }
  
  public final boolean canApplyTheme()
  {
    return mDelegateState.canApplyTheme();
  }
  
  public final int getChangingConfigurations()
  {
    return mDelegateState.getChangingConfigurations();
  }
  
  public final Drawable newDrawable()
  {
    AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((byte)0);
    mDelegateDrawable = mDelegateState.newDrawable();
    mDelegateDrawable.setCallback(AnimatedVectorDrawableCompat.access$100(localAnimatedVectorDrawableCompat));
    return localAnimatedVectorDrawableCompat;
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((byte)0);
    mDelegateDrawable = mDelegateState.newDrawable(paramResources);
    mDelegateDrawable.setCallback(AnimatedVectorDrawableCompat.access$100(localAnimatedVectorDrawableCompat));
    return localAnimatedVectorDrawableCompat;
  }
  
  public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
  {
    AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((byte)0);
    mDelegateDrawable = mDelegateState.newDrawable(paramResources, paramTheme);
    mDelegateDrawable.setCallback(AnimatedVectorDrawableCompat.access$100(localAnimatedVectorDrawableCompat));
    return localAnimatedVectorDrawableCompat;
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */