package com.linkedin.android.entities.viewmodels.cards;

import com.linkedin.android.entities.viewholders.MultiHeadlineCardViewHolder;
import com.linkedin.android.entities.viewmodels.items.EntityMultiHeadlineItemViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.TrackingClosure;
import java.util.ArrayList;
import java.util.List;

public final class MultiHeadlineCardViewModel
  extends EntityBaseCardViewModel<MultiHeadlineCardViewHolder>
{
  public boolean isExpanded;
  public final List<EntityMultiHeadlineItemViewModel> items = new ArrayList();
  public int multiHeadlineCardMaxPairsCollapsed;
  public TrackingClosure<Void, Void> onExpandButtonClick;
  
  public final ViewHolderCreator<MultiHeadlineCardViewHolder> getCreator()
  {
    return MultiHeadlineCardViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.MultiHeadlineCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */