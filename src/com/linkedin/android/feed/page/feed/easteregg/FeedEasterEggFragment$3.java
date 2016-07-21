package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import java.util.ArrayList;

final class FeedEasterEggFragment$3
  extends DefaultAnimatorListener
{
  FeedEasterEggFragment$3(FeedEasterEggFragment paramFeedEasterEggFragment, View paramView, ValueAnimator paramValueAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if ((this$0.container != null) && (val$creditsBubble.getParent() != null)) {
      this$0.container.removeView(val$creditsBubble);
    }
    FeedEasterEggFragment.access$600(this$0).remove(val$fallAnimation);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */