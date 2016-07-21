package com.linkedin.android.growth.boost.error;

import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.PageFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BoostErrorFragment_MembersInjector
  implements MembersInjector<BoostErrorFragment>
{
  private final Provider<IntentRegistry> intentRegistryProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!BoostErrorFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private BoostErrorFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<IntentRegistry> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    intentRegistryProvider = paramProvider;
  }
  
  public static MembersInjector<BoostErrorFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<IntentRegistry> paramProvider)
  {
    return new BoostErrorFragment_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.error.BoostErrorFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */