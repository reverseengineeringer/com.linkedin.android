package com.linkedin.android.growth.abi;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AbiResultsLandingValuePropHolder$$ViewInjector<T extends AbiResultsLandingValuePropHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    resultLandingValuePropContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755955, "field 'resultLandingValuePropContainer'"), 2131755955, "field 'resultLandingValuePropContainer'"));
    resultLandingValuePropHeader = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755956, "field 'resultLandingValuePropHeader'"), 2131755956, "field 'resultLandingValuePropHeader'"));
    resultLandingValuePropSubheader = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755957, "field 'resultLandingValuePropSubheader'"), 2131755957, "field 'resultLandingValuePropSubheader'"));
  }
  
  public void reset(T paramT)
  {
    resultLandingValuePropContainer = null;
    resultLandingValuePropHeader = null;
    resultLandingValuePropSubheader = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiResultsLandingValuePropHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */