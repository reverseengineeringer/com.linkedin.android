package com.linkedin.android.growth.newtovoyager.banner;

import android.animation.Animator;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

final class NewToVoyagerPropCardViewListener$1
  extends DefaultAnimatorListener
{
  NewToVoyagerPropCardViewListener$1(NewToVoyagerPropCardViewListener paramNewToVoyagerPropCardViewListener) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator.setStartDelay(val$startDelayInMs);
    paramAnimator.start();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerPropCardViewListener.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */