package com.linkedin.android.growth.calendar;

import android.widget.CompoundButton.OnCheckedChangeListener;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class CalendarToggleAllRowViewModel
  extends ViewModel<CalendarToggleRowViewHolder>
{
  private final CompoundButton.OnCheckedChangeListener checkedChangeListener;
  private final boolean isSynced = true;
  
  public CalendarToggleAllRowViewModel(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    checkedChangeListener = paramOnCheckedChangeListener;
  }
  
  public final ViewHolderCreator<CalendarToggleRowViewHolder> getCreator()
  {
    return CalendarToggleRowViewHolder.CREATOR_GLOBAL;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarToggleAllRowViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */