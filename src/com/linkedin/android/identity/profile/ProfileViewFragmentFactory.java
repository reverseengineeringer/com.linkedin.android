package com.linkedin.android.identity.profile;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class ProfileViewFragmentFactory
  extends FragmentFactory<ProfileBundleBuilder>
{
  protected final Fragment provideFragment()
  {
    return new ProfileHomeTabFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.ProfileViewFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */