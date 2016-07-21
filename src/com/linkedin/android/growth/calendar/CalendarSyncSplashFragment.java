package com.linkedin.android.growth.calendar;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Set;
import javax.inject.Inject;

public class CalendarSyncSplashFragment
  extends PageFragment
{
  public static final String BACK_STACK_NAME = CalendarSyncSplashFragment.class.getName();
  @Inject
  FragmentRegistry fragmentRegistry;
  @InjectView(2131755468)
  Toolbar toolbar;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968812, paramViewGroup, false);
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    if ((paramSet1.contains("android.permission.READ_CALENDAR")) || (paramSet2.contains("android.permission.READ_CALENDAR"))) {
      CalendarSyncHelper.onRequestPermissionsResult(fragmentComponent.activity(), paramSet2);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setTitle(2131231412);
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        NavigationUtils.onUpPressed(getActivity(), false);
      }
    });
    ((Button)paramView.findViewById(2131756001)).setOnClickListener(new TrackingOnClickListener(tracker, "sync_calendar", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        CalendarSyncHelper.requestCalendarSyncPermission(CalendarSyncSplashFragment.this);
      }
    });
    ((TextView)paramView.findViewById(2131756000)).setOnClickListener(new TrackingOnClickListener(tracker, "learn_more", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = CalendarSyncSplashFragment.this;
        ((CalendarLearnMoreFragment)fragmentRegistry.calendarLearnMore.newFragment(null)).show(paramAnonymousView.getFragmentManager(), CalendarLearnMoreFragment.TAG);
      }
    });
  }
  
  public final String pageKey()
  {
    return "people_calendar_permission_splash";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncSplashFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */