package com.linkedin.android.feed.page.feed.easteregg;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

final class FeedEasterEggFragment$1
  implements View.OnClickListener
{
  FeedEasterEggFragment$1(FeedEasterEggFragment paramFeedEasterEggFragment) {}
  
  public final void onClick(View paramView)
  {
    if (FeedEasterEggFragment.access$000(this$0).get() % 20 == 0) {
      FeedEasterEggFragment.access$100(this$0);
    }
    if (FeedEasterEggFragment.access$000(this$0).incrementAndGet() <= 10) {
      FeedEasterEggFragment.access$200(this$0, 2131231211);
    }
    for (;;)
    {
      int i = FeedEasterEggFragment.access$300(this$0).nextInt(2);
      FeedEasterEggFragment.access$400(this$0, i + 1);
      return;
      if (FeedEasterEggFragment.access$000(this$0).get() <= 20) {
        FeedEasterEggFragment.access$200(this$0, 2131231214);
      } else {
        FeedEasterEggFragment.access$200(this$0, 2131231210);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */