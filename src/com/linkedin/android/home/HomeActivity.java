package com.linkedin.android.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixDefinition;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.tos.Logger;
import com.linkedin.android.infra.tos.ToSHttpNetwork;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuthProvider;
import com.linkedin.android.tos.Host;
import com.linkedin.android.tos.HostInterface;
import com.linkedin.android.tos.LiLogInStateInterface;
import com.linkedin.android.tos.LiTermsOfService;
import com.linkedin.android.tos.LiTermsOfServiceInterface;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class HomeActivity
  extends BaseActivity
  implements HostInterface
{
  @Inject
  HomeCachedLix homeCachedLix;
  private final HomeKeyEventResponder keyResponder = new HomeKeyEventResponder(this);
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  private LiTermsOfServiceInterface termsOfService;
  
  private HomeFragment findHomeFragment()
  {
    List localList = getSupportFragmentManager().getFragments();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Fragment localFragment = (Fragment)localList.get(i);
        if ((localFragment instanceof HomeFragment)) {
          return (HomeFragment)localFragment;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void replaceHomeFragment()
  {
    Object localObject1 = homeCachedLix;
    Object localObject2 = HomeCachedLix.LIX_TO_MONITOR;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      LixDefinition localLixDefinition = localObject2[i];
      cachedLix.put(localLixDefinition, lixManager.getTreatment(localLixDefinition));
      i += 1;
    }
    lixValueChanged = false;
    localObject2 = getIntent().getExtras();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    localObject1 = HomeFragment.newInstance((Bundle)localObject1);
    getSupportFragmentManager().beginTransaction().replace(2131756509, (Fragment)localObject1).commit();
  }
  
  protected final boolean disableTransitionAnimations()
  {
    return true;
  }
  
  public final Host getHost()
  {
    if (sharedPreferences.getBaseUrl().equals("https://www.linkedin.com")) {
      return Host.HOST_PROD;
    }
    return Host.HOST_EI;
  }
  
  public void onBackPressed()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(2131756509);
    if (((localFragment instanceof OnBackPressedListener)) && (((OnBackPressedListener)localFragment).onBackPressed())) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968929);
    if (paramBundle == null) {
      replaceHomeFragment();
    }
    paramBundle = activityComponent;
    termsOfService = new LiTermsOfService(new ToSHttpNetwork(((FlagshipApplication)getApplication()).getAppComponent().networkClient(), getApplicationContext()), this, new LiLogInStateInterface()new Logger
    {
      public final boolean isLoggedInAsLinkedinMember()
      {
        LiAuth localLiAuth = LiAuthProvider.getInstance(paramBundle.context());
        paramBundle.context();
        return !localLiAuth.needsAuth$faab209();
      }
    }, new Logger(), paramBundle.context(), getSupportFragmentManager());
    ((FlagshipApplication)getApplicationContext()).getAppComponent().termsOfService();
    termsOfService.checkPolicy();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    termsOfService.unregisterBroadcastReceiver();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    Object localObject = keyResponder;
    int i;
    if (paramKeyEvent.isCtrlPressed())
    {
      i = -1;
      switch (paramInt)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      if ((i != 0) || (super.onKeyUp(paramInt, paramKeyEvent))) {
        bool = true;
      }
      return bool;
      i = 0;
      for (;;)
      {
        localObject = activity.findHomeFragment();
        if ((localObject == null) || (i < 0)) {
          break label192;
        }
        ((HomeFragment)localObject).setActiveTab(i, true);
        i = 1;
        break;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
        continue;
        HomeFragment localHomeFragment = activity.findHomeFragment();
        if (localHomeFragment != null) {
          if (paramKeyEvent.isShiftPressed()) {
            i = localHomeFragment.getAdjacentPosition(false);
          } else {
            i = localHomeFragment.getAdjacentPosition(true);
          }
        }
      }
      label192:
      i = 0;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    HomeFragment localHomeFragment = findHomeFragment();
    if (localHomeFragment != null) {
      localHomeFragment.setActiveTab(HomeBundle.getActiveTab(applicationComponent.flagshipSharedPreferences(), paramIntent.getExtras()), false);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    HomeCachedLix localHomeCachedLix = homeCachedLix;
    if ((lixValueChanged) && (lixChangeTimeStamp < sharedPreferences.getAppLastBackgroundTimeStamp()) && (System.currentTimeMillis() - sharedPreferences.getAppLastBackgroundTimeStamp() > FlagshipSharedPreferences.BACKGROUND_SESSION_THRESHOLD)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        replaceHomeFragment();
      }
      sharedPreferences.getPreferences().edit().putBoolean("homeActivityResumedAtLeastOnce", true).apply();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.home.HomeActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */