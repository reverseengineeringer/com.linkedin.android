package com.linkedin.android.entities.viewmodels;

import android.view.View;
import com.linkedin.android.entities.shared.AutofitTextButton;
import com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class EntityDetailedTopCardViewModel$6
  extends TrackingOnClickListener
{
  EntityDetailedTopCardViewModel$6(EntityDetailedTopCardViewModel paramEntityDetailedTopCardViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, EntityDetailedTopCardViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = this$0;
    boolean bool;
    AutofitTextButton localAutofitTextButton;
    if (!this$0.isSecondaryButtonClicked)
    {
      bool = true;
      isSecondaryButtonClicked = bool;
      this$0.onSecondaryButtonClick.apply(Boolean.valueOf(this$0.isSecondaryButtonClicked));
      localAutofitTextButton = val$viewHolder.secondaryButton;
      if (!this$0.isSecondaryButtonClicked) {
        break label85;
      }
    }
    label85:
    for (paramView = this$0.secondaryButtonClickedText;; paramView = this$0.secondaryButtonDefaultText)
    {
      localAutofitTextButton.setText(paramView);
      return;
      bool = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */