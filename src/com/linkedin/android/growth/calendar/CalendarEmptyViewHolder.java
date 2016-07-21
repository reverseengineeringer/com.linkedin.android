package com.linkedin.android.growth.calendar;

import android.view.View;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public final class CalendarEmptyViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<CalendarEmptyViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968807;
    }
  };
  
  public CalendarEmptyViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarEmptyViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */