package com.linkedin.android.feed.page.feed;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;

final class FeedFragment$3
  implements RecyclerView.OnItemTouchListener
{
  FeedFragment$3(FeedFragment paramFeedFragment) {}
  
  public final boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (FeedFragment.access$1000(this$0))
    {
      paramRecyclerView.requestDisallowInterceptTouchEvent(true);
      return true;
    }
    paramRecyclerView.requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public final void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public final void onTouchEvent$606727f8(MotionEvent paramMotionEvent) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */