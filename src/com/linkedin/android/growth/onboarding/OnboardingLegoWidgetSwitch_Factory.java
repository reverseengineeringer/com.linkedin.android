package com.linkedin.android.growth.onboarding;

import android.content.Context;
import com.linkedin.android.infra.IntentRegistry;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class OnboardingLegoWidgetSwitch_Factory
  implements Factory<OnboardingLegoWidgetSwitch>
{
  private final Provider<Context> contextProvider;
  private final Provider<IntentRegistry> intentRegistryProvider;
  private final MembersInjector<OnboardingLegoWidgetSwitch> membersInjector;
  
  static
  {
    if (!OnboardingLegoWidgetSwitch_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingLegoWidgetSwitch_Factory(MembersInjector<OnboardingLegoWidgetSwitch> paramMembersInjector, Provider<Context> paramProvider, Provider<IntentRegistry> paramProvider1)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    contextProvider = paramProvider;
    assert (paramProvider1 != null);
    intentRegistryProvider = paramProvider1;
  }
  
  public static Factory<OnboardingLegoWidgetSwitch> create(MembersInjector<OnboardingLegoWidgetSwitch> paramMembersInjector, Provider<Context> paramProvider, Provider<IntentRegistry> paramProvider1)
  {
    return new OnboardingLegoWidgetSwitch_Factory(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */