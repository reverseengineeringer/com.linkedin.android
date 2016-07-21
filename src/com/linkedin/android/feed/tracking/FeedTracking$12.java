package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.feed.shared.FeedUpdateOnClickListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$12
  extends FeedUpdateOnClickListener
{
  FeedTracking$12(Update paramUpdate, FragmentComponent paramFragmentComponent, int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, String paramVarArgs)
  {
    super(paramUpdate, paramFragmentComponent, paramInt, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramString1, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(fragmentComponent.tracker().getCurrentPageInstance()), fragmentComponent, update.tracking, val$sponsoredTrackingAction);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */