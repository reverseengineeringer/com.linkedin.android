package com.linkedin.android.entities.viewmodels.cards;

import android.view.View;
import com.linkedin.android.entities.viewholders.ParagraphCardViewHolder;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class ParagraphCardViewModel$3
  extends TrackingOnClickListener
{
  ParagraphCardViewModel$3(ParagraphCardViewModel paramParagraphCardViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, ParagraphCardViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    val$holder.body.expand(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */