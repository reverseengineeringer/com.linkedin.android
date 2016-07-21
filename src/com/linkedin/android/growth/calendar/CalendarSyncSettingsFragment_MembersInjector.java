package com.linkedin.android.growth.calendar;

import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CalendarSyncSettingsFragment_MembersInjector
  implements MembersInjector<CalendarSyncSettingsFragment>
{
  private final Provider<CalendarSyncManager> calendarSyncManagerProvider;
  private final Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!CalendarSyncSettingsFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CalendarSyncSettingsFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<FlagshipSharedPreferences> paramProvider, Provider<CalendarSyncManager> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    flagshipSharedPreferencesProvider = paramProvider;
    assert (paramProvider1 != null);
    calendarSyncManagerProvider = paramProvider1;
  }
  
  public static MembersInjector<CalendarSyncSettingsFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<FlagshipSharedPreferences> paramProvider, Provider<CalendarSyncManager> paramProvider1)
  {
    return new CalendarSyncSettingsFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncSettingsFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */