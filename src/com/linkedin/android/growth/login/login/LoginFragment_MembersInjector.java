package com.linkedin.android.growth.login.login;

import com.linkedin.android.growth.login.PrefillManager;
import com.linkedin.android.growth.login.fastrack.FastrackManager;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.utils.InputValidator;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LoginFragment_MembersInjector
  implements MembersInjector<LoginFragment>
{
  private final Provider<FastrackManager> fastrackManagerProvider;
  private final Provider<GoogleIdTokenManager> googleIdTokenManagerProvider;
  private final Provider<InputValidator> inputValidatorProvider;
  private final Provider<PreAuthLixManager> lixManagerProvider;
  private final Provider<LoginManager> loginManagerProvider;
  private final Provider<MemberUtil> memberUtilProvider;
  private final Provider<PasswordVisibilityPresenter> passwordVisibilityPresenterProvider;
  private final Provider<PrefillManager> prefillManagerProvider;
  private final Provider<FlagshipSharedPreferences> sharedPreferencesProvider;
  private final Provider<SmartLockManager> smartLockManagerProvider;
  private final Provider<SnackbarUtil> snackbarProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!LoginFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LoginFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<MemberUtil> paramProvider, Provider<FlagshipSharedPreferences> paramProvider1, Provider<PasswordVisibilityPresenter> paramProvider2, Provider<InputValidator> paramProvider3, Provider<LoginManager> paramProvider4, Provider<FastrackManager> paramProvider5, Provider<PreAuthLixManager> paramProvider6, Provider<Tracker> paramProvider7, Provider<SnackbarUtil> paramProvider8, Provider<SmartLockManager> paramProvider9, Provider<GoogleIdTokenManager> paramProvider10, Provider<PrefillManager> paramProvider11)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    memberUtilProvider = paramProvider;
    assert (paramProvider1 != null);
    sharedPreferencesProvider = paramProvider1;
    assert (paramProvider2 != null);
    passwordVisibilityPresenterProvider = paramProvider2;
    assert (paramProvider3 != null);
    inputValidatorProvider = paramProvider3;
    assert (paramProvider4 != null);
    loginManagerProvider = paramProvider4;
    assert (paramProvider5 != null);
    fastrackManagerProvider = paramProvider5;
    assert (paramProvider6 != null);
    lixManagerProvider = paramProvider6;
    assert (paramProvider7 != null);
    trackerProvider = paramProvider7;
    assert (paramProvider8 != null);
    snackbarProvider = paramProvider8;
    assert (paramProvider9 != null);
    smartLockManagerProvider = paramProvider9;
    assert (paramProvider10 != null);
    googleIdTokenManagerProvider = paramProvider10;
    assert (paramProvider11 != null);
    prefillManagerProvider = paramProvider11;
  }
  
  public static MembersInjector<LoginFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<MemberUtil> paramProvider, Provider<FlagshipSharedPreferences> paramProvider1, Provider<PasswordVisibilityPresenter> paramProvider2, Provider<InputValidator> paramProvider3, Provider<LoginManager> paramProvider4, Provider<FastrackManager> paramProvider5, Provider<PreAuthLixManager> paramProvider6, Provider<Tracker> paramProvider7, Provider<SnackbarUtil> paramProvider8, Provider<SmartLockManager> paramProvider9, Provider<GoogleIdTokenManager> paramProvider10, Provider<PrefillManager> paramProvider11)
  {
    return new LoginFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9, paramProvider10, paramProvider11);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */