package com.linkedin.android.growth.login.prereg.people;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class PreRegPeopleFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<PreRegPeopleFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968861;
    }
  };
  @InjectView(2131756211)
  ViewGroup connectionContainer;
  @InjectView(2131756200)
  ViewGroup horizontalDividerContainer;
  @InjectView(2131756203)
  ImageView referral1Image;
  @InjectView(2131756208)
  ImageView referral2Image;
  @InjectView(2131756199)
  ViewGroup referralContainer;
  
  public PreRegPeopleFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.people.PreRegPeopleFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */