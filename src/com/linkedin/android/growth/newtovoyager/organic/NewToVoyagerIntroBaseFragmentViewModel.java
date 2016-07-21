package com.linkedin.android.growth.newtovoyager.organic;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.linkedin.android.growth.login.prereg.PreRegBaseFragmentViewModel;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import com.linkedin.android.infra.app.BaseViewHolder;

public abstract class NewToVoyagerIntroBaseFragmentViewModel<VH extends BaseViewHolder>
  extends PreRegBaseFragmentViewModel<VH>
{
  static final PropertyValuesHolder EXPAND_HALF_Y = PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.5F, 1.0F });
  private static final PropertyValuesHolder EXPAND_X = PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.0F, 1.1F, 1.0F });
  private static final PropertyValuesHolder EXPAND_Y = PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.0F, 1.1F, 1.0F });
  
  protected static ObjectAnimator fadeIn(View paramView)
  {
    return ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L);
  }
  
  protected static ObjectAnimator moveVertically(View paramView)
  {
    return ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F }).setDuration(1000L);
  }
  
  protected final ObjectAnimator expandElastically(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { EXPAND_X, EXPAND_Y }).setDuration(500L);
    localObjectAnimator.addListener(createSetVisibleOnStartListener(paramView));
    return localObjectAnimator;
  }
  
  protected abstract void resetViews();
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroBaseFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */