package com.linkedin.android.growth.newtovoyager.organic;

import android.animation.Animator;
import android.view.View;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

final class NewToVoyagerIntroBaseFragmentViewModel$1
  extends DefaultAnimatorListener
{
  private float pivotY;
  
  NewToVoyagerIntroBaseFragmentViewModel$1(NewToVoyagerIntroBaseFragmentViewModel paramNewToVoyagerIntroBaseFragmentViewModel, View paramView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    val$view.setPivotY(pivotY);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    val$view.setPivotY(pivotY);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    pivotY = val$view.getPivotY();
    val$view.setPivotY(0.0F);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroBaseFragmentViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */