package com.linkedin.android.entities.viewmodels;

import com.linkedin.android.entities.viewholders.TextViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class TextViewModel
  extends ViewModel<TextViewHolder>
{
  public CharSequence text;
  public int textStyleId;
  
  public final ViewHolderCreator<TextViewHolder> getCreator()
  {
    return TextViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.TextViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */