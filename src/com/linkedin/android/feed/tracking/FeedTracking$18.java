package com.linkedin.android.feed.tracking;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

final class FeedTracking$18
  implements View.OnClickListener
{
  FeedTracking$18(FragmentComponent paramFragmentComponent, Update paramUpdate, String paramString) {}
  
  public final void onClick(View paramView)
  {
    new ControlInteractionEvent(val$fragmentComponent.tracker(), "expand", ControlType.TEXTFIELD, InteractionType.SHORT_PRESS).send();
    if ((val$update != null) && (val$update.tracking != null))
    {
      if (FeedTracking.isSponsored(val$update.tracking)) {
        FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, val$actionType);
      }
      FeedTracking.trackFAE(val$fragmentComponent.tracker(), "expand", ActionCategory.EXPAND, val$actionType, val$update.tracking, val$update.urn, val$fragmentComponent);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */