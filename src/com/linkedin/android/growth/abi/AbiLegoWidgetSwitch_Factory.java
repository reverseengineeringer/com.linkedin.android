package com.linkedin.android.growth.abi;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class AbiLegoWidgetSwitch_Factory
  implements Factory<AbiLegoWidgetSwitch>
{
  private final MembersInjector<AbiLegoWidgetSwitch> membersInjector;
  
  static
  {
    if (!AbiLegoWidgetSwitch_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiLegoWidgetSwitch_Factory(MembersInjector<AbiLegoWidgetSwitch> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<AbiLegoWidgetSwitch> create(MembersInjector<AbiLegoWidgetSwitch> paramMembersInjector)
  {
    return new AbiLegoWidgetSwitch_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiLegoWidgetSwitch_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */