package com.linkedin.android.feed.endor.ui;

import com.linkedin.android.tracking.v2.event.PageViewEvent;

final class FeedAdapter$1
  implements Runnable
{
  FeedAdapter$1(FeedAdapter paramFeedAdapter) {}
  
  public final void run()
  {
    if (FeedAdapter.access$000(this$0) != null)
    {
      FeedAdapter.access$000(this$0).send();
      FeedAdapter.access$002$5e79ba79(this$0);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */