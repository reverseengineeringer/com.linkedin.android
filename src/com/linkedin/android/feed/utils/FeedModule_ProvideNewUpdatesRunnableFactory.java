package com.linkedin.android.feed.utils;

import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FeedModule_ProvideNewUpdatesRunnableFactory
  implements Factory<CheckForNewUpdatesRunnable>
{
  private final Provider<Bus> busProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<DelayedExecution> delayedExecutionProvider;
  private final Provider<FeedKeyValueStore> feedKeyValueStoreProvider;
  private final Provider<LixManager> lixManagerProvider;
  private final FeedModule module;
  private final Provider<FlagshipSharedPreferences> sharedPrefsProvider;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!FeedModule_ProvideNewUpdatesRunnableFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedModule_ProvideNewUpdatesRunnableFactory(FeedModule paramFeedModule, Provider<FlagshipDataManager> paramProvider, Provider<DelayedExecution> paramProvider1, Provider<Tracker> paramProvider2, Provider<FlagshipSharedPreferences> paramProvider3, Provider<FeedKeyValueStore> paramProvider4, Provider<Bus> paramProvider5, Provider<LixManager> paramProvider6)
  {
    assert (paramFeedModule != null);
    module = paramFeedModule;
    assert (paramProvider != null);
    dataManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    delayedExecutionProvider = paramProvider1;
    assert (paramProvider2 != null);
    trackerProvider = paramProvider2;
    assert (paramProvider3 != null);
    sharedPrefsProvider = paramProvider3;
    assert (paramProvider4 != null);
    feedKeyValueStoreProvider = paramProvider4;
    assert (paramProvider5 != null);
    busProvider = paramProvider5;
    assert (paramProvider6 != null);
    lixManagerProvider = paramProvider6;
  }
  
  public static Factory<CheckForNewUpdatesRunnable> create(FeedModule paramFeedModule, Provider<FlagshipDataManager> paramProvider, Provider<DelayedExecution> paramProvider1, Provider<Tracker> paramProvider2, Provider<FlagshipSharedPreferences> paramProvider3, Provider<FeedKeyValueStore> paramProvider4, Provider<Bus> paramProvider5, Provider<LixManager> paramProvider6)
  {
    return new FeedModule_ProvideNewUpdatesRunnableFactory(paramFeedModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule_ProvideNewUpdatesRunnableFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */