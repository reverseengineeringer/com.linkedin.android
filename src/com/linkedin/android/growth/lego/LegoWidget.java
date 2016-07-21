package com.linkedin.android.growth.lego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.animations.AnimationProxy;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import java.util.Map;
import javax.inject.Inject;

public abstract class LegoWidget
  extends BaseFragment
{
  int activityContainer;
  int activityLayout;
  @Inject
  public FragmentRegistry fragmentRegistry;
  public boolean isFirstWidgetInLegoFlow;
  public LegoFlowNavigation legoNavigator;
  public int status = 0;
  public boolean stopped;
  
  public final void addFragment$4857f75f(Fragment paramFragment, String paramString)
  {
    fragmentComponent.animationProxy();
    paramFragment = AnimationProxy.setAnimations(getChildFragmentManager().beginTransaction(), 2131034161, 2131034164, 2131034160, 2131034165).add(activityContainer, paramFragment, paramString);
    paramFragment.addToBackStack(paramString);
    paramFragment.commit();
  }
  
  public void finishCurrentFragment()
  {
    if (stopped) {}
    while (getChildFragmentManager().popBackStackImmediate()) {
      return;
    }
    legoNavigator.moveToNextLegoWidget();
  }
  
  public final Fragment getCurrentActiveFragment()
  {
    if (getCurrentActiveFragmentTag() != null) {
      return getChildFragmentManager().findFragmentByTag(getCurrentActiveFragmentTag());
    }
    return null;
  }
  
  public abstract String getCurrentActiveFragmentTag();
  
  public DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return null;
  }
  
  public abstract Fragment getLandingFragment();
  
  public int getStatus(ActivityComponent paramActivityComponent)
  {
    return status;
  }
  
  public final String getTrackingToken()
  {
    return getArguments().getString("tracking_token", null);
  }
  
  public void handleBack()
  {
    if (stopped) {}
    while (getChildFragmentManager().popBackStackImmediate()) {
      return;
    }
    legoNavigator.moveToPreviousLegoWidget();
  }
  
  public boolean loadData(ActivityComponent paramActivityComponent, LegoWidgetMultiplexCompletionCallback paramLegoWidgetMultiplexCompletionCallback)
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Fragment localFragment = getCurrentActiveFragment();
    if (localFragment != null) {
      localFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof LegoFlowNavigation))
    {
      legoNavigator = ((LegoFlowNavigation)paramActivity);
      activityContainer = legoNavigator.getFlowContainer();
      activityLayout = legoNavigator.getFlowLayout();
      return;
    }
    Util.safeThrow$7a8b4789(new IllegalStateException("Lego widget must be attached to an activity that implements lego navigation"));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    if (paramBundle == null)
    {
      paramBundle = getArguments();
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("isFirstWidgetInLegoFlow");
      }
      isFirstWidgetInLegoFlow = bool;
      paramBundle = getLandingFragment();
      if (paramBundle != null)
      {
        getChildFragmentManager().beginTransaction().replace(activityContainer, paramBundle, "landing").commit();
        return;
      }
      Util.safeThrow$7a8b4789(new IllegalStateException("Landing fragment should not be null"));
      legoNavigator.moveToNextLegoWidget();
      return;
    }
    status = paramBundle.getInt("status", 0);
    isFirstWidgetInLegoFlow = paramBundle.getBoolean("isFirstWidgetInLegoFlow");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(activityLayout, paramViewGroup, false);
  }
  
  public void onDataReady$581b308(ActivityComponent paramActivityComponent, Map<String, DataStoreResponse> paramMap, DataManagerException paramDataManagerException) {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("status", status);
    paramBundle.putBoolean("isFirstWidgetInLegoFlow", isFirstWidgetInLegoFlow);
  }
  
  public void onStart()
  {
    super.onStart();
    stopped = false;
  }
  
  public void onStop()
  {
    super.onStop();
    stopped = true;
  }
  
  public final void switchCurrentFragment(Fragment paramFragment, boolean paramBoolean, String paramString)
  {
    fragmentComponent.animationProxy();
    paramFragment = AnimationProxy.setAnimations(getChildFragmentManager().beginTransaction(), 2131034161, 2131034164, 2131034160, 2131034165).replace(activityContainer, paramFragment, paramString);
    if (paramBoolean) {
      paramFragment.addToBackStack(paramString);
    }
    paramFragment.commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoWidget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */