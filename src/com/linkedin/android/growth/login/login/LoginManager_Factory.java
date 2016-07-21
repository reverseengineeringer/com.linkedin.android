package com.linkedin.android.growth.login.login;

import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.NetworkClient;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LoginManager_Factory
  implements Factory<LoginManager>
{
  private final Provider<BaseActivity> activityProvider;
  private final Provider<Auth> authProvider;
  private final Provider<LoginUtils> loginUtilsProvider;
  private final Provider<NetworkClient> networkClientProvider;
  private final Provider<TakeoverManager> takeoverManagerProvider;
  
  static
  {
    if (!LoginManager_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LoginManager_Factory(Provider<Auth> paramProvider, Provider<LoginUtils> paramProvider1, Provider<BaseActivity> paramProvider2, Provider<TakeoverManager> paramProvider3, Provider<NetworkClient> paramProvider4)
  {
    assert (paramProvider != null);
    authProvider = paramProvider;
    assert (paramProvider1 != null);
    loginUtilsProvider = paramProvider1;
    assert (paramProvider2 != null);
    activityProvider = paramProvider2;
    assert (paramProvider3 != null);
    takeoverManagerProvider = paramProvider3;
    assert (paramProvider4 != null);
    networkClientProvider = paramProvider4;
  }
  
  public static Factory<LoginManager> create(Provider<Auth> paramProvider, Provider<LoginUtils> paramProvider1, Provider<BaseActivity> paramProvider2, Provider<TakeoverManager> paramProvider3, Provider<NetworkClient> paramProvider4)
  {
    return new LoginManager_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginManager_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */