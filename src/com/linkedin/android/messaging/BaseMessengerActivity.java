package com.linkedin.android.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.NavigationUtils;

public abstract class BaseMessengerActivity
  extends BaseActivity
{
  public abstract Fragment buildNewChildFragment();
  
  public Bundle getArguments()
  {
    return getIntent().getExtras();
  }
  
  public abstract String getChildFragmentTag();
  
  public abstract int getContentViewResId();
  
  public abstract int getFragmentContainerResId();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(getContentViewResId());
    performInjections();
    setupChildFragment();
  }
  
  public void onNavigationClick()
  {
    Object localObject = activityComponent.intentRegistry().home;
    BaseActivity localBaseActivity = activityComponent.activity();
    HomeBundle localHomeBundle = new HomeBundle();
    activeTab = HomeTabInfo.MESSAGING;
    localObject = ((HomeIntent)localObject).newIntent(localBaseActivity, localHomeBundle);
    NavigationUtils.navigateUp(activityComponent.activity(), (Intent)localObject, false);
  }
  
  public abstract void performInjections();
  
  public Fragment setupChildFragment()
  {
    Fragment localFragment2 = getSupportFragmentManager().findFragmentByTag(getChildFragmentTag());
    Fragment localFragment1 = localFragment2;
    if (localFragment2 == null)
    {
      localFragment2 = buildNewChildFragment();
      localFragment1 = localFragment2;
      if (getArguments() != null)
      {
        localFragment2.setArguments(getArguments());
        localFragment1 = localFragment2;
      }
    }
    getSupportFragmentManager().beginTransaction().replace(getFragmentContainerResId(), localFragment1, getChildFragmentTag()).commit();
    return localFragment1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.BaseMessengerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */