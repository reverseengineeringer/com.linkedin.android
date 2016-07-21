package com.linkedin.android.growth.onboarding.base;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.viewmodel.ViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class OnboardingListFragment_MembersInjector<M extends FissileDataModel<M>, T extends ViewModel>
  implements MembersInjector<OnboardingListFragment<M, T>>
{
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<Bus> eventBusProvider;
  private final MembersInjector<LegoFragment> supertypeInjector;
  
  static
  {
    if (!OnboardingListFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private OnboardingListFragment_MembersInjector(MembersInjector<LegoFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<FlagshipDataManager> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    eventBusProvider = paramProvider;
    assert (paramProvider1 != null);
    dataManagerProvider = paramProvider1;
  }
  
  public static <M extends FissileDataModel<M>, T extends ViewModel> MembersInjector<OnboardingListFragment<M, T>> create(MembersInjector<LegoFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<FlagshipDataManager> paramProvider1)
  {
    return new OnboardingListFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingListFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */