package com.linkedin.android.growth.abi;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AbiPrepareFragment$$ViewInjector<T extends AbiPrepareFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    loadContactsProgressBar = ((ProgressBar)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755920, null), 2131755920, "field 'loadContactsProgressBar'"));
    loadingProgressLayout = ((View)paramFinder.findOptionalView(paramObject, 2131755917, null));
    resultsLoadingLayout = ((View)paramFinder.findOptionalView(paramObject, 2131755949, null));
    topCardContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755948, null), 2131755948, "field 'topCardContainer'"));
    topCard = ((RelativeLayout)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131758309, null), 2131758309, "field 'topCard'"));
    messageButton = ((ImageButton)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131758311, null), 2131758311, "field 'messageButton'"));
    abiResultsLoadingToolbarText = ((TextView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755951, null), 2131755951, "field 'abiResultsLoadingToolbarText'"));
    resultsLoadingProgressBarHorizontal = ((ProgressBar)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755954, null), 2131755954, "field 'resultsLoadingProgressBarHorizontal'"));
  }
  
  public void reset(T paramT)
  {
    loadContactsProgressBar = null;
    loadingProgressLayout = null;
    resultsLoadingLayout = null;
    topCardContainer = null;
    topCard = null;
    messageButton = null;
    abiResultsLoadingToolbarText = null;
    resultsLoadingProgressBarHorizontal = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiPrepareFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */