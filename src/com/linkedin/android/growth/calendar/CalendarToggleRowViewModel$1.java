package com.linkedin.android.growth.calendar;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.linkedin.android.growth.calendar.sync.CalendarMetadata;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.MultipleTrackingEventSender;
import java.util.Iterator;
import java.util.List;

final class CalendarToggleRowViewModel$1
  implements CompoundButton.OnCheckedChangeListener
{
  CalendarToggleRowViewModel$1(CalendarToggleRowViewModel paramCalendarToggleRowViewModel, CalendarToggleRowViewHolder paramCalendarToggleRowViewHolder) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this$0.isSynced = val$holder.toggleSwitchView.isChecked();
    paramCompoundButton = this$0.flagshipSharedPreferences.getCalendarSyncPreferences();
    Iterator localIterator = paramCompoundButton.iterator();
    for (;;)
    {
      CalendarMetadata localCalendarMetadata;
      if (localIterator.hasNext())
      {
        localCalendarMetadata = (CalendarMetadata)localIterator.next();
        String str1 = this$0.accountType;
        String str2 = this$0.accountName;
        String str3 = this$0.calendarName;
        if ((!str1.equals(accountType)) || (!str2.equals(accountName)) || (!str3.equals(name))) {
          break label199;
        }
      }
      label199:
      for (int i = 1; i != 0; i = 0)
      {
        shouldSync = this$0.isSynced;
        this$0.flagshipSharedPreferences.setCalendarSyncPreferences(paramCompoundButton);
        paramCompoundButton = new ControlInteractionEvent(this$0.tracker, "calendar_toggle", ControlType.TOGGLE, InteractionType.SHORT_PRESS);
        new MultipleTrackingEventSender(this$0.tracker, paramCompoundButton, new TrackingEventBuilder[0]).sendAll();
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarToggleRowViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */