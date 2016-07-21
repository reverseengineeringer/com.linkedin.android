package com.linkedin.android.growth.onboarding.rbmf;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class RebuildMyFeedFactory
  extends FragmentFactory<RebuildMyFeedBundleBuilder>
{
  protected final Fragment provideFragment()
  {
    return new RebuildMyFeedFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */