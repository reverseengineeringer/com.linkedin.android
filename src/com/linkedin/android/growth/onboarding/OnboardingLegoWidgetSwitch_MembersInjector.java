package com.linkedin.android.growth.onboarding;

import com.linkedin.android.growth.lego.LegoWidgetSwitch;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OnboardingLegoWidgetSwitch_MembersInjector
  implements MembersInjector<OnboardingLegoWidgetSwitch>
{
  private final Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private final Provider<FragmentRegistry> fragmentRegistryProvider;
  private final MembersInjector<LegoWidgetSwitch> supertypeInjector;
  
  static
  {
    if (!OnboardingLegoWidgetSwitch_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingLegoWidgetSwitch_MembersInjector(MembersInjector<LegoWidgetSwitch> paramMembersInjector, Provider<FragmentRegistry> paramProvider, Provider<FlagshipSharedPreferences> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    fragmentRegistryProvider = paramProvider;
    assert (paramProvider1 != null);
    flagshipSharedPreferencesProvider = paramProvider1;
  }
  
  public static MembersInjector<OnboardingLegoWidgetSwitch> create(MembersInjector<LegoWidgetSwitch> paramMembersInjector, Provider<FragmentRegistry> paramProvider, Provider<FlagshipSharedPreferences> paramProvider1)
  {
    return new OnboardingLegoWidgetSwitch_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */