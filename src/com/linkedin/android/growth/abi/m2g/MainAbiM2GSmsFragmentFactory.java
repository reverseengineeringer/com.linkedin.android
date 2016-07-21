package com.linkedin.android.growth.abi.m2g;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class MainAbiM2GSmsFragmentFactory
  extends FragmentFactory<DefaultBundle>
{
  protected final Fragment provideFragment()
  {
    return new MainAbiM2GSmsFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2g.MainAbiM2GSmsFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */