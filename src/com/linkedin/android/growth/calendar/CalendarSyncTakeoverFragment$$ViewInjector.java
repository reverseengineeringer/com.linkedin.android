package com.linkedin.android.growth.calendar;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CalendarSyncTakeoverFragment$$ViewInjector<T extends CalendarSyncTakeoverFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756301, "field 'toolbar'"), 2131756301, "field 'toolbar'"));
    learnMore = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756299, "field 'learnMore'"), 2131756299, "field 'learnMore'"));
    ctaButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756308, "field 'ctaButton'"), 2131756308, "field 'ctaButton'"));
    cardTitle = ((TextView)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131756305, null), 2131756305, "field 'cardTitle'"));
  }
  
  public void reset(T paramT)
  {
    toolbar = null;
    learnMore = null;
    ctaButton = null;
    cardTitle = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */