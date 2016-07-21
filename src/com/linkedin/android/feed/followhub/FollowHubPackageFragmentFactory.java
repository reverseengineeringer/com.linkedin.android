package com.linkedin.android.feed.followhub;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class FollowHubPackageFragmentFactory
  extends FragmentFactory<FollowHubPackageBundleBuilder>
{
  protected final Fragment provideFragment()
  {
    return new FollowHubPackageFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubPackageFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */