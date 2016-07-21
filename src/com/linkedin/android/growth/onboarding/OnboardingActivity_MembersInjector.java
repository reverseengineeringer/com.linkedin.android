package com.linkedin.android.growth.onboarding;

import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OnboardingActivity_MembersInjector
  implements MembersInjector<OnboardingActivity>
{
  private final Provider<FragmentRegistry> fragmentRegistryProvider;
  private final Provider<I18NManager> i18nManagerProvider;
  private final Provider<LegoManager> managerProvider;
  private final Provider<MemberUtil> memberUtilProvider;
  private final Provider<OnboardingDataProvider> onboardingDataProvider;
  private final Provider<OnboardingLegoWidgetSwitch> onboardingLegoWidgetSwitchProvider;
  private final MembersInjector<BaseActivity> supertypeInjector;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!OnboardingActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingActivity_MembersInjector(MembersInjector<BaseActivity> paramMembersInjector, Provider<LegoManager> paramProvider, Provider<OnboardingLegoWidgetSwitch> paramProvider1, Provider<OnboardingDataProvider> paramProvider2, Provider<Tracker> paramProvider3, Provider<FragmentRegistry> paramProvider4, Provider<MemberUtil> paramProvider5, Provider<I18NManager> paramProvider6)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    managerProvider = paramProvider;
    assert (paramProvider1 != null);
    onboardingLegoWidgetSwitchProvider = paramProvider1;
    assert (paramProvider2 != null);
    onboardingDataProvider = paramProvider2;
    assert (paramProvider3 != null);
    trackerProvider = paramProvider3;
    assert (paramProvider4 != null);
    fragmentRegistryProvider = paramProvider4;
    assert (paramProvider5 != null);
    memberUtilProvider = paramProvider5;
    assert (paramProvider6 != null);
    i18nManagerProvider = paramProvider6;
  }
  
  public static MembersInjector<OnboardingActivity> create(MembersInjector<BaseActivity> paramMembersInjector, Provider<LegoManager> paramProvider, Provider<OnboardingLegoWidgetSwitch> paramProvider1, Provider<OnboardingDataProvider> paramProvider2, Provider<Tracker> paramProvider3, Provider<FragmentRegistry> paramProvider4, Provider<MemberUtil> paramProvider5, Provider<I18NManager> paramProvider6)
  {
    return new OnboardingActivity_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingActivity_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */