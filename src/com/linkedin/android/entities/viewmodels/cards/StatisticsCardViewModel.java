package com.linkedin.android.entities.viewmodels.cards;

import android.support.v4.util.Pair;
import com.linkedin.android.entities.viewholders.StatisticsCardViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.TrackingClosure;
import java.util.ArrayList;
import java.util.List;

public final class StatisticsCardViewModel
  extends EntityBaseCardViewModel<StatisticsCardViewHolder>
{
  public final List<Pair<String, String>> contentPairs = new ArrayList();
  public String header;
  public boolean isExpanded;
  public int maxRowsVisibleWhenCollapsed;
  public TrackingClosure<Void, Void> onExpandButtonClick;
  
  public final ViewHolderCreator<StatisticsCardViewHolder> getCreator()
  {
    return StatisticsCardViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.StatisticsCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */