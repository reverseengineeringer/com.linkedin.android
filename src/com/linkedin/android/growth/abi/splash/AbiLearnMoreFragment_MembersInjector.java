package com.linkedin.android.growth.abi.splash;

import android.support.v4.app.FragmentManager;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.PageFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AbiLearnMoreFragment_MembersInjector
  implements MembersInjector<AbiLearnMoreFragment>
{
  private final Provider<FragmentManager> fragmentManagerProvider;
  private final Provider<FragmentRegistry> fragmentRegistryProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!AbiLearnMoreFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiLearnMoreFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<FragmentRegistry> paramProvider, Provider<FragmentManager> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    fragmentRegistryProvider = paramProvider;
    assert (paramProvider1 != null);
    fragmentManagerProvider = paramProvider1;
  }
  
  public static MembersInjector<AbiLearnMoreFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<FragmentRegistry> paramProvider, Provider<FragmentManager> paramProvider1)
  {
    return new AbiLearnMoreFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiLearnMoreFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */