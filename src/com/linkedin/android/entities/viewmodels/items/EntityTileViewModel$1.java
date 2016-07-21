package com.linkedin.android.entities.viewmodels.items;

import android.view.View;
import com.linkedin.android.entities.viewholders.EntityTileViewHolder;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class EntityTileViewModel$1
  extends TrackingOnClickListener
{
  EntityTileViewModel$1(EntityTileViewModel paramEntityTileViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, EntityTileViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.onPrimaryClick.apply(val$holder.icon);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.EntityTileViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */