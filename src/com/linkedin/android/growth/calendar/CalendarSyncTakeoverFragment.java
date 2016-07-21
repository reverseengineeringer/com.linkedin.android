package com.linkedin.android.growth.calendar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.takeover.TakeoverIntentBundleBuilder;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CrossActivitySnackbarCallbacks;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Set;
import javax.inject.Inject;

public class CalendarSyncTakeoverFragment
  extends PageFragment
{
  @Inject
  CalendarSyncManager calendarSyncManager;
  @InjectView(2131756305)
  @Optional
  TextView cardTitle;
  @InjectView(2131756308)
  Button ctaButton;
  @Inject
  FragmentRegistry fragmentRegistry;
  @Inject
  I18NManager i18nManager;
  @InjectView(2131756299)
  TextView learnMore;
  @Inject
  LegoTrackingDataProvider legoTrackingDataProvider;
  private String legoTrackingToken;
  @Inject
  SnackbarUtil snackbarUtil;
  @InjectView(2131756301)
  Toolbar toolbar;
  
  private void doCalendarSyncAndShowSnackbar()
  {
    calendarSyncManager.doCalendarSync(getContext());
    applicationComponent.app().registerActivityLifecycleCallbacks(new CrossActivitySnackbarCallbacks(applicationComponent.app(), 2131231751));
    getActivity().finish();
  }
  
  public static CalendarSyncTakeoverFragment newInstance(TakeoverIntentBundleBuilder paramTakeoverIntentBundleBuilder)
  {
    CalendarSyncTakeoverFragment localCalendarSyncTakeoverFragment = new CalendarSyncTakeoverFragment();
    localCalendarSyncTakeoverFragment.setArguments(paramTakeoverIntentBundleBuilder.build());
    return localCalendarSyncTakeoverFragment;
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (!TextUtils.isEmpty(legoTrackingToken)) {
      legoTrackingDataProvider.sendWidgetImpressionEvent$4bb724c7(legoTrackingToken, Visibility.SHOW);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    legoTrackingToken = TakeoverIntentBundleBuilder.getLegoTrackingToken(getArguments());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968880, paramViewGroup, false);
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    super.onRequestPermissionsResult(paramSet1, paramSet2);
    if (paramSet2.isEmpty()) {
      doCalendarSyncAndShowSnackbar();
    }
    do
    {
      return;
      paramSet1 = snackbarUtil.make(2131231750, 0);
    } while (paramSet1 == null);
    paramSet1.show();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        NavigationUtils.onUpPressed(getActivity(), false);
      }
    });
    learnMore.setOnClickListener(new TrackingOnClickListener(tracker, "learn_more", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        ((CalendarLearnMoreFragment)fragmentRegistry.calendarLearnMore.newFragment(null)).show(((BaseActivity)getActivity()).getSupportFragmentManager(), CalendarLearnMoreFragment.TAG);
      }
    });
    ctaButton.setOnClickListener(new TrackingOnClickListener(tracker, "sync_calendar", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        if (PermissionRequester.hasPermission(getContext(), "android.permission.READ_CALENDAR"))
        {
          CalendarSyncTakeoverFragment.this.doCalendarSyncAndShowSnackbar();
          return;
        }
        CalendarSyncHelper.requestCalendarSyncPermission(fragmentComponent.fragment());
      }
    });
    if (cardTitle != null) {
      cardTitle.setText(i18nManager.getSpannedString(2131231744, new Object[0]).toString());
    }
  }
  
  public final String pageKey()
  {
    return "calendar_sync_splash";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */