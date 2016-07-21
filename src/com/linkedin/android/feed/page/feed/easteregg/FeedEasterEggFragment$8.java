package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import java.util.ArrayList;

final class FeedEasterEggFragment$8
  extends DefaultAnimatorListener
{
  FeedEasterEggFragment$8(FeedEasterEggFragment paramFeedEasterEggFragment, View paramView, AnimatorSet paramAnimatorSet) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    FeedEasterEggFragment.access$900(this$0, val$head, true);
    FeedEasterEggFragment.access$600(this$0).remove(val$moveToCenter);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */