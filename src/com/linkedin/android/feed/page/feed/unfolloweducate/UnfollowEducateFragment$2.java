package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ViewFlipper;

final class UnfollowEducateFragment$2
  implements Animation.AnimationListener
{
  UnfollowEducateFragment$2(UnfollowEducateFragment paramUnfollowEducateFragment) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    UnfollowEducateFragment.access$100(this$0);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this$0.viewFlipper.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */