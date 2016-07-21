package com.linkedin.android.growth.login.prereg.people;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PreRegPeopleFragmentViewHolder$$ViewInjector<T extends PreRegPeopleFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    connectionContainer = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756211, "field 'connectionContainer'"), 2131756211, "field 'connectionContainer'"));
    horizontalDividerContainer = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756200, "field 'horizontalDividerContainer'"), 2131756200, "field 'horizontalDividerContainer'"));
    referralContainer = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756199, "field 'referralContainer'"), 2131756199, "field 'referralContainer'"));
    referral1Image = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756203, "field 'referral1Image'"), 2131756203, "field 'referral1Image'"));
    referral2Image = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756208, "field 'referral2Image'"), 2131756208, "field 'referral2Image'"));
  }
  
  public void reset(T paramT)
  {
    connectionContainer = null;
    horizontalDividerContainer = null;
    referralContainer = null;
    referral1Image = null;
    referral2Image = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.people.PreRegPeopleFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */