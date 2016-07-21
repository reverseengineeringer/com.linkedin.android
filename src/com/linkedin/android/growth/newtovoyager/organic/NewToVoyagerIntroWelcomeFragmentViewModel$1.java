package com.linkedin.android.growth.newtovoyager.organic;

import android.animation.Animator;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

final class NewToVoyagerIntroWelcomeFragmentViewModel$1
  extends DefaultAnimatorListener
{
  NewToVoyagerIntroWelcomeFragmentViewModel$1(NewToVoyagerIntroWelcomeFragmentViewModel paramNewToVoyagerIntroWelcomeFragmentViewModel) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator.setStartDelay(val$startDelayInMs);
    paramAnimator.start();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroWelcomeFragmentViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */