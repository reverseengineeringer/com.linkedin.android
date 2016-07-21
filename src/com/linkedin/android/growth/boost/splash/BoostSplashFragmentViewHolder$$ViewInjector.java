package com.linkedin.android.growth.boost.splash;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class BoostSplashFragmentViewHolder$$ViewInjector<T extends BoostSplashFragmentViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    messageHeading = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755987, "field 'messageHeading'"), 2131755987, "field 'messageHeading'"));
    messageBody = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755988, "field 'messageBody'"), 2131755988, "field 'messageBody'"));
    messageFooter = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755989, "field 'messageFooter'"), 2131755989, "field 'messageFooter'"));
  }
  
  public void reset(T paramT)
  {
    messageHeading = null;
    messageBody = null;
    messageFooter = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.splash.BoostSplashFragmentViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */