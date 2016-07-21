package com.linkedin.android.growth.abi;

import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.TimeWrapper;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AbiAutoSyncManager_MembersInjector
  implements MembersInjector<AbiAutoSyncManager>
{
  private final Provider<AbiContactsReader> abiContactsReaderProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private final Provider<LixManager> lixManagerProvider;
  private final Provider<MemberUtil> memberUtilProvider;
  private final Provider<TimeWrapper> timeWrapperProvider;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!AbiAutoSyncManager_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiAutoSyncManager_MembersInjector(Provider<FlagshipSharedPreferences> paramProvider, Provider<TimeWrapper> paramProvider1, Provider<FlagshipDataManager> paramProvider2, Provider<MemberUtil> paramProvider3, Provider<Tracker> paramProvider4, Provider<LixManager> paramProvider5, Provider<AbiContactsReader> paramProvider6)
  {
    assert (paramProvider != null);
    flagshipSharedPreferencesProvider = paramProvider;
    assert (paramProvider1 != null);
    timeWrapperProvider = paramProvider1;
    assert (paramProvider2 != null);
    dataManagerProvider = paramProvider2;
    assert (paramProvider3 != null);
    memberUtilProvider = paramProvider3;
    assert (paramProvider4 != null);
    trackerProvider = paramProvider4;
    assert (paramProvider5 != null);
    lixManagerProvider = paramProvider5;
    assert (paramProvider6 != null);
    abiContactsReaderProvider = paramProvider6;
  }
  
  public static MembersInjector<AbiAutoSyncManager> create(Provider<FlagshipSharedPreferences> paramProvider, Provider<TimeWrapper> paramProvider1, Provider<FlagshipDataManager> paramProvider2, Provider<MemberUtil> paramProvider3, Provider<Tracker> paramProvider4, Provider<LixManager> paramProvider5, Provider<AbiContactsReader> paramProvider6)
  {
    return new AbiAutoSyncManager_MembersInjector(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiAutoSyncManager_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */