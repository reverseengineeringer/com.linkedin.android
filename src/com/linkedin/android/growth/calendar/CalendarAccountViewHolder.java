package com.linkedin.android.growth.calendar;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class CalendarAccountViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<CalendarAccountViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968806;
    }
  };
  @InjectView(2131755992)
  TextView calendarAccountTextView;
  
  public CalendarAccountViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarAccountViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */