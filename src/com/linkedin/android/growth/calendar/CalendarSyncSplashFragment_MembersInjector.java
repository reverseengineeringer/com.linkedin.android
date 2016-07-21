package com.linkedin.android.growth.calendar;

import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.PageFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CalendarSyncSplashFragment_MembersInjector
  implements MembersInjector<CalendarSyncSplashFragment>
{
  private final Provider<FragmentRegistry> fragmentRegistryProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!CalendarSyncSplashFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CalendarSyncSplashFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<FragmentRegistry> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    fragmentRegistryProvider = paramProvider;
  }
  
  public static MembersInjector<CalendarSyncSplashFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<FragmentRegistry> paramProvider)
  {
    return new CalendarSyncSplashFragment_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncSplashFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */