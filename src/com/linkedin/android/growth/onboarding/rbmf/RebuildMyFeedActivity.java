package com.linkedin.android.growth.onboarding.rbmf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;

public class RebuildMyFeedActivity
  extends BaseActivity
{
  public void onBackPressed()
  {
    RebuildMyFeedFragment localRebuildMyFeedFragment = (RebuildMyFeedFragment)getSupportFragmentManager().findFragmentByTag("onboarding_feed_follow");
    if (localRebuildMyFeedFragment == null) {
      return;
    }
    localRebuildMyFeedFragment.handleExitFlowButton();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968929);
    paramBundle = getIntent().getExtras();
    boolean bool;
    int i;
    if (paramBundle != null)
    {
      bool = paramBundle.getBoolean("skipRbmfIntro", false);
      i = paramBundle.getInt("origin", 0);
    }
    for (paramBundle = RebuildMyFeedBundleBuilder.createBundle(bool).setRbmfOrigin(i);; paramBundle = RebuildMyFeedBundleBuilder.createBundle(false))
    {
      paramBundle = (RebuildMyFeedFragment)fragmentRegistry.rbmf.newFragment(paramBundle);
      getAnimationFragmentTransaction(2131034161, 2131034164, 2131034160, 2131034165).replace(2131756509, paramBundle, paramBundle.pageKey()).commit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */