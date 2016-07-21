package com.linkedin.android.growth.calendar;

import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class CalendarEmptyViewModel
  extends ViewModel<CalendarEmptyViewHolder>
{
  public final ViewHolderCreator<CalendarEmptyViewHolder> getCreator()
  {
    return CalendarEmptyViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarEmptyViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */