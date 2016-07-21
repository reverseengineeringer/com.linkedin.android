package com.linkedin.android.growth.login;

import android.support.v4.app.FragmentManager;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.login.sso.SSOManager;
import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.l2m.notification.NotificationUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LoginActivity_MembersInjector
  implements MembersInjector<LoginActivity>
{
  private final Provider<Auth> authProvider;
  private final Provider<Bus> busProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<FragmentManager> fragmentManagerProvider;
  private final Provider<FragmentRegistry> fragmentRegistryProvider;
  private final Provider<GoogleIdTokenManager> googleIdTokenManagerProvider;
  private final Provider<LaunchUtils> launchUtilsProvider;
  private final Provider<PreAuthLixManager> lixManagerProvider;
  private final Provider<LoginManager> loginManagerProvider;
  private final Provider<LoginUtils> loginUtilsProvider;
  private final Provider<NotificationUtils> notificationUtilsProvider;
  private final Provider<FlagshipSharedPreferences> sharedPreferencesProvider;
  private final Provider<SmartLockManager> smartLockManagerProvider;
  private final Provider<SnackbarUtil> snackbarProvider;
  private final Provider<SSOManager> ssoManagerProvider;
  private final MembersInjector<BaseActivity> supertypeInjector;
  private final Provider<TakeoverManager> takeoverManagerProvider;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!LoginActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LoginActivity_MembersInjector(MembersInjector<BaseActivity> paramMembersInjector, Provider<Auth> paramProvider, Provider<LoginUtils> paramProvider1, Provider<LoginManager> paramProvider2, Provider<PreAuthLixManager> paramProvider3, Provider<LaunchUtils> paramProvider4, Provider<FragmentRegistry> paramProvider5, Provider<FragmentManager> paramProvider6, Provider<SmartLockManager> paramProvider7, Provider<GoogleIdTokenManager> paramProvider8, Provider<SSOManager> paramProvider9, Provider<NotificationUtils> paramProvider10, Provider<FlagshipSharedPreferences> paramProvider11, Provider<TakeoverManager> paramProvider12, Provider<FlagshipDataManager> paramProvider13, Provider<Bus> paramProvider14, Provider<SnackbarUtil> paramProvider15, Provider<Tracker> paramProvider16)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    authProvider = paramProvider;
    assert (paramProvider1 != null);
    loginUtilsProvider = paramProvider1;
    assert (paramProvider2 != null);
    loginManagerProvider = paramProvider2;
    assert (paramProvider3 != null);
    lixManagerProvider = paramProvider3;
    assert (paramProvider4 != null);
    launchUtilsProvider = paramProvider4;
    assert (paramProvider5 != null);
    fragmentRegistryProvider = paramProvider5;
    assert (paramProvider6 != null);
    fragmentManagerProvider = paramProvider6;
    assert (paramProvider7 != null);
    smartLockManagerProvider = paramProvider7;
    assert (paramProvider8 != null);
    googleIdTokenManagerProvider = paramProvider8;
    assert (paramProvider9 != null);
    ssoManagerProvider = paramProvider9;
    assert (paramProvider10 != null);
    notificationUtilsProvider = paramProvider10;
    assert (paramProvider11 != null);
    sharedPreferencesProvider = paramProvider11;
    assert (paramProvider12 != null);
    takeoverManagerProvider = paramProvider12;
    assert (paramProvider13 != null);
    dataManagerProvider = paramProvider13;
    assert (paramProvider14 != null);
    busProvider = paramProvider14;
    assert (paramProvider15 != null);
    snackbarProvider = paramProvider15;
    assert (paramProvider16 != null);
    trackerProvider = paramProvider16;
  }
  
  public static MembersInjector<LoginActivity> create(MembersInjector<BaseActivity> paramMembersInjector, Provider<Auth> paramProvider, Provider<LoginUtils> paramProvider1, Provider<LoginManager> paramProvider2, Provider<PreAuthLixManager> paramProvider3, Provider<LaunchUtils> paramProvider4, Provider<FragmentRegistry> paramProvider5, Provider<FragmentManager> paramProvider6, Provider<SmartLockManager> paramProvider7, Provider<GoogleIdTokenManager> paramProvider8, Provider<SSOManager> paramProvider9, Provider<NotificationUtils> paramProvider10, Provider<FlagshipSharedPreferences> paramProvider11, Provider<TakeoverManager> paramProvider12, Provider<FlagshipDataManager> paramProvider13, Provider<Bus> paramProvider14, Provider<SnackbarUtil> paramProvider15, Provider<Tracker> paramProvider16)
  {
    return new LoginActivity_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9, paramProvider10, paramProvider11, paramProvider12, paramProvider13, paramProvider14, paramProvider15, paramProvider16);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginActivity_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */