package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.entities.shared.MiniJobOnClickListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$7
  extends MiniJobOnClickListener
{
  FeedTracking$7(MiniJob paramMiniJob, FragmentComponent paramFragmentComponent1, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent2, Update paramVarArgs)
  {
    super(paramMiniJob, paramFragmentComponent1, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, "viewJob");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */