package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.feed.shared.articleviewer.ShareArticleOnClickListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$8
  extends ShareArticleOnClickListener
{
  FeedTracking$8(String paramString1, String paramString2, String paramString3, String paramString4, Update paramUpdate1, FragmentComponent paramFragmentComponent1, String paramString5, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent2, Update paramVarArgs)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramUpdate1, paramFragmentComponent1, paramString5, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, "viewContent");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */