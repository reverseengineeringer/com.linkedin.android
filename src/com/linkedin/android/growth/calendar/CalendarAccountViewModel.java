package com.linkedin.android.growth.calendar;

import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class CalendarAccountViewModel
  extends ViewModel<CalendarAccountViewHolder>
{
  public final String accountName;
  
  public CalendarAccountViewModel(String paramString)
  {
    accountName = paramString;
  }
  
  public final ViewHolderCreator<CalendarAccountViewHolder> getCreator()
  {
    return CalendarAccountViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarAccountViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */