package com.linkedin.android.entities.viewmodels;

import android.view.View;
import com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class EntityDetailedTopCardViewModel$7
  extends TrackingOnClickListener
{
  EntityDetailedTopCardViewModel$7(EntityDetailedTopCardViewModel paramEntityDetailedTopCardViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, EntityDetailedTopCardViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.onLogoClick.apply(val$viewHolder.iconView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */