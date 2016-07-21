package com.linkedin.android.growth.onboarding.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class OnboardingListFragment$$ViewInjector<T extends OnboardingListFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    addAllButton = ((Button)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131756106, null), 2131756106, "field 'addAllButton'"));
    nextButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756107, "field 'nextButton'"), 2131756107, "field 'nextButton'"));
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755940, "field 'recyclerView'"), 2131755940, "field 'recyclerView'"));
  }
  
  public void reset(T paramT)
  {
    addAllButton = null;
    nextButton = null;
    recyclerView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingListFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */