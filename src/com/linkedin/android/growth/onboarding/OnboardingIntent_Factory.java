package com.linkedin.android.growth.onboarding;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class OnboardingIntent_Factory
  implements Factory<OnboardingIntent>
{
  private final MembersInjector<OnboardingIntent> membersInjector;
  
  static
  {
    if (!OnboardingIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingIntent_Factory(MembersInjector<OnboardingIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<OnboardingIntent> create(MembersInjector<OnboardingIntent> paramMembersInjector)
  {
    return new OnboardingIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */