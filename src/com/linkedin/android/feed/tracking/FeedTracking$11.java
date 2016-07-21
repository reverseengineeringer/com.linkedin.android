package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.feed.shared.FeedViralUpdateOnClickListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$11
  extends FeedViralUpdateOnClickListener
{
  FeedTracking$11(String paramString1, Update paramUpdate, FragmentComponent paramFragmentComponent1, int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent2, String paramVarArgs)
  {
    super(paramString1, paramUpdate, paramFragmentComponent1, paramInt, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramString2, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, update.tracking, val$sponsoredTrackingAction);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */