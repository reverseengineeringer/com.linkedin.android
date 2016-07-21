package com.linkedin.android.entities.company;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class CompanyIntent_Factory
  implements Factory<CompanyIntent>
{
  private final MembersInjector<CompanyIntent> membersInjector;
  
  static
  {
    if (!CompanyIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CompanyIntent_Factory(MembersInjector<CompanyIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<CompanyIntent> create(MembersInjector<CompanyIntent> paramMembersInjector)
  {
    return new CompanyIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */