package com.linkedin.android.growth.abi;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class AbiPrepareFragmentFactory
  extends FragmentFactory<AbiPrepareBundle>
{
  protected final Fragment provideFragment()
  {
    return new AbiPrepareFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiPrepareFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */