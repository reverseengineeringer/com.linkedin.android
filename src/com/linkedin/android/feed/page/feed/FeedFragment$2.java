package com.linkedin.android.feed.page.feed;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.linkedin.android.feed.page.feed.hero.FeedHeroManager;
import com.linkedin.android.feed.utils.FeedShareHeaderManager;
import com.linkedin.android.logger.FeatureLog;

final class FeedFragment$2
  extends RecyclerView.OnScrollListener
{
  FeedFragment$2(FeedFragment paramFeedFragment) {}
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = 0;
    if (paramInt == 1) {
      FeatureLog.d(FeedFragment.TAG, "user interaction detected on feed", "Realtime Feed Updates");
    }
    do
    {
      FeedFragment.access$602$571b359f(this$0);
      do
      {
        return;
      } while ((paramInt != 0) || (FeedFragment.access$700(this$0)) || (!FeedFragment.access$500(this$0)));
      paramInt = i;
      if (com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(this$0.layoutManager)[0] == 0)
      {
        paramInt = i;
        if (paramRecyclerView.getChildAt(0).getTop() >= 0) {
          paramInt = 1;
        }
      }
    } while (paramInt == 0);
    FeedFragment.access$800(this$0).setShareActionsVisibility(true, true);
    FeedFragment.access$900(this$0).expandFeedHeroIfAvailable();
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((FeedFragment.access$400(this$0)) && (paramInt2 > 0)) {
      FeedFragment.access$402$571b359f(this$0);
    }
    paramRecyclerView = this$0;
    if (paramInt2 < 0) {}
    for (boolean bool = true;; bool = false)
    {
      FeedFragment.access$502(paramRecyclerView, bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */