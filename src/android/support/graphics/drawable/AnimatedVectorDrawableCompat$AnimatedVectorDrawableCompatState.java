package android.support.graphics.drawable;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

final class AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState
  extends Drawable.ConstantState
{
  ArrayList<Animator> mAnimators;
  int mChangingConfigurations;
  ArrayMap<Animator, String> mTargetNameMap;
  VectorDrawableCompat mVectorDrawable;
  
  public final int getChangingConfigurations()
  {
    return mChangingConfigurations;
  }
  
  public final Drawable newDrawable()
  {
    throw new IllegalStateException("No constant state support for SDK < 23.");
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    throw new IllegalStateException("No constant state support for SDK < 23.");
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */