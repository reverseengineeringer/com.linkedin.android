package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import java.util.ArrayList;

final class FeedEasterEggFragment$7
  extends DefaultAnimatorListener
{
  FeedEasterEggFragment$7(FeedEasterEggFragment paramFeedEasterEggFragment, boolean paramBoolean, View paramView, AnimatorSet paramAnimatorSet) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (val$isBonusHead) {
      FeedEasterEggFragment.access$1200(this$0);
    }
    for (;;)
    {
      FeedEasterEggFragment.access$600(this$0).remove(val$popBubble);
      return;
      FeedEasterEggFragment.access$1100(this$0, val$head);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */