package com.linkedin.android.entities.viewmodels.items;

import android.view.View;
import com.linkedin.android.entities.viewholders.EntityItemViewHolder;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class EntityItemViewModel$2
  extends TrackingOnClickListener
{
  EntityItemViewModel$2(EntityItemViewModel paramEntityItemViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, EntityItemViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.onRowClick.apply(val$viewHolder.image);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.EntityItemViewModel.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */