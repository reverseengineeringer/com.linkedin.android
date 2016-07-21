package com.linkedin.android.entities.viewmodels.items;

import com.linkedin.android.entities.viewholders.BarItemViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class BarItemViewModel
  extends ViewModel<BarItemViewHolder>
{
  public int barColor;
  public float barWeight;
  public CharSequence caption;
  public String value;
  
  public final ViewHolderCreator<BarItemViewHolder> getCreator()
  {
    return BarItemViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.BarItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */