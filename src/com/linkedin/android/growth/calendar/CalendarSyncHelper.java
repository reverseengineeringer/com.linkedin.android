package com.linkedin.android.growth.calendar;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.growth.calendar.sync.CalendarSyncTrackingUtils;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Set;

public final class CalendarSyncHelper
{
  public static TrackingOnClickListener buildOnClickListenerToGoToSplashPage(final FragmentComponent paramFragmentComponent, String paramString, final View.OnClickListener paramOnClickListener)
  {
    new TrackingOnClickListener(paramFragmentComponent.tracker(), paramString, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(paramAnonymousView);
        }
        int i;
        if ((PermissionRequester.hasPermission(paramFragmentComponent.context(), "android.permission.READ_CALENDAR")) && (paramFragmentComponentactivityapplicationComponent.flagshipSharedPreferences().getCalendarSyncEnabled()))
        {
          i = 1;
          if (i == 0) {
            break label129;
          }
          paramAnonymousView = new CalendarSyncSettingsFragment();
          label76:
          if (i == 0) {
            break label140;
          }
        }
        label129:
        label140:
        for (String str = null;; str = CalendarSyncSplashFragment.BACK_STACK_NAME)
        {
          i = CalendarSyncHelper.getContainerViewId(paramFragmentComponent.activity());
          paramFragmentComponent.activity().getSupportFragmentManager().beginTransaction().add(i, paramAnonymousView).addToBackStack(str).commit();
          return;
          i = 0;
          break;
          paramAnonymousView = new CalendarSyncSplashFragment();
          break label76;
        }
      }
    };
  }
  
  static int getContainerViewId(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity instanceof HomeActivity)) {
      return 2131756509;
    }
    return 16908290;
  }
  
  public static void onRequestPermissionsResult(BaseActivity paramBaseActivity, Set<String> paramSet)
  {
    Tracker localTracker = activityComponent.tracker();
    if (paramSet.isEmpty())
    {
      CalendarSyncTrackingUtils.trackCalendarSyncControlInteractionEvent(localTracker, "calendar_sync_allow", ControlType.BUTTON, InteractionType.SHORT_PRESS);
      paramSet = paramBaseActivity.getSupportFragmentManager();
      if ((paramSet.getBackStackEntryCount() > 0) && (paramSet.getBackStackEntryAt(paramSet.getBackStackEntryCount() - 1).getName().equals(CalendarSyncSplashFragment.BACK_STACK_NAME))) {
        paramSet.popBackStack();
      }
      int i = getContainerViewId(paramBaseActivity);
      paramBaseActivity.getSupportFragmentManager().beginTransaction().add(i, new CalendarSyncSettingsFragment()).addToBackStack(null).commit();
    }
    do
    {
      return;
      CalendarSyncTrackingUtils.trackCalendarSyncControlInteractionEvent(localTracker, "calendar_sync_reject", ControlType.BUTTON, InteractionType.SHORT_PRESS);
      paramBaseActivity = applicationComponent.snackbarUtil().make(2131231407, 0);
    } while (paramBaseActivity == null);
    paramBaseActivity.show();
  }
  
  public static void requestCalendarSyncPermission(Fragment paramFragment)
  {
    if (!(paramFragment instanceof BaseFragment))
    {
      paramFragment.getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Fragment must extend BaseFragment"));
      return;
    }
    ((BaseFragment)paramFragment).requestPermission("android.permission.READ_CALENDAR", 2131231409, 2131231408);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */