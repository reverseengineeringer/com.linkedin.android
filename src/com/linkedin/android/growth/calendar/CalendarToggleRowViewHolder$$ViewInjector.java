package com.linkedin.android.growth.calendar;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class CalendarToggleRowViewHolder$$ViewInjector<T extends CalendarToggleRowViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    toggleTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755995, "field 'toggleTextView'"), 2131755995, "field 'toggleTextView'"));
    toggleSwitchView = ((SwitchCompat)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755994, "field 'toggleSwitchView'"), 2131755994, "field 'toggleSwitchView'"));
  }
  
  public void reset(T paramT)
  {
    toggleTextView = null;
    toggleSwitchView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarToggleRowViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */