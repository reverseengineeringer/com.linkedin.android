package com.linkedin.android.growth.login.fastrack;

import com.linkedin.android.growth.login.PrefillManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FastrackManager_MembersInjector
  implements MembersInjector<FastrackManager>
{
  private final Provider<PrefillManager> prefillManagerProvider;
  
  static
  {
    if (!FastrackManager_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FastrackManager_MembersInjector(Provider<PrefillManager> paramProvider)
  {
    assert (paramProvider != null);
    prefillManagerProvider = paramProvider;
  }
  
  public static MembersInjector<FastrackManager> create(Provider<PrefillManager> paramProvider)
  {
    return new FastrackManager_MembersInjector(paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.fastrack.FastrackManager_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */