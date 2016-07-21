package com.linkedin.android.growth.calendar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import butterknife.InjectView;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.calendar.sync.CalendarSyncSettingsTransformer;
import com.linkedin.android.growth.calendar.sync.CalendarSyncTrackingUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent.Builder;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class CalendarSyncSettingsFragment
  extends PageFragment
{
  @Inject
  CalendarSyncManager calendarSyncManager;
  @Inject
  FlagshipSharedPreferences flagshipSharedPreferences;
  @InjectView(2131756002)
  RecyclerView recyclerView;
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
    return paramLayoutInflater.inflate(2130968813, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, final Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    if (!PermissionRequester.hasPermission(getContext(), "android.permission.READ_CALENDAR")) {
      getFragmentManager().popBackStack();
    }
    toolbar.setTitle(2131231412);
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        NavigationUtils.onUpPressed(getActivity(), false);
      }
    });
    paramView = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), Collections.emptyList());
    paramBundle = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), Collections.emptyList());
    MergeAdapter localMergeAdapter = new MergeAdapter();
    localMergeAdapter.addAdapter(paramView);
    localMergeAdapter.addAdapter(paramBundle);
    final Object localObject = fragmentComponent.activity();
    CompoundButton.OnCheckedChangeListener local1 = new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        paramAnonymousCompoundButton = calendarSyncManager;
        label62:
        GlobalCalendarSyncActionEvent.Builder localBuilder;
        Boolean localBoolean;
        if (paramAnonymousBoolean)
        {
          paramAnonymousCompoundButton.enableCalendarSync();
          if (!paramAnonymousBoolean) {
            break label140;
          }
          paramAnonymousCompoundButton = CalendarSyncSettingsTransformer.toViewModels(localObject);
          paramBundle.appendValues(paramAnonymousCompoundButton);
          if (getView() != null) {
            Snackbar.make(getView(), 2131231411, 0).show();
          }
          CalendarSyncTrackingUtils.trackCalendarSyncControlInteractionEvent(fragmentComponent.tracker(), "global_calendar_toggle", ControlType.TOGGLE, InteractionType.SHORT_PRESS);
          paramAnonymousCompoundButton = fragmentComponent.tracker();
          localBuilder = new GlobalCalendarSyncActionEvent.Builder();
          localBoolean = Boolean.valueOf(paramAnonymousBoolean);
          if (localBoolean != null) {
            break label176;
          }
          hasIsSyncEnabled = false;
        }
        for (isSyncEnabled = false;; isSyncEnabled = localBoolean.booleanValue())
        {
          paramAnonymousCompoundButton.send(localBuilder);
          return;
          paramAnonymousCompoundButton.disableCalendarSync();
          break;
          label140:
          paramBundle.clear();
          if (getView() == null) {
            break label62;
          }
          Snackbar.make(getView(), 2131231393, 0).show();
          break label62;
          label176:
          hasIsSyncEnabled = true;
        }
      }
    };
    calendarSyncManager.doCalendarSync(getContext());
    localObject = CalendarSyncSettingsTransformer.toViewModels((BaseActivity)localObject);
    paramView.appendValues(Collections.singletonList(new CalendarToggleAllRowViewModel(local1)));
    paramBundle.setValues((List)localObject);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerView.setAdapter(localMergeAdapter);
  }
  
  public final String pageKey()
  {
    return "people_calendar";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncSettingsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */