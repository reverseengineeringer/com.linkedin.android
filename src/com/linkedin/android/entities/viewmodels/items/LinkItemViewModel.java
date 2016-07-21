package com.linkedin.android.entities.viewmodels.items;

import android.view.View.OnClickListener;
import com.linkedin.android.entities.viewholders.LinkItemViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class LinkItemViewModel
  extends ViewModel<LinkItemViewHolder>
{
  public View.OnClickListener clickListener;
  public String linkText;
  
  public final ViewHolderCreator<LinkItemViewHolder> getCreator()
  {
    return LinkItemViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.LinkItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */