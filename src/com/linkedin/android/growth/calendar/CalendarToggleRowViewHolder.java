package com.linkedin.android.growth.calendar;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class CalendarToggleRowViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<CalendarToggleRowViewHolder> CREATOR_GLOBAL = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968808;
    }
  };
  public static final ViewHolderCreator<CalendarToggleRowViewHolder> CREATOR_SINGLE = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968810;
    }
  };
  @InjectView(2131755994)
  SwitchCompat toggleSwitchView;
  @InjectView(2131755995)
  TextView toggleTextView;
  
  public CalendarToggleRowViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarToggleRowViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */