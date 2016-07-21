package com.linkedin.android.growth.login.phoneverification;

import com.linkedin.android.growth.login.join.JoinManager;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.SnackbarUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PinVerificationFragment_MembersInjector
  implements MembersInjector<PinVerificationFragment>
{
  private final Provider<Auth> authProvider;
  private final Provider<JoinManager> joinManagerProvider;
  private final Provider<SnackbarUtil> snackbarProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!PinVerificationFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PinVerificationFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<Auth> paramProvider, Provider<JoinManager> paramProvider1, Provider<SnackbarUtil> paramProvider2)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    authProvider = paramProvider;
    assert (paramProvider1 != null);
    joinManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    snackbarProvider = paramProvider2;
  }
  
  public static MembersInjector<PinVerificationFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<Auth> paramProvider, Provider<JoinManager> paramProvider1, Provider<SnackbarUtil> paramProvider2)
  {
    return new PinVerificationFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */