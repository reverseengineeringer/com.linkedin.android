package com.linkedin.android.entities.viewmodels.cards;

import android.view.View;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class ParagraphCardViewModel$1
  extends TrackingOnClickListener
{
  ParagraphCardViewModel$1(ParagraphCardViewModel paramParagraphCardViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.onExpandButtonClick.apply(null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */