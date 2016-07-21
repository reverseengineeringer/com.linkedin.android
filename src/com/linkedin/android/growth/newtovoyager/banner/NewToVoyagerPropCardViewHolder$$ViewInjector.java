package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class NewToVoyagerPropCardViewHolder$$ViewInjector<T extends NewToVoyagerPropCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    headingTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756034, "field 'headingTextView'"), 2131756034, "field 'headingTextView'"));
    subheadingTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756035, "field 'subheadingTextView'"), 2131756035, "field 'subheadingTextView'"));
    swipeInstructionView = ((View)paramFinder.findRequiredView(paramObject, 2131756074, "field 'swipeInstructionView'"));
    swipeArrow = ((View)paramFinder.findRequiredView(paramObject, 2131756075, "field 'swipeArrow'"));
    bannerView = ((NewToVoyagerPropCardView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756031, "field 'bannerView'"), 2131756031, "field 'bannerView'"));
  }
  
  public void reset(T paramT)
  {
    headingTextView = null;
    subheadingTextView = null;
    swipeInstructionView = null;
    swipeArrow = null;
    bannerView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerPropCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */