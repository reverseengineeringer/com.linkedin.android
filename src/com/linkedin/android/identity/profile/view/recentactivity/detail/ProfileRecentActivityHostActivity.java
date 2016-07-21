package com.linkedin.android.identity.profile.view.recentactivity.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;

public class ProfileRecentActivityHostActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130969234);
    if (paramBundle != null) {
      return;
    }
    paramBundle = getIntent().getExtras();
    getSupportFragmentManager().beginTransaction().replace(2131757804, RecentActivityFragment.newInstance(paramBundle)).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileRecentActivityHostActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */