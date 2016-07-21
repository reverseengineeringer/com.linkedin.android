package com.linkedin.android.feed.page.feed;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class FeedFragment$18
  implements View.OnTouchListener
{
  FeedFragment$18(FeedFragment paramFeedFragment) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      paramView.setPressed(false);
      paramView.removeCallbacks(FeedFragment.access$2300(this$0));
      FeedFragment.access$002(this$0, false);
    }
    do
    {
      do
      {
        return true;
        paramView.setPressed(true);
        FeedFragment.access$002(this$0, true);
      } while (!FeedFragment.access$100(this$0));
      paramView.postDelayed(FeedFragment.access$2300(this$0), 5000L);
      return true;
      paramView.setPressed(false);
      paramView.removeCallbacks(FeedFragment.access$2300(this$0));
      FeedFragment.access$002(this$0, false);
    } while (FeedFragment.access$2400(this$0));
    paramView.performClick();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */