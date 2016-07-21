package com.linkedin.android.growth.login.login;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class LoginFragmentFactory
  extends FragmentFactory<DefaultBundle>
{
  public final Fragment provideFragment()
  {
    return new LoginFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */