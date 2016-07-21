package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.entities.shared.MiniCompanyOnClickListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

final class FeedTracking$1
  extends MiniCompanyOnClickListener
{
  FeedTracking$1(MiniCompany paramMiniCompany, ActivityComponent paramActivityComponent, String paramString1, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, String paramString2, FragmentComponent paramFragmentComponent, TrackingData paramVarArgs)
  {
    super(paramMiniCompany, paramActivityComponent, paramString1, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (val$controlName.equals("actor"))
    {
      FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$trackingData, "viewCompany");
      return;
    }
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$trackingData, "viewCompanyPic");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */