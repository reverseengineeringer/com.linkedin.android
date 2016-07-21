package com.linkedin.android.entities.viewmodels.items;

import com.linkedin.android.entities.viewholders.FooterItemViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class FooterItemViewModel
  extends ViewModel<FooterItemViewHolder>
{
  public String text;
  
  public final ViewHolderCreator<FooterItemViewHolder> getCreator()
  {
    return FooterItemViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.FooterItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */