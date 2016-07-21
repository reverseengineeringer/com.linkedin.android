package com.linkedin.android.feed.detail;

import com.linkedin.android.feed.events.LoadMoreEvent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;

final class FeedUpdateDetailFragment$3
  extends InfiniteScrollListener
{
  FeedUpdateDetailFragment$3(FeedUpdateDetailFragment paramFeedUpdateDetailFragment) {}
  
  public final void loadMore()
  {
    if ((FeedUpdateDetailFragment.access$400(this$0) != null) && (FeedUpdateDetailFragment.access$400(this$0).hasNextComments()) && (!FeedUpdateDetailFragment.access$500(this$0)) && (!FeedUpdateDetailFragment.access$600(this$0)))
    {
      FeedUpdateDetailFragment.access$502$74222c4(this$0);
      this$0.fragmentComponent.eventBus();
      Bus.publish(LoadMoreEvent.comments(1));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */