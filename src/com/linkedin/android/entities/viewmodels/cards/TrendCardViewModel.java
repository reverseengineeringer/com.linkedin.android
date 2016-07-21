package com.linkedin.android.entities.viewmodels.cards;

import android.util.Pair;
import com.linkedin.android.entities.viewholders.TrendCardViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public final class TrendCardViewModel
  extends EntityBaseCardViewModel<TrendCardViewHolder>
{
  public String footerText;
  public String graphEndDate;
  public Pair<Integer, Integer> graphHighlightRange;
  public int[] graphMarkers;
  public String graphStartDate;
  public String graphYAxisBottom;
  public String graphYAxisTop;
  public long[] graphYValues;
  public String header;
  public CharSequence insightText;
  
  public final ViewHolderCreator<TrendCardViewHolder> getCreator()
  {
    return TrendCardViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.TrendCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */