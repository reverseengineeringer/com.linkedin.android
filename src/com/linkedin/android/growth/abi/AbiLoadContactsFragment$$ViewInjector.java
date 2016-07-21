package com.linkedin.android.growth.abi;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AbiLoadContactsFragment$$ViewInjector<T extends AbiLoadContactsFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    loadContactsProgressBar = ((ProgressBar)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755920, null), 2131755920, "field 'loadContactsProgressBar'"));
    resultsLoadingProgressBarHorizontal = ((ProgressBar)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755954, null), 2131755954, "field 'resultsLoadingProgressBarHorizontal'"));
    abiResultsLoadingToolbarText = ((TextView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755951, null), 2131755951, "field 'abiResultsLoadingToolbarText'"));
  }
  
  public void reset(T paramT)
  {
    loadContactsProgressBar = null;
    resultsLoadingProgressBarHorizontal = null;
    abiResultsLoadingToolbarText = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiLoadContactsFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */