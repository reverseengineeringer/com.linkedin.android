package com.linkedin.android.growth.boost.error;

import android.view.View.OnClickListener;
import android.widget.Button;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class BoostErrorFragmentViewModel
  extends ViewModel<BoostErrorFragmentViewHolder>
{
  public View.OnClickListener continueListener;
  
  public final ViewHolderCreator<BoostErrorFragmentViewHolder> getCreator()
  {
    return BoostErrorFragmentViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$6245ffb7(BoostErrorFragmentViewHolder paramBoostErrorFragmentViewHolder)
  {
    continueButton.setOnClickListener(continueListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.error.BoostErrorFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */