package com.linkedin.android.growth.login.join;

import com.linkedin.android.growth.login.PrefillManager;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.utils.InputValidator;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.StringUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class JoinFragment_MembersInjector
  implements MembersInjector<JoinFragment>
{
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private final Provider<I18NManager> i18nManagerProvider;
  private final Provider<InputValidator> inputValidatorProvider;
  private final Provider<JoinManager> joinManagerProvider;
  private final Provider<KeyboardUtil> keyboardUtilProvider;
  private final Provider<LoginManager> loginManagerProvider;
  private final Provider<PasswordVisibilityPresenter> passwordVisibilityPresenterProvider;
  private final Provider<PreAuthLixManager> preAuthLixManagerProvider;
  private final Provider<PrefillManager> prefillManagerProvider;
  private final Provider<SmartLockManager> smartLockManagerProvider;
  private final Provider<SnackbarUtil> snackBarProvider;
  private final Provider<StringUtils> stringUtilsProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!JoinFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private JoinFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<Tracker> paramProvider, Provider<I18NManager> paramProvider1, Provider<StringUtils> paramProvider2, Provider<PasswordVisibilityPresenter> paramProvider3, Provider<InputValidator> paramProvider4, Provider<KeyboardUtil> paramProvider5, Provider<JoinManager> paramProvider6, Provider<PreAuthLixManager> paramProvider7, Provider<SnackbarUtil> paramProvider8, Provider<LoginManager> paramProvider9, Provider<SmartLockManager> paramProvider10, Provider<PrefillManager> paramProvider11, Provider<FlagshipDataManager> paramProvider12, Provider<FlagshipSharedPreferences> paramProvider13)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    trackerProvider = paramProvider;
    assert (paramProvider1 != null);
    i18nManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    stringUtilsProvider = paramProvider2;
    assert (paramProvider3 != null);
    passwordVisibilityPresenterProvider = paramProvider3;
    assert (paramProvider4 != null);
    inputValidatorProvider = paramProvider4;
    assert (paramProvider5 != null);
    keyboardUtilProvider = paramProvider5;
    assert (paramProvider6 != null);
    joinManagerProvider = paramProvider6;
    assert (paramProvider7 != null);
    preAuthLixManagerProvider = paramProvider7;
    assert (paramProvider8 != null);
    snackBarProvider = paramProvider8;
    assert (paramProvider9 != null);
    loginManagerProvider = paramProvider9;
    assert (paramProvider10 != null);
    smartLockManagerProvider = paramProvider10;
    assert (paramProvider11 != null);
    prefillManagerProvider = paramProvider11;
    assert (paramProvider12 != null);
    dataManagerProvider = paramProvider12;
    assert (paramProvider13 != null);
    flagshipSharedPreferencesProvider = paramProvider13;
  }
  
  public static MembersInjector<JoinFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<Tracker> paramProvider, Provider<I18NManager> paramProvider1, Provider<StringUtils> paramProvider2, Provider<PasswordVisibilityPresenter> paramProvider3, Provider<InputValidator> paramProvider4, Provider<KeyboardUtil> paramProvider5, Provider<JoinManager> paramProvider6, Provider<PreAuthLixManager> paramProvider7, Provider<SnackbarUtil> paramProvider8, Provider<LoginManager> paramProvider9, Provider<SmartLockManager> paramProvider10, Provider<PrefillManager> paramProvider11, Provider<FlagshipDataManager> paramProvider12, Provider<FlagshipSharedPreferences> paramProvider13)
  {
    return new JoinFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9, paramProvider10, paramProvider11, paramProvider12, paramProvider13);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */