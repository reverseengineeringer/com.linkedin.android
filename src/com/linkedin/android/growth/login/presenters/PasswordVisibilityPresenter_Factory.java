package com.linkedin.android.growth.login.presenters;

import com.linkedin.android.infra.network.I18NManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PasswordVisibilityPresenter_Factory
  implements Factory<PasswordVisibilityPresenter>
{
  private final Provider<I18NManager> i18nManagerProvider;
  
  static
  {
    if (!PasswordVisibilityPresenter_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PasswordVisibilityPresenter_Factory(Provider<I18NManager> paramProvider)
  {
    assert (paramProvider != null);
    i18nManagerProvider = paramProvider;
  }
  
  public static Factory<PasswordVisibilityPresenter> create(Provider<I18NManager> paramProvider)
  {
    return new PasswordVisibilityPresenter_Factory(paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */