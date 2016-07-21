package com.linkedin.android.growth.login;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PrefillManager_Factory
  implements Factory<PrefillManager>
{
  private final Provider<Context> contextProvider;
  
  static
  {
    if (!PrefillManager_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PrefillManager_Factory(Provider<Context> paramProvider)
  {
    assert (paramProvider != null);
    contextProvider = paramProvider;
  }
  
  public static Factory<PrefillManager> create(Provider<Context> paramProvider)
  {
    return new PrefillManager_Factory(paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.PrefillManager_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */