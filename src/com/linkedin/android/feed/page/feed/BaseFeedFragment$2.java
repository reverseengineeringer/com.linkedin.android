package com.linkedin.android.feed.page.feed;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

final class BaseFeedFragment$2
  extends RecyclerView.OnScrollListener
{
  BaseFeedFragment$2(BaseFeedFragment paramBaseFeedFragment) {}
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (!this$0.isActive()) {}
    label62:
    do
    {
      return;
      this$0.loadMoreUpdatesIfNecessary();
      if (!paramRecyclerView.canScrollVertically(-1)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label62;
        }
        if (this$0.swipeRefreshLayout.isEnabled()) {
          break;
        }
        this$0.swipeRefreshLayout.setEnabled(true);
        return;
      }
    } while (!this$0.swipeRefreshLayout.isEnabled());
    this$0.swipeRefreshLayout.setEnabled(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.BaseFeedFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */