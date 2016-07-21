package com.linkedin.android.growth.login.prereg;

import android.animation.Animator;
import android.view.View;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

final class PreRegBaseFragmentViewModel$1
  extends DefaultAnimatorListener
{
  PreRegBaseFragmentViewModel$1(PreRegBaseFragmentViewModel paramPreRegBaseFragmentViewModel, View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    val$view.setVisibility(4);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    val$view.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegBaseFragmentViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */