package com.linkedin.android.entities.company;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CompanyDataProvider_Factory
  implements Factory<CompanyDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<CompanyDataProvider> membersInjector;
  
  static
  {
    if (!CompanyDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CompanyDataProvider_Factory(MembersInjector<CompanyDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<CompanyDataProvider> create(MembersInjector<CompanyDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new CompanyDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */