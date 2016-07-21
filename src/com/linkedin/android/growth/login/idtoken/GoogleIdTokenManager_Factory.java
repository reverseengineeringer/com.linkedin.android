package com.linkedin.android.growth.login.idtoken;

import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GoogleIdTokenManager_Factory
  implements Factory<GoogleIdTokenManager>
{
  private final Provider<BaseActivity> activityProvider;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!GoogleIdTokenManager_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private GoogleIdTokenManager_Factory(Provider<BaseActivity> paramProvider, Provider<Tracker> paramProvider1)
  {
    assert (paramProvider != null);
    activityProvider = paramProvider;
    assert (paramProvider1 != null);
    trackerProvider = paramProvider1;
  }
  
  public static Factory<GoogleIdTokenManager> create(Provider<BaseActivity> paramProvider, Provider<Tracker> paramProvider1)
  {
    return new GoogleIdTokenManager_Factory(paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */