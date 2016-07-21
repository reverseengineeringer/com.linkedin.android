package com.linkedin.android.entities.viewmodels.items;

import com.linkedin.android.entities.viewholders.EmployeeQuoteItemViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class EmployeeQuoteItemViewModel
  extends ViewModel<EmployeeQuoteItemViewHolder>
{
  public String body;
  public EntityItemViewModel employee;
  
  public final ViewHolderCreator<EmployeeQuoteItemViewHolder> getCreator()
  {
    return EmployeeQuoteItemViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.EmployeeQuoteItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */