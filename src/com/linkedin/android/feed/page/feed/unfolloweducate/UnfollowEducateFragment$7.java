package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.animation.Animator;
import android.view.View;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

final class UnfollowEducateFragment$7
  extends DefaultAnimatorListener
{
  UnfollowEducateFragment$7(UnfollowEducateFragment paramUnfollowEducateFragment) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    paramAnimator.removeAllListeners();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this$0.controlPanelOverlay.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */