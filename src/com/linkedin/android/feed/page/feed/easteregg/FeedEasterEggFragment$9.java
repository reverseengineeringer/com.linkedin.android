package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import java.util.ArrayList;

final class FeedEasterEggFragment$9
  extends DefaultAnimatorListener
{
  FeedEasterEggFragment$9(FeedEasterEggFragment paramFeedEasterEggFragment, TextView paramTextView, AnimatorSet paramAnimatorSet) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if ((this$0.container != null) && (val$bonusScore.getParent() != null))
    {
      this$0.container.removeView(val$bonusScore);
      FeedEasterEggFragment.access$1302(this$0, FeedEasterEggFragment.access$1300(this$0) + 1000.0D);
      FeedEasterEggFragment.access$1000(this$0);
    }
    FeedEasterEggFragment.access$600(this$0).remove(val$moveToScore);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */