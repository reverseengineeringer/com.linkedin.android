package com.linkedin.android.growth.login.join;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class JoinFragmentFactory
  extends FragmentFactory<DefaultBundle>
{
  public final Fragment provideFragment()
  {
    return new JoinFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */