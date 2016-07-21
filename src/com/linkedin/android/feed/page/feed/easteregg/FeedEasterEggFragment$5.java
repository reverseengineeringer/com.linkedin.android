package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class FeedEasterEggFragment$5
  extends DefaultAnimatorListener
{
  FeedEasterEggFragment$5(FeedEasterEggFragment paramFeedEasterEggFragment, View paramView, ValueAnimator paramValueAnimator, boolean paramBoolean) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (((Integer)val$head.getTag()).intValue() == 1) {
      FeedEasterEggFragment.access$1100(this$0, val$head);
    }
    FeedEasterEggFragment.access$600(this$0).remove(val$fallAnimation);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    val$head.setVisibility(0);
    val$head.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        val$head.setOnClickListener(null);
        val$head.setTag(Integer.valueOf(2));
        val$fallAnimation.cancel();
        FeedEasterEggFragment.access$700(this$0).incrementAndGet();
        if (val$isBonusHead)
        {
          FeedEasterEggFragment.access$800(this$0, val$head);
          return;
        }
        FeedEasterEggFragment.access$900(this$0, val$head, false);
        FeedEasterEggFragment.access$1000(this$0);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */