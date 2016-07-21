package com.linkedin.android.growth.newtovoyager.banner;

import android.support.v4.app.Fragment;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class NewToVoyagerFeedFragmentFactory
  extends FragmentFactory<NewToVoyagerIntroBundle>
{
  public final Fragment provideFragment()
  {
    return new NewToVoyagerFeedFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */