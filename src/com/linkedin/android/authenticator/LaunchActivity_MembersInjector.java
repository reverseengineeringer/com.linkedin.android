package com.linkedin.android.authenticator;

import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.Auth;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LaunchActivity_MembersInjector
  implements MembersInjector<LaunchActivity>
{
  private final Provider<Auth> authProvider;
  private final Provider<Bus> busProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<LaunchUtils> launchUtilsProvider;
  private final Provider<FlagshipSharedPreferences> sharedPreferencesProvider;
  private final MembersInjector<BaseActivity> supertypeInjector;
  private final Provider<TakeoverManager> takeoverManagerProvider;
  
  static
  {
    if (!LaunchActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LaunchActivity_MembersInjector(MembersInjector<BaseActivity> paramMembersInjector, Provider<Auth> paramProvider, Provider<LaunchUtils> paramProvider1, Provider<TakeoverManager> paramProvider2, Provider<FlagshipSharedPreferences> paramProvider3, Provider<FlagshipDataManager> paramProvider4, Provider<Bus> paramProvider5)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    authProvider = paramProvider;
    assert (paramProvider1 != null);
    launchUtilsProvider = paramProvider1;
    assert (paramProvider2 != null);
    takeoverManagerProvider = paramProvider2;
    assert (paramProvider3 != null);
    sharedPreferencesProvider = paramProvider3;
    assert (paramProvider4 != null);
    dataManagerProvider = paramProvider4;
    assert (paramProvider5 != null);
    busProvider = paramProvider5;
  }
  
  public static MembersInjector<LaunchActivity> create(MembersInjector<BaseActivity> paramMembersInjector, Provider<Auth> paramProvider, Provider<LaunchUtils> paramProvider1, Provider<TakeoverManager> paramProvider2, Provider<FlagshipSharedPreferences> paramProvider3, Provider<FlagshipDataManager> paramProvider4, Provider<Bus> paramProvider5)
  {
    return new LaunchActivity_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.authenticator.LaunchActivity_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */