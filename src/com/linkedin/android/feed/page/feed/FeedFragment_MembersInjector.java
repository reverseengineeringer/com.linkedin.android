package com.linkedin.android.feed.page.feed;

import com.linkedin.android.axle.rta.RateTheApp;
import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.consistency.ConsistencyManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FeedFragment_MembersInjector
  implements MembersInjector<FeedFragment>
{
  private final Provider<ConsistencyManager> consistencyManagerProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<DelayedExecution> delayedExecutionProvider;
  private final Provider<Bus> eventBusProvider;
  private final Provider<FollowPublisher> followPublisherProvider;
  private final Provider<CheckForNewUpdatesRunnable> newUpdatesCheckerProvider;
  private final Provider<RateTheApp> rateTheAppProvider;
  private final Provider<FeedSharePublisher> sharePublisherProvider;
  private final MembersInjector<BaseFeedFragment> supertypeInjector;
  
  static
  {
    if (!FeedFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedFragment_MembersInjector(MembersInjector<BaseFeedFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<DelayedExecution> paramProvider1, Provider<ConsistencyManager> paramProvider2, Provider<FlagshipDataManager> paramProvider3, Provider<FeedSharePublisher> paramProvider4, Provider<FollowPublisher> paramProvider5, Provider<CheckForNewUpdatesRunnable> paramProvider6, Provider<RateTheApp> paramProvider7)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    eventBusProvider = paramProvider;
    assert (paramProvider1 != null);
    delayedExecutionProvider = paramProvider1;
    assert (paramProvider2 != null);
    consistencyManagerProvider = paramProvider2;
    assert (paramProvider3 != null);
    dataManagerProvider = paramProvider3;
    assert (paramProvider4 != null);
    sharePublisherProvider = paramProvider4;
    assert (paramProvider5 != null);
    followPublisherProvider = paramProvider5;
    assert (paramProvider6 != null);
    newUpdatesCheckerProvider = paramProvider6;
    assert (paramProvider7 != null);
    rateTheAppProvider = paramProvider7;
  }
  
  public static MembersInjector<FeedFragment> create(MembersInjector<BaseFeedFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<DelayedExecution> paramProvider1, Provider<ConsistencyManager> paramProvider2, Provider<FlagshipDataManager> paramProvider3, Provider<FeedSharePublisher> paramProvider4, Provider<FollowPublisher> paramProvider5, Provider<CheckForNewUpdatesRunnable> paramProvider6, Provider<RateTheApp> paramProvider7)
  {
    return new FeedFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */