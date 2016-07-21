package com.linkedin.android.growth.abi.splash;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.ButterKnife.Finder;

public class MainAbiSplashFragment$$ViewInjector<T extends MainAbiSplashFragment>
  extends AbiSplashBaseFragment..ViewInjector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    super.inject(paramFinder, paramT, paramObject);
    topCardContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755967, null), 2131755967, "field 'topCardContainer'"));
    topCard = ((RelativeLayout)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131758309, null), 2131758309, "field 'topCard'"));
    splashImage = ((ImageView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755966, null), 2131755966, "field 'splashImage'"));
    toolBarForNonAcceptInvite = ((Toolbar)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755962, null), 2131755962, "field 'toolBarForNonAcceptInvite'"));
    toolBarForAcceptInvite = ((Toolbar)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755978, null), 2131755978, "field 'toolBarForAcceptInvite'"));
  }
  
  public void reset(T paramT)
  {
    super.reset(paramT);
    topCardContainer = null;
    topCard = null;
    splashImage = null;
    toolBarForNonAcceptInvite = null;
    toolBarForAcceptInvite = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */