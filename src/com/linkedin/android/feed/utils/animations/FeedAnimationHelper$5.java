package com.linkedin.android.feed.utils.animations;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.linkedin.android.feed.FeedLoadingViewHolder;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;

public final class FeedAnimationHelper$5
  extends DefaultAnimatorListener
{
  public FeedAnimationHelper$5(FeedAnimationHelper paramFeedAnimationHelper, ObjectAnimator paramObjectAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    val$progressBarFadeInAnimation.start();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this$0.recyclerView.setVisibility(8);
    this$0.loadingViewHolder.text.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.animations.FeedAnimationHelper.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */