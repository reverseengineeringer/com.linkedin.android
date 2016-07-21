package com.linkedin.android.growth.newtovoyager.organic;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class NewToVoyagerIntroFragmentFactory
  extends FragmentFactory<NewToVoyagerIntroBundle>
{
  public final Fragment provideFragment()
  {
    return new NewToVoyagerIntroFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */