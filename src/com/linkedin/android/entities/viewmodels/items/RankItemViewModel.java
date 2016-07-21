package com.linkedin.android.entities.viewmodels.items;

import com.linkedin.android.entities.viewholders.RankItemViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class RankItemViewModel
  extends ViewModel<RankItemViewHolder>
{
  public String caption;
  public CharSequence description;
  public String rank;
  
  public final ViewHolderCreator<RankItemViewHolder> getCreator()
  {
    return RankItemViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.RankItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */