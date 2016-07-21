package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.view.View;
import android.widget.ViewFlipper;
import com.linkedin.android.feed.utils.PulsatingView;
import com.linkedin.android.infra.RepeatingRunnable;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class UnfollowEducateFragment$4
  extends TrackingOnClickListener
{
  UnfollowEducateFragment$4(UnfollowEducateFragment paramUnfollowEducateFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = this$0.pulsingButton;
    isAnimating = false;
    if (pulsingRunnable != null) {
      pulsingRunnable.stop();
    }
    paramView.invalidate();
    this$0.viewFlipper.showNext();
    UnfollowEducateFragment.access$200(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */