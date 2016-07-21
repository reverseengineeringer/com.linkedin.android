package com.linkedin.android.growth.login.phoneverification;

import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.SnackbarUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PhoneConfirmationFragment_MembersInjector
  implements MembersInjector<PhoneConfirmationFragment>
{
  private final Provider<Auth> authProvider;
  private final Provider<CountrySelectorManager> countrySelectorManagerProvider;
  private final Provider<SnackbarUtil> snackbarProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!PhoneConfirmationFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PhoneConfirmationFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<Auth> paramProvider, Provider<CountrySelectorManager> paramProvider1, Provider<SnackbarUtil> paramProvider2)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    authProvider = paramProvider;
    assert (paramProvider1 != null);
    countrySelectorManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    snackbarProvider = paramProvider2;
  }
  
  public static MembersInjector<PhoneConfirmationFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<Auth> paramProvider, Provider<CountrySelectorManager> paramProvider1, Provider<SnackbarUtil> paramProvider2)
  {
    return new PhoneConfirmationFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */