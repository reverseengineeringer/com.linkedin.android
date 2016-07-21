package com.linkedin.android.growth.login.phoneverification;

import android.view.View.OnClickListener;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class CountryNameDialingCodeViewModel
  extends ViewModel<CountryNameDialingCodeViewHolder>
{
  public String countryName;
  public String dialingCode;
  public View.OnClickListener listener;
  
  public final ViewHolderCreator<CountryNameDialingCodeViewHolder> getCreator()
  {
    return CountryNameDialingCodeViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.CountryNameDialingCodeViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */