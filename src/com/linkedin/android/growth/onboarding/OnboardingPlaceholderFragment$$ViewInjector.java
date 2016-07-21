package com.linkedin.android.growth.onboarding;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import butterknife.internal.DebouncingOnClickListener;

public class OnboardingPlaceholderFragment$$ViewInjector<T extends OnboardingPlaceholderFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, final T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756133, "field 'title'"), 2131756133, "field 'title'"));
    ((View)paramFinder.findRequiredView(paramObject, 2131756107, "method 'skipFragment'")).setOnClickListener(new DebouncingOnClickListener()
    {
      public final void doClick(View paramAnonymousView)
      {
        paramT.skipFragment();
      }
    });
  }
  
  public void reset(T paramT)
  {
    title = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingPlaceholderFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */