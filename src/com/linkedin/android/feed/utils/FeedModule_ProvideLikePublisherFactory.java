package com.linkedin.android.feed.utils;

import com.linkedin.android.feed.shared.liking.LikePublisher;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.consistency.ConsistencyManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FeedModule_ProvideLikePublisherFactory
  implements Factory<LikePublisher>
{
  private final Provider<FlagshipApplication> appProvider;
  private final Provider<Bus> busProvider;
  private final Provider<ConsistencyManager> consistencyManagerProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<LixManager> lixManagerProvider;
  private final Provider<MemberUtil> memberUtilProvider;
  private final FeedModule module;
  
  static
  {
    if (!FeedModule_ProvideLikePublisherFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedModule_ProvideLikePublisherFactory(FeedModule paramFeedModule, Provider<FlagshipApplication> paramProvider, Provider<FlagshipDataManager> paramProvider1, Provider<ConsistencyManager> paramProvider2, Provider<Bus> paramProvider3, Provider<MemberUtil> paramProvider4, Provider<LixManager> paramProvider5)
  {
    assert (paramFeedModule != null);
    module = paramFeedModule;
    assert (paramProvider != null);
    appProvider = paramProvider;
    assert (paramProvider1 != null);
    dataManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    consistencyManagerProvider = paramProvider2;
    assert (paramProvider3 != null);
    busProvider = paramProvider3;
    assert (paramProvider4 != null);
    memberUtilProvider = paramProvider4;
    assert (paramProvider5 != null);
    lixManagerProvider = paramProvider5;
  }
  
  public static Factory<LikePublisher> create(FeedModule paramFeedModule, Provider<FlagshipApplication> paramProvider, Provider<FlagshipDataManager> paramProvider1, Provider<ConsistencyManager> paramProvider2, Provider<Bus> paramProvider3, Provider<MemberUtil> paramProvider4, Provider<LixManager> paramProvider5)
  {
    return new FeedModule_ProvideLikePublisherFactory(paramFeedModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule_ProvideLikePublisherFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */