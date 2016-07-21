package com.linkedin.android.growth.onboarding.welcome_mat;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper.Builder;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.lego.LegoManager.LegoNoWidgetsException;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.growth.onboarding.base.OnboardingListFragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.growth.goal.Goal;
import com.linkedin.android.pegasus.gen.voyager.growth.goal.Goal.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.goal.GoalType;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public final class WelcomeMatFragment
  extends OnboardingListFragment<GoalType, WelcomeMatItemViewModel>
{
  static final Urn GOAL_URN = Urn.createFromTuple("goal", new Object[] { Integer.valueOf(-1) });
  private LegoManager legoManager;
  @Inject
  SnackbarUtil snackbar;
  
  private Goal createGoal(GoalType paramGoalType)
  {
    Goal.Builder localBuilder = new Goal.Builder().setEntityUrn(GOAL_URN);
    if (paramGoalType == null) {
      hasGoalType = false;
    }
    for (goalType = null;; goalType = paramGoalType)
    {
      try
      {
        paramGoalType = localBuilder.build(RecordTemplate.Flavor.RECORD);
        return paramGoalType;
      }
      catch (BuilderException paramGoalType)
      {
        getActivity();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed Goal validation", paramGoalType));
      }
      hasGoalType = true;
    }
    return null;
  }
  
  private void onSaveGoalFailed()
  {
    Snackbar localSnackbar = snackbar.make(2131231509, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  protected final void initialize()
  {
    if ((getDataProvider().getGoalTypes() != null) && (getDataProvidergetGoalTypeshasElements)) {
      adapter.setValues(transformModelCollection(getDataProvidergetGoalTypeselements));
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      fromCache = true;
      getDataProvider().makeParallelCacheRequest(busSubscriberId, getRumSessionId(), new DataRequestWrapper.Builder[] { Request.get().url(getDataProviderstate).goalTypeRecommendationsRoute).builder(CollectionTemplate.of(GoalType.BUILDER)) });
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968849, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramSet == null) {}
    while (!paramSet.contains(getDataProviderstate).goalsRoute)) {
      return;
    }
    onSaveGoalFailed();
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet == null) || (paramMap == null)) {}
    do
    {
      return;
      paramType = getDataProviderstate).goalTypeRecommendationsRoute;
      if (paramSet.contains(paramType))
      {
        paramType = (DataStoreResponse)paramMap.get(paramType);
        if ((paramType != null) && (model != null) && (model).elements != null)) {
          adapter.setValues(transformModelCollection(model).elements));
        }
      }
      paramType = getDataProviderstate).onboardingFlowRoute;
    } while (!paramSet.contains(paramType));
    paramType = (DataStoreResponse)paramMap.get(paramType);
    if ((paramType != null) && (model != null)) {}
    try
    {
      legoManager.buildFlow((PageContent)model, true);
      legoWidget.finishCurrentFragment();
      return;
    }
    catch (LegoManager.LegoNoWidgetsException paramType)
    {
      for (;;) {}
    }
  }
  
  @Subscribe
  public final void onEvent(GoalType paramGoalType)
  {
    paramGoalType = createGoal(paramGoalType);
    if (paramGoalType != null)
    {
      trackLegoWidgetPrimaryAction(1);
      OnboardingDataProvider localOnboardingDataProvider = getDataProvider();
      String str = busSubscriberId;
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.sequential();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      localOnboardingDataProvider.performMultiplexedFetch(str, null, localMap, localBuilder.filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.post().url(state).goalsRoute).model(paramGoalType)).required(Request.get().url(state).onboardingFlowRoute).builder(PageContent.BUILDER)));
      return;
    }
    onSaveGoalFailed();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("saved", true);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    legoManager = getActivityactivityComponent.legoManager();
    nextButton.setOnClickListener(new WelcomeMatFragment.1(this, legoWidget.getTrackingToken(), ActionCategory.SKIP, legoTrackingDataProvider, tracker, "not_sure", new TrackingEventBuilder[0]));
  }
  
  public final String pageKey()
  {
    return "onboarding_wm1";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */