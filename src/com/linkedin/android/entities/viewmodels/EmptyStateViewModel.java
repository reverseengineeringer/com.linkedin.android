package com.linkedin.android.entities.viewmodels;

import android.graphics.drawable.Drawable;
import com.linkedin.android.entities.viewholders.EmptyStateViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class EmptyStateViewModel
  extends ViewModel<EmptyStateViewHolder>
{
  public Drawable image;
  public String message;
  
  public final ViewHolderCreator<EmptyStateViewHolder> getCreator()
  {
    return EmptyStateViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.EmptyStateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */