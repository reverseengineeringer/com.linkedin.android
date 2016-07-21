package com.linkedin.android.growth.login.presenters;

import com.linkedin.android.infra.network.I18NManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class InputValidationPresenter_Factory
  implements Factory<InputValidationPresenter>
{
  private final Provider<I18NManager> i18NManagerProvider;
  
  static
  {
    if (!InputValidationPresenter_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private InputValidationPresenter_Factory(Provider<I18NManager> paramProvider)
  {
    assert (paramProvider != null);
    i18NManagerProvider = paramProvider;
  }
  
  public static Factory<InputValidationPresenter> create(Provider<I18NManager> paramProvider)
  {
    return new InputValidationPresenter_Factory(paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.presenters.InputValidationPresenter_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */