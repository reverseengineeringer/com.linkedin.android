package com.linkedin.android.growth.calendar;

import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.linkedin.android.growth.calendar.sync.CalendarMetadata;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.MultipleTrackingEventSender;
import java.util.Iterator;
import java.util.List;

public final class CalendarToggleRowViewModel
  extends ViewModel<CalendarToggleRowViewHolder>
{
  final String accountName;
  final String accountType;
  public final String calendarDisplayName;
  final String calendarName;
  final FlagshipSharedPreferences flagshipSharedPreferences;
  boolean isSynced;
  final Tracker tracker;
  
  public CalendarToggleRowViewModel(boolean paramBoolean, FlagshipSharedPreferences paramFlagshipSharedPreferences, String paramString1, String paramString2, String paramString3, String paramString4, Tracker paramTracker)
  {
    isSynced = paramBoolean;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    accountType = paramString1;
    accountName = paramString2;
    calendarName = paramString3;
    calendarDisplayName = paramString4;
    tracker = paramTracker;
  }
  
  public final ViewHolderCreator<CalendarToggleRowViewHolder> getCreator()
  {
    return CalendarToggleRowViewHolder.CREATOR_SINGLE;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarToggleRowViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */