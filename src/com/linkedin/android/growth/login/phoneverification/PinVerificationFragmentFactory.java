package com.linkedin.android.growth.login.phoneverification;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class PinVerificationFragmentFactory
  extends FragmentFactory<PinVerificationBundle>
{
  public final Fragment provideFragment()
  {
    return new PinVerificationFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */