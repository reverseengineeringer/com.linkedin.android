package com.linkedin.android.feed.promptresponselist;

import android.support.v4.widget.SwipeRefreshLayout;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.feed.shared.PullToRefreshListener;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.litrackinglib.metric.Tracker;

final class FeedPromptResponseListFragment$1
  extends PullToRefreshListener
{
  FeedPromptResponseListFragment$1(FeedPromptResponseListFragment paramFeedPromptResponseListFragment, Tracker paramTracker, String paramString, SwipeRefreshLayout paramSwipeRefreshLayout)
  {
    super(paramTracker, paramString);
  }
  
  public final void onRefresh()
  {
    super.onRefresh();
    val$swipeRefreshLayout.setRefreshing(true);
    String str = RUMHelper.pageInitRefresh(this$0);
    FeedPromptResponseListFragment.access$300(this$0).refreshFeed(Tracker.createPageInstanceHeader(this$0.getPageInstance()), FeedRouteUtils.getPromptResponseUpdatesRoute(this$0.fragmentComponent, FeedPromptResponseListFragment.access$000(this$0), FeedPromptResponseListFragment.access$100(this$0), FeedPromptResponseListFragment.access$200(this$0)), str);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */