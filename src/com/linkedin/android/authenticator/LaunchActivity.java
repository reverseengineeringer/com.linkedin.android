package com.linkedin.android.authenticator;

import android.content.Intent;
import android.os.Bundle;
import com.linkedin.android.growth.boost.BoostUtil;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.Auth;
import javax.inject.Inject;

public class LaunchActivity
  extends BaseActivity
{
  @Inject
  Auth auth;
  @Inject
  Bus bus;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  LaunchUtils launchUtils;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  @Inject
  TakeoverManager takeoverManager;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    if (auth.isAuthenticated())
    {
      takeoverManager.loadTakeovers();
      startActivity(intentRegistry.home.newIntent(this, null));
    }
    for (;;)
    {
      finish();
      overridePendingTransition(0, 0);
      return;
      paramBundle = new LoginIntentBundle();
      BoostUtil.getEligibility(sharedPreferences, dataManager, bus, getApplicationContext());
      bundle.putBoolean("boostEligibilityFetched", true);
      if ((getIntent() != null) && ("sdk_sso".equals(getIntent().getStringExtra("src"))))
      {
        paramBundle.setThirdPartyApplicationPackageName(getIntent().getStringExtra("callerPackageName"));
        paramBundle = intentRegistry.login.newIntent(this, paramBundle);
        paramBundle.addFlags(33554432);
        startActivity(paramBundle);
      }
      else
      {
        startActivity(intentRegistry.login.newIntent(this, paramBundle).setFlags(65536));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.authenticator.LaunchActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */