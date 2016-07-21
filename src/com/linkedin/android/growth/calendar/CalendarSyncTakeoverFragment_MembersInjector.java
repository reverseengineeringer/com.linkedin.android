package com.linkedin.android.growth.calendar;

import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.SnackbarUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CalendarSyncTakeoverFragment_MembersInjector
  implements MembersInjector<CalendarSyncTakeoverFragment>
{
  private final Provider<CalendarSyncManager> calendarSyncManagerProvider;
  private final Provider<FragmentRegistry> fragmentRegistryProvider;
  private final Provider<I18NManager> i18nManagerProvider;
  private final Provider<LegoTrackingDataProvider> legoTrackingDataProvider;
  private final Provider<SnackbarUtil> snackbarUtilProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!CalendarSyncTakeoverFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CalendarSyncTakeoverFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<I18NManager> paramProvider, Provider<FragmentRegistry> paramProvider1, Provider<LegoTrackingDataProvider> paramProvider2, Provider<CalendarSyncManager> paramProvider3, Provider<SnackbarUtil> paramProvider4)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    i18nManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    fragmentRegistryProvider = paramProvider1;
    assert (paramProvider2 != null);
    legoTrackingDataProvider = paramProvider2;
    assert (paramProvider3 != null);
    calendarSyncManagerProvider = paramProvider3;
    assert (paramProvider4 != null);
    snackbarUtilProvider = paramProvider4;
  }
  
  public static MembersInjector<CalendarSyncTakeoverFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<I18NManager> paramProvider, Provider<FragmentRegistry> paramProvider1, Provider<LegoTrackingDataProvider> paramProvider2, Provider<CalendarSyncManager> paramProvider3, Provider<SnackbarUtil> paramProvider4)
  {
    return new CalendarSyncTakeoverFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */