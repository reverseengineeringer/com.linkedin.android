package com.linkedin.android.feed.page.feed;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class FeedFragment$20
  implements View.OnTouchListener
{
  FeedFragment$20(FeedFragment paramFeedFragment) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      paramView.setPressed(false);
      paramView.removeCallbacks(FeedFragment.access$2300(this$0));
      FeedFragment.access$202(this$0, false);
    }
    do
    {
      return true;
      paramView.setPressed(true);
      FeedFragment.access$202(this$0, true);
      paramView.postDelayed(FeedFragment.access$2300(this$0), 8000L);
      return true;
      paramView.setPressed(false);
      paramView.removeCallbacks(FeedFragment.access$2300(this$0));
      FeedFragment.access$202(this$0, false);
    } while (FeedFragment.access$2400(this$0));
    paramView.performClick();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */