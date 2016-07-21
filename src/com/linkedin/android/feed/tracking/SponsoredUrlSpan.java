package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.spans.UrlSpan;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public class SponsoredUrlSpan
  extends UrlSpan
{
  private final FragmentComponent fragmentComponent;
  private final Update update;
  
  public SponsoredUrlSpan(String paramString, Update paramUpdate, FragmentComponent paramFragmentComponent, TrackingEventBuilder... paramVarArgs)
  {
    super(paramString, paramUpdate, paramFragmentComponent, paramVarArgs);
    update = paramUpdate;
    fragmentComponent = paramFragmentComponent;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(fragmentComponent.tracker().getCurrentPageInstance()), fragmentComponent, update.tracking, "viewContent");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.SponsoredUrlSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */