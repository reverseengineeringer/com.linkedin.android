package com.linkedin.android.entities.viewmodels;

import android.view.View;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class EntityTopCardViewModel$1
  extends TrackingOnClickListener
{
  EntityTopCardViewModel$1(EntityTopCardViewModel paramEntityTopCardViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.onPrimaryButtonClick.apply(Boolean.valueOf(false));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.EntityTopCardViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */