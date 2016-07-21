package com.linkedin.android.growth.login.join;

import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.network.Auth;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class JoinManager_Factory
  implements Factory<JoinManager>
{
  private final Provider<BaseActivity> activityProvider;
  private final Provider<Auth> authProvider;
  private final Provider<LoginUtils> loginUtilsProvider;
  
  static
  {
    if (!JoinManager_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private JoinManager_Factory(Provider<Auth> paramProvider, Provider<LoginUtils> paramProvider1, Provider<BaseActivity> paramProvider2)
  {
    assert (paramProvider != null);
    authProvider = paramProvider;
    assert (paramProvider1 != null);
    loginUtilsProvider = paramProvider1;
    assert (paramProvider2 != null);
    activityProvider = paramProvider2;
  }
  
  public static Factory<JoinManager> create(Provider<Auth> paramProvider, Provider<LoginUtils> paramProvider1, Provider<BaseActivity> paramProvider2)
  {
    return new JoinManager_Factory(paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinManager_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */