package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.concurrent.atomic.AtomicInteger;

final class FeedEasterEggFragment$5$1
  implements View.OnClickListener
{
  FeedEasterEggFragment$5$1(FeedEasterEggFragment.5 param5) {}
  
  public final void onClick(View paramView)
  {
    this$1.val$head.setOnClickListener(null);
    this$1.val$head.setTag(Integer.valueOf(2));
    this$1.val$fallAnimation.cancel();
    FeedEasterEggFragment.access$700(this$1.this$0).incrementAndGet();
    if (this$1.val$isBonusHead)
    {
      FeedEasterEggFragment.access$800(this$1.this$0, this$1.val$head);
      return;
    }
    FeedEasterEggFragment.access$900(this$1.this$0, this$1.val$head, false);
    FeedEasterEggFragment.access$1000(this$1.this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.5.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */