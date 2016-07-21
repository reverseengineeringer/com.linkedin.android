package com.linkedin.android.growth.abi;

import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.TimeWrapper;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AbiCacheUtils_Factory
  implements Factory<AbiCacheUtils>
{
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private final Provider<LixManager> lixManagerProvider;
  private final Provider<TimeWrapper> timeWrapperProvider;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!AbiCacheUtils_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiCacheUtils_Factory(Provider<FlagshipDataManager> paramProvider, Provider<Tracker> paramProvider1, Provider<FlagshipSharedPreferences> paramProvider2, Provider<TimeWrapper> paramProvider3, Provider<LixManager> paramProvider4)
  {
    assert (paramProvider != null);
    dataManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    trackerProvider = paramProvider1;
    assert (paramProvider2 != null);
    flagshipSharedPreferencesProvider = paramProvider2;
    assert (paramProvider3 != null);
    timeWrapperProvider = paramProvider3;
    assert (paramProvider4 != null);
    lixManagerProvider = paramProvider4;
  }
  
  public static Factory<AbiCacheUtils> create(Provider<FlagshipDataManager> paramProvider, Provider<Tracker> paramProvider1, Provider<FlagshipSharedPreferences> paramProvider2, Provider<TimeWrapper> paramProvider3, Provider<LixManager> paramProvider4)
  {
    return new AbiCacheUtils_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiCacheUtils_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */