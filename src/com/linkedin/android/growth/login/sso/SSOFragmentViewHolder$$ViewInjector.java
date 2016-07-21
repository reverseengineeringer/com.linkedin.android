package com.linkedin.android.growth.login.sso;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SSOFragmentViewHolder$$ViewInjector<T extends SSOFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    profilePicture = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756292, "field 'profilePicture'"), 2131756292, "field 'profilePicture'"));
    plusIcon = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756293, "field 'plusIcon'"), 2131756293, "field 'plusIcon'"));
    continueButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756291, "field 'continueButton'"), 2131756291, "field 'continueButton'"));
    signIn = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756295, "field 'signIn'"), 2131756295, "field 'signIn'"));
    joinNow = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756296, "field 'joinNow'"), 2131756296, "field 'joinNow'"));
  }
  
  public void reset(T paramT)
  {
    profilePicture = null;
    plusIcon = null;
    continueButton = null;
    signIn = null;
    joinNow = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.sso.SSOFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */