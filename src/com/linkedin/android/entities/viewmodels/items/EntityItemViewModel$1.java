package com.linkedin.android.entities.viewmodels.items;

import android.view.View;
import com.linkedin.android.entities.viewholders.EntityItemViewHolder;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class EntityItemViewModel$1
  extends TrackingOnClickListener
{
  EntityItemViewModel$1(EntityItemViewModel paramEntityItemViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, EntityItemViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = this$0;
    if (!this$0.isCtaButtonClicked) {}
    for (boolean bool = true;; bool = false)
    {
      isCtaButtonClicked = bool;
      this$0.toggleButtonClicked(val$viewHolder.ctaButton, val$viewHolder.ctaClickedButton, this$0.isCtaButtonClicked);
      this$0.onCtaButtonClick.apply(Boolean.valueOf(this$0.isCtaButtonClicked));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.EntityItemViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */