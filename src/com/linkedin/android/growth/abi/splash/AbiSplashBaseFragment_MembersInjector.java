package com.linkedin.android.growth.abi.splash;

import android.support.v4.app.FragmentManager;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.infra.FragmentRegistry;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AbiSplashBaseFragment_MembersInjector
  implements MembersInjector<AbiSplashBaseFragment>
{
  private final Provider<FragmentManager> fragmentManagerProvider;
  private final Provider<FragmentRegistry> fragmentRegistryProvider;
  private final MembersInjector<LegoFragment> supertypeInjector;
  
  static
  {
    if (!AbiSplashBaseFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiSplashBaseFragment_MembersInjector(MembersInjector<LegoFragment> paramMembersInjector, Provider<FragmentRegistry> paramProvider, Provider<FragmentManager> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    fragmentRegistryProvider = paramProvider;
    assert (paramProvider1 != null);
    fragmentManagerProvider = paramProvider1;
  }
  
  public static MembersInjector<AbiSplashBaseFragment> create(MembersInjector<LegoFragment> paramMembersInjector, Provider<FragmentRegistry> paramProvider, Provider<FragmentManager> paramProvider1)
  {
    return new AbiSplashBaseFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiSplashBaseFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */