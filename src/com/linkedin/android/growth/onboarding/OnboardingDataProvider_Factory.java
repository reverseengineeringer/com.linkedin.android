package com.linkedin.android.growth.onboarding;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class OnboardingDataProvider_Factory
  implements Factory<OnboardingDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<OnboardingDataProvider> membersInjector;
  
  static
  {
    if (!OnboardingDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingDataProvider_Factory(MembersInjector<OnboardingDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<OnboardingDataProvider> create(MembersInjector<OnboardingDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new OnboardingDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */