package com.linkedin.android.entities.viewmodels.cards;

import android.view.View;
import com.linkedin.android.entities.viewholders.EntitySingleCardViewHolder;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class EntitySingleCardViewModel
  extends EntityBaseCardViewModel<EntitySingleCardViewHolder>
{
  public EntityItemViewModel itemViewModel;
  public TrackingClosure onPeopleInCommonClick;
  public CharSequence peopleInCommonCaption;
  public ImageModel peopleInCommonImage1;
  public TrackingClosure viewAllClosure;
  public String viewAllText;
  
  public final ViewHolderCreator<EntitySingleCardViewHolder> getCreator()
  {
    return EntitySingleCardViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.EntitySingleCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */