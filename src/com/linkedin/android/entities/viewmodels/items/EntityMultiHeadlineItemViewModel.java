package com.linkedin.android.entities.viewmodels.items;

import android.support.v4.util.Pair;
import android.view.View;
import com.linkedin.android.entities.viewholders.EntityMultiHeadlineItemViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class EntityMultiHeadlineItemViewModel
  extends ViewModel<EntityMultiHeadlineItemViewHolder>
{
  public Pair<String, String> headerBodyPair;
  public TrackingClosure<Void, Void> onBodyClick;
  
  public final ViewHolderCreator<EntityMultiHeadlineItemViewHolder> getCreator()
  {
    return EntityMultiHeadlineItemViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.EntityMultiHeadlineItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */