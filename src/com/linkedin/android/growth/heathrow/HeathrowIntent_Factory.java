package com.linkedin.android.growth.heathrow;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class HeathrowIntent_Factory
  implements Factory<HeathrowIntent>
{
  private final MembersInjector<HeathrowIntent> membersInjector;
  
  static
  {
    if (!HeathrowIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private HeathrowIntent_Factory(MembersInjector<HeathrowIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<HeathrowIntent> create(MembersInjector<HeathrowIntent> paramMembersInjector)
  {
    return new HeathrowIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */