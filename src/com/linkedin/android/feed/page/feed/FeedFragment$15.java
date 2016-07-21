package com.linkedin.android.feed.page.feed;

import android.support.v4.widget.SwipeRefreshLayout;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesManager;
import com.linkedin.android.feed.shared.PullToRefreshListener;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.litrackinglib.metric.Tracker;

final class FeedFragment$15
  extends PullToRefreshListener
{
  FeedFragment$15(FeedFragment paramFeedFragment, Tracker paramTracker, String paramString)
  {
    super(paramTracker, paramString);
  }
  
  public final void onRefresh()
  {
    super.onRefresh();
    if (FeedFragment.access$1900(this$0).shouldShowNewUpdatesPill())
    {
      FeedFragment.access$2000(this$0, FeedTracking.getNUPTrackingEventForSwipeToRefresh(this$0.applicationComponent));
      this$0.swipeRefreshLayout.setRefreshing(false);
    }
    for (;;)
    {
      FeedFragment.access$2100(this$0);
      return;
      this$0.swipeRefreshLayout.setRefreshing(true);
      this$0.hardRefreshFeed();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */