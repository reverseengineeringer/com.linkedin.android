package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class NewToVoyagerFeedCardViewHolder$$ViewInjector<T extends NewToVoyagerFeedCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    promoImage = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756033, "field 'promoImage'"), 2131756033, "field 'promoImage'"));
    headingTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756034, "field 'headingTextView'"), 2131756034, "field 'headingTextView'"));
    continueButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756036, "field 'continueButton'"), 2131756036, "field 'continueButton'"));
    notNowButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756037, "field 'notNowButton'"), 2131756037, "field 'notNowButton'"));
  }
  
  public void reset(T paramT)
  {
    promoImage = null;
    headingTextView = null;
    continueButton = null;
    notNowButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */