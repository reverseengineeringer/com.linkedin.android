package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.animation.AnimatorSet;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ViewFlipper;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class UnfollowEducateFragment$8
  extends TrackingOnClickListener
{
  UnfollowEducateFragment$8(UnfollowEducateFragment paramUnfollowEducateFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (!UnfollowEducateFragment.access$500(this$0)) {
      this$0.unfollowList.setVisibility(8);
    }
    UnfollowEducateFragment.access$600(this$0).end();
    UnfollowEducateFragment.access$700(this$0);
    this$0.viewFlipper.showNext();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFragment.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */