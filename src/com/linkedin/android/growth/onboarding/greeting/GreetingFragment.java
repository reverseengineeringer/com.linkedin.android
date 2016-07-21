package com.linkedin.android.growth.onboarding.greeting;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.lego.LegoFlowNavigation;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.lego.LegoManager.LegoNoWidgetsException;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import java.util.Map;
import java.util.Set;

public class GreetingFragment
  extends PageFragment
{
  boolean animationExpired;
  boolean dataLoaded;
  @InjectView(2131756104)
  TextView greeting;
  LegoManager legoManager;
  LegoFlowNavigation legoNavigator;
  OnboardingDataProvider onboardingDataProvider;
  
  private void startOnboarding()
  {
    if ((dataLoaded) && (animationExpired)) {
      legoNavigator.startFlow();
    }
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    onboardingDataProvider = paramActivityComponent.onboardingDataProvider();
    return onboardingDataProvider;
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if ((paramContext instanceof LegoFlowNavigation))
    {
      legoNavigator = ((LegoFlowNavigation)paramContext);
      return;
    }
    Util.safeThrow$7a8b4789(new IllegalStateException("Fragment must be attached to an activity that implements lego navigation"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968835, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (legoNavigator != null) {
      legoNavigator.exitFlow(null);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (legoNavigator == null) {
      return;
    }
    paramType = (OnboardingDataProvider.OnboardingState)onboardingDataProvider.state;
    paramType = (PageContent)paramType.getModel(onboardingFlowRoute);
    if (paramType == null)
    {
      legoNavigator.exitFlow(null);
      return;
    }
    try
    {
      legoManager.buildFlow(paramType, false);
      legoManager.prefetchData(true);
      dataLoaded = true;
      startOnboarding();
      return;
    }
    catch (LegoManager.LegoNoWidgetsException paramType)
    {
      Log.e("flow has no widgets", paramType);
      legoNavigator.exitFlow(null);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    int j = 1;
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    label46:
    Object localObject1;
    int i;
    label103:
    label122:
    Object localObject2;
    Object localObject3;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("greeting", null);
      paramView = (GreetingFragmentViewHolder)GreetingFragmentViewHolder.CREATOR.createViewHolder(paramView);
      if (TextUtils.isEmpty(paramBundle)) {
        break label285;
      }
      localObject1 = new GreetingFragmentViewModel();
      greeting = paramBundle;
      getLayoutInflater(null);
      fragmentComponent.mediaCenter();
      ((GreetingFragmentViewModel)localObject1).onBindViewHolder$3b56654c(paramView);
      paramBundle = getArguments();
      if ((paramBundle == null) || (!paramBundle.getBoolean("debug"))) {
        break label299;
      }
      i = 1;
      if (i == 0) {
        break label304;
      }
      greeting.setOnClickListener(new GreetingFragment.1(this));
      legoManager = getActivityactivityComponent.legoManager();
      paramBundle = onboardingDataProvider;
      paramView = busSubscriberId;
      localObject2 = getRumSessionId();
      localObject1 = Tracker.createPageInstanceHeader(getPageInstance());
      localObject3 = getArguments();
      if ((localObject3 == null) || (!((Bundle)localObject3).getBoolean("isLapse", false))) {
        break label329;
      }
      i = j;
      label191:
      localObject2 = paramBundle.newModelListener(paramView, (String)localObject2);
      localObject3 = (OnboardingDataProvider.OnboardingState)state;
      if (i == 0) {
        break label334;
      }
    }
    label285:
    label299:
    label304:
    label329:
    label334:
    for (paramView = Routes.ONBOARDING_LAPSE_FLOW.buildUponRoot().toString();; paramView = Routes.ONBOARDING_FLOW.buildUponRoot().toString())
    {
      onboardingFlowRoute = paramView;
      activityComponent.dataManager().submit(Request.get().url(state).onboardingFlowRoute).builder(PageContent.BUILDER).listener((RecordTemplateListener)localObject2).customHeaders((Map)localObject1).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      return;
      paramBundle = null;
      break;
      paramBundle = getResources().getString(2131231549);
      break label46;
      i = 0;
      break label103;
      new Handler().postDelayed(new GreetingFragment.2(this), 2000L);
      break label122;
      i = 0;
      break label191;
    }
  }
  
  public final String pageKey()
  {
    return "onboarding_welcome";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.greeting.GreetingFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */