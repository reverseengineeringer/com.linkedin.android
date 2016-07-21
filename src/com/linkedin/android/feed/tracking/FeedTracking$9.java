package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$9
  extends SponsoredLandingPageClickListener
{
  FeedTracking$9(FragmentComponent paramFragmentComponent1, Update paramUpdate1, String paramString1, String paramString2, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent2, Update paramUpdate2, String paramVarArgs)
  {
    super(paramFragmentComponent1, paramUpdate1, paramString1, paramString2, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, val$sponsoredTrackingAction);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */