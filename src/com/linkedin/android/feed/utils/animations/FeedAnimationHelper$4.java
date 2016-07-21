package com.linkedin.android.feed.utils.animations;

import android.animation.Animator;
import android.os.Handler;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

public final class FeedAnimationHelper$4
  extends DefaultAnimatorListener
{
  public FeedAnimationHelper$4(FeedAnimationHelper paramFeedAnimationHelper) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this$0.animationHandler.postDelayed(this$0.waitForFeedAnimationRunnable, 2000L);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.animations.FeedAnimationHelper.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */