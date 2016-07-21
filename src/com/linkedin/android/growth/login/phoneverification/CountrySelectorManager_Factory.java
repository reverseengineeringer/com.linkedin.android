package com.linkedin.android.growth.login.phoneverification;

import com.linkedin.android.infra.app.BaseActivity;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CountrySelectorManager_Factory
  implements Factory<CountrySelectorManager>
{
  private final Provider<BaseActivity> activityProvider;
  
  static
  {
    if (!CountrySelectorManager_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CountrySelectorManager_Factory(Provider<BaseActivity> paramProvider)
  {
    assert (paramProvider != null);
    activityProvider = paramProvider;
  }
  
  public static Factory<CountrySelectorManager> create(Provider<BaseActivity> paramProvider)
  {
    return new CountrySelectorManager_Factory(paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.CountrySelectorManager_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */