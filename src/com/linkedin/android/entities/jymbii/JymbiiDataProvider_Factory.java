package com.linkedin.android.entities.jymbii;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class JymbiiDataProvider_Factory
  implements Factory<JymbiiDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<JymbiiDataProvider> membersInjector;
  
  static
  {
    if (!JymbiiDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private JymbiiDataProvider_Factory(MembersInjector<JymbiiDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<JymbiiDataProvider> create(MembersInjector<JymbiiDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new JymbiiDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.JymbiiDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */