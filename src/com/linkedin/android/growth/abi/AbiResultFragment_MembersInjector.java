package com.linkedin.android.growth.abi;

import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.infra.events.Bus;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AbiResultFragment_MembersInjector
  implements MembersInjector<AbiResultFragment>
{
  private final Provider<Bus> eventBusProvider;
  private final MembersInjector<LegoFragment> supertypeInjector;
  
  static
  {
    if (!AbiResultFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiResultFragment_MembersInjector(MembersInjector<LegoFragment> paramMembersInjector, Provider<Bus> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    eventBusProvider = paramProvider;
  }
  
  public static MembersInjector<AbiResultFragment> create(MembersInjector<LegoFragment> paramMembersInjector, Provider<Bus> paramProvider)
  {
    return new AbiResultFragment_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiResultFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */