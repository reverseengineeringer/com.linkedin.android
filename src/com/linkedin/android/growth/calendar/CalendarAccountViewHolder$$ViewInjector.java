package com.linkedin.android.growth.calendar;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CalendarAccountViewHolder$$ViewInjector<T extends CalendarAccountViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    calendarAccountTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755992, "field 'calendarAccountTextView'"), 2131755992, "field 'calendarAccountTextView'"));
  }
  
  public void reset(T paramT)
  {
    calendarAccountTextView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarAccountViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */