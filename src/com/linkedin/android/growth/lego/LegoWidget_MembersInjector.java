package com.linkedin.android.growth.lego;

import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LegoWidget_MembersInjector
  implements MembersInjector<LegoWidget>
{
  private final Provider<FragmentRegistry> fragmentRegistryProvider;
  private final MembersInjector<BaseFragment> supertypeInjector;
  
  static
  {
    if (!LegoWidget_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LegoWidget_MembersInjector(MembersInjector<BaseFragment> paramMembersInjector, Provider<FragmentRegistry> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    fragmentRegistryProvider = paramProvider;
  }
  
  public static MembersInjector<LegoWidget> create(MembersInjector<BaseFragment> paramMembersInjector, Provider<FragmentRegistry> paramProvider)
  {
    return new LegoWidget_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoWidget_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */