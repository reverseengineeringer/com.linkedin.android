package com.linkedin.android.growth.onboarding.base;

import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OnboardingProfileEditFragment_MembersInjector
  implements MembersInjector<OnboardingProfileEditFragment>
{
  private final Provider<KeyboardUtil> keyboardUtilProvider;
  private final Provider<LixManager> lixManagerProvider;
  private final Provider<SnackbarUtil> snackBarProvider;
  private final MembersInjector<LegoFragment> supertypeInjector;
  
  static
  {
    if (!OnboardingProfileEditFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingProfileEditFragment_MembersInjector(MembersInjector<LegoFragment> paramMembersInjector, Provider<SnackbarUtil> paramProvider, Provider<KeyboardUtil> paramProvider1, Provider<LixManager> paramProvider2)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    snackBarProvider = paramProvider;
    assert (paramProvider1 != null);
    keyboardUtilProvider = paramProvider1;
    assert (paramProvider2 != null);
    lixManagerProvider = paramProvider2;
  }
  
  public static MembersInjector<OnboardingProfileEditFragment> create(MembersInjector<LegoFragment> paramMembersInjector, Provider<SnackbarUtil> paramProvider, Provider<KeyboardUtil> paramProvider1, Provider<LixManager> paramProvider2)
  {
    return new OnboardingProfileEditFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */