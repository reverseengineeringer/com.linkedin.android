package com.linkedin.android.growth.newtovoyager.organic;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class NewToVoyagerIntroWelcomeFragmentViewHolder$$ViewInjector<T extends NewToVoyagerIntroWelcomeFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    introTitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756041, "field 'introTitle'"), 2131756041, "field 'introTitle'"));
    introSubtitle = ((View)paramFinder.findRequiredView(paramObject, 2131756042, "field 'introSubtitle'"));
    skipButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756040, "field 'skipButton'"), 2131756040, "field 'skipButton'"));
    leftArrow = ((View)paramFinder.findRequiredView(paramObject, 2131756044, "field 'leftArrow'"));
    directionLayout = ((View)paramFinder.findRequiredView(paramObject, 2131756043, "field 'directionLayout'"));
  }
  
  public void reset(T paramT)
  {
    introTitle = null;
    introSubtitle = null;
    skipButton = null;
    leftArrow = null;
    directionLayout = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroWelcomeFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */