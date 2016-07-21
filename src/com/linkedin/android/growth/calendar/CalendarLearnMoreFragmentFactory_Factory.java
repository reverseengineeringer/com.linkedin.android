package com.linkedin.android.growth.calendar;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class CalendarLearnMoreFragmentFactory_Factory
  implements Factory<CalendarLearnMoreFragmentFactory>
{
  private final MembersInjector<CalendarLearnMoreFragmentFactory> membersInjector;
  
  static
  {
    if (!CalendarLearnMoreFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CalendarLearnMoreFragmentFactory_Factory(MembersInjector<CalendarLearnMoreFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<CalendarLearnMoreFragmentFactory> create(MembersInjector<CalendarLearnMoreFragmentFactory> paramMembersInjector)
  {
    return new CalendarLearnMoreFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarLearnMoreFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */