package com.linkedin.android.growth.login.phoneverification;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class CountryNameDialingCodeViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<CountryNameDialingCodeViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968853;
    }
  };
  @InjectView(2131756173)
  TextView countryName;
  @InjectView(2131756174)
  TextView dialingCode;
  
  public CountryNameDialingCodeViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.CountryNameDialingCodeViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */