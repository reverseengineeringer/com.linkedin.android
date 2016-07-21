package com.linkedin.android.feed.followhub;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;

public class FollowHubActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968929);
    paramBundle = FollowHubBundleBuilder.createBundle();
    paramBundle = (FollowHubFragment)fragmentRegistry.followHub.newFragment(paramBundle);
    getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */