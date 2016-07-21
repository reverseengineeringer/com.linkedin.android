package com.linkedin.android.feed.page.feed;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;

final class FeedFragment$4
  implements RecyclerView.OnChildAttachStateChangeListener
{
  FeedFragment$4(FeedFragment paramFeedFragment) {}
  
  public final void onChildViewAttachedToWindow(View paramView)
  {
    if ((paramView.getId() == 2131755870) && (!FeedFragment.access$500(this$0)))
    {
      this$0.recyclerView.stopScroll();
      FeedFragment.access$1100(this$0, paramView);
    }
  }
  
  public final void onChildViewDetachedFromWindow(View paramView) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */