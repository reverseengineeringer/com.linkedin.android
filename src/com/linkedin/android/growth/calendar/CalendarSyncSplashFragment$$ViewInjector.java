package com.linkedin.android.growth.calendar;

import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CalendarSyncSplashFragment$$ViewInjector<T extends CalendarSyncSplashFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
  }
  
  public void reset(T paramT)
  {
    toolbar = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncSplashFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */