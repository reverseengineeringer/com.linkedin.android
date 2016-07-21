package com.linkedin.android.feed.utils.animations;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

final class FeedAnimationHelper$6
  extends DefaultAnimatorListener
{
  FeedAnimationHelper$6(FeedAnimationHelper paramFeedAnimationHelper) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this$0;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(recyclerView, View.TRANSLATION_Y, new float[] { screenHeight, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.addListener(new FeedAnimationHelper.3(paramAnimator));
    localObjectAnimator.start();
    this$0.feedAnimationListener.onDismissLoadingViewDone();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.animations.FeedAnimationHelper.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */