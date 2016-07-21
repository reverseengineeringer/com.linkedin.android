package com.linkedin.android.growth.login;

import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LoginUtils_Factory
  implements Factory<LoginUtils>
{
  private final Provider<Auth> authProvider;
  private final Provider<LaunchUtils> launchUtilsProvider;
  private final Provider<LixManager> lixManagerProvider;
  
  static
  {
    if (!LoginUtils_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LoginUtils_Factory(Provider<LaunchUtils> paramProvider, Provider<LixManager> paramProvider1, Provider<Auth> paramProvider2)
  {
    assert (paramProvider != null);
    launchUtilsProvider = paramProvider;
    assert (paramProvider1 != null);
    lixManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    authProvider = paramProvider2;
  }
  
  public static Factory<LoginUtils> create(Provider<LaunchUtils> paramProvider, Provider<LixManager> paramProvider1, Provider<Auth> paramProvider2)
  {
    return new LoginUtils_Factory(paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginUtils_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */