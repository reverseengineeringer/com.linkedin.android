package com.linkedin.android.entities.jymbii;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class JymbiiIntent_Factory
  implements Factory<JymbiiIntent>
{
  private final MembersInjector<JymbiiIntent> membersInjector;
  
  static
  {
    if (!JymbiiIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private JymbiiIntent_Factory(MembersInjector<JymbiiIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<JymbiiIntent> create(MembersInjector<JymbiiIntent> paramMembersInjector)
  {
    return new JymbiiIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.JymbiiIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */