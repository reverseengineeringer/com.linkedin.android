package com.linkedin.android.feed.followhub;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class FollowHubFragmentFactory
  extends FragmentFactory<FollowHubBundleBuilder>
{
  protected final Fragment provideFragment()
  {
    return new FollowHubFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */