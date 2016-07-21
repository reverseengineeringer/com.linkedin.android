package com.linkedin.android.feed.utils.animations;

import android.animation.Animator;
import android.support.v7.widget.RecyclerView;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

final class FeedAnimationHelper$3
  extends DefaultAnimatorListener
{
  FeedAnimationHelper$3(FeedAnimationHelper paramFeedAnimationHelper) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this$0.feedAnimationListener.onAnimateRecyclerViewUpDone();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this$0.recyclerView.setAlpha(1.0F);
    this$0.recyclerView.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.animations.FeedAnimationHelper.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */