package com.linkedin.android.growth.calendar;

import android.support.design.widget.Snackbar;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.calendar.sync.CalendarSyncSettingsTransformer;
import com.linkedin.android.growth.calendar.sync.CalendarSyncTrackingUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent.Builder;

final class CalendarSyncSettingsFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  CalendarSyncSettingsFragment$1(CalendarSyncSettingsFragment paramCalendarSyncSettingsFragment, BaseActivity paramBaseActivity, ViewModelArrayAdapter paramViewModelArrayAdapter) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this$0.calendarSyncManager;
    label62:
    GlobalCalendarSyncActionEvent.Builder localBuilder;
    Boolean localBoolean;
    if (paramBoolean)
    {
      paramCompoundButton.enableCalendarSync();
      if (!paramBoolean) {
        break label140;
      }
      paramCompoundButton = CalendarSyncSettingsTransformer.toViewModels(val$activity);
      val$individualTogglesSyncAdapter.appendValues(paramCompoundButton);
      if (this$0.getView() != null) {
        Snackbar.make(this$0.getView(), 2131231411, 0).show();
      }
      CalendarSyncTrackingUtils.trackCalendarSyncControlInteractionEvent(this$0.fragmentComponent.tracker(), "global_calendar_toggle", ControlType.TOGGLE, InteractionType.SHORT_PRESS);
      paramCompoundButton = this$0.fragmentComponent.tracker();
      localBuilder = new GlobalCalendarSyncActionEvent.Builder();
      localBoolean = Boolean.valueOf(paramBoolean);
      if (localBoolean != null) {
        break label176;
      }
      hasIsSyncEnabled = false;
    }
    for (isSyncEnabled = false;; isSyncEnabled = localBoolean.booleanValue())
    {
      paramCompoundButton.send(localBuilder);
      return;
      paramCompoundButton.disableCalendarSync();
      break;
      label140:
      val$individualTogglesSyncAdapter.clear();
      if (this$0.getView() == null) {
        break label62;
      }
      Snackbar.make(this$0.getView(), 2131231393, 0).show();
      break label62;
      label176:
      hasIsSyncEnabled = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncSettingsFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */